package co.com.accidente;
import co.com.accidente.comandos.AgregarRegistro;
import co.com.accidente.eventos.RegistroAgregado;
import co.com.accidente.valor.IdAccidente;
import co.com.ausencia.valor.Fecha;
import co.com.ausencia.valor.IdRegistro;
import co.com.ausencia.valor.Lugar;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarRegistroUseCaseTest {
    @InjectMocks
    private AgregarAccidenteUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void addRegistro() {
//        given
        IdAccidente idAccidente = IdAccidente.of("1");
        IdRegistro idRegistro =  IdRegistro.of("2");
        Lugar lugar = new Lugar("Escaleras");
        Fecha fecha = new Fecha(LocalDateTime.now());
        var command = new AgregarRegistro(idAccidente, idRegistro, lugar, fecha);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

//        when
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getIdAccidente().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        assert
        var event = (RegistroAgregado) events.get(0);
        assertEquals("2", event.getIdRegistro().value());
        assertEquals(LocalDateTime.now(), event.getFecha().value());
        assertEquals("Escaleras", event.getLugar().value());
        Mockito.verify(repository).getEventsBy("1");
    }

    private List<DomainEvent> history() {
        IdAccidente IdAccidente = IdAccidente.of("fakeTrainerID");
        Name name = new Name("Juan");
        var event = new TrainerCreated(name);
        event.setAggregateRootId(trainerID.value());
        return List.of(event);
    }

}
