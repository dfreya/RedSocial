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
    private String usuario;
    private LocalDateTime momentoPublicacion;
    private int cantidadMeGusta;


    /**
     * Constructor for objects of class Entrada
     */
    public Entrada(String autor)
    {
        usuario = autor;
        momentoPublicacion = LocalDateTime.now();
        cantidadMeGusta = 0;     
    }
    
    public void meGusta()
    {
        cantidadMeGusta++;
    }    
    
    
    public LocalDateTime getMomentoPublicacion()
    {
        return momentoPublicacion;
    }
        
    public String toString(){
        String cadenaDevolver="";
        cadenaDevolver+= "Usuario: " + getUsuario() +"\n";
        

        long segundosDeLaCreacion= getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosDePublicaion= segundosDeLaCreacion/60;
        long segundosDePublicacion=segundosDeLaCreacion % 60;

        cadenaDevolver+= "Hace ";
        if(minutosDePublicaion>0){
            cadenaDevolver+= minutosDePublicaion+ " minutos ";
        }
        cadenaDevolver+= segundosDePublicacion +" segundos.\n";
        cadenaDevolver+=  getMeGusta() +" me gusta.";

        return cadenaDevolver;
    }
    
    public String getUsuario()
    {
        return usuario;
    }

    public int getMeGusta()
    {
        return cantidadMeGusta;
    }
    
     public int getCantidadDeDatosAsociadosALaEntrada(){
         return 0;
    }

    

}


