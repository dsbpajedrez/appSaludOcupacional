package co.com.ausencia.comandos;

import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdAusencia;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
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
    private IdAusencia idAusencia;
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;

    /**
     * Constructor
     * @param idAusencia: Identidad de la ausencia
     * @param idRegistro: Identidad del registro
     * @param lugar: Lugar
     * @param fecha: Fecha de la ausencia
     */
    public AgregarRegistro(IdAusencia idAusencia,IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        this.fecha = fecha;
        this.idRegistro = idRegistro;
        this.lugar = lugar;
        this.idAusencia = idAusencia;
    }
    /**
     * Getter
     * @return:
     */
    public IdAusencia getIdAusencia() {
        return idAusencia;
    }

    /**
     * Getter
     * @return: Retorna el idRegistro
     */
    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    /**
     * Getter
     * @return: Retorna la fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * Getter
     * @return: Retorna el lugar
     */
    public Lugar getLugar() {
        return lugar;
    }
}
