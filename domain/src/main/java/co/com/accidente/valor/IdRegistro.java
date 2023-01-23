package co.com.accidente.valor;


import co.com.sofka.domain.generic.Identity;
/**
 * [Identidad IdRegistro]
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
public class IdRegistro extends Identity {
    /**
     * Constructor
     */
    public IdRegistro(){

    }

    /**
     * Constructor del IdRegistro
     * @param id: Identificador del registro
     */
    private IdRegistro(String id){
        super(id);
    }

    /**
     * IdRegistro: Método estático que retorna una instancia del IdRegistro
     * @param id: Identificador del registro
     * @return: Retorna una nueva instancia del IdRegistro
     */
    public static IdRegistro of(String id){
        return new IdRegistro(id);
    }
}
