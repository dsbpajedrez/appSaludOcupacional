    package co.com.trabajador;

    import co.com.sofka.business.generic.UseCase;
    import co.com.sofka.business.support.RequestCommand;
    import co.com.sofka.business.support.ResponseEvents;
    import co.com.trabajador.comandos.AgregarTrabajador;

    /**
     * [Clase para caso de uso AgregarTrabajador]
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
    public class AgregarTrabajadorUseCase extends UseCase<RequestCommand<AgregarTrabajador>, ResponseEvents> {

        @Override
        public void executeUseCase(RequestCommand<AgregarTrabajador> agregarTrabajadorRequestCommand) {
            var command = agregarTrabajadorRequestCommand.getCommand();

            var trabajador = new Trabajador(command.getIdTrabajador(),
                    command.getDepartamento(),
                    command.getCargo(),
                    command.getDatosPersonales()
            );
            emit().onResponse(new ResponseEvents(trabajador.getUncommittedChanges()));


        }
    }
