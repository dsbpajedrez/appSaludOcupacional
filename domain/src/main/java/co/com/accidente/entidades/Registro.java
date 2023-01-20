package co.com.accidente.entidades;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
import co.com.sofka.domain.generic.Entity;

public class Registro extends Entity<IdRegistro> {
    private IdRegistro idRegistro;
   private Lugar lugar;
   private Fecha fecha;
    public Registro(IdRegistro idRegistro, Lugar lugar, Fecha fecha) {
        super(idRegistro);
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Lugar lugar() {
        return lugar;
    }
}
