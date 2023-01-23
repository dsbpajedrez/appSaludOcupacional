    package co.com.trabajador.comandos;

    import co.com.sofka.domain.generic.Command;
    import co.com.trabajador.entidades.Cargo;
    import co.com.trabajador.entidades.Departamento;
    import co.com.trabajador.valor.DatosPersonalesTrabajador;
    import co.com.trabajador.valor.IdTrabajador;

    /**
     * [Comando para agregar trabajador]
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
    public class AgregarTrabajador extends Command {

        /**
         * Representa el id del trabajdor
         */
        private final IdTrabajador idTrabajador;
        /**
         * Representa la entidad departamento
         */
        private final Departamento departamento;
        /**
         * Representa la entidad cargo
         */
        private final Cargo cargo;
        /**
         * Representa datos personales del trabajador
         */
        private final DatosPersonalesTrabajador datosPersonales;

        /**
         * Constructor de la clase que crea una instancia de Agregar Trabajador
         * @param idTrabajador
         * @param departamento
         * @param cargo
         * @param datosPersonales
         */
        public AgregarTrabajador(IdTrabajador idTrabajador, Departamento departamento, Cargo cargo,
                                 DatosPersonalesTrabajador datosPersonales) {
            this.idTrabajador = idTrabajador;
            this.departamento = departamento;
            this.cargo = cargo;
            this.datosPersonales = datosPersonales;
        }

        /**
         * Muestra el id del trabajador
         * @return id del trabajador
         */
        public IdTrabajador getIdTrabajador() {
            return idTrabajador;
        }

        /**
         * Muestra el departamento
         * @return departamento
         */
        public Departamento getDepartamento() {
            return departamento;
        }

        /**
         * Muestra el cargo del trabajador
         * @return
         */
        public Cargo getCargo() {
            return cargo;
        }

        /**
         * Muestra los datos personales del trabajador
         * @return
         */
        public DatosPersonalesTrabajador getDatosPersonales() {
            return datosPersonales;
        }


    }
