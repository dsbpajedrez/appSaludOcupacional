package co.com.ausencia.eventos;

import co.com.ausencia.valor.Descripcion;
import co.com.ausencia.valor.IdClasificacion;
import co.com.ausencia.valor.Tipo;
import co.com.sofka.domain.generic.DomainEvent;

public class ClasificacionAgregada extends DomainEvent {
    private IdClasificacion idClasificacion;
    private Descripcion descripcion;
    private Tipo tipo;

    public ClasificacionAgregada(IdClasificacion idClasificacion,
                                 Descripcion descripcion, Tipo tipo){
        super("co.com.ausencia.eventos.ClasificacionAgregada");
        this.idClasificacion = idClasificacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public IdClasificacion getIdClasificacion() {
        return idClasificacion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
