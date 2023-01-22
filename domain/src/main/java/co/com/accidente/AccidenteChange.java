package co.com.accidente;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.eventos.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class AccidenteChange extends EventChange {
    public AccidenteChange(Accidente accidente) {
        apply((AccidenteAgregado event)->{
            accidente.clasificacion = event.getClasificacion();
            accidente.tipos = new HashSet<>();
            accidente.registros = new HashSet<>();
        });
        apply((RegistroAgregado event)->{
            accidente.registros.add(new Registro(event.getIdRegistro(), event.getLugar(), event.getFecha()));
        });
        apply((RegistroActualizado event)->{
            var regActualizado = accidente.getRegistroPorId(event.getIdRegistro())
                    .orElseThrow(()->new IllegalArgumentException("No se encontro el id del registro"));
            regActualizado.cambiarLugar(event.getLugar());
            regActualizado.cambiarFecha(event.getFecha());
        });
        apply((TipoAgregado event)->{
            accidente.tipos.add(new Tipo(event.getIdTipo(), event.getSeveridad()));
        });
        apply((TipoActualizado event)->{
            var tipoAactualizar = accidente.getTipoPorId(event.getIdTipo())
                    .orElseThrow(()->new IllegalArgumentException("No se encontro el id del tipo: "+ event.getIdTipo()));
            tipoAactualizar.actualizarTipo(event.getSeveridad());
        });
    }
}
