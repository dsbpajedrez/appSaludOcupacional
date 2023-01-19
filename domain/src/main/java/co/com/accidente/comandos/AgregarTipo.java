package co.com.accidente.comandos;

import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.Command;

public class AgregarTipo extends Command {
    private IdTipo idTipo;
    private Severidad severidad;

    public AgregarTipo(IdTipo idTipo, Severidad severidad){
            this.idTipo = idTipo;
            this.severidad = severidad;
    }

    public IdTipo getIdTipo() {
        return idTipo;
    }

    public Severidad getSeveridad() {
        return severidad;
    }

}
