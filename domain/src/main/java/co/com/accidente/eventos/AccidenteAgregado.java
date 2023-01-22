package co.com.accidente.eventos;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdAccidente;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;
import java.util.UUID;

public class AccidenteAgregado extends DomainEvent {
    private Clasificacion clasificacion;


    public AccidenteAgregado( Clasificacion clasificacion){
        super("co.com.accidente.eventos.AccidenteAgregado");
        this.clasificacion = clasificacion;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}

