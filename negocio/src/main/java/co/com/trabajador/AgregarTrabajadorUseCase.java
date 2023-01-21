/*package co.com.trabajador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.trabajador.comandos.AgregarTrabajador;

public class AgregarTrabajadorUseCase extends UseCase<RequestCommand<AgregarTrabajador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTrabajador> agregarTrabajadorRequestCommand) {
        var command = agregarTrabajadorRequestCommand.getCommand();
        var trabajador = new Trabajador(command.getIdTrabajador(),
                command.getDepartamento(),
                command.getCargo(),
                command.getDatosPersonales()
        );
        trabajador.agregarTrabajador(command.getDepartamento(),command.getCargo(),command.getDatosPersonales());
        emit().onResponse(new ResponseEvents(trabajador.getUncommittedChanges()));
    }
}
*/