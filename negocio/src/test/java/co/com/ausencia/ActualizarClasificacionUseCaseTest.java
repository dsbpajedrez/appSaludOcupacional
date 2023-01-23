package co.com.ausencia;

import co.com.ausencia.comandos.ActualizarClasificacion;
import co.com.ausencia.comandos.ActualizarRegistro;
import co.com.ausencia.eventos.*;
import co.com.ausencia.valor.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarClasificacionUseCaseTest {
    @InjectMocks
    private ActualizarClasificacionUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void aupdateRegistro() {
//        arrange
        IdAusencia idAusencia = IdAusencia.of("1");
        IdClasificacion idClasificacion =  IdClasificacion.of("2");
        Descripcion descripcion = new Descripcion("Descrito");
        Tipo tipo = new Tipo("Ausencia casera");
        var command = new ActualizarClasificacion(idAusencia,idClasificacion,descripcion,tipo);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

//        when
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getIdAusencia().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        assert
        var event = (ClasificacionActualizada) events.get(0);
        assertEquals("2", event.getIdClasificacion().value());
        assertEquals("Ausencia casera", event.getTipo().value());
    }
    private List<DomainEvent> history() {
        IdAusencia idAusencia = IdAusencia.of("1");
        Duracion duracion = new Duracion(LocalDateTime.now());
        var event = new AusenciaAgregada(duracion);
        event.setAggregateRootId(idAusencia.value());

        IdClasificacion idClasificacion =  IdClasificacion.of("2");
        Descripcion descripcion = new Descripcion("Descrito");
        Tipo tipo = new Tipo("Ausencia casera");
        var event2 = new ClasificacionAgregada(idClasificacion,descripcion,tipo);
        event2.setAggregateRootId(idAusencia.value());
        return List.of(event, event2);
    }

}