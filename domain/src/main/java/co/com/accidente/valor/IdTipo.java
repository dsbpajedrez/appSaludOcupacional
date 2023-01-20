package co.com.accidente.valor;

import co.com.sofka.domain.generic.Identity;

public class IdTipo extends Identity {
    public IdTipo(){

    }
    private IdTipo(String id){
        super(id);
    }

    public static IdTipo of(String id){
        return new IdTipo(id);
    }

}
