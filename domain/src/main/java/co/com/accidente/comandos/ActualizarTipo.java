package co.com.accidente.comandos;

import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipo extends Command {
    IdAccidente idAccidente;
    private IdTipo idTipo;
    private Severidad severidad;

    public ActualizarTipo(IdAccidente idAccidente,IdTipo idTipo, Severidad severidad){
        this.severidad = severidad;
        this.idTipo = idTipo;
        this.idAccidente = idAccidente;
    }

    public IdTipo getIdTipo() {
        return idTipo;
    }

    public IdAccidente getIdAccidente() {
        return idAccidente;
    }

    public Severidad getSeveridad() {
        return severidad;
    }
}
