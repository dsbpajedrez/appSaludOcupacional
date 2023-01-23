package co.com.ausencia.comandos;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.Command;
/**
 * [Comando ActualizarClasificacion]
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
public class ActualizarClasificacion extends Command {
    IdAusencia idAusencia;
    private IdClasificacion idClasificacion;
    private Descripcion descripcion;
    private Tipo tipo;

    /**
     * Constructor
     * @param idClasificacion: Idetidad de la clasificacion
     * @param descripcion: Descripción de la ausencia
     * @param tipo: Tipo de la ausencia
     */
    public ActualizarClasificacion(IdAusencia idAusencia,IdClasificacion idClasificacion,
                                   Descripcion descripcion, Tipo tipo){
        this.idClasificacion = idClasificacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.idAusencia = idAusencia;
    }

    public IdAusencia getIdAusencia() {
        return idAusencia;
    }

    /**
     * Getter
     * @return Retorna la identidad de la clasificación
     */
    public IdClasificacion getIdClasificacion() {
        return idClasificacion;
    }

    /**
     * Getter
     * @return: Retorna la descripcion
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
