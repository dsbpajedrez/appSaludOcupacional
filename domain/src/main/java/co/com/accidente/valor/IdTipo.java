package co.com.accidente.valor;

import co.com.sofka.domain.generic.Identity;
/**
 * [Identidad IdTipo]
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
public class IdTipo extends Identity {
    /**
     * Constructor
     */
    public IdTipo(){

    }

    /**
     * Constructor del IdTipo
     * @param id: Identificador del tipo
     */
    private IdTipo(String id){
        super(id);
    }

    /**
     * IdTipo: Método estático que retorna una instancia del IdTipo
     * @param id: Identificador del tipo
     * @return: Retorna una nueva instancia del IdTipo
     */
    public static IdTipo of(String id){
        return new IdTipo(id);
    }

}
