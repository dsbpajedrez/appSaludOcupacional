package co.com.accidente.comandos;

import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.Clasificacion;
import co.com.sofka.domain.generic.Command;
/**
 * [Comando AgregarAccidente]
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
public class AgregarAccidente extends Command {
    private final IdAccidente idAccidente;
    private Clasificacion clasificacion;

    /**
     * Constructor
     * @param idAccidente: Identificador del accidente
     * @param clasificacion: Clasificación del accidente
     */
    public AgregarAccidente( IdAccidente idAccidente,Clasificacion clasificacion){
        this.idAccidente = idAccidente;

        this.clasificacion = clasificacion;
    }

    /**
     *
     * @return: Retorna el idAccidente
     */
    public IdAccidente getAccidenteId() {return this.idAccidente;}

    /**
     *
     * @return: Retorna la clasificación del accidente
     */
    public Clasificacion getClasificacion() {return this.clasificacion;}


}

