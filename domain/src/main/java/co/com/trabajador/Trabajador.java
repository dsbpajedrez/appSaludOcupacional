package co.com.trabajador;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.trabajador.entidades.Cargo;
import co.com.trabajador.entidades.Departamento;
import co.com.trabajador.eventos.CargoActualizado;
import co.com.trabajador.eventos.CargoAgregado;
import co.com.trabajador.eventos.DepartamentoActualizado;
import co.com.trabajador.eventos.DepartamentoAgregado;
import co.com.trabajador.eventos.TrabajadorAgregado;
import co.com.trabajador.valor.DatosPersonalesTrabajador;
import co.com.trabajador.valor.IdCargo;
import co.com.trabajador.valor.IdDepartamento;
import co.com.trabajador.valor.IdTrabajador;
import co.com.trabajador.valor.NombreCargo;
import co.com.trabajador.valor.NombreDepartamento;

import java.util.List;
import java.util.Objects;

public class Trabajador extends AggregateEvent<IdTrabajador> {

    protected DatosPersonalesTrabajador datosPersonales;
    protected Departamento departamento;
    protected Cargo cargo;

    public Trabajador(IdTrabajador idTrabajador, Departamento departamento, Cargo cargo, DatosPersonalesTrabajador datosPersonales) {
        super(idTrabajador);
        appendChange(new TrabajadorAgregado(departamento, cargo, datosPersonales)).apply();
    }

    private Trabajador(IdTrabajador idTrabajador){
        super(idTrabajador);
        subscribe(new TrabajadorChange(this));
    }

    public static Trabajador from(IdTrabajador idTrabajador, List<DomainEvent> events){
        var trabajador= new Trabajador(idTrabajador);
        events.forEach(trabajador::applyEvent);
        return trabajador;
    }

    //comportamiento
    public void agregarDepartamento(IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento){
        Objects.requireNonNull(idDepartamento);
        Objects.requireNonNull(nombreDepartamento);
        appendChange(new DepartamentoAgregado(idDepartamento, nombreDepartamento)).apply();
    }

    public void agregarCargo(IdCargo idCargo, NombreCargo nombreCargo){
        Objects.requireNonNull(idCargo);
        Objects.requireNonNull(nombreCargo);
        appendChange(new CargoAgregado(idCargo, nombreCargo)).apply();
    }

    public void  actualizarCargo(IdCargo idCargo, NombreCargo nombreCargo){
        Objects.requireNonNull(idCargo);
        Objects.requireNonNull(nombreCargo);
        appendChange(new CargoActualizado(idCargo,nombreCargo)).apply();
    }

    public void  actualizarDepartamento(IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento){
        Objects.requireNonNull(idDepartamento);
        Objects.requireNonNull(nombreDepartamento);
        appendChange(new DepartamentoActualizado(idDepartamento,nombreDepartamento)).apply();
    }

    public Cargo getCargoPorId(IdCargo idCargo){
        return cargo;
    }
    public Departamento getDepartamentoPorId(IdDepartamento idDepartamento){
        return departamento;
    }

}
