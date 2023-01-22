package co.com.accidente.entidades;

import co.com.accidente.valor.Clasificacion;
import co.com.accidente.valor.IdTipo;
import co.com.accidente.valor.Severidad;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;
/**
 * [Entidad Tipo]
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
public class Tipo extends Entity<IdTipo> {
    private IdTipo idTipo;
    private Severidad severidad;

    /**
     * Constructor
     * @param idTipo: Identificador del tipo de accidente
     * @param severidad: Severidad del accidente
     */
    public Tipo(IdTipo idTipo, Severidad severidad) {
        super(idTipo);
        this.severidad = severidad;
        this.idTipo = idTipo;
    }

    /**
     * actualizarTipo: Actualiza la severidad del accidente
     * @param severidad: Parámetro severidad del accidente
     *
     */
    public void actualizarSeveridad(Severidad severidad) {
        this.severidad = Objects.requireNonNull(severidad);
    }

    /**
     * Getter
     * @return: Retrona la severidad
     */
    public Severidad severidad() {
        return severidad;
    }
}
