package co.com.ausencia.comandos;

import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.domain.generic.Command;
/**
 * [Comando ActualizarRegistro]
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
public class ActualizarRegistro extends Command {
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;

    /**
     * Constructor
     * @param idRegistro: Identidad del registro
     * @param lugar: Parámetro lugar
     * @param fecha: Parámetro  de la fecha
     */
    public ActualizarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        this.fecha = fecha;
        this.lugar = lugar;
        this.idRegistro = idRegistro;
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
     * @return: Retorna el lugar
     */
    public Lugar getLugar() {
        return lugar;
    }

    /**
     * Getter
     * @return: Retorna la fecha
     */
    public Fecha getFecha() {
        return fecha;
    }
}
