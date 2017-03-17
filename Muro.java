
import java.util.ArrayList;
/**
 * Write a description of class Muro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Muro
{

    private ArrayList<Entrada> entrada;

    public Muro(){
        entrada = new ArrayList<Entrada>();
    }

    public void addEntrada(Entrada entrada){
        this.entrada.add(entrada);
    }

    public String toString()
    {
        String cadenaADevolver = "";
        if (!entrada.isEmpty()){
            for (Entrada entradaActual : entrada)
            {
                cadenaADevolver += entradaActual + "\n";
            }
        }

        return cadenaADevolver;
    }

    public void mostrar()
    {
        System.out.println(this);
    }
}
