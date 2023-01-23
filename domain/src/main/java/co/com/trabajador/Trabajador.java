    package co.com.trabajador;

    import co.com.sofka.domain.generic.AggregateEvent;
    import co.com.sofka.domain.generic.DomainEvent;
    import co.com.trabajador.entidades.Cargo;
    import co.com.trabajador.entidades.Departamento;
    import co.com.trabajador.eventos.CargoActualizado;
    import co.com.trabajador.eventos.CargoAgregado;
    import co.com.trabajador.eventos.DepartamentoActualizado;
    import co.com.trabajador.eventos.DepartamentoAgregado;
    import co.com.trabajador.eventos.TrabajadorAgregado;
    import co.com.trabajador.valor.DatosPersonalesTrabajador;
    import co.com.trabajador.valor.IdCargo;
    import co.com.trabajador.valor.IdDepartamento;
    import co.com.trabajador.valor.IdTrabajador;
    import co.com.trabajador.valor.NombreCargo;
    import co.com.trabajador.valor.NombreDepartamento;

    import java.util.List;
    import java.util.Objects;

    /**
     * [Clase que representa agregado root Trabajador]
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
    public class Trabajador extends AggregateEvent<IdTrabajador> {

        /**
         * Representa los datos personales del trabajador
         */
        protected DatosPersonalesTrabajador datosPersonales;
        /**
         * Representa el departamento al que pertenece el trabajador
         */
        protected Departamento departamento;
        /**
         * Representa el cargo del trabajador
         */
        protected Cargo cargo;

        /**
         * Constructor de la clase que crea una instancia de Trabajador
         * @param idTrabajador
         * @param departamento
         * @param cargo
         * @param datosPersonales
         */
        public Trabajador(IdTrabajador idTrabajador, Departamento departamento, Cargo cargo, DatosPersonalesTrabajador datosPersonales) {
            super(idTrabajador);
            appendChange(new TrabajadorAgregado(departamento, cargo, datosPersonales)).apply();
        }

        /**
         * Constructor de la clase que crea una instancia de Trabajador para la suscripción
         * @param idTrabajador
         */
        private Trabajador(IdTrabajador idTrabajador){
            super(idTrabajador);
            subscribe(new TrabajadorChange(this));
        }

        /**
         * Representa los eventos del agregado root Trabajador
         * @param idTrabajador
         * @param events
         * @return
         */
        public static Trabajador from(IdTrabajador idTrabajador, List<DomainEvent> events){
            var trabajador= new Trabajador(idTrabajador);
            events.forEach(trabajador::applyEvent);
            return trabajador;
        }

        /**
         * Representa el comportamiento del trabajador, permite agregar departamento
         * @param idDepartamento
         * @param nombreDepartamento
         */
        public void agregarDepartamento(IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento){
            Objects.requireNonNull(idDepartamento);
            Objects.requireNonNull(nombreDepartamento);
            appendChange(new DepartamentoAgregado(idDepartamento, nombreDepartamento)).apply();
        }

        /**
         * Representa el comportamiento del trabajador, permite agregar cargo
         * @param idCargo
         * @param nombreCargo
         */
        public void agregarCargo(IdCargo idCargo, NombreCargo nombreCargo){
            Objects.requireNonNull(idCargo);
            Objects.requireNonNull(nombreCargo);
            appendChange(new CargoAgregado(idCargo, nombreCargo)).apply();
        }

        /**
         * Representa el comportamiento del trabajador, permite actualizar cargo
         * @param idCargo
         * @param nombreCargo
         */
        public void  actualizarCargo(IdCargo idCargo, NombreCargo nombreCargo){
            Objects.requireNonNull(idCargo);
            Objects.requireNonNull(nombreCargo);
            appendChange(new CargoActualizado(idCargo,nombreCargo)).apply();
        }

        /**
         * Representa el comportamiento del trabajador, permite actualizar departamento
         * @param idDepartamento
         * @param nombreDepartamento
         */
        public void  actualizarDepartamento(IdDepartamento idDepartamento, NombreDepartamento nombreDepartamento){
            Objects.requireNonNull(idDepartamento);
            Objects.requireNonNull(nombreDepartamento);
            appendChange(new DepartamentoActualizado(idDepartamento,nombreDepartamento)).apply();
        }

        /**
         * Muestra el cargo del trabajador
         * @param idCargo
         * @return
         */
        public Cargo getCargoPorId(IdCargo idCargo){
            return cargo;
        }

        /**
         * Muestra el departamento al que pertenece el trabajador
         * @param idDepartamento
         * @return
         */
        public Departamento getDepartamentoPorId(IdDepartamento idDepartamento){
            return departamento;
        }

    }
