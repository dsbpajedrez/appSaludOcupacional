package co.com.ausencia.entidades;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.Entity;

public class Registro extends Entity<IdRegistro> {
   private IdRegistro idRegistro;
   private Fecha fecha;
   private Lugar lugar;

    public Registro(IdRegistro idRegistro,Lugar lugar, Fecha fecha) {
        super(idRegistro);
        this.lugar = lugar;
        this.fecha = fecha;
        this.idRegistro = idRegistro;
    }
    public void cambiarLugar(Lugar lugar){
        this.lugar = lugar;
    }
    public void cambiarFecha(Fecha fecha) {this.fecha = fecha;}

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Lugar getLugar() {
        return lugar;
    }
}