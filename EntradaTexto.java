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
  public String toString()
    {
        String cadenaADevolver = null;
        
        cadenaADevolver = "Autor: " + usuario + ". Mensaje: " + mensaje + " " +
                    cantidadMeGusta + " Me Gusta.";
        if (momentoPublicacion.until(LocalDateTime.now(), ChronoUnit.SECONDS) <= 59) {
            cadenaADevolver = cadenaADevolver + " Tiempo transcurrido: " + 
                    momentoPublicacion.until(LocalDateTime.now(), ChronoUnit.SECONDS)
                            + " segundos.";
        }
        else {
            cadenaADevolver = cadenaADevolver + " Tiempo transcurrido: " + 
                momentoPublicacion.until(LocalDateTime.now(), ChronoUnit.MINUTES)+ " minutos, " + 
                (momentoPublicacion.until(LocalDateTime.now(), ChronoUnit.SECONDS) - 60)+ " segundos.";
        }
        if (comentarios.isEmpty()) {
            cadenaADevolver = cadenaADevolver + " - No contiene comentarios";
        }
        System.out.println(cadenaADevolver);
        return cadenaADevolver;
    }
}
