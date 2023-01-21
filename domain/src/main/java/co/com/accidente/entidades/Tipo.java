package co.com.accidente.entidades;

import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Tipo extends Entity<IdTipo> {
    private IdTipo idTipo;
    private Severidad severidad;
    public Tipo(IdTipo idTipo, Severidad severidad) {
        super(idTipo);
        this.severidad = severidad;
        this.idTipo = idTipo;
    }
    public void actualizarTipo(Severidad severidad) {
        this.severidad = Objects.requireNonNull(severidad);
    }

    public Severidad severidad() {
        return severidad;
    }
}
