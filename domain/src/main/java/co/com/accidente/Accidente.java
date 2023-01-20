package co.com.accidente;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.eventos.AccidenteAgregado;
import co.com.accidente.eventos.RegistroAgregado;
import co.com.accidente.eventos.TipoActualizado;
import co.com.accidente.eventos.TipoAgregado;
import co.com.accidente.valor.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Accidente extends AggregateEvent<IdAccidente> {
    protected Clasificacion clasificacion;
    protected Set<Registro> registros;
    protected Set<Tipo> tipos;

    public Accidente(IdAccidente idAccidente, Clasificacion clasificacion) {
        super(idAccidente);
        appendChange(new AccidenteAgregado(clasificacion, idAccidente)).apply();
    }

    private Accidente(IdAccidente idAccidente){
        super(idAccidente);
        subscribe(new AccidenteChange(this));
    }
    public static Accidente from(IdAccidente idAccidente, List<DomainEvent> events){
        var accidente = new Accidente(idAccidente);
        events.forEach(accidente::applyEvent);
        return accidente;
    }
    public Clasificacion getClasificacion(){return this.clasificacion;}

    public void agregarTipo(IdTipo idTipo, Severidad severidad){
        Objects.requireNonNull(idTipo);
        Objects.requireNonNull(severidad);
        appendChange(new TipoAgregado(idTipo, severidad)).apply();
    }

    public void actualizarTipo(IdAccidente idAccidente,IdTipo idTipo, Severidad severidad){
        Objects.requireNonNull(idAccidente);
        Objects.requireNonNull(idTipo);
        Objects.requireNonNull(severidad);
        appendChange(new TipoActualizado(idTipo, severidad)).apply();
    }

    public void agregarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        Objects.requireNonNull(idRegistro);
        Objects.requireNonNull(lugar);
        Objects.requireNonNull(fecha);
        appendChange(new RegistroAgregado(idRegistro, lugar, fecha)).apply();
    }
    protected Optional<Registro> getRegistroPorId(IdRegistro idRegistro){
        return registros
                .stream()
                .filter(registrado -> registrado.identity().equals(idRegistro))
                .findFirst();
    }
    protected Optional<Tipo> getTipoPorId(IdTipo idTipo){
        return tipos
                .stream()
                .filter(type -> type.identity().equals(idTipo))
                .findFirst();
    }
}
