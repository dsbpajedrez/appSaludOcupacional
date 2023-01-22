package co.com.accidente.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Lugar implements ValueObject<String> {
    private  String value;

    public Lugar(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El lugar no puede estar en blanco");
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
        Lugar lugar = (Lugar) o;
        return Objects.equals(value, lugar.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
