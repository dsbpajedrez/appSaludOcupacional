package co.com.ausencia.entidades;

import co.com.ausencia.valor.Descripcion;
import co.com.ausencia.valor.Estado;
import co.com.ausencia.valor.IdClasificacion;
import co.com.ausencia.valor.Tipo;
import co.com.sofka.domain.generic.Entity;
/**
 * [Entidad Clasificacion]
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

public class Clasificacion extends Entity<IdClasificacion> {
    private Descripcion descripcion;
    private Tipo tipo;

    /**
     * Constructor
     * @param idClasificacion: Identidad de la clasificación
     * @param descripcion: Descripción de la ausencia
     * @param tipo: Tipo de ausencia
     */
    public Clasificacion(IdClasificacion idClasificacion, Descripcion descripcion, Tipo tipo) {
        super(idClasificacion);
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    /**
     * cambiarDescripcion: Función que modifica la descripción
     * del caso
     * @param descripcion: Descripción nueva
     */
    public void cambiarDescripcion(Descripcion descripcion){
        this.descripcion = descripcion;
    }

    /**
     *cambiarTipo: Funcion que modifica el tipo de ausencia
     * @param tipo: Tipo nuevo de ausencia.
     */
    public void cambiarTipo(Tipo tipo){
        this.tipo = tipo;
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
