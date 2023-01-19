package co.com.ausencia.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;

public class Fecha implements ValueObject<LocalDateTime> {
    @Override
    public LocalDateTime value() {
        return null;
    }
}
