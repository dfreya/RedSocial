import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Write a description of class Entrada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entrada
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
        cadenaDevolver+="Usuario: " + getUsuario() +"\n";

        long segundosDeLaCreacion= getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosDePublicaion= segundosDeLaCreacion/60;
        long segundosDePublicacion=segundosDeLaCreacion % 60;

        cadenaDevolver+= "Hace ";
        if(minutosDePublicaion>0){
            cadenaDevolver+= minutosDePublicaion+ " minutos ";
        }
        cadenaDevolver+= segundosDePublicacion +" segundos."+"\n";
        cadenaDevolver+=  getMeGusta() +" me gusta."+"\n";

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

    public String toStringWeb(){
        String cadenaDevolver="";
        cadenaDevolver+="<div class=\"parrafo\"><p>"+"<b class=\"usu\">"+ "Usuario: "+"</b>" + getUsuario()+"</br>" +"\n";

        long segundosDeLaCreacion= getMomentoPublicacion().until(LocalDateTime.now(), ChronoUnit.SECONDS);
        long minutosDePublicaion= segundosDeLaCreacion/60;
        long segundosDePublicacion=segundosDeLaCreacion % 60;

       String tiempoDevolver="";
        cadenaDevolver+= "Hace ";

        if(minutosDePublicaion>0){
            tiempoDevolver=minutosDePublicaion+ " minutos "+segundosDePublicacion +" segundos.";
            if(minutosDePublicaion>60){
                long horasDePublicacion= minutosDePublicaion/60;
                minutosDePublicaion= minutosDePublicaion%60;

                if(horasDePublicacion>0){
                    tiempoDevolver= horasDePublicacion+" horas.";
                    if (horasDePublicacion>24){
                        long diasDePublicacion=horasDePublicacion/24;
                        horasDePublicacion=horasDePublicacion%24;
                        if(diasDePublicacion>0){
                            tiempoDevolver= diasDePublicacion+" dias.";
                        }
                    }
                }
            }
        }
        cadenaDevolver+= tiempoDevolver +"</br>"+"\n";
        cadenaDevolver+=  getMeGusta() +" me gusta."+"</br>"+"\n";

        return cadenaDevolver;
    }

    public void timepoDePublicacion(String fehaHora){
        String horaFecha[]=fehaHora.split("-");
        String fecha[]=horaFecha[0].split("/");
        String hora[]=horaFecha[1].split(":");

        momentoPublicacion = LocalDateTime.of(Integer.parseInt(fecha[2]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[0]), Integer.parseInt(hora[0]), Integer.parseInt(hora[1]));

    }
 
 

}

