import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
/**
 * Write a description of class EntradaForo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntradaFoto extends EntraConComentarios
{

    private String urlImagen;
    private String titulo;

    public EntradaFoto(String autor, String url, String titulo){
        super(autor);
        urlImagen=url;
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
        String cadenaADevolver =super.toString();
        
        cadenaADevolver += titulo + "\n";
        cadenaADevolver += urlImagen + "\n";
        

        return cadenaADevolver;
    }

    public void mostrar()
    {
        System.out.println(this);
    }
    
        public int getCantidadDeDatosAsociadosALaEntrada (){
        int cantidadDeDatos=6;

        return cantidadDeDatos;
    }
        public void mostrarDatosExclusivos (){
        String cadena="";
        cadena= " "+"Titulo: "+getTituloImagen();
        cadena="Url: "+getUrlImagen();
        
        System.out.println(cadena);
    }
    
    public String toStringWeb()
    {
        String cadenaADevolver =super.toStringWeb();
        
        cadenaADevolver +="<big>"+"<b>"+ titulo +"</b>"+"</big>"+"</br>"+ "\n";
        cadenaADevolver +="<img src=\""+urlImagen + "\"/>" +"</p>"+"</div>" +"\n";
        

        return cadenaADevolver;
    }
}
