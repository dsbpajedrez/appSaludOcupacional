package co.com.accidente.eventos;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroActualizado extends DomainEvent {
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;

    public RegistroActualizado(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        super("co.com.accidente.eventos.RegistroActualizado");
        this.idRegistro = idRegistro;
        this.fecha = fecha;
        this.lugar = lugar;
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
