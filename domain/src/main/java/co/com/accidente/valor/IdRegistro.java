package co.com.accidente.valor;


import co.com.sofka.domain.generic.Identity;

public class IdRegistro extends Identity {
    public IdRegistro(){

    }
    private IdRegistro(String id){
        super(id);
    }

    public static IdRegistro of(String id){
        return new IdRegistro(id);
    }
}
