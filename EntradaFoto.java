import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
 * Write a description of class EntradaForo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntradaFoto
{
    private String usuario;
    private String urlImagen;
    private String titulo;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;
    private ArrayList<String> comentarios;

    public EntradaFoto(String autor, String url, String titulo){
        usuario= autor;
        url=urlImagen;
        this.titulo=titulo;
    }

    public void meGusta(){
        cantidadMeGusta++;
    }

    public void addComentario(String texto){
        comentarios.add(texto);
    }

    public String getUrlImagen(){
        return urlImagen;
    }

    public String getTituloImagen(){
        return titulo;
    }

    public LocalDateTime getMomentoPublicacion(){
        return momentoPublicacion;
    }

    public String toString()
    {
        String cadenaADevolver = null;
        cadenaADevolver = "Autor: " + usuario + ". Titulo: " + titulo + " " + urlImagen + " " + cantidadMeGusta + " Me Gusta.";
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
