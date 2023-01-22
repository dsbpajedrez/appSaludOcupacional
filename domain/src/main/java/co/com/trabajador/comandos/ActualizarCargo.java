package co.com.trabajador.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.trabajador.valor.IdCargo;
import co.com.trabajador.valor.IdTrabajador;
import co.com.trabajador.valor.NombreCargo;

public class ActualizarCargo extends Command {

    private final IdTrabajador idTrabajador;
    private final IdCargo idCargo;
    private final NombreCargo nombreCargo;

    public ActualizarCargo(IdTrabajador idTrabajador,IdCargo idCargo, NombreCargo nombreCargo) {
        this.idTrabajador = idTrabajador;
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
    }

    public IdTrabajador getIdTrabajador() {
        return idTrabajador;
    }

    public IdCargo getIdCargo() {
        return idCargo;
    }

    public NombreCargo getNombreCargo() {
        return nombreCargo;
    }
}
