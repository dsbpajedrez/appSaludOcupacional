package co.com.ausencia.comandos;

import co.com.ausencia.valor.Estado;
import co.com.ausencia.valor.IdClasificacion;
import co.com.ausencia.valor.Tipo;
import co.com.sofka.domain.generic.Command;

public class ActualizarClasificacion extends Command {
    private IdClasificacion idClasificacion;
    private Estado descripcion;
    private Tipo tipo;

    public ActualizarClasificacion(IdClasificacion idClasificacion,
                                   Estado descripcion, Tipo tipo){
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
