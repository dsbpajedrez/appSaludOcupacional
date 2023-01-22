package co.com.ausencia.comandos;

import co.com.ausencia.valor.Duracion;
import co.com.ausencia.valor.IdAusencia;
import co.com.sofka.domain.generic.Command;

public class AgregarAusencia extends Command {
    private IdAusencia idAusencia;
    private Duracion duracion;

    public AgregarAusencia(IdAusencia idAusencia,Duracion duracion){
        this.idAusencia = idAusencia;
        this.duracion = duracion;
    }

    public IdAusencia getIdAusencia() {
        return idAusencia;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
