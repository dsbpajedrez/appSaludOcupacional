package co.com.accidente;

import co.com.accidente.comandos.Actualizartipo;
import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.eventos.AccidenteAgregado;
import co.com.accidente.eventos.TipoActualizado;
import co.com.accidente.eventos.TipoAgregado;
import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;
import java.util.Set;

public class Accidente extends AggregateEvent<IdAccidente> {
    protected Clasificacion clasificacion;
    protected Registro registro;
    protected Set<Tipo> tipo;

    public Accidente(IdAccidente idAccidente, Clasificacion clasificacion) {
        super(idAccidente);
        appendChange(new AccidenteAgregado(clasificacion)).apply();
    }
    public Clasificacion getClasificacion(){return this.clasificacion;}

    public void agregarTipo(IdTipo idTipo, Severidad severidad){
        Objects.requireNonNull(idTipo);
        Objects.requireNonNull(severidad);
        appendChange(new TipoAgregado(idTipo, severidad)).apply();
    }

    public void actualizarTipo(IdTipo idTipo, Severidad severidad){
        Objects.requireNonNull(idTipo);
        Objects.requireNonNull(severidad);
        appendChange(new TipoActualizado(idTipo, severidad)).apply();
    }
}
