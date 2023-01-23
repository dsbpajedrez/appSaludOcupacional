    package co.com.trabajador.valor;

    import co.com.sofka.domain.generic.Identity;

    /**
     * [Clase que representa el objeto de valor IdDepartamento]
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
    public class IdDepartamento extends Identity {

        /**
         * Constructor de la clase que crea una instancia de IdDepartamento y retornar el valor
         * @param valor id
         */
        private IdDepartamento(String valor) {
            super(valor);
        }

        /**
         * Constructor de la clase que crea una instancia de IdDepartamento
         */
        public IdDepartamento () {};

        /**
         * Muestra el valor del id del departamento
         * @param valor id
         * @return
         */
        public static IdDepartamento of(String valor) {
            return new IdDepartamento(valor);
        }
    }
