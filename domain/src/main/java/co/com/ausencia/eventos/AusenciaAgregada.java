package co.com.ausencia.eventos;

import co.com.ausencia.valor.Duracion;
import co.com.sofka.domain.generic.DomainEvent;

public class AusenciaAgregada extends DomainEvent {
    private Duracion duracion;

    public AusenciaAgregada(Duracion duracion){
        super("co.com.ausencia.eventos.AusenciaAgregada");
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
