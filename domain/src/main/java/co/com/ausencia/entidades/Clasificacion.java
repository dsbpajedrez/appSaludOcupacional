package co.com.ausencia.entidades;

import co.com.ausencia.valor.Descripcion;
import co.com.ausencia.valor.Estado;
import co.com.ausencia.valor.IdClasificacion;
import co.com.ausencia.valor.Tipo;
import co.com.sofka.domain.generic.Entity;

public class Clasificacion extends Entity<IdClasificacion> {
    private Descripcion descripcion;
    private Tipo tipo;
    public Clasificacion(IdClasificacion idClasificacion, Descripcion descripcion, Tipo tipo) {
        super(idClasificacion);
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public void cambiarDescripcion(Descripcion descripcion){
        this.descripcion = descripcion;
    }
    public void cambiarTipo(Tipo tipo){
        this.tipo = tipo;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
