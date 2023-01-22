package co.com.ausencia.valor;

import co.com.sofka.domain.generic.Identity;

public class IdAusencia extends Identity {
    public IdAusencia(){

    }
    private IdAusencia(String id){
        super(id);
    }

    public static IdAusencia of(String id){
        return new IdAusencia(id);
    }
}
