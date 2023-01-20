package co.com.ausencia.eventos;

import co.com.ausencia.valor.Estado;
import co.com.ausencia.valor.IdClasificacion;
import co.com.ausencia.valor.Tipo;
import co.com.sofka.domain.generic.DomainEvent;

public class ClasificacionAgregada extends DomainEvent {
    private IdClasificacion idClasificacion;
    private Estado descripcion;
    private Tipo tipo;

    public ClasificacionAgregada(IdClasificacion idClasificacion,
                                 Estado descripcion, Tipo tipo){
        super("co.com.ausencia.eventos.ClasificacionAgregada");
        this.idClasificacion = idClasificacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public IdClasificacion getIdClasificacion() {
        return idClasificacion;
    }

    public Estado getDescripcion() {
        return descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
