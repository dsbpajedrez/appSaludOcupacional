    package co.com.trabajador;

    import co.com.sofka.business.generic.UseCase;
    import co.com.sofka.business.support.RequestCommand;
    import co.com.sofka.business.support.ResponseEvents;
    import co.com.trabajador.comandos.AgregarDepartamento;

    /**
     * [Clase para caso de uso AgregarDepartamento]
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
    public class AgregarDepartamentoUseCase extends UseCase<RequestCommand<AgregarDepartamento>, ResponseEvents> {
        @Override
        public void executeUseCase(RequestCommand<AgregarDepartamento> agregarDepartamentoRequestCommand) {

            var command = agregarDepartamentoRequestCommand.getCommand();

            var trabajador = Trabajador.from(command.getIdTrabajador(),
                             repository().getEventsBy(command.getIdTrabajador().value()));

            trabajador.agregarDepartamento(command.getIdDepartamento(),command.getNombreDepartamento());

            emit().onResponse(new ResponseEvents(trabajador.getUncommittedChanges()));

        }
    }
