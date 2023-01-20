package co.com.accidente.comandos;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
import co.com.sofka.domain.generic.Command;

public class AgregarRegistro extends Command {
    private IdRegistro idRegistro;
    private Fecha fecha;
    private Lugar lugar;

    public AgregarRegistro(IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        this.idRegistro = idRegistro;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public IdRegistro getIdRegistro() {
        return idRegistro;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Lugar getLugar() {
        return lugar;
    }
}
