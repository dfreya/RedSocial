import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
 * Write a description of class Grupo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntadaUnionAGrupo extends Entrada
{
    private String grupo;
    public EntadaUnionAGrupo(String autor, String nombreGrupo){
        super(autor);
        grupo=nombreGrupo;
    }

    public String toString(){
        String cadenaDevolver=super.toString();
        cadenaDevolver+= "Se a unido a " + grupo +"\n";

        return cadenaDevolver; 
    }

    public void mostrar()
    {
        System.out.println(this);
    }
    public String getGrupo(){
        return grupo;
    }
    
        public int getCantidadDeDatosAsociadosALaEntrada (){
        int cantidadDeDatos=4;
     
        return cantidadDeDatos;
    }
    
        public void mostrarDatosExclusivos (){
        String cadena="";
        cadena="Se unio a: "+getGrupo();
        System.out.println(cadena);
    }
    
        public String toStringWeb(){
        String cadenaDevolver=super.toStringWeb();
        cadenaDevolver+= "Se a unido a: " + grupo +"</p>"+"</div>"+"\n";

        return cadenaDevolver; 
    }
}
