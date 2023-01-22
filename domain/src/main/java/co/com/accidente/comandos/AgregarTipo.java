package co.com.accidente.comandos;

import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.Command;

public class AgregarTipo extends Command {
    private IdAccidente idAccidente;
    private IdTipo idTipo;
    private Severidad severidad;

    public AgregarTipo(IdAccidente idAccidente,IdTipo idTipo, Severidad severidad){
            this.idTipo = idTipo;
            this.severidad = severidad;
            this.idAccidente = idAccidente;
    }

    public IdAccidente getIdAccidente() {
        return idAccidente;
    }

    public IdTipo getIdTipo() {
        return idTipo;
    }

    public Severidad getSeveridad() {
        return severidad;
    }

}
