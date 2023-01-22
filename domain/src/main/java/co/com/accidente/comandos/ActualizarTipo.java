package co.com.accidente.comandos;

import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.Command;
/**
 * [Comando ActualizarTipo]
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

public class ActualizarTipo extends Command {
    private final IdAccidente idAccidente;
    private final IdTipo idTipo;
    private final Severidad severidad;

    /**
     * Constructor ActualizarTipo
     * @param idAccidente: Identificador del accidente
     * @param idTipo: Identificador del tipo de accidente
     * @param severidad: Severidad del accidente
     */

    public ActualizarTipo(IdAccidente idAccidente,IdTipo idTipo, Severidad severidad){
        this.severidad = severidad;
        this.idTipo = idTipo;
        this.idAccidente = idAccidente;
    }

    /**
     * @return: Retorna el idTipo
     */
    public IdTipo getIdTipo() {
        return idTipo;
    }

    /**
     * @return: Retorna el idAccidente
     */
    public IdAccidente getIdAccidente() {
        return idAccidente;
    }

    /**
     *
     * @return: Retorna la severidad
     */
    public Severidad getSeveridad() {
        return severidad;
    }
}
