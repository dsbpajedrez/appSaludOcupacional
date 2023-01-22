package co.com.trabajador.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.trabajador.valor.IdCargo;
import co.com.trabajador.valor.NombreCargo;

public class CargoActualizado extends DomainEvent {

    private final IdCargo idCargo;
    private final NombreCargo nombreCargo;

    public CargoActualizado(IdCargo idCargo, NombreCargo nombreCargo) {
        super("co.com.trabajador.CargoActualizado");
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
