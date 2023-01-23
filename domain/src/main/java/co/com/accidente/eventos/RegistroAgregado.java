package co.com.accidente.eventos;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
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
     * @param idRegistro
     * @param lugar
     * @param fecha
     */
    public RegistroAgregado(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        super("co.com.accidente.eventos.RegistroAgregado");
        this.fecha = fecha;
        this.idRegistro = idRegistro;
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
