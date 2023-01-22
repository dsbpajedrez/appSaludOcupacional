package co.com.ausencia.eventos;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroAgregado extends DomainEvent {
    private IdRegistro idRegistro;
    private Estado estado;
    public RegistroAgregado(IdRegistro idRegistro, Estado estado) {
        super("co.com.ausencia.eventos");
        this.idRegistro = idRegistro;
        this.estado = estado;
    }
    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(IdRegistro idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Estado getEstado() {
        return estado;
    }
}
