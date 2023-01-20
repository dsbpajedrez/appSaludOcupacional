package co.com.trabajador.entidades;


import co.com.sofka.domain.generic.Entity;
import co.com.trabajador.valor.IdCargo;
import co.com.trabajador.valor.NombreCargo;

import java.util.Objects;

public class Cargo extends Entity<IdCargo> {

    private NombreCargo nombreCargo;

    public Cargo(IdCargo idCargo, NombreCargo nombreCargo) {
        super(idCargo);
        this.nombreCargo = nombreCargo;
    }

    public NombreCargo nombreCargo() {
        return nombreCargo;
    }

    public void actualizar(NombreCargo nombreCargo) {
        this.nombreCargo = Objects.requireNonNull(nombreCargo);
    }
}
