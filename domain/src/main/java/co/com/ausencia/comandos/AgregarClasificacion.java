package co.com.ausencia.comandos;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.Command;

public class AgregarClasificacion extends Command {
    private IdAusencia idAusencia;
    private IdClasificacion idClasificacion;
    private Descripcion descripcion;
    private Tipo tipo;

    public AgregarClasificacion(IdAusencia idAusencia, IdClasificacion idClasificacion,
                                Descripcion descripcion, Tipo tipo){
        this.idAusencia = idAusencia;
        this.idClasificacion = idClasificacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public IdClasificacion getIdClasificacion() {
        return idClasificacion;
    }

    public IdAusencia getIdAusencia() {
        return idAusencia;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
