package co.com.trabajador.comandos;

import co.com.sofka.domain.generic.Command;
import co.com.trabajador.valor.IdDepartamento;
import co.com.trabajador.valor.IdTrabajador;
import co.com.trabajador.valor.NombreDepartamento;

public class AgregarDepartamento extends Command {

    private final IdDepartamento idDepartamento;
    private final NombreDepartamento nombreDepartamento;

    public AgregarDepartamento(IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public IdDepartamento getIdDepartamento() {
        return idDepartamento;
    }

    public NombreDepartamento getNombreDepartamento() {
        return nombreDepartamento;
    }


}
