import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
 * Write a description of class EntradaTexto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntradaTexto extends EntraConComentarios
{
    private String mensaje;

    public EntradaTexto(String autor, String texto){
        super(autor);
        mensaje=texto;
    }

    public String getMensaje(){
        return mensaje;
    }

    public String toString(){
        String cadenaDevolver="";
        cadenaDevolver+= "Usuario: " + getUsuario() +"\n";
        cadenaDevolver+= mensaje +"\n";
        cadenaDevolver+=  getMeGusta() +" me gusta.";

        long segundosDeLaCreacion= getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosDePublicaion= segundosDeLaCreacion/60;
        long segundosDePublicacion=segundosDeLaCreacion % 60;

        cadenaDevolver+= "Hace ";
        if(minutosDePublicaion>0){
            cadenaDevolver+= minutosDePublicaion+ " minutos ";
        }
        cadenaDevolver+= segundosDePublicacion +" segundos.\n";

        if (getComentarios().isEmpty()) {
            cadenaDevolver = cadenaDevolver + " - No contiene comentarios"+"\n";
        }
        else{
            for(String comentario: getComentarios()){
                cadenaDevolver+= comentario +"\n";
            }
        }


        return cadenaDevolver;
    }
    
      public void mostrar()
    {
        System.out.println(this);
    }
}
