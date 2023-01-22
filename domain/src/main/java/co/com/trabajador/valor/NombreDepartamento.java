package co.com.trabajador.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreDepartamento implements ValueObject<String> {

    private final String value;

    public NombreDepartamento(String value){
        this.value= Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El departamento no puede estar vacío");
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
        NombreDepartamento that = (NombreDepartamento) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
