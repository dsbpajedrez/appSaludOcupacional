package co.com.accidente;
import co.com.accidente.comandos.ActualizarTipo;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
public class ActualizarTipoUseCase extends UseCase<RequestCommand<ActualizarTipo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTipo> actualizarTipoRequestCommand) {
        var command = actualizarTipoRequestCommand.getCommand();

        var accidente = Accidente.from(
                command.getIdAccidente(), repository().getEventsBy(command.getIdAccidente().value())
        );
        accidente.actualizarTipo(command.getIdAccidente(),command.getSeveridad());

        emit().onResponse(new ResponseEvents(accidente.getUncommittedChanges()));
    }
}
