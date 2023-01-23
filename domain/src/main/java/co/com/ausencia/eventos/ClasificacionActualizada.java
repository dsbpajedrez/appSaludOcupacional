package co.com.ausencia.eventos;

import co.com.ausencia.valor.Descripcion;
import co.com.ausencia.valor.Estado;
import co.com.ausencia.valor.IdClasificacion;
import co.com.ausencia.valor.Tipo;
import co.com.sofka.domain.generic.DomainEvent;
/**
 * [Evento ClasificacionActualizada]
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
public class ClasificacionActualizada extends DomainEvent {
    private IdClasificacion idClasificacion;
    private Descripcion descripcion;
    private Tipo tipo;

    /**
     * Constructor
     * @param idClasificacion: Identidad de la clasificación
     * @param descripcion: Descripción de la ausencia
     * @param tipo: Tipo de la ausencia
     */
    public ClasificacionActualizada(IdClasificacion idClasificacion,
                                    Descripcion descripcion, Tipo tipo){
        super("co.com.ausencia.eventos.ClasificacionActualizada");
        this.idClasificacion = idClasificacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    /**
     * Getter
     * @return: Retorna el idClasificacion
     */
    public IdClasificacion getIdClasificacion() {
        return idClasificacion;
    }

    /**
     * Getter
     * @return: Retorna la descripción
     */
    public Descripcion getDescripcion() {
        return descripcion;
    }

    /**
     * Getter
     * @return: Retorna el tipo
     */
    public Tipo getTipo() {
        return tipo;
    }
}
