    package co.com.trabajador.valor;

    import co.com.sofka.domain.generic.ValueObject;

    /**
     * [Clase que representa el objeto de valor Datos Personales Trabajador]
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
    public class DatosPersonalesTrabajador implements ValueObject<String> {

        /**
         * Representa el nombre del trabajador
         */
        private final String nombre;
        /**
         * Representa el apellido del trabajador
         */
        private final String apellido;
        /**
         * Representa el teléfono del trabajador
         */
        private final String telefono;
        /**
         * Representa el correo del trabajador
         */
        private final String correo;

        /**
         * Constructor de la clase que crea una instancia de los datos personales del trabajador
         * @param nombre
         * @param apellido
         * @param telefono
         * @param correo
         */
        public DatosPersonalesTrabajador(String nombre, String apellido, String telefono, String correo) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.telefono = telefono;
            this.correo = correo;
        }

        /**
         * Muestra el nombre del trabajador
         * @return nombre
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Muestra el apellido del trabajador
         * @return apellido
         */
        public String getApellido() {
            return apellido;
        }

        /**
         * Muestra el teléfono del trabajador
         * @return teléfono
         */
        public String getTelefono() {
            return telefono;
        }

        /**
         * Muestra el correo del trabajador
         * @return correo del trabajador
         */
        public String getCorreo() {
            return correo;
        }

        /**
         * Método para retornar valores
         * @return value
         */
        @Override
        public String value() {
            return null;
        }
    }
