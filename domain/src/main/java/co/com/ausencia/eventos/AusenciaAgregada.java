package co.com.ausencia.eventos;

import co.com.ausencia.valor.Duracion;
import co.com.sofka.domain.generic.DomainEvent;
/**
 * [Evento AusenciaAgregada]
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
public class AusenciaAgregada extends DomainEvent {
    private Duracion duracion;

    /**
     * Constructor
     * @param duracion: Parámetro duracion de la ausencia
     */
    public AusenciaAgregada(Duracion duracion){
        super("co.com.ausencia.eventos.AusenciaAgregada");
        this.duracion = duracion;
    }

    /**
     *Getter
     * @return: Retorna la duración
     */
    public Duracion getDuracion() {
        return duracion;
    }
}
