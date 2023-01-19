package co.com.ausencia.eventos;

import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroAgregado extends DomainEvent {
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;
    public RegistroAgregado(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        super("co.com.ausencia.eventos.RegistroAgregado");
        this.fecha = fecha;
        this.idRegistro = idRegistro;
        this.lugar = lugar;
    }

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
