package co.com.trabajador.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.trabajador.valor.IdCargo;
import co.com.trabajador.valor.NombreCargo;

public class CargoAgregado extends DomainEvent {

    private final IdCargo idCargo;
    private final NombreCargo nombreCargo;

    public CargoAgregado(IdCargo idCargo, NombreCargo nombreCargo) {
        super("co.com.trabajador.CargoAgregado");
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
