package co.com.ausencia;

import co.com.ausencia.entidades.Clasificacion;
import co.com.ausencia.entidades.Registro;
import co.com.ausencia.eventos.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class AusenciaChange extends EventChange {
    public AusenciaChange(Ausencia ausencia) {
        apply((AusenciaAgregada event)->{
            ausencia.duracion = event.getDuracion();
            ausencia.registros = new HashSet<>();
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
