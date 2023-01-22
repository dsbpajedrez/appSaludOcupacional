package co.com.ausencia;

import co.com.ausencia.comandos.AgregarClasificacion;
import co.com.ausencia.comandos.AgregarRegistro;
import co.com.ausencia.eventos.AusenciaAgregada;
import co.com.ausencia.eventos.ClasificacionAgregada;
import co.com.ausencia.eventos.RegistroAgregado;
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
class AgregarClasificacionUseCaseTest {
    @InjectMocks
    private AgregarClasificacionUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void addClasificacion() {
//        given
        IdAusencia idAusencia = IdAusencia.of("1");
        IdClasificacion idClasificacion =  IdClasificacion.of("2");
        Descripcion descripcion = new Descripcion("Se fue pa la playa");
        Tipo tipo = new Tipo("Viaje");
        var command = new AgregarClasificacion(idAusencia,idClasificacion,descripcion, tipo);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

//        when
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getIdAusencia().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        assert
        var event = (ClasificacionAgregada) events.get(0);
        assertEquals("2", event.getIdClasificacion().value());
        assertEquals("Se fue pa la playa", event.getDescripcion().value());
    }
    private List<DomainEvent> history() {
        IdAusencia idAusencia = IdAusencia.of("1");
        Duracion duracion = new Duracion(LocalDateTime.now());
        var event = new AusenciaAgregada(duracion);
        event.setAggregateRootId(idAusencia.value());
        return List.of(event);
    }
}