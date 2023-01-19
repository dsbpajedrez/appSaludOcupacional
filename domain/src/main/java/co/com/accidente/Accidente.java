package co.com.accidente;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.eventos.AccidenteAgregado;
import co.com.accidente.valor.AccidenteId;
import co.com.accidente.valor.Clasificacion;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.AggregateRoot;

import java.util.Set;

public class Accidente extends AggregateEvent<AccidenteId> {
    protected Clasificacion clasificacion;
    protected Registro registro;
    protected Set<Tipo> tipo;

    public Accidente(AccidenteId accidenteId, Clasificacion clasificacion, Registro registro, Set<Tipo> tipo) {
        super(accidenteId);
        appendChanged(new AccidenteAgregado(clasificacion, registro, tipo)).apply();
    }

    public Clasificacion getClasificacion(){return this.clasificacion;}

}
