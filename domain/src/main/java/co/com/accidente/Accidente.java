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

/**
 * [Agregado root accidente]
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
public class Accidente extends AggregateEvent<IdAccidente> {

    protected Clasificacion clasificacion;
    protected Set<Registro> registros;
    protected Set<Tipo> tipos;

    /**
     * Accidente: Constructor principal de la clase Accidente
     * @param idAccidente: Recibe el idAccidente como parámetro
     * @param clasificacion: Recibe el idAccidente como parámetro
     */
    public Accidente( IdAccidente idAccidente,Clasificacion clasificacion) {
        super(idAccidente);
        appendChange(new AccidenteAgregado(clasificacion)).apply();
    }

    /**
     * Constructor accidente: Constructor para suscribir el agregado root al
     * AccidenteChange
     * @param idAccidente
     */

    private Accidente(IdAccidente idAccidente){
        super(idAccidente);
        subscribe(new AccidenteChange(this));
    }

    /**
     * Constructor accidente estático: Clase que invoca los apply de la
     * clase AccidenteChange
     * @param idAccidente: Parámetro idAccidente
     * @param events:Lista de eventos del caso de uso(use case)
     * @return: Retorna instancia de accidente
     */
    public static Accidente from(IdAccidente idAccidente, List<DomainEvent> events){
        Accidente accidente = new Accidente(idAccidente);
        events.forEach(accidente::applyEvent);
        return accidente;
    }

    /**
     *
     * @return: Retorna objeto valor clasificación
     */
    public Clasificacion getClasificacion(){return this.clasificacion;}

    /**
     * agregarTipo: Ejecuta el comando TipoAgregado y lo aplica con el appendChange
     * @param idTipo: Identificador del tipo de accidente
     * @param severidad: Severidad del accidente
     */
    public void agregarTipo(IdTipo idTipo, Severidad severidad){
        Objects.requireNonNull(idTipo);
        Objects.requireNonNull(severidad);
        appendChange(new TipoAgregado(idTipo, severidad)).apply();
    }

    /**
     * actualizarTipo:Ejecuta el comando actualizarTipo y lo aplica con el appendChange
     * @param idTipo: Identificador del tipo de accidente
     * @param severidad: Severidad del accidente
     */
    public void actualizarTipo(IdTipo idTipo, Severidad severidad){
        Objects.requireNonNull(idTipo);
        Objects.requireNonNull(severidad);
        appendChange(new TipoActualizado(idTipo, severidad)).apply();
    }

    /**
     * agregarRegistro: Ejecuta el comando  y lo aplica con el appendChange
     * @param idRegistro
     * @param lugar
     * @param fecha
     */

    public void agregarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        Objects.requireNonNull(idRegistro);
        Objects.requireNonNull(lugar);
        Objects.requireNonNull(fecha);
        appendChange(new RegistroAgregado(idRegistro, lugar, fecha)).apply();
    }

    /**
     * getResgistroPorId: Busca un registro por su id
     * @param idRegistro:Identificador del registro
     * @return Registro encontrado por su id
     */
    protected Optional<Registro> getRegistroPorId(IdRegistro idRegistro){
        return registros
                .stream()
                .filter(registrado -> registrado.identity().equals(idRegistro))
                .findFirst();
    }

    /**
     * getResgistroPorId: Busca un tipo por su id
     * @param idTipo: Identificador del tipo
     * @return Tipo encontrado por su id
     */
    protected Optional<Tipo> getTipoPorId(IdTipo idTipo){
        return tipos
                .stream()
                .filter(type -> type.identity().equals(idTipo))
                .findFirst();
    }

    /**
     * @return: Retorna los registros
     */
    public Set<Registro> getRegistros() {
        return registros;
    }

    /**
     *
     * @return:  Retorna los tipos
     */
    public Set<Tipo> getTipos() {
        return tipos;
    }
}
