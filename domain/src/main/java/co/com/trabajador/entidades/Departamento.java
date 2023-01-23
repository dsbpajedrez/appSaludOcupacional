    package co.com.trabajador.entidades;

    import co.com.sofka.domain.generic.Entity;
    import co.com.trabajador.valor.IdDepartamento;
    import co.com.trabajador.valor.NombreDepartamento;

    import java.util.Objects;

    /**
     * [Entidad Departamento]
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
    public class Departamento extends Entity<IdDepartamento> {

        /**
         * Representa nombre del departamento
         */
        private NombreDepartamento nombreDepartamento;

        /**
         * Constructor de la clase que crea una instancia de Departamento
         * @param idDepartamento
         * @param nombreDepartamento
         */
        public Departamento(IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento) {
            super(idDepartamento);
            this.nombreDepartamento = nombreDepartamento;
        }

        /**
         * Constructor de la clase que crea una instancia de Departamento
         * @return
         */
        public NombreDepartamento nombreDepartamento() {
            return nombreDepartamento;
        }

        /**
         * Método para la actualización del departamento
         * @param nombreDepartamento
         */
        public void actualizar(NombreDepartamento nombreDepartamento) {
            this.nombreDepartamento = Objects.requireNonNull(nombreDepartamento);
        }
    }
