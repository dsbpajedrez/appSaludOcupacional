package co.com.accidente;

import co.com.accidente.comandos.AgregarAccidente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

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
