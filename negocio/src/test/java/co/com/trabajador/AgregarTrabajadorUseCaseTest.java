    package co.com.trabajador;

    import co.com.sofka.business.generic.UseCaseHandler;
    import co.com.sofka.business.support.RequestCommand;
    import co.com.trabajador.comandos.AgregarTrabajador;
    import co.com.trabajador.entidades.Cargo;
    import co.com.trabajador.entidades.Departamento;
    import co.com.trabajador.eventos.TrabajadorAgregado;
    import co.com.trabajador.valor.DatosPersonalesTrabajador;
    import co.com.trabajador.valor.IdCargo;
    import co.com.trabajador.valor.IdDepartamento;
    import co.com.trabajador.valor.IdTrabajador;
    import co.com.trabajador.valor.NombreCargo;
    import co.com.trabajador.valor.NombreDepartamento;
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

    /**
     * [Clase para pruebas unitarias AgregarTrabajador]
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
    class AgregarTrabajadorUseCaseTest {
        private AgregarTrabajadorUseCase useCase;

        @BeforeEach
        public void setUp() {
            useCase = new AgregarTrabajadorUseCase();
        }
        @Test
        void agregarTrabajador() {

            //Arrange
            var idTrabajador = IdTrabajador.of("789");
            var departamento = new Departamento(IdDepartamento.of("3"),
                    new NombreDepartamento("Administrativo"));
            var cargo = new Cargo(IdCargo.of("9"),new NombreCargo("Presidente"));
            var datosPersonalesTrabajador = new DatosPersonalesTrabajador(
                    "Valentina",
                    "Santa",
                    "49892",
                    "valentina@gmail.com");

            DatosPersonalesTrabajador datosTrabajador = new DatosPersonalesTrabajador(
                    "Valentina","Santa","49892","valentina@gmail.com");

            var command = new AgregarTrabajador(idTrabajador, departamento, cargo, datosPersonalesTrabajador);
            //Act
            var events = UseCaseHandler.getInstance()
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow()
                    .getDomainEvents();

            //Asserts
            Trabajador trabajador = new Trabajador(idTrabajador, departamento, cargo, datosPersonalesTrabajador);
            var trabajadorAgregado = (TrabajadorAgregado) events.get(0);
            Assertions.assertEquals("789", trabajadorAgregado.aggregateRootId());
            Assertions.assertEquals("Administrativo", trabajadorAgregado.getDepartamento().nombreDepartamento().value());
            Assertions.assertEquals("Presidente", trabajadorAgregado.getCargo().nombreCargo().value());
            Assertions.assertEquals("Valentina", trabajadorAgregado.getDatosPersonales().getNombre());
            Assertions.assertEquals("Santa", trabajadorAgregado.getDatosPersonales().getApellido());
            Assertions.assertEquals("49892", trabajadorAgregado.getDatosPersonales().getTelefono());
            Assertions.assertEquals("valentina@gmail.com", trabajadorAgregado.getDatosPersonales().getCorreo());
        }
        }

