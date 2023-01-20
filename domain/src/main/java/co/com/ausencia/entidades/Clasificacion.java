package co.com.ausencia.entidades;

import co.com.ausencia.valor.Descripcion;
import co.com.ausencia.valor.IdClasificacion;
import co.com.ausencia.valor.Tipo;
import co.com.sofka.domain.generic.Entity;

public class Clasificacion extends Entity<IdClasificacion> {
    private Descripcion descripcion;
    private Tipo tipo;
    public Clasificacion(IdClasificacion entityId, Descripcion descripcion, Tipo tipo) {
        super(entityId);
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
}
