package co.com.trabajador;

import co.com.sofka.domain.generic.EventChange;
import co.com.trabajador.eventos.CargoActualizado;
import co.com.trabajador.eventos.CargoAgregado;
import co.com.trabajador.eventos.DepartamentoActualizado;
import co.com.trabajador.eventos.DepartamentoAgregado;
import co.com.trabajador.eventos.TrabajadorAgregado;

public class TrabajadorChange extends EventChange {

    public TrabajadorChange(Trabajador trabajador) {
        apply((TrabajadorAgregado event) ->{
            trabajador.departamento = event.getDepartamento();
            trabajador.cargo = event.getCargo();
            trabajador.datosPersonales = event.getDatosPersonales();
        });
        apply((DepartamentoAgregado event) ->{
            trabajador.departamento = event.getNombreDepartamento();
        });
        apply((CargoAgregado event) ->{
            trabajador.cargo.nombreCargo();
        });
        apply((CargoActualizado event) ->{
            var cargo=trabajador.getCargoPorId(event.getIdCargo())
                    .orElseThrow(() -> new IllegalArgumentException("no se encuentra el cargo"));
            cargo.actualizarCargo(event.getCargo());
        });
        apply((DepartamentoActualizado event) ->{
            var departamento=trabajador.getDepartamentoPorId(event.getIdDepartamento())
                    .orElseThrow(() -> new IllegalArgumentException("no se encuentra el departamento"));
            departamento.actualizarDepartamento(event.getDepartamento());
        });

    }
}
