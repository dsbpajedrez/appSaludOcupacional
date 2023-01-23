    package co.com.trabajador;

    import co.com.sofka.business.generic.UseCaseHandler;
    import co.com.sofka.business.repository.DomainEventRepository;
    import co.com.sofka.business.support.RequestCommand;
    import co.com.sofka.domain.generic.DomainEvent;
    import co.com.trabajador.comandos.ActualizarCargo;
    import co.com.trabajador.entidades.Cargo;
    import co.com.trabajador.entidades.Departamento;
    import co.com.trabajador.eventos.CargoActualizado;
    import co.com.trabajador.eventos.TrabajadorAgregado;
    import co.com.trabajador.valor.DatosPersonalesTrabajador;
    import co.com.trabajador.valor.IdCargo;
    import co.com.trabajador.valor.IdDepartamento;
    import co.com.trabajador.valor.IdTrabajador;
    import co.com.trabajador.valor.NombreCargo;
    import co.com.trabajador.valor.NombreDepartamento;
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.junit.jupiter.MockitoExtension;

    import java.util.List;


    import static org.mockito.Mockito.when;
    /**
     * [Clase para pruebas unitarias ActualizarCargo]
     *
     * @version [1.0.0 2023-01-22,    La clase corresponde a la versión 1 del sistema,
     *                                no ha sufrido refactorings durante la versión,
     *                                no se han realizado cambios.
     *
     * @author [Valentina Santa Muñoz – valen_2605@hotmail.com]
     * @author [David Santiago Benjumea Pérez – dsbpim@gmail.com]
     *
     * @since [Versión 1]
     *
     */
    @ExtendWith(MockitoExtension.class)
    class ActualizarCargoUseCaseTest {

        @InjectMocks
        private ActualizarCargoUseCase useCase;

        @Mock
        private DomainEventRepository repository;

        @Test
        void actualizarCargoUseCaseTest() {

            //Arrange
            IdTrabajador idTrabajador = IdTrabajador.of("123");
            IdDepartamento idDepartamento = IdDepartamento.of("1");
            NombreDepartamento nombreDepartamento = new NombreDepartamento("Recursos H");
            IdCargo idCargo = IdCargo.of("5");
            NombreCargo nombreCargo = new NombreCargo("Gerente");

            Departamento departamento = new Departamento(idDepartamento,nombreDepartamento);
            DatosPersonalesTrabajador datosPersonalesTrabajador = new DatosPersonalesTrabajador(
                    "Valentina","Santa","333444","valentina@gmail.com");
            Cargo cargo = new Cargo(idCargo,nombreCargo);
            var command = new ActualizarCargo(idTrabajador, idCargo, new NombreCargo("Gerente"));
            TrabajadorAgregado trabajadorAgregado = new TrabajadorAgregado(
                    departamento,
                    cargo,
                    datosPersonalesTrabajador
            );
            when(repository.getEventsBy("123")).thenReturn(List.of(trabajadorAgregado));
            useCase.addRepository(repository);

            List<DomainEvent> events = UseCaseHandler.getInstance()
                    .setIdentifyExecutor("123")
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow()
                    .getDomainEvents();

            var event = (CargoActualizado) events.get(0);
            Assertions.assertEquals("Gerente", event.getNombreCargo().value());
            Assertions.assertEquals("5", event.getIdCargo().value());

        }

    }