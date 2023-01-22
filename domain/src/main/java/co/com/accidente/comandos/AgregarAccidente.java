package co.com.accidente.comandos;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.Clasificacion;
import co.com.sofka.domain.generic.Command;

import java.util.Set;

public class AgregarAccidente extends Command {
    private final IdAccidente idAccidente;
    private Clasificacion clasificacion;


    public AgregarAccidente( IdAccidente idAccidente,Clasificacion clasificacion){
        this.idAccidente = idAccidente;

        this.clasificacion = clasificacion;
    }
    public IdAccidente getAccidenteId() {return this.idAccidente;}
    public Clasificacion getClasificacion() {return this.clasificacion;}


}

