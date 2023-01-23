package co.com.accidente.eventos;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
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
    private Lugar lugar;
    private Fecha fecha;

    /**
     * Constructor
     * @param idRegistro: Identificador del registro del accidente
     * @param lugar: Lugar del accidente
     * @param fecha: Fecha del accidente
     */
    public RegistroActualizado(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        super("co.com.accidente.eventos.RegistroActualizado");
        this.idRegistro = idRegistro;
        this.fecha = fecha;
        this.lugar = lugar;
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
