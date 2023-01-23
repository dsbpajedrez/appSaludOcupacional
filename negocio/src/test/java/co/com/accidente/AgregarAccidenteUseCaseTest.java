package co.com.accidente;

import co.com.accidente.comandos.AgregarAccidente;
import co.com.accidente.eventos.AccidenteAgregado;
import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdAccidente;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/**
 * [Clase para pruebas unitarias AgregarAccidente]
 *
 * @version [1.0.0 2023-01-22,    La clase corresponde a la versión 1 del sistema,
 *                                no ha sufrido refactorings durante la versión,
 *                                no se han realizado cambios.
 *
 * @author [Valentina Santa Muñoz – valen_2605@hotmail.com]
 * @author [David Santiago Benjumea Pérez – dsbpim@gmail.com]
 *
 * @since [Versión 1]
 *
 */
class AgregarAccidenteUseCaseTest {
    private AgregarAccidenteUseCase useCase;
    @BeforeEach
    public void setUp() {
        useCase = new AgregarAccidenteUseCase();
    }

    @Test
    public void addAccidente() {
//        given
        IdAccidente idAccidente = IdAccidente.of("1");
        Clasificacion clasificacion = new Clasificacion("Clasificacion1");
        var command = new AgregarAccidente(idAccidente, clasificacion);
//        when
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        var agregarAccidente = (AccidenteAgregado) domainEvents.get(0);
        assertEquals("1", agregarAccidente.aggregateRootId());
        assertEquals("Clasificacion1", agregarAccidente.getClasificacion().value());


    }

}