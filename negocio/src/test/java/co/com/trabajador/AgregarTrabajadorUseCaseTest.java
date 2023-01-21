/*package co.com.trabajador;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.trabajador.comandos.AgregarTrabajador;
import co.com.trabajador.entidades.Cargo;
import co.com.trabajador.entidades.Departamento;
import co.com.trabajador.eventos.TrabajadorAgregado;
import co.com.trabajador.valor.DatosPersonalesTrabajador;
import co.com.trabajador.valor.IdCargo;
import co.com.trabajador.valor.IdDepartamento;
import co.com.trabajador.valor.IdTrabajador;
import co.com.trabajador.valor.NombreCargo;
import co.com.trabajador.valor.NombreDepartamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgregarTrabajadorUseCaseTest {

    private AgregarTrabajadorUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new AgregarTrabajadorUseCase();
    }

    @Test
    public void AgregarTrabajadorNuevo() {
        //Arrange
        var idTrabajador = IdTrabajador.of("458932");
        var departamento = new Departamento(IdDepartamento.of("451889"),"Administrativo");
        var cargo = new Cargo(new IdCargo(),"Gerente");
        var datosPersonales = new DatosPersonalesTrabajador("Juan", "Orozco","458789","juano@gmail.com");

        var command = new AgregarTrabajador(idTrabajador, departamento, cargo,datosPersonales);
        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var trabajadorAgregado = (TrabajadorAgregado) events.get(0);
        Assertions.assertEquals("458932", trabajadorAgregado.aggregateRootId());
        //TODO continuar con los assertions
    }
}
*/