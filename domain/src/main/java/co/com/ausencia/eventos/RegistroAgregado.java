package co.com.ausencia.eventos;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.DomainEvent;
/**
 * [Evento RegistroAgregado]
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
public class RegistroAgregado extends DomainEvent {
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;

    /**
     * Constructor
     * @param idRegistro: Identidad del registro
     * @param lugar: Lugar de la ocurrencia del caso
     * @param fecha: Fecha de la ocurrencia del caso
     */
    public RegistroAgregado(IdRegistro idRegistro, Lugar lugar, Fecha fecha) {
        super("co.com.ausencia.eventos");
        this.idRegistro = idRegistro;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    /**
     * Getter
     * @return: Retonra el idRegistro
     */
    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    /**
     * Setter
     * @param idRegistro: Modifica el idRegistro
     */
    public void setIdRegistro(IdRegistro idRegistro) {
        this.idRegistro = idRegistro;
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
