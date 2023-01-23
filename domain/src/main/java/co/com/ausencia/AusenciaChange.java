package co.com.ausencia;

import co.com.ausencia.entidades.Clasificacion;
import co.com.ausencia.entidades.Registro;
import co.com.ausencia.eventos.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;
/**
 * [AusenciaeChange]
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
public class AusenciaChange extends EventChange {
    /**
     * AusenciaChanfe: Recibe los eventos y actualiza los componentes pertinentes
     * @param ausencia: Parámetro de la instancia de ausencia
     */
    public AusenciaChange(Ausencia ausencia) {
        apply((AusenciaAgregada event)->{
            ausencia.duracion = event.getDuracion();
            ausencia.registros = new HashSet<>();
            ausencia.clasificaciones = new HashSet<>();
        });
        apply((ClasificacionActualizada event)->{
            var clasificado = ausencia.
                                                getClasificacionPorId(event.getIdClasificacion())
                    .orElseThrow(() -> new IllegalArgumentException("no se encuentra información de la clasificación"));
            clasificado.cambiarDescripcion(event.getDescripcion());
            clasificado.cambiarTipo(event.getTipo());
        });
        apply((ClasificacionAgregada event)->{
            ausencia.clasificaciones.add(
                    new Clasificacion(event.getIdClasificacion(),event.getDescripcion(),event.getTipo()));
        });
        apply((RegistroAgregado event)->{
            ausencia.registros.add(new Registro(event.getIdRegistro(),event.getLugar(), event.getFecha()));
        });
        apply((RegistroActualizado event)->{
            var registrado = ausencia
                    .getRegistroPorId(event.getIdRegistro())
                    .orElseThrow(()-> new IllegalArgumentException("No se encontro el registro"));
            //cambiar lugar y fecha
            registrado.cambiarLugar(event.getLugar());

        });

    }
}
