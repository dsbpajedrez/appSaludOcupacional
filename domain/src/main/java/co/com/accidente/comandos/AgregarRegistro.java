package co.com.accidente.comandos;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
import co.com.sofka.domain.generic.Command;
/**
 * [Comando AgregarRegistro]
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
public class AgregarRegistro extends Command {
    private IdAccidente idAccidente;
    private IdRegistro idRegistro;
    private Fecha fecha;
    private Lugar lugar;

    /**
     * Constructor
     * @param idAccidente: Identificador del accidente
     * @param idRegistro: Identificador del registro del accidente
     * @param lugar: Lugar del accidente
     * @param fecha: Fecha del accidente
     */
    public AgregarRegistro(IdAccidente idAccidente,IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        this.idRegistro = idRegistro;
        this.fecha = fecha;
        this.lugar = lugar;
        this.idAccidente = idAccidente;
    }

    /**
     *
     * @return: Retorna el idRegistro
     */
    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    /**
     *
     * @return: Retorna la fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     *
     * @return: Retorna el lugar
     */
    public Lugar getLugar() {
        return lugar;
    }

    /**
     *
     * @return: Retorna el idAccidente
     */
    public IdAccidente getIdAccidente() {
        return idAccidente;
    }
}
