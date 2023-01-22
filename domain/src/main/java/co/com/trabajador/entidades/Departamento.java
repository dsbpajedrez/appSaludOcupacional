package co.com.trabajador.entidades;

import co.com.sofka.domain.generic.Entity;
import co.com.trabajador.valor.IdDepartamento;
import co.com.trabajador.valor.NombreDepartamento;

import java.util.Objects;

public class Departamento extends Entity<IdDepartamento> {

    private NombreDepartamento nombreDepartamento;

    public Departamento(IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento) {
        super(idDepartamento);
        this.nombreDepartamento = nombreDepartamento;
    }


    public NombreDepartamento nombreDepartamento() {
        return nombreDepartamento;
    }

    public void actualizar(NombreDepartamento nombreDepartamento) {
        this.nombreDepartamento = Objects.requireNonNull(nombreDepartamento);
    }
}
