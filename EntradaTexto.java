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
        String cadenaDevolver=super.toString();

        cadenaDevolver+= mensaje +"\n";

        return cadenaDevolver;
    }
    
      public void mostrar()
    {
        System.out.println(this);
    }
    
    public int getCantidadDeDatosAsociadosALaEntrada(){
        int cantidadDeDatos=5;

        return cantidadDeDatos;
    }
    public void mostrarDatosExclusivos (){
        String cadena="";
        cadena=getMensaje();
        System.out.println(cadena);
    }
}
