import java.nio.file.*;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
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
                cadenaADevolver +=entradaActual + "\n";
            }
        }

        return cadenaADevolver;
    }
    
        public String toStringWeb()
    {
        String cadenaADevolver = "";
        if (!entrada.isEmpty()){
            for (Entrada entradaActual : entrada)
            {
                cadenaADevolver +=entradaActual.toStringWeb() + "\n";
            }
            
        }
        return cadenaADevolver;
    }

    public void mostrar()
    {
        System.out.println(this);
    }

    public void verCantidadDatosPorEntrada(){
        for(Entrada entradaActual: entrada){
            System.out.println(entradaActual.getCantidadDeDatosAsociadosALaEntrada());
        }

    }

    public void mostrarDatosExclusivosEntradasFiltradas(String tipoEntrada, String autor){
        for (Entrada entradaActual: entrada){
            String usuario=entradaActual.getUsuario();
            if(usuario.equals(autor)|| autor==null){
                String entradaBuscada=entradaActual.getClass().getSimpleName();

                if(entradaBuscada.equals(tipoEntrada) || tipoEntrada==null){
                    if(entradaActual instanceof EntradaTexto ){
                        ((EntradaTexto)entradaActual).mostrarDatosExclusivos();
                    }
                    else if(entradaActual instanceof EntradaFoto){
                        ((EntradaFoto)entradaActual).mostrarDatosExclusivos();
                    }
                    else{
                        ((EntadaUnionAGrupo)entradaActual).mostrarDatosExclusivos();
                    }
                }

            }

        }
    }

    public void mostrarMuroEnNavegador(){
        Path archivoWeb = Paths.get("muroEnWeb.html");
        try  
        {
            BufferedWriter archivo = Files.newBufferedWriter(archivoWeb);
            archivo.write("<html><head><title>My Sitico</title><link href=\"estiloWeb.css\" rel=\"stylesheet\" type=\"text/css\"></head><body>"+"\n");
            archivo.write("<h1>MY Sitico</h1>"+"\n");
            archivo.write(this.toStringWeb());  
            archivo.write("</body></html>");

            archivo.close();
        }
        catch (IOException excepcion) {
            // Mostramos por pantalla la excepción que se ha producido
            System.out.println(excepcion.toString());
        }
        
        try 
        {
            String cmd = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome " + "muroEnWeb.html" ;
            Runtime.getRuntime().exec(cmd); 
        } 
        catch (IOException ioe) 
        {
            System.out.println (ioe);
        }
    }


    

}
