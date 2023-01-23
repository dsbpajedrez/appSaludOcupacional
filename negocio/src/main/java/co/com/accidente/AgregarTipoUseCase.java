package co.com.accidente;

import co.com.accidente.comandos.AgregarRegistro;
import co.com.accidente.comandos.AgregarTipo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
/**
 * [Clase para caso de uso AgregarTipo]
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
public class AgregarTipoUseCase extends UseCase<RequestCommand<AgregarTipo>, ResponseEvents> {
@Override
public void executeUseCase(RequestCommand<AgregarTipo> agregarTipoRequestCommand) {
        var command = agregarTipoRequestCommand.getCommand();

        var accidente = Accidente.from(
        command.getIdAccidente(), repository().getEventsBy(command.getIdAccidente().value())
        );
        accidente.agregarTipo(command.getIdTipo(),command.getSeveridad());
        emit().onResponse(new ResponseEvents(accidente.getUncommittedChanges()));
  }
}