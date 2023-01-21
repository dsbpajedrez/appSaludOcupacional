package co.com.accidente;

import co.com.accidente.comandos.ActualizarTipo;
import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
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
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
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
                new TipoAgregado(IdTipo.of("aaa"), new Severidad("ggg")),
                new TipoAgregado(IdTipo.of("eee"), new Severidad("fuerte"))
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

    /*private List<DomainEvent> history() {
        IdAccidente idAccidente = IdAccidente.of("ddd");
        Clasificacion clasificacion = new Clasificacion("Nueva");
        IdTipo idTipo = IdTipo.of("aaa");
        Severidad severidad = new Severidad("fuerte");
        //Accidente accidente = new Accidente(idAccidente, clasificacion);
        Tipo tipo = new Tipo(idTipo, severidad);
        Set<Tipo> tipos = new HashSet<>();
        Set<Registro> registros = new HashSet<>();
        tipos.add(tipo);
        var event = new AccidenteAgregado(idAccidente,tipos, registros,clasificacion);
        /*var event = new TipoActualizado(
                idTipo, severidad
        );
        event.setAggregateRootId("ddd");
        return List.of(event);
    }*/
}