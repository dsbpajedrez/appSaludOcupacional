package co.com.ausencia.eventos;

import co.com.ausencia.valor.Estado;
import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroActualizado extends DomainEvent {
    private IdRegistro idRegistro;
    private Estado estado;
    public RegistroActualizado(IdRegistro idRegistro,Estado estado){
        super("co.com.ausencia.eventos.RegistroActualizado");
        this.estado = estado;
        this.idRegistro = idRegistro;
    }

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Estado getEstado() {
        return estado;
    }
}
