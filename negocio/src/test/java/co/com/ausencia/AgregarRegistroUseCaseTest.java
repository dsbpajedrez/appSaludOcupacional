package co.com.ausencia;


import co.com.ausencia.comandos.AgregarRegistro;
import co.com.ausencia.entidades.Registro;
import co.com.ausencia.eventos.AusenciaAgregada;
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
/**
 * [Clase para pruebas unitarias AgregarRegistro]
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
class AgregarRegistroUseCaseTest {
    @InjectMocks
    private AgregarRegistroUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void addRegistro() {
//        given
        IdAusencia idAusencia = IdAusencia.of("1");
        IdRegistro idRegistro =  IdRegistro.of("2");
        Lugar lugar = new Lugar("Escaleras");
        Fecha fecha = new Fecha(LocalDateTime.now());
        Duracion duracion = new Duracion(LocalDateTime.now());
        var command = new AgregarRegistro(idAusencia,idRegistro,lugar,fecha);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

//        when
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getIdAusencia().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        assert
        var event = (RegistroAgregado) events.get(0);
        assertEquals("2", event.getIdRegistro().value());
        assertEquals("Escaleras", event.getLugar().value());
    }
    private List<DomainEvent> history() {
        IdAusencia idAusencia = IdAusencia.of("1");
        Duracion duracion = new Duracion(LocalDateTime.now());
        var event = new AusenciaAgregada(duracion);
        event.setAggregateRootId(idAusencia.value());
        return List.of(event);
    }

}