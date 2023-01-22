package co.com.trabajador;


import co.com.sofka.domain.generic.EventChange;
import co.com.trabajador.entidades.Cargo;
import co.com.trabajador.entidades.Departamento;
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
            trabajador.departamento = new Departamento(event.getIdDepartamento(), event.getNombreDepartamento());
        });
        apply((CargoAgregado event) ->{
            trabajador.cargo = new Cargo(event.getIdCargo(),event.getNombreCargo());
        });

        apply((CargoActualizado event) ->{
            trabajador.cargo.actualizar(event.getNombreCargo());
        });
       apply((DepartamentoActualizado event) ->{
           trabajador.departamento.actualizar(event.getNombreDepartamento());
        });

    }
}
