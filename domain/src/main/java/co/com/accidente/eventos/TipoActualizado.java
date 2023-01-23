package co.com.accidente.eventos;

import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.DomainEvent;
/**
 * [Evento TipoActualizado]
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
public class TipoActualizado extends DomainEvent {
    private final IdTipo idTipo;
    private final Severidad severidad;

    /**
     * Constructor
     * @param idTipo: Identificador del tipo de accidente
     * @param severidad: Severidad del accidente
     */
    public TipoActualizado(IdTipo idTipo, Severidad severidad){
        super("co.com.accidente.eventos.TipoActualizado");
        this.severidad = severidad;
        this.idTipo = idTipo;
    }

    /**
     * Getter
     * @return: Retorna el idTipo
     */
    public IdTipo getIdTipo() {
        return idTipo;
    }

    /**
     * Getter
     * @return: Retorna la severidad
     */
    public Severidad getSeveridad() {
        return severidad;
    }
}
