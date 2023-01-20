package co.com.trabajador.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.trabajador.entidades.Cargo;
import co.com.trabajador.entidades.Departamento;
import co.com.trabajador.valor.DatosPersonalesTrabajador;
import co.com.trabajador.valor.IdTrabajador;

public class TrabajadorAgregado extends DomainEvent {

    private final Departamento departamento;
    private final Cargo cargo;
    private final DatosPersonalesTrabajador datosPersonales;


    public TrabajadorAgregado(Departamento departamento, Cargo cargo, DatosPersonalesTrabajador datosPersonales) {
        super("co.com.trabajador.TrabajadorAgregado");
        this.departamento= departamento;
        this.cargo=cargo;
        this.datosPersonales= datosPersonales;

    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public DatosPersonalesTrabajador getDatosPersonales() {
        return datosPersonales;
    }

}
