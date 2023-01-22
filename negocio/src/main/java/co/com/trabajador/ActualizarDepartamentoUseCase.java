package co.com.trabajador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.trabajador.comandos.ActualizarDepartamento;

public class ActualizarDepartamentoUseCase extends UseCase<RequestCommand<ActualizarDepartamento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDepartamento> actualizarDepartamentoRequestCommand) {
        var command = actualizarDepartamentoRequestCommand.getCommand();
        var trabajador = Trabajador.from(command.getIdTrabajador(), repository().getEventsBy(command.getIdTrabajador().value()));
        trabajador.actualizarDepartamento(command.getIdDepartamento(),command.getNombreDepartamento());
        emit().onResponse(new ResponseEvents(trabajador.getUncommittedChanges()));
    }
}
