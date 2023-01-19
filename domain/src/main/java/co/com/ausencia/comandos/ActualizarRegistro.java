package co.com.ausencia.comandos;

import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.domain.generic.Command;

public class ActualizarRegistro extends Command {
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;
    public ActualizarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        this.fecha = fecha;
        this.lugar = lugar;
        this.idRegistro = idRegistro;
    }

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
