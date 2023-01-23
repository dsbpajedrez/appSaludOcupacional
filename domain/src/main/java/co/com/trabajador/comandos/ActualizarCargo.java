    package co.com.trabajador.comandos;

    import co.com.sofka.domain.generic.Command;
    import co.com.trabajador.valor.IdCargo;
    import co.com.trabajador.valor.IdTrabajador;
    import co.com.trabajador.valor.NombreCargo;

    /**
     * [Comando para actualizar cargo]
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
    public class ActualizarCargo extends Command {

        /**
         * Representa el id del trabajador
         */
        private final IdTrabajador idTrabajador;
        /**
         * Representa el id del cargo
         */
        private final IdCargo idCargo;

        /**
         * Representa el nombre del cargo
         */
        private final NombreCargo nombreCargo;

        /**
         * Constructor de la clase que crea una instancia de Actualizar Cargo
         * @param idTrabajador
         * @param idCargo
         * @param nombreCargo
         */
        public ActualizarCargo(IdTrabajador idTrabajador,IdCargo idCargo, NombreCargo nombreCargo) {
            this.idTrabajador = idTrabajador;
            this.idCargo = idCargo;
            this.nombreCargo = nombreCargo;
        }

        /**
         * Muestra el id del trabajador
         * @return id del trabajador
         */
        public IdTrabajador getIdTrabajador() {
            return idTrabajador;
        }

        /**
         * Muestra el id del cargo
         * @return id del cargo
         */
        public IdCargo getIdCargo() {
            return idCargo;
        }

        /**
         * Muestra el nombre del cargo
         * @return nombre del cargo
         */
        public NombreCargo getNombreCargo() {
            return nombreCargo;
        }
    }
