package co.com.ausencia.entidades;

import co.com.ausencia.valor.Descripcion;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Tipo;
import co.com.sofka.domain.generic.Entity;

public class Registro extends Entity<IdRegistro> {
    private Descripcion descripcion;
    private Tipo tipo;
    public Registro(IdRegistro entityId, Descripcion descripcion, Tipo tipo) {
        super(entityId);
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    public void cambiarDescripcion(Descripcion descripcion){
        this.descripcion = descripcion;
    }
    public void cambiarTipo(Descripcion tipo){
        this.tipo = tipo;
    }
    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}