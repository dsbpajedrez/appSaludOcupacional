package co.com.accidente;

import co.com.accidente.comandos.ActualizarTipo;
import co.com.accidente.eventos.TipoActualizado;
import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.when;

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

        when(repository.getEventsBy("ddd")).thenReturn(history());
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

    private List<DomainEvent> history() {
        IdAccidente idAccidente = IdAccidente.of("dasd");
        Clasificacion clasificacion = new Clasificacion("Nueva");
        IdTipo idTipo = IdTipo.of("dsad");
        Severidad severidad = new Severidad("Nueva");
        Accidente accidente = new Accidente(idAccidente, clasificacion);
        var event = new TipoActualizado(
                idTipo, severidad
        );
        event.setAggregateRootId("dddd");
        return List.of(event);
    }
}