package co.com.accidente;

import co.com.accidente.comandos.ActualizarTipo;
import co.com.accidente.eventos.AccidenteAgregado;
import co.com.accidente.eventos.TipoActualizado;
import co.com.accidente.eventos.TipoAgregado;
import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;
/**
 * [Clase para pruebas unitarias ActualizarTipo]
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
@ExtendWith(MockitoExtension.class)
class ActualizarTipoUseCaseTest {
    @InjectMocks
    private ActualizarTipoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarTipoTest() {
        //Arrange
        IdAccidente idAccidente = IdAccidente.of("ddd");
        IdTipo idTipo = IdTipo.of("aaa");
        Severidad severidad = new Severidad("fuerte");
        var command = new ActualizarTipo(idAccidente, idTipo, severidad);


        when(repository.getEventsBy("ddd")).thenReturn(List.of(
                new AccidenteAgregado(new Clasificacion("nueva")),
                new TipoAgregado(IdTipo.of("aaa"), new Severidad("g"))
        ));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getIdAccidente().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (TipoActualizado) events.get(0);
        Assertions.assertEquals("fuerte", event.getSeveridad().value());
    }
}