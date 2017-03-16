import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
 * Write a description of class Entrada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entrada 
{
    // instance variables - replace the example below with your own
    private String usuario;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;
    public Entrada(String autor){
        usuario=autor;
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
    
        public String getUsuario(){
        return usuario;
    }
    public int getMeGusta(){
        return cantidadMeGusta;
    }
    public LocalDateTime getMomentoPublicacion(){
        return momentoPublicacion;
    }
    public ArrayList<String> getComentarios(){
        return comentarios;
    }
    public String toString(){
        return "";
    }
}
