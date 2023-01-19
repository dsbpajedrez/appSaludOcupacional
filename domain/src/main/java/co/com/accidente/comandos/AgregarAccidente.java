package co.com.accidente.comandos;

import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.Clasificacion;
import co.com.sofka.domain.generic.Command;

public class AgregarAccidente extends Command {
    private final IdAccidente accidenteId;
    private final Clasificacion clasificacion;


    public AgregarAccidente(IdAccidente accidenteId, Clasificacion clasificacion) {
        this.accidenteId = accidenteId;
        this.clasificacion = clasificacion;
    }

    public IdAccidente getAccidenteId() {return this.accidenteId;}
    public Clasificacion clasificacion() {return this.clasificacion;}
}
