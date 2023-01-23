package co.com.ausencia;

import co.com.ausencia.comandos.ActualizarClasificacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarClasificacionUseCase extends UseCase<RequestCommand<ActualizarClasificacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarClasificacion> actualizarClasificacionRequestCommand) {
        var command = actualizarClasificacionRequestCommand.getCommand();

        var ausencia = Ausencia.from(
                command.getIdAusencia(), repository().getEventsBy(command.getIdAusencia().value())
        );
        ausencia.actualizarClasificacion(command.getIdClasificacion(),command.getDescripcion(),command.getTipo());
        emit().onResponse(new ResponseEvents(ausencia.getUncommittedChanges()));
    }
}
