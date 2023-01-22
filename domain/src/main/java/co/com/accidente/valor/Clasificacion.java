package co.com.accidente.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * [Objeto de valor Clasificación]
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
public class Clasificacion implements ValueObject<String> {
    public String value;

    /**
     * Constructor: Dentro de éste se verifica que no sea nulo ni que esté en blanco
     * @param value: Valor de tipo String
     */
    public Clasificacion(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La clasificiación no puede quedar en blanco");
        }
    }

    /**
     * Getter
     * @return: Retorna el valor para la clasificación
     */
    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clasificacion that = (Clasificacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
