package co.com.ausencia;


import co.com.ausencia.entidades.Clasificacion;
import co.com.ausencia.entidades.Registro;
import co.com.ausencia.eventos.*;
import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
/**
 * [Agregado root ausencia]
 *
 * @version [1.0.0 2023-01-22,    La clase corresponde a la versión 1 del sistema,
 *                                no ha sufrido refactorings durante la versión,
 *                                no se han realizado cambios.
 *
 * @author [Valentina Santa Muñoz – valen_2605@hotmail.com]
 * @author [David Santiago Benjumea Pérez – dsbpim@gmail.com]
 *
 * @since [Versión 1]
 *
 */
public class Ausencia extends AggregateEvent<IdAusencia> {
    protected Set<Registro> registros;
    protected Set<Clasificacion> clasificaciones;
    protected Duracion duracion;

    /**
     * Constructor
     * @param idAusencia: Identidad de la ausencia
     * @param duracion: Duración del periodo de ausencia
     */
    public Ausencia(IdAusencia idAusencia, Duracion duracion){
        super(idAusencia);
        appendChange(new AusenciaAgregada(duracion)).apply();
    }

    /**
     * Constructor: Crea una suscripción al cambio de eventos
     * @param idAusencia: Identidad de la ausencia
     */
    private Ausencia(IdAusencia idAusencia){
        super(idAusencia);
        subscribe(new AusenciaChange(this));
    }

    /**
     * Constructor de ausencia estático: Clase que invoca los apply de la
     * clase AusenciaChange
     * @param idAusencia: Identidad de la ausencia
     * @param events: Lista de eventos del dominio
     * @return: Retorno de la instancia de ausencia
     */
    public static Ausencia from(IdAusencia idAusencia, List<DomainEvent> events){
        var ausencia = new Ausencia(idAusencia);
        events.forEach(ausencia::applyEvent);
        return ausencia;
    }

    /**
     * Getter
     * @return: Retorna la duración de la ausencia
     */
    public Duracion getDuracion() {
        return duracion;
    }

    /**
     * agregarRegistro: Ejecuta el comando RegistroAgregado y lo aplica con el appendChange
     * @param idRegistro: Identidad de registro
     * @param lugar: Lugar que causa la ausencia del trabajado
     *             (En caso de que la ausencia haya sido por algun tipo de trabajo de la empresa)
     * @param fecha: Fecha de incapacidad o ausencia
     */
    public void agregarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        Objects.requireNonNull(idRegistro);
        Objects.requireNonNull(lugar);
        Objects.requireNonNull(fecha);
        appendChange(new RegistroAgregado(idRegistro,lugar, fecha )).apply();
    }

    /**
     * aactualizarRegistro: Ejecuta el comando RegistroActualizado y lo aplica con el appendChange
     * @param idRegistro
     * @param lugar
     * @param fecha
     */
    public void actualizarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha) {
        Objects.requireNonNull(idRegistro);
        Objects.requireNonNull(lugar);
        Objects.requireNonNull(fecha);
        appendChange(new RegistroActualizado(idRegistro,lugar, fecha)).apply();
    }

    /**
     * agregarRegistro: Ejecuta el comando ClasificacionAgregado y lo aplica con el appendChange
     * @param idClasificacion: Identidad de la clasificación
     * @param descripcion: Descripción del caso
     * @param tipo: Tipo de ausencia
     */
    public void agregarClasificacion(IdClasificacion idClasificacion, Descripcion descripcion, Tipo tipo){
        Objects.requireNonNull(idClasificacion);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(tipo);

        appendChange(new ClasificacionAgregada(idClasificacion, descripcion, tipo)).apply();
    }

    /**
     * actualizarClasificacion: Ejecuta el comando ClasificacionActualizada y lo aplica con el appendChange
     * @param idClasificacion: Identidad de la clasificación
     * @param descripcion: Descripción del caso de ausencia
     * @param tipo: Tipo de ausencia
     */

    public void actualizarClasificacion(IdClasificacion idClasificacion, Descripcion descripcion, Tipo tipo){
        Objects.requireNonNull(idClasificacion);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(tipo);

        appendChange(new ClasificacionActualizada(idClasificacion, descripcion, tipo)).apply();
    }

    /**
     * getClasificacionPorId: Busca una clasificación por su identidad
     * @param idClasificacion: Identidad de la clasificación
     * @return: Retorna la clasificación
     */
    protected Optional<Clasificacion> getClasificacionPorId(IdClasificacion idClasificacion){
        return clasificaciones
                .stream()
                .filter(clasificado -> clasificado.identity().equals(idClasificacion))
                .findFirst();
    }

    /**
     * getRegistroPorId: Busca un registro por su identidad
     * @param idRegistro: Identidad del registro
     * @return: Retorna el registro
     */
    protected Optional<Registro> getRegistroPorId(IdRegistro idRegistro){
        return registros
                .stream()
                .filter(registrado -> registrado.identity().equals(idRegistro))
                .findFirst();
    }
}
