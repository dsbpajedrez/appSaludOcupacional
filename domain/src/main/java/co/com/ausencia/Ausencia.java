package co.com.ausencia;


import co.com.ausencia.entidades.Clasificacion;
import co.com.ausencia.entidades.Registro;
import co.com.ausencia.eventos.*;
import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;
import java.util.Set;

public class Ausencia extends AggregateEvent<IdAusencia> {
    protected Registro registro;
    protected Set<Clasificacion> clasificaciones;
    protected Duracion duracion;

    public Ausencia(IdAusencia idAusencia, Registro registro,
                    Set<Clasificacion> clasificaciones, Duracion duracion){
        super(idAusencia);
        appendChange(new AusenciaAgregada(duracion)).apply();
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public void agregarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        Objects.requireNonNull(idRegistro);
        Objects.requireNonNull(lugar);
        Objects.requireNonNull(fecha);
        appendChange(new RegistroAgregado(idRegistro, lugar, fecha)).apply();
    }

    public void actualizarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha) {
        Objects.requireNonNull(idRegistro);
        Objects.requireNonNull(lugar);
        Objects.requireNonNull(fecha);

        appendChange(new RegistroActualizado(idRegistro, lugar, fecha)).apply();
    }

    public void agregarClasificacion(IdClasificacion idClasificacion, Descripcion descripcion, Tipo tipo){
        Objects.requireNonNull(idClasificacion);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(tipo);

        appendChange(new ClasificacionAgregada(idClasificacion, descripcion, tipo)).apply();
    }

    public void actualizarClasificacion(IdClasificacion idClasificacion, Descripcion descripcion, Tipo tipo){
        Objects.requireNonNull(idClasificacion);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(tipo);

        appendChange(new ClasificacionActualizada(idClasificacion, descripcion, tipo)).apply();

    }
}
