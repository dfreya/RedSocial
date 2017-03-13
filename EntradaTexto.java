import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
 * Write a description of class EntradaTexto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntradaTexto
{
    private String usuario;
    private String mensaje;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;
    public EntradaTexto(String autor, String texto){
        usuario=autor;
        mensaje=texto;
        comentarios = new ArrayList<String>();
        cantidadMeGusta=0;
        momentoPublicacion = LocalDateTime.now();
    }

    public void meGusta(){
        cantidadMeGusta++;
    }

    public void addComentario(String texto){
        comentarios.add(texto);
    }

    public String getMensaje(){
        return mensaje;
    }

    public LocalDateTime getMomentoPublicacion(){
        return momentoPublicacion;
    }

    
    public String toString(){
        String cadenaDevolver="";
        cadenaDevolver+= "Usuario: " + usuario +"\n";
        cadenaDevolver+= mensaje +"\n";
        cadenaDevolver+= cantidadMeGusta +" me gusta.";
        
        long segundosDeLaCreacion= momentoPublicacion.until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosDePublicaion= segundosDeLaCreacion/60;
        long segundosDePublicacion=segundosDeLaCreacion % 60;
        
        cadenaDevolver+= "Hace ";
        if(minutosDePublicaion>0){
            cadenaDevolver+= minutosDePublicaion+ " minutos ";
        }
        cadenaDevolver+= segundosDePublicacion +" segundos.\n";
        
        if (comentarios.isEmpty()) {
            cadenaDevolver = cadenaDevolver + " - No contiene comentarios";
        }
        else{
            for(String comentario: comentarios){
                cadenaDevolver+= comentario +"\n";
            }
        }
        
        System.out.println(cadenaDevolver);
        return cadenaDevolver;
    }
}
