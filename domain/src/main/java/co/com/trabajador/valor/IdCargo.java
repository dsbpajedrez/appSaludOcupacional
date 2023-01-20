package co.com.trabajador.valor;

import co.com.sofka.domain.generic.Identity;

public class IdCargo extends Identity {

    private IdCargo(String valor) {
        super(valor);
    }

    public IdCargo () {};

    public static IdCargo of(String valor) {
        return new IdCargo(valor);
    }
}
