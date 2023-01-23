    package co.com.trabajador.valor;

    import co.com.sofka.domain.generic.ValueObject;

    import java.util.Objects;

    /**
     * [Clase que representa el objeto de valor NombreCargo]
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
    public class NombreCargo implements ValueObject<String> {

        /**
         * Representa el valor Nombre del cargo
         */
        private final String value;

        /**
         * Constructor de la clase que crea una instancia de NombreCargo y retornar el valor
         * @param value
         */
        public NombreCargo(String value){
            this.value= Objects.requireNonNull(value);
            if(this.value.isBlank()){
                throw new IllegalArgumentException("El cargo no puede estar vacío");
            }
        }

        /**
         * Método para retornar valor de nombre del cargo
         * @return
         */
        @Override
        public String value() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NombreCargo that = (NombreCargo) o;
            return Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
