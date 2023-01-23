package co.com.accidente.valor;

import co.com.sofka.domain.generic.Identity;
/**
 * [Identidad IdAccidente]
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
public class IdAccidente extends Identity {
    /**
     * Constructor
     */
    public IdAccidente(){

    }

    /**
     *Constructor del IdAccidente
     * @param id: Identificador del accidente
     */
    private IdAccidente(String id){
        super(id);
    }

    /**
     * IdAccidente: Método estatico que retorna una instancia del identidad del accidente
     * @param id: Parámetro para la identidad del accidente
     * @return: Retorna la instancia de identidad del accidente
     */
    public static IdAccidente of(String id){
        return new IdAccidente(id);
    }
}
