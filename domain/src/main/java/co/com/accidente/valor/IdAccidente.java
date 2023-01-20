package co.com.accidente.valor;

import co.com.sofka.domain.generic.Identity;

public class IdAccidente extends Identity {
    public IdAccidente(){

    }
    private IdAccidente(String id){
        super(id);
    }

    public static IdAccidente of(String id){
        return new IdAccidente(id);
    }
}
