package co.com.ausencia;

import co.com.ausencia.comandos.AgregarClasificacion;
import co.com.ausencia.comandos.AgregarRegistro;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarClasificacionUseCase extends UseCase<RequestCommand<AgregarClasificacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarClasificacion> agregarClasificacionRequestCommand) {
        var command = agregarClasificacionRequestCommand.getCommand();

        var ausencia = Ausencia.from(
                command.getIdAusencia(), repository().getEventsBy(command.getIdAusencia().value())
        );
        ausencia.agregarClasificacion(command.getIdClasificacion(),command.getDescripcion(),command.getTipo());
        emit().onResponse(new ResponseEvents(ausencia.getUncommittedChanges()));
    }
}
