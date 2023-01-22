package co.com.ausencia.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class Duracion implements ValueObject<LocalDateTime> {
    private  LocalDateTime value;

    public Duracion(LocalDateTime value){
        this.value = Objects.requireNonNull(value);

    }
    @Override
    public LocalDateTime value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duracion duracion = (Duracion) o;
        return Objects.equals(value, duracion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
