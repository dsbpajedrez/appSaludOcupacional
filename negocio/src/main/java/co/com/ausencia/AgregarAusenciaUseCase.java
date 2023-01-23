package co.com.ausencia;

import co.com.accidente.Accidente;
import co.com.accidente.comandos.AgregarAccidente;
import co.com.ausencia.comandos.AgregarAusencia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
/**
 * [Clase para caso de uso AgregarAusencia]
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
public class AgregarAusenciaUseCase extends UseCase<RequestCommand<AgregarAusencia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarAusencia> ausenciaRequestCommand) {
        var command = ausenciaRequestCommand.getCommand();

        var ausencia = new Ausencia(
                command.getIdAusencia(), command.getDuracion()
        );
        emit().onResponse(new ResponseEvents(ausencia.getUncommittedChanges()));
    }
}
