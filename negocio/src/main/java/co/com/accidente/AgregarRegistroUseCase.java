package co.com.accidente;

import co.com.accidente.comandos.AgregarRegistro;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarRegistroUseCase extends UseCase<RequestCommand<AgregarRegistro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRegistro> agregarRegistroRequestCommand) {
        var command = agregarRegistroRequestCommand.getCommand();

        var accidente = Accidente.from(
                command.getIdAccidente(), repository().getEventsBy(command.getIdAccidente().value())
        );
        accidente.agregarRegistro(command.getIdRegistro(),command.getLugar(), command.getFecha());
        emit().onResponse(new ResponseEvents(accidente.getUncommittedChanges()));
    }
}
