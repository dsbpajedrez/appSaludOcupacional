package co.com.ausencia;

import co.com.accidente.Accidente;
import co.com.accidente.comandos.AgregarAccidente;
import co.com.ausencia.comandos.AgregarAusencia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

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
