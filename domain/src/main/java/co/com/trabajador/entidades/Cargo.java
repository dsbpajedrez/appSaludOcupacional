    package co.com.trabajador.entidades;


    import co.com.sofka.domain.generic.Entity;
    import co.com.trabajador.valor.IdCargo;
    import co.com.trabajador.valor.NombreCargo;

    import java.util.Objects;

    /**
     * [Entidad Cargo]
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
    public class Cargo extends Entity<IdCargo> {

        /**
         * Representa el nombre del cargo
         */
        private NombreCargo nombreCargo;

        /**
         * Constructor de la clase que crea una instancia de Cargo
         * @param idCargo
         * @param nombreCargo
         */
        public Cargo(IdCargo idCargo, NombreCargo nombreCargo) {
            super(idCargo);
            this.nombreCargo = nombreCargo;
        }

        /**
         * Muestra el nombre del cargo
         * @return nombre del cargo
         */
        public NombreCargo nombreCargo() {
            return nombreCargo;
        }

        /**
         * Método que actualiza el cargo
         * @param nombreCargo
         */
        public void actualizar(NombreCargo nombreCargo) {
            this.nombreCargo = Objects.requireNonNull(nombreCargo);
        }
    }
