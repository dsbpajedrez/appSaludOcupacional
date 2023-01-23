package co.com.accidente;

import co.com.accidente.comandos.AgregarAccidente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
/**
 * [Clase para caso de uso AgregarAccudente]
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
public class AgregarAccidenteUseCase extends UseCase<RequestCommand<AgregarAccidente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarAccidente> accidenteRequestCommand) {
        var command = accidenteRequestCommand.getCommand();

        var accidente = new Accidente(
                command.getAccidenteId(), command.getClasificacion()
        );
        emit().onResponse(new ResponseEvents(accidente.getUncommittedChanges()));
    }
}
