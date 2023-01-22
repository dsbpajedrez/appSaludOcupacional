package co.com.accidente.eventos;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdAccidente;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;
import java.util.UUID;
/**
 * [Evento AccidenteAgregado]
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
public class AccidenteAgregado extends DomainEvent {
    private Clasificacion clasificacion;

    /**
     * Constructor
     * @param clasificacion: Clasificacion del accidente
     */
    public AccidenteAgregado( Clasificacion clasificacion){
        super("co.com.accidente.eventos.AccidenteAgregado");
        this.clasificacion = clasificacion;
    }

    /**
     * Getter
     * @return: Retorna la clasificación del accidente
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}

