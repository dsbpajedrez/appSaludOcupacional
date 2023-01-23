package co.com.accidente.entidades;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
import co.com.sofka.domain.generic.Entity;
/**
 * [Entidad Registro]
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
public class Registro extends Entity<IdRegistro> {
    private IdRegistro idRegistro;
   private Lugar lugar;
   private Fecha fecha;

    /**
     * Constructor
     * @param idRegistro: Identificador del registro del accidente
     * @param lugar: Lugar del accidente
     * @param fecha: Fecha del accidente
     */
    public Registro(IdRegistro idRegistro, Lugar lugar, Fecha fecha) {
        super(idRegistro);
        this.lugar = lugar;
        this.fecha = fecha;
    }

    /**
     * cambiarLugar: Modifica el lugar del accidente
     * @param lugar: Parámetro del lugar de accidente
     */
    public void cambiarLugar(Lugar lugar) {this.lugar = lugar;}

    /**
     * cambiarFecha: Cambia la fecha del accidente
     * @param fecha: Parámetro fecha del accidente
     */
    public void cambiarFecha(Fecha fecha) {this.fecha = fecha;}

    /**
     *Getter
     * @return: Retorna idRegistro
     */
    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    /**
     * Getter
     * @return: Retorna la fecha
     */
    public Fecha fecha() {
        return fecha;
    }

    /**
     * Getter
     * @return: Retorna el lugar
     */
    public Lugar lugar() {
        return lugar;
    }
}
