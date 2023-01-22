package co.com.trabajador.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.trabajador.entidades.Cargo;
import co.com.trabajador.entidades.Departamento;
import co.com.trabajador.valor.DatosPersonalesTrabajador;
import co.com.trabajador.valor.IdTrabajador;

public class AgregarTrabajador extends Command {

    private final IdTrabajador idTrabajador;
    private final Departamento departamento;
    private final Cargo cargo;
    private final DatosPersonalesTrabajador datosPersonales;

    public AgregarTrabajador(IdTrabajador idTrabajador, Departamento departamento, Cargo cargo, DatosPersonalesTrabajador datosPersonales) {
        this.idTrabajador = idTrabajador;
        this.departamento = departamento;
        this.cargo = cargo;
        this.datosPersonales = datosPersonales;
    }

    public IdTrabajador getIdTrabajador() {
        return idTrabajador;
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
