package co.com.accidente.eventos;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroAgregado extends DomainEvent {
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;
    public RegistroAgregado(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        super("co.com.accidente.eventos.RegistroAgregado");
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
