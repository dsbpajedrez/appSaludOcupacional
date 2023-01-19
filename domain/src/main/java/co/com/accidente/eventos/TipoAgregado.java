package co.com.accidente.eventos;

import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoAgregado extends DomainEvent {
    private IdTipo idTipo;
    private Severidad severidad;
    public TipoAgregado(IdTipo idTipo, Severidad severidad) {
        super("co.com.accidente.eventos.TipoAgregado");
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
