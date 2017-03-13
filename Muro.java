
import java.util.ArrayList;
/**
 * Write a description of class Muro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Muro
{

    private ArrayList<EntradaTexto> mensajes;
    private ArrayList<EntradaFoto> fotos;
    public Muro(){
        mensajes = new ArrayList<EntradaTexto>();
        fotos = new ArrayList<EntradaFoto>();
    }

    public void addEntradaTexto(EntradaTexto entradaTexto){
        mensajes.add(entradaTexto);
    }

    public void addEntradaTexto(EntradaFoto entradaFoto){
        fotos.add(entradaFoto);
    }

    public String toString()
    {
        String cadenaADevolver = "";
        
        for (EntradaTexto entrada : mensajes)
        {
            cadenaADevolver += entrada + "\n";
        }

        
        for (EntradaFoto entrada : fotos)
        {
            cadenaADevolver += entrada + "\n";
        }        
        
        return cadenaADevolver;
    }
    
    public void mostrar()
    {
        System.out.println(this);
    }
}
