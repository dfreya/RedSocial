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
        cantidadMeGusta=0;
        comentarios = new ArrayList<String>();
        momentoPublicacion = LocalDateTime.now();
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
        String cadenaADevolver = "";
        
        cadenaADevolver += "Usuario: " + usuario + "\n";
        cadenaADevolver += titulo + "\n";
        cadenaADevolver += urlImagen + "\n";
        cadenaADevolver += cantidadMeGusta + " me gusta";
        
        long segundosQueHanPasadoDesdeCreacion = momentoPublicacion.until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosQueHanPasadoDesdeCreacion = segundosQueHanPasadoDesdeCreacion / 60;
        long segundosResiduales = segundosQueHanPasadoDesdeCreacion % 60;
        
        cadenaADevolver += "Hace ";
        if (minutosQueHanPasadoDesdeCreacion > 0) {
            cadenaADevolver += minutosQueHanPasadoDesdeCreacion + " minutos ";
        }
        cadenaADevolver += segundosResiduales + " segundos.\n";       
        
        if (comentarios.isEmpty()) {
            cadenaADevolver += "La entrada no tiene comentarios.";
        }
        else {
            //Se recopilan los comentarios
            cadenaADevolver += "Comentarios:\n";
            for (String comentario : comentarios) {
                cadenaADevolver += comentario + "\n";
            }
        }   
        
        return cadenaADevolver;
    }
}
