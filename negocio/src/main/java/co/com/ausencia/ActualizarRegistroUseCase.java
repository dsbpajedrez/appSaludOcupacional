package co.com.ausencia;

import co.com.ausencia.comandos.ActualizarRegistro;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarRegistroUseCase extends UseCase<RequestCommand<ActualizarRegistro>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarRegistro> actualizarRegistroRequestCommand) {
        var command = actualizarRegistroRequestCommand.getCommand();

        var ausencia = Ausencia.from(
                command.getIdAusencia(), repository().getEventsBy(command.getIdAusencia().value())
        );
        ausencia.actualizarRegistro(command.getIdRegistro(),command.getLugar(),command.getFecha());
        emit().onResponse(new ResponseEvents(ausencia.getUncommittedChanges()));
    }
}

