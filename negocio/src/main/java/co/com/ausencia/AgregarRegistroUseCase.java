package co.com.ausencia;


import co.com.ausencia.comandos.AgregarRegistro;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
/**
 * [Clase para caso de uso AgregarRegistro]
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
public class AgregarRegistroUseCase extends UseCase<RequestCommand<AgregarRegistro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRegistro> agregarRegistroRequestCommand) {
        var command = agregarRegistroRequestCommand.getCommand();

        var accidente = Ausencia.from(
                command.getIdAusencia(), repository().getEventsBy(command.getIdAusencia().value())
        );
        accidente.agregarRegistro(command.getIdRegistro(),command.getLugar(), command.getFecha());
        emit().onResponse(new ResponseEvents(accidente.getUncommittedChanges()));
    }
}
