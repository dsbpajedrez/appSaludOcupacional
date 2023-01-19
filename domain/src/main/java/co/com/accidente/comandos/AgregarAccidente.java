package co.com.accidente.comandos;

import co.com.accidente.valor.AccidenteId;
import co.com.accidente.valor.Clasificacion;
import co.com.sofka.domain.generic.Command;

public class AgregarAccidente extends Command {
    private final AccidenteId accidenteId;
    private final Clasificacion clasificacion;


    public AgregarAccidente(AccidenteId accidenteId, Clasificacion clasificacion) {
        this.accidenteId = accidenteId;
        this.clasificacion = clasificacion;
    }

    public AccidenteId getAccidenteId() {return this.accidenteId;}
    public Clasificacion clasificacion() {return this.clasificacion;}
}
