package co.com.accidente;

import co.com.accidente.eventos.AccidenteAgregado;
import co.com.accidente.eventos.RegistroAgregado;
import co.com.sofka.domain.generic.EventChange;

public class AccidenteChange extends EventChange {
    public AccidenteChange(Accidente accidente) {
        apply((AccidenteAgregado event)->{
            accidente.clasificacion = event.getClasificacion();
        });

    }
}
