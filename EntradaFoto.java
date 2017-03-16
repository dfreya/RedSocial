import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
 * Write a description of class EntradaForo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntradaFoto extends Entrada
{

    private String urlImagen;
    private String titulo;

    public EntradaFoto(String autor, String url, String titulo){
        super(autor);
        url=urlImagen;
        this.titulo=titulo;
    }

    public String getUrlImagen(){
        return urlImagen;
    }

    public String getTituloImagen(){
        return titulo;
    }

      public String toString()
    {
        String cadenaADevolver = "";
        
        cadenaADevolver += "Usuario: " +  getUsuario() + "\n";
        cadenaADevolver += titulo + "\n";
        cadenaADevolver += urlImagen + "\n";
        cadenaADevolver += getMeGusta() + " me gusta";
        
        long segundosQueHanPasadoDesdeCreacion = getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosQueHanPasadoDesdeCreacion = segundosQueHanPasadoDesdeCreacion / 60;
        long segundosResiduales = segundosQueHanPasadoDesdeCreacion % 60;
        
        cadenaADevolver += "Hace ";
        if (minutosQueHanPasadoDesdeCreacion > 0) {
            cadenaADevolver += minutosQueHanPasadoDesdeCreacion + " minutos ";
        }
        cadenaADevolver += segundosResiduales + " segundos.\n";       
        
        if (getComentarios().isEmpty()) {
            cadenaADevolver += "La entrada no tiene comentarios.";
        }
        else {
            //Se recopilan los comentarios
            cadenaADevolver += "Comentarios:\n";
            for (String comentario : getComentarios()) {
                cadenaADevolver += comentario + "\n";
            }
        }   
        
        return cadenaADevolver;
    }
}
