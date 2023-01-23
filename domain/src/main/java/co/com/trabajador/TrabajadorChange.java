    package co.com.trabajador;


    import co.com.sofka.domain.generic.EventChange;
    import co.com.trabajador.entidades.Cargo;
    import co.com.trabajador.entidades.Departamento;
    import co.com.trabajador.eventos.CargoActualizado;
    import co.com.trabajador.eventos.CargoAgregado;
    import co.com.trabajador.eventos.DepartamentoActualizado;
    import co.com.trabajador.eventos.DepartamentoAgregado;
    import co.com.trabajador.eventos.TrabajadorAgregado;

    /**
     * [Clase para generar los eventos del agregado root Trabajador]
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
    public class TrabajadorChange extends EventChange {

        /**
         * Constructor de la clase que crea una instancia de TrabajadorChange para los eventos
         * @param trabajador
         */
        public TrabajadorChange(Trabajador trabajador) {
            apply((TrabajadorAgregado event) ->{
                trabajador.departamento = event.getDepartamento();
                trabajador.cargo = event.getCargo();
                trabajador.datosPersonales = event.getDatosPersonales();
            });
            apply((DepartamentoAgregado event) ->{
                trabajador.departamento = new Departamento(event.getIdDepartamento(), event.getNombreDepartamento());
            });
            apply((CargoAgregado event) ->{
                trabajador.cargo = new Cargo(event.getIdCargo(),event.getNombreCargo());
            });

            apply((CargoActualizado event) ->{
                trabajador.cargo.actualizar(event.getNombreCargo());
            });
           apply((DepartamentoActualizado event) ->{
               trabajador.departamento.actualizar(event.getNombreDepartamento());
            });

        }
    }
