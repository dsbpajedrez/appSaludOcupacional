package co.com.ausencia.comandos;

import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.domain.generic.Command;

public class AgregarRegistro extends Command {
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;
    public AgregarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        this.fecha = fecha;
        this.idRegistro = idRegistro;
        this.lugar = lugar;
    }

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
