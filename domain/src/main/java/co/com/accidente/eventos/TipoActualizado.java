package co.com.accidente.eventos;

import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoActualizado extends DomainEvent {
    private final IdTipo idTipo;
    private final Severidad severidad;

    public TipoActualizado(IdTipo idTipo, Severidad severidad){
        super("co.com.accidente.eventos.TipoActualizado");
        this.severidad = severidad;
        this.idTipo = idTipo;
    }

    public IdTipo getIdTipo() {
        return idTipo;
    }

    public Severidad getSeveridad() {
        return severidad;
    }
}
