package co.com.accidente.entidades;

import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.Entity;

public class Tipo extends Entity<IdTipo> {
    private Severidad severidad;
    public Tipo(IdTipo idTipo, Severidad severidad) {
        super(idTipo);
        this.severidad = severidad;
    }

    public void actualizar() {}
}
