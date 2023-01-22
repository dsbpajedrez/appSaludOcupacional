package co.com.ausencia.comandos;

import co.com.ausencia.valor.Duracion;
import co.com.sofka.domain.generic.Command;

public class AgregarAusencia extends Command {
    private Duracion duracion;

    public AgregarAusencia(Duracion duracion){
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
