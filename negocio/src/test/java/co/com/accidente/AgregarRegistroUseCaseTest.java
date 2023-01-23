package co.com.accidente;
import co.com.accidente.comandos.AgregarRegistro;
import co.com.accidente.entidades.Registro;
import co.com.accidente.eventos.AccidenteAgregado;
import co.com.accidente.eventos.RegistroAgregado;
import co.com.accidente.valor.*;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        IdAccidente idAccidente = IdAccidente.of("1");
        IdRegistro idRegistro =  IdRegistro.of("2");
        Lugar lugar = new Lugar("Escaleras");
        Fecha fecha = new Fecha(LocalDateTime.now());
        var command = new AgregarRegistro(idAccidente,idRegistro,lugar,fecha);

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
        assertEquals("Escaleras", event.getLugar().value());
    }
    private List<DomainEvent> history() {
        IdAccidente idAccidente = IdAccidente.of("1");
        Clasificacion clasificacion = new Clasificacion("Clasificado");
        Lugar lugar = new Lugar("Escaleras");
        Fecha fecha = new Fecha(LocalDateTime.now());
        Registro registro = new Registro(IdRegistro.of("2"),lugar,fecha);
        var event = new AccidenteAgregado(clasificacion);
        event.setAggregateRootId(idAccidente.value());
        return List.of(event);
    }

}
