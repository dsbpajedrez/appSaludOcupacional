package co.com.trabajador.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.trabajador.valor.IdCargo;
import co.com.trabajador.valor.IdDepartamento;
import co.com.trabajador.valor.IdTrabajador;
import co.com.trabajador.valor.NombreCargo;
import co.com.trabajador.valor.NombreDepartamento;

public class ActualizarDepartamento extends Command {

    private final IdTrabajador idTrabajador;
    private final IdDepartamento idDepartamento;
    private final NombreDepartamento nombreDepartamento;

    public ActualizarDepartamento(IdTrabajador idTrabajador, IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento) {
        this.idTrabajador = idTrabajador;
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public IdTrabajador getIdTrabajador() {
        return idTrabajador;
    }

    public IdDepartamento getIdDepartamento() {
        return idDepartamento;
    }

    public NombreDepartamento getNombreDepartamento() {
        return nombreDepartamento;
    }
}
