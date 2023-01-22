package co.com.accidente.comandos;

import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipo extends Command {
    private IdAccidente idAccidente;
    private Severidad severidad;

    public ActualizarTipo(IdAccidente idAccidente, Severidad severidad){
        this.severidad = severidad;
        this.idAccidente = idAccidente;
    }
    public IdAccidente getIdAccidente() {
        return idAccidente;
    }

    public Severidad getSeveridad() {
        return severidad;
    }
}
