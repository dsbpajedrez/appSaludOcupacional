package co.com.accidente.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * [Objeto de valor Lugar]
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
public class Lugar implements ValueObject<String> {
    private  String value;

    /**
     * Constructor: Dentro de éste se verifica que no sea nulo ni esté en blanco
     * @param value: Parámetro del valor para el lugar
     */
    public Lugar(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El lugar no puede estar en blanco");
        }
    }

    /**
     * Getter
     * @return: Retorna el valor
     */
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
