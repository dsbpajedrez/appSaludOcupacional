package co.com.ausencia.eventos;

import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroActualizado extends DomainEvent {
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;
    public RegistroActualizado(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        super("co.com.ausencia.eventos.RegistroActualizado");
        this.fecha = fecha;
        this.lugar = lugar;
        this.idRegistro = idRegistro;
    }

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
