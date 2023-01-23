package co.com.ausencia.comandos;

import co.com.ausencia.valor.Duracion;
import co.com.ausencia.valor.IdAusencia;
import co.com.sofka.domain.generic.Command;
/**
 * [Comando AgregarAusencia]
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
public class AgregarAusencia extends Command {
    private IdAusencia idAusencia;
    private Duracion duracion;

    /**
     * Constructor
     * @param idAusencia: Identidad de la ausencia
     * @param duracion: Duración de la ausencia
     */
    public AgregarAusencia(IdAusencia idAusencia,Duracion duracion){
        this.idAusencia = idAusencia;
        this.duracion = duracion;
    }

    /**
     * Getter
     * @return: Retorna el idAusencia
     */
    public IdAusencia getIdAusencia() {
        return idAusencia;
    }

    /**
     * Getter
     * @return: Retorna la duracion
     */
    public Duracion getDuracion() {
        return duracion;
    }
}
