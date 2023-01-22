package co.com.ausencia.comandos;

import co.com.accidente.valor.IdAccidente;
import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdAusencia;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.domain.generic.Command;

public class AgregarRegistro extends Command {
    private IdAusencia idAusencia;
    private IdRegistro idRegistro;
    private Lugar lugar;
    private Fecha fecha;
    public AgregarRegistro(IdAusencia idAusencia,IdRegistro idRegistro, Lugar lugar, Fecha fecha){
        this.fecha = fecha;
        this.idRegistro = idRegistro;
        this.lugar = lugar;
        this.idAusencia = idAusencia;
    }

    public IdAusencia getIdAusencia() {
        return idAusencia;
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
