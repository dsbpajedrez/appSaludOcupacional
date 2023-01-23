package co.com.accidente;
import co.com.accidente.comandos.ActualizarTipo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
/**
 * [Clase para caso de uso ActualizarTipo]
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
public class ActualizarTipoUseCase extends UseCase<RequestCommand<ActualizarTipo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTipo> actualizarTipoRequestCommand) {
        var command = actualizarTipoRequestCommand.getCommand();

        var accidente = Accidente.from(
                command.getIdAccidente(), repository().getEventsBy(command.getIdAccidente().value())
        );
        accidente.actualizarTipo(command.getIdTipo(),command.getSeveridad());

        emit().onResponse(new ResponseEvents(accidente.getUncommittedChanges()));
    }
}
