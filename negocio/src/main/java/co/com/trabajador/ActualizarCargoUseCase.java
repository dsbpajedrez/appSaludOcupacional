    package co.com.trabajador;

    import co.com.sofka.business.generic.UseCase;
    import co.com.sofka.business.support.RequestCommand;
    import co.com.sofka.business.support.ResponseEvents;
    import co.com.trabajador.comandos.ActualizarCargo;

    /**
     * [Clase para caso de uso ActualizarCargo]
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
    public class ActualizarCargoUseCase extends UseCase<RequestCommand<ActualizarCargo>, ResponseEvents> {
        @Override
        public void executeUseCase(RequestCommand<ActualizarCargo> actualizarCargoRequestCommand) {
            var command = actualizarCargoRequestCommand.getCommand();
            var trabajador = Trabajador.from(command.getIdTrabajador(),
                             repository().getEventsBy(command.getIdTrabajador().value()));
            trabajador.actualizarCargo(command.getIdCargo(),command.getNombreCargo());
            emit().onResponse(new ResponseEvents(trabajador.getUncommittedChanges()));
        }
    }
