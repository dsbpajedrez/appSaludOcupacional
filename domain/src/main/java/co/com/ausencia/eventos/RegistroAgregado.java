package co.com.ausencia.eventos;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroAgregado extends DomainEvent {
    private IdRegistro idRegistro;
   private Tipo tipo;
   private Descripcion descripcion;
    public RegistroAgregado(IdRegistro idRegistro, Descripcion descripcion, Tipo tipo){
        super("co.com.ausencia.eventos.RegistroAgregado");
        this.descripcion = descripcion;
        this.idRegistro = idRegistro;

    }

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
