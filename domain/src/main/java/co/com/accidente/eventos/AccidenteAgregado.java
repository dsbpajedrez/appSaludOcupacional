package co.com.accidente.eventos;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdAccidente;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;
import java.util.UUID;

public class AccidenteAgregado extends DomainEvent {
    private final IdAccidente idAccidente;
    private Clasificacion clasificacion;

    public AccidenteAgregado(Clasificacion clasificacion, IdAccidente idAccidente){
        super("co.com.accidente.eventos.AccidenteAgregado");
        this.clasificacion = clasificacion;
        this.idAccidente = idAccidente;

    }

    public IdAccidente getIdAccidente() {
        return idAccidente;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}

