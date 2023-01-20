package co.com.accidente.entidades;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
import co.com.sofka.domain.generic.Entity;

public class Registro extends Entity<IdRegistro> {
   private Lugar lugar;
   private Fecha fecha;
    public Registro(IdRegistro entityId, Lugar lugar, Fecha fecha) {
        super(entityId);
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Lugar lugar() {
        return lugar;
    }
}
