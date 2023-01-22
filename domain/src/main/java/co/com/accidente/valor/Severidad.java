package co.com.accidente.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Severidad implements ValueObject<String> {
    private  String value;

    public Severidad(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La severidad no puede quedar en blanco");
        }
    }
    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Severidad severidad = (Severidad) o;
        return Objects.equals(value, severidad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
