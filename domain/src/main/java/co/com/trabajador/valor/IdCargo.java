    package co.com.trabajador.valor;

    import co.com.sofka.domain.generic.Identity;

    /**
     * [Clase que representa el objeto de valor IdCargo]
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
    public class IdCargo extends Identity {

        /**
         * Constructor de la clase que crea una instancia de IdCargo y retornar el valor
         * @param valor del id del cargo
         */
        private IdCargo(String valor) {
            super(valor);
        }

        /**
         * Constructor de la clase que crea una instancia de id del cargo
         */
        public IdCargo () {};

        /**
         * Muestra el valor del id del cargo
         * @param valor
         * @return
         */
        public static IdCargo of(String valor) {
            return new IdCargo(valor);
        }
    }
