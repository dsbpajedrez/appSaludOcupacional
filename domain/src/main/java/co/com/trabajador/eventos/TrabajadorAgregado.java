    package co.com.trabajador.eventos;

    import co.com.sofka.domain.generic.DomainEvent;
    import co.com.trabajador.entidades.Cargo;
    import co.com.trabajador.entidades.Departamento;
    import co.com.trabajador.valor.DatosPersonalesTrabajador;

    /**
     * [Clase que representa el evento Trabajador Agregado]
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
    public class TrabajadorAgregado extends DomainEvent {

        /**
         * Representa el departamento
         */
        private final Departamento departamento;
        /**
         * Representa el cargo
         */
        private final Cargo cargo;
        /**
         * Representa los datos personales del trabajador
         */
        private final DatosPersonalesTrabajador datosPersonales;

        /**
         * Constructor de la clase que crea una instancia de Trabajador Agregado
         * @param departamento
         * @param cargo
         * @param datosPersonales
         */
        public TrabajadorAgregado(Departamento departamento, Cargo cargo,
                                  DatosPersonalesTrabajador datosPersonales) {
            super("co.com.trabajador.TrabajadorAgregado");
            this.departamento= departamento;
            this.cargo=cargo;
            this.datosPersonales= datosPersonales;

        }

        /**
         * Muestra el departamento
         * @return departamento
         */
        public Departamento getDepartamento() {
            return departamento;
        }

        /**
         * Muestra el cargo
         * @return cargo
         */
        public Cargo getCargo() {
            return cargo;
        }

        /**
         * Muestra los datos personales
         * @return datos personales
         */
        public DatosPersonalesTrabajador getDatosPersonales() {
            return datosPersonales;
        }

    }
