package co.com.accidente.comandos;

import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.Command;

public class ActualizarTipo extends Command {
    private IdTipo idTipo;
    private Severidad severidad;

    public ActualizarTipo(IdTipo idTipo, Severidad severidad){
        this.severidad = severidad;
        this.idTipo = idTipo;
    }

    public IdTipo getIdTipo() {
        return idTipo;
    }

    public Severidad getSeveridad() {
        return severidad;
    }
}
