package co.com.trabajador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.trabajador.comandos.ActualizarCargo;

public class ActualizarCargoUseCase extends UseCase<RequestCommand<ActualizarCargo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCargo> actualizarCargoRequestCommand) {
        var command = actualizarCargoRequestCommand.getCommand();
        var trabajador = Trabajador.from(command.getIdTrabajador(), repository().getEventsBy(command.getIdTrabajador().value()));
        trabajador.actualizarCargo(command.getIdCargo(),command.getNombreCargo());
        emit().onResponse(new ResponseEvents(trabajador.getUncommittedChanges()));
    }
}
