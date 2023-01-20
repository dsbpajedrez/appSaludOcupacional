package co.com.trabajador.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DatosPersonalesTrabajador implements ValueObject<String> {

    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final String correo;


    public DatosPersonalesTrabajador(String nombre, String apellido, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }


    @Override
    public String value() {
        return null;
    }
}
