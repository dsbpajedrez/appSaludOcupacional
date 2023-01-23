package co.com.ausencia.eventos;

import co.com.ausencia.valor.Estado;
import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.domain.generic.DomainEvent;
/**
 * [Evento RegistroActualizado]
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
public class RegistroActualizado extends DomainEvent {
    private IdRegistro idRegistro;
    private Fecha fecha;
    private Lugar lugar;

    /**
     * Constructor
     * @param idRegistro: Identidad del registro
     * @param lugar: Lugar del caso
     * @param fecha: Fecha de ocurrencia
     */
    public RegistroActualizado(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        super("co.com.ausencia.eventos.RegistroActualizado");
        this.lugar = lugar;
        this.fecha = fecha;
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
