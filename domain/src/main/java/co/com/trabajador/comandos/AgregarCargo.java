package co.com.trabajador.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.trabajador.valor.IdCargo;
import co.com.trabajador.valor.NombreCargo;

public class AgregarCargo extends Command {

    private final IdCargo idCargo;
    private final NombreCargo nombreCargo;

    public AgregarCargo(IdCargo idCargo, NombreCargo nombreCargo) {
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
    }

    public IdCargo getIdCargo() {
        return idCargo;
    }

    public NombreCargo getNombreCargo() {
        return nombreCargo;
    }
}
