package co.com.ausencia.eventos;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroAgregado extends DomainEvent {
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;
    public RegistroAgregado(IdRegistro idRegistro, Lugar lugar, Fecha fecha) {
        super("co.com.ausencia.eventos");
        this.idRegistro = idRegistro;
        this.lugar = lugar;
        this.fecha = fecha;
    }
    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(IdRegistro idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
