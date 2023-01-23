package co.com.ausencia.entidades;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.Entity;
/**
 * [Entidad Resgistro]
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
   private Fecha fecha;
   private Lugar lugar;

    /**
     * Constructor
     * @param idRegistro: Identidad del registro
     * @param lugar: Lugar
     * @param fecha: Fecha de la ausencia
     */
    public Registro(IdRegistro idRegistro,Lugar lugar, Fecha fecha) {
        super(idRegistro);
        this.lugar = lugar;
        this.fecha = fecha;
        this.idRegistro = idRegistro;
    }

    /**
     * cambiarLugar: Función para modificar el lugar
     * @param lugar: Parámetro lugar
     */
    public void cambiarLugar(Lugar lugar){
        this.lugar = lugar;
    }

    /**
     * cambiarFecha: Función para modificar la fecha
     * @param fecha: Parámetro fecha
     */
    public void cambiarFecha(Fecha fecha) {this.fecha = fecha;}

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