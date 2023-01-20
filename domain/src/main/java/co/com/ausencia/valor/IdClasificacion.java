package co.com.ausencia.valor;

import co.com.sofka.domain.generic.Identity;

public class IdClasificacion extends Identity {
    public IdClasificacion(){

    }
    private IdClasificacion(String id){
        super(id);
    }

    public static IdClasificacion of(String id){
        return new IdClasificacion(id);
    }
}
