package co.com.ausencia;

import co.com.accidente.AgregarAccidenteUseCase;
import co.com.accidente.comandos.AgregarAccidente;
import co.com.accidente.eventos.AccidenteAgregado;
import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdAccidente;
import co.com.ausencia.comandos.AgregarAusencia;
import co.com.ausencia.eventos.AusenciaAgregada;
import co.com.ausencia.valor.Duracion;
import co.com.ausencia.valor.IdAusencia;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgregarAusenciaUseCaseTest {
    private AgregarAusenciaUseCase useCase;
    @BeforeEach
    public void setUp() {
        useCase = new AgregarAusenciaUseCase();
    }

    @Test
    public void addAccidente() {
//        given
        IdAusencia idAusencia = IdAusencia.of("1");
        Duracion duracion = new Duracion(LocalDateTime.now());
        var command = new AgregarAusencia(idAusencia,duracion);
//        when
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        var agregarAusencia = (AusenciaAgregada) domainEvents.get(0);
        assertEquals("1", agregarAusencia.aggregateRootId());
        assertEquals(duracion.value(), agregarAusencia.getDuracion().value());
    }
}