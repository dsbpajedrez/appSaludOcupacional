package co.com.accidente;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.eventos.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;
/**
 * [AccidenteChange]
 *
 * @version [1.0.0 2023-01-22,    La clase corresponde a la versión 1 del sistema,
 *                                no ha sufrido refactorings durante la versión,
 *                                no se han realizado cambios.
 *
 * @author [Valentina Santa Muñoz – valen_2605@hotmail.com]
 * @author [David Santiago Benjumea Pérez – dsbpim@gmail.com]
 *
 * @since [Versión 1]
 *
 */
public class AccidenteChange extends EventChange {
    /**
     * AccidenteChange: Recibe los eventos y actualiza los componentes pertinentes
     * @param accidente: Parámetro de la instancia de accidente
     */
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
            tipoAactualizar.actualizarSeveridad(event.getSeveridad());
        });
    }
}
