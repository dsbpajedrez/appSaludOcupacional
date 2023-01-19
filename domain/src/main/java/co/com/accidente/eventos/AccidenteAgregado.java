package co.com.accidente.eventos;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.valor.Clasificacion;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;
import java.util.UUID;

public class AccidenteAgregado extends DomainEvent {
    protected Registro registro;
    protected Set<Tipo> tipo;
    protected Clasificacion clasificacion;


    public AccidenteAgregado(Clasificacion clasificacion){
        super("co.com.accidente.eventos.AccidenteAgregado");
        this.registro = registro;
        this.clasificacion = clasificacion;
        this.tipo = tipo;
    }
}
