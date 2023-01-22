package co.com.trabajador.valor;

import co.com.sofka.domain.generic.Identity;

public class IdDepartamento extends Identity {

    private IdDepartamento(String valor) {
        super(valor);
    }

    public IdDepartamento () {};

    public static IdDepartamento of(String valor) {
        return new IdDepartamento(valor);
    }
}
