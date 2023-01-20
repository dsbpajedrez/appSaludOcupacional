package co.com.trabajador;

import co.com.sofka.business.generic.UseCase;
import co.com.trabajador.comandos.ActualizarCargo;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarCargoUseCase extends UseCase<RequestCommand<ActualizarCargo>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarCargo> actualizarCargoRequestCommand) {
        var command = actualizarCargoRequestCommand.getCommand();
        var nombreCargo = Trabajador.from(command.getIdCargo(),repository().getEventsBy(command.getIdCargo().value())
        );
        nombreCargo.actualizarCargo(command.getNombreCargo());
        emit().onResponse(new ResponseEvents(nombreCargo.getUncommittedChanges()));
    }
}
