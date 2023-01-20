package co.com.ausencia.entidades;

import co.com.ausencia.valor.*;
import co.com.sofka.domain.generic.Entity;

public class Registro extends Entity<IdRegistro> {
   private IdRegistro idRegistro;
   private Estado estado;

    public Registro(IdRegistro idRegistro, Estado estado) {
        super(idRegistro);
        this.estado = estado;
    }
    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}