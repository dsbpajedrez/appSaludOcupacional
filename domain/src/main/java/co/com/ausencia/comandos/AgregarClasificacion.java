package co.com.ausencia.comandos;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.Command;
/**
 * [Comando AgregarClasificacion]
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
public class AgregarClasificacion extends Command {
    private IdAusencia idAusencia;
    private IdClasificacion idClasificacion;
    private Descripcion descripcion;
    private Tipo tipo;

    /**
     * Constructor
     * @param idAusencia: Identidad de la ausencia
     * @param idClasificacion: Identidad de la clasificación
     * @param descripcion: Descripción del motivo de la ausencia
     * @param tipo: Tipo de ausencia
     */
    public AgregarClasificacion(IdAusencia idAusencia, IdClasificacion idClasificacion,
                                Descripcion descripcion, Tipo tipo){
        this.idAusencia = idAusencia;
        this.idClasificacion = idClasificacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    /**
     * Getter
     * @return: Retorna idClasificacion
     */
    public IdClasificacion getIdClasificacion() {
        return idClasificacion;
    }

    /**
     * Getter
     * @return: Retorna idAusencia
     */
    public IdAusencia getIdAusencia() {
        return idAusencia;
    }

    /**
     * Getter
     * @return: Retorna la descripción del caso
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
