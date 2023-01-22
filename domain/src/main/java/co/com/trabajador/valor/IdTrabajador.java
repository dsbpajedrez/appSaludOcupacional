package co.com.trabajador.valor;

import co.com.sofka.domain.generic.Identity;

public class IdTrabajador extends Identity {
    private IdTrabajador(String valor) {
        super(valor);
    }

    public IdTrabajador () {};

    public static IdTrabajador of(String valor) {
        return new IdTrabajador(valor);
    }
}
