package co.com.ausencia.eventos;

import co.com.ausencia.valor.Estado;
import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroActualizado extends DomainEvent {
    private IdRegistro idRegistro;
    private Fecha fecha;
    private Lugar lugar;
    public RegistroActualizado(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        super("co.com.ausencia.eventos.RegistroActualizado");
        this.lugar = lugar;
        this.fecha = fecha;
        this.idRegistro = idRegistro;
    }

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Lugar getLugar() {
        return lugar;
    }
}
