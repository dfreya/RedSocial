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
        String cadenaDevolver="";
        cadenaDevolver+= "Usuario: " + getUsuario() +"\n";
        cadenaDevolver+= "Se a unido a " + grupo +"\n";
        cadenaDevolver+=  getMeGusta() +" me gusta.";

        long segundosDeLaCreacion= getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosDePublicaion= segundosDeLaCreacion/60;
        long segundosDePublicacion=segundosDeLaCreacion % 60;

        cadenaDevolver+= "Hace ";
        if(minutosDePublicaion>0){
            cadenaDevolver+= minutosDePublicaion+ " minutos ";
        }
        cadenaDevolver+= segundosDePublicacion +" segundos.\n";

        return cadenaDevolver; 
    }
      public void mostrar()
    {
        System.out.println(this);
    }
}
