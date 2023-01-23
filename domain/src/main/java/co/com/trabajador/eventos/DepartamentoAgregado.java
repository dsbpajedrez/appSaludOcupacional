package co.com.trabajador.eventos;

    import co.com.sofka.domain.generic.DomainEvent;
    import co.com.trabajador.valor.IdDepartamento;
    import co.com.trabajador.valor.NombreDepartamento;

    /**
     * [Clase que representa el evento Departamento Agregado]
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
    public class DepartamentoAgregado extends DomainEvent {

        /**
         * Representa el id del departamento
         */
        private final IdDepartamento idDepartamento;
        /**
         * Representa el nombre del departamento
         */
        private final NombreDepartamento nombreDepartamento;

        /**
         * Constructor de la clase que crea una instancia de Departamento Agregado
         * @param idDepartamento
         * @param nombreDepartamento
         */
        public DepartamentoAgregado(IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento) {
            super("co.com.trabajador.DepartamentoAgregado");
            this.idDepartamento = idDepartamento;
            this.nombreDepartamento = nombreDepartamento;
        }

        /**
         * Muestra el id del departamento
         * @return id del departamento
         */
        public IdDepartamento getIdDepartamento() {
            return idDepartamento;
        }

        /**
         * Muestra el nombre del departamento
         * @return nombre del departamento
         */
        public NombreDepartamento getNombreDepartamento() {
            return nombreDepartamento;
        }

    }
