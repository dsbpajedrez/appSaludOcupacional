package co.com.accidente.comandos;

import co.com.accidente.entidades.Registro;
import co.com.accidente.entidades.Tipo;
import co.com.accidente.valor.IdAccidente;
import co.com.accidente.valor.Clasificacion;
import co.com.sofka.domain.generic.Command;

import java.util.Set;

public class AgregarAccidente extends Command {
    private final IdAccidente idAccidente;
    private Set<Tipo> tipos;
    private Set<Registro> registros;
    private Clasificacion clasificacion;


    public AgregarAccidente( IdAccidente idAccidente,Set<Tipo> tipos,Set<Registro> registros,Clasificacion clasificacion){
        this.idAccidente = idAccidente;
        this.tipos = tipos;
        this.registros = registros;
        this.clasificacion = clasificacion;


    }
    public IdAccidente getAccidenteId() {return this.idAccidente;}
    public Clasificacion clasificacion() {return this.clasificacion;}

    public Set<Tipo> getTipos() {
        return tipos;
    }

    public Set<Registro> getRegistros() {
        return registros;
    }
}
