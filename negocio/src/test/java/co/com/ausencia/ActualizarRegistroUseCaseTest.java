package co.com.ausencia;


import co.com.ausencia.comandos.ActualizarRegistro;
import co.com.ausencia.eventos.AusenciaAgregada;
import co.com.ausencia.eventos.RegistroActualizado;
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
class ActualizarRegistroUseCaseTest {
    @InjectMocks
    private ActualizarRegistroUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void aupdateRegistro() {
//        arrange
        IdAusencia idAusencia = IdAusencia.of("1");
        IdRegistro idRegistro =  IdRegistro.of("2");
        Lugar lugar = new Lugar("Escaleras");
        Fecha fecha = new Fecha(LocalDateTime.now());
        var command = new ActualizarRegistro(idAusencia,idRegistro,lugar,fecha);

       /* when(repository.getEventsBy("1")).thenReturn(List.of(
                new AusenciaAgregada(new Duracion(fecha.value())),
                new RegistroAgregado(IdRegistro.of("2"),new Lugar("Escaleras"),new Fecha(LocalDateTime.now()))
        ));*/
        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

//        when
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getIdAusencia().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        assert
        var event = (RegistroActualizado) events.get(0);
        assertEquals("2", event.getIdRegistro().value());
        assertEquals("Escaleras", event.getLugar().value());
    }
   private List<DomainEvent> history() {
        IdAusencia idAusencia = IdAusencia.of("1");
        Duracion duracion = new Duracion(LocalDateTime.now());
        var event = new AusenciaAgregada(duracion);
        event.setAggregateRootId(idAusencia.value());
        IdRegistro idRegistro = IdRegistro.of("2");
        Lugar lugar = new Lugar("Escaleras");
        Fecha fecha = new Fecha(LocalDateTime.now());
        var event2 = new RegistroAgregado(idRegistro,lugar,fecha);
        event2.setAggregateRootId(idAusencia.value());
        return List.of(event, event2);
    }

}