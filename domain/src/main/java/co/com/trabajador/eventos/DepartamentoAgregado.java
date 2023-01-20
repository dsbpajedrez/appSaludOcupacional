package co.com.trabajador.eventos;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.trabajador.valor.IdDepartamento;
import co.com.trabajador.valor.NombreDepartamento;

public class DepartamentoAgregado extends DomainEvent {

    private final IdDepartamento idDepartamento;
    private final NombreDepartamento nombreDepartamento;

    public DepartamentoAgregado(IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento) {
        super("co.com.trabajador.DepartamentoAgregado");
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
