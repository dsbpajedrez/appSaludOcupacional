package co.com.ausencia;

import co.com.ausencia.comandos.ActualizarClasificacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
/**
 * [Clase para caso de uso ActualizarClasificación]
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
public class ActualizarClasificacionUseCase extends UseCase<RequestCommand<ActualizarClasificacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarClasificacion> actualizarClasificacionRequestCommand) {
        var command = actualizarClasificacionRequestCommand.getCommand();

        var ausencia = Ausencia.from(
                command.getIdAusencia(), repository().getEventsBy(command.getIdAusencia().value())
        );
        ausencia.actualizarClasificacion(command.getIdClasificacion(),command.getDescripcion(),command.getTipo());
        emit().onResponse(new ResponseEvents(ausencia.getUncommittedChanges()));
    }
}
