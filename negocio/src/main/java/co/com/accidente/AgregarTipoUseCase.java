package co.com.accidente;

import co.com.accidente.comandos.AgregarRegistro;
import co.com.accidente.comandos.AgregarTipo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

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