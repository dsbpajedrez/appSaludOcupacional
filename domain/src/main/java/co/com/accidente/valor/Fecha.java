package co.com.accidente.valor;

import co.com.sofka.domain.generic.ValueObject;
import java.time.LocalDateTime;
import java.util.Objects;
/**
 * [Objeto de valor Fecha]
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
public class Fecha implements ValueObject<LocalDateTime> {
    private  LocalDateTime value;
    /**
     * Constructor: Dentro de éste se verifica que no sea nulo
     * @param value: Valor de tipo LocalDateTime
     */
    public Fecha(LocalDateTime value){
        this.value = Objects.requireNonNull(value);

    }

    /**
     * Getter
     * @return: Retorna el valor del tipo LocalDateTime
     */
    @Override
    public LocalDateTime value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha = (Fecha) o;
        return Objects.equals(value, fecha.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
