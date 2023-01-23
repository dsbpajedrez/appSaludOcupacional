    package co.com.trabajador;

    import co.com.sofka.business.generic.UseCaseHandler;
    import co.com.sofka.business.repository.DomainEventRepository;
    import co.com.sofka.business.support.RequestCommand;
    import co.com.sofka.domain.generic.DomainEvent;
    import co.com.trabajador.comandos.AgregarCargo;
    import co.com.trabajador.entidades.Cargo;
    import co.com.trabajador.eventos.CargoAgregado;
    import co.com.trabajador.valor.DatosPersonalesTrabajador;
    import co.com.trabajador.valor.IdCargo;
    import co.com.trabajador.valor.IdDepartamento;
    import co.com.trabajador.valor.IdTrabajador;
    import co.com.trabajador.valor.NombreCargo;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.junit.jupiter.MockitoExtension;

    import java.util.List;

    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.mockito.Mockito.when;

    /**
     * [Clase para pruebas unitarias AgregarCargo]
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
    class AgregarCargoUseCaseTest {

        @InjectMocks
        private AgregarCargoUseCase useCase;

        @Mock
        private DomainEventRepository repository;

        @Test
        void agregarCargoUseCaseTest() {

            IdTrabajador idTrabajador = IdTrabajador.of("8");
            IdCargo idCargo = IdCargo.of("9");
            NombreCargo nombreCargo = new NombreCargo("Contador");
            var command = new AgregarCargo(idTrabajador,idCargo,nombreCargo);

            when(repository.getEventsBy("8")).thenReturn(history());
            useCase.addRepository(repository);

    //        when
            var events = UseCaseHandler.getInstance()
                    .setIdentifyExecutor(command.getIdTrabajador().value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow()
                    .getDomainEvents();
    //        assert
            var event = (CargoAgregado) events.get(0);
            assertEquals("9", event.getIdCargo().value());
            assertEquals("Contador", event.getNombreCargo().value());
        }
        private List<DomainEvent> history() {
            IdTrabajador idTrabajador = IdTrabajador.of("8");
            IdDepartamento idDepartamento = IdDepartamento.of("6");
            IdCargo idCargo = IdCargo.of("5");
            NombreCargo nombreCargo = new NombreCargo("Secretaria");
            DatosPersonalesTrabajador datosPersonalesTrabajador = new DatosPersonalesTrabajador(
                    "María",
                    "Gomez",
                    "123456",
                    "maria@gmail.com"
            );
            Cargo cargo = new Cargo(idCargo,new NombreCargo("Contador"));
            var event = new CargoAgregado(idCargo,nombreCargo);
            event.setAggregateRootId(idTrabajador.value());
            return List.of(event);
        }

    }