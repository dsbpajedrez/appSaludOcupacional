package co.com.accidente.comandos;

import co.com.accidente.valor.Fecha;
import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.IdRegistro;
import co.com.accidente.valor.Lugar;
import co.com.sofka.domain.generic.Command;

public class AgregarRegistro extends Command {
    private IdAccidente idAccidente;
    private IdRegistro idRegistro;
    private Fecha fecha;
    private Lugar lugar;

    public AgregarRegistro(IdAccidente idAccidente,IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        this.idRegistro = idRegistro;
        this.fecha = fecha;
        this.lugar = lugar;
        this.idAccidente = idAccidente;
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

    public IdAccidente getIdAccidente() {
        return idAccidente;
    }
}
