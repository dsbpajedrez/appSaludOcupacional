    package co.com.trabajador.eventos;

    import co.com.sofka.domain.generic.DomainEvent;
    import co.com.trabajador.valor.IdCargo;
    import co.com.trabajador.valor.NombreCargo;

    /**
     * [Clase que representa el evento Cargo Agregado]
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
    public class CargoAgregado extends DomainEvent {

        /**
         * Representa el id del cargo
         */
        private final IdCargo idCargo;
        /**
         * Representa el nombre del cargo
         */
        private final NombreCargo nombreCargo;

        /**
         * Constructor de la clase que crea una instancia de Cargo Agregado
         * @param idCargo
         * @param nombreCargo
         */
        public CargoAgregado(IdCargo idCargo, NombreCargo nombreCargo) {
            super("co.com.trabajador.CargoAgregado");
            this.idCargo = idCargo;
            this.nombreCargo = nombreCargo;
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
         * @return
         */
        public NombreCargo getNombreCargo() {
            return nombreCargo;
        }

    }
