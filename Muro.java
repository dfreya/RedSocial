import java.nio.file.*;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.net.URL;
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
                        ((EntradaUnionAGrupo)entradaActual).mostrarDatosExclusivos();
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

    public void mostrarMuroEnNavegador(String usuario){
        entrada.clear();

        try 
        {

            URL url = new URL("https://script.google.com/macros/s/AKfycbzHc3p1twTfyF7o0_cxSwnxSsyOemuHnSu406ly9DZIf5Ck2BA/exec?user=" + usuario);
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNextLine()) {
                String linea[]= sc.nextLine().split(";");
                if(linea[0].equals("EntradaTexto")){// 6 elementos,0 el tipo, 1 el usuario, 2 me gustas, 3 la hora fecha, 4 el msm, 5 los comentarios
                    EntradaTexto entradaActual= new EntradaTexto(linea[1], linea[4]);
                    for(int cont=0; cont<=Integer.parseInt(linea[2]);cont++){
                        entradaActual.meGusta();
                    }
                    entradaActual.timepoDePublicacion(linea[3]);

                    String lineaComentarios[]=linea[5].split("%");
                    for(int cont=0; cont<lineaComentarios.length;cont++){
                        entradaActual.addComentario(lineaComentarios[cont]);
                    }
                    entrada.add(entradaActual);
                }
                else if(linea[0].equals("EntradaFoto")){//7 elementos, 0 el tipo, 1 el usuario, 2 me gusta, 3 la hora y fecha, 4 al url, 5 titulo, 6 los comentarios
                     EntradaFoto entradaActual= new EntradaFoto(linea[1], linea[4], linea[5]);
                    for(int cont=0; cont<=Integer.parseInt(linea[2]);cont++){
                        entradaActual.meGusta();
                    }
                    entradaActual.timepoDePublicacion(linea[3]);

                    String lineaComentarios[]=linea[6].split("%");
                    for(int cont=0; cont<lineaComentarios.length;cont++){
                        entradaActual.addComentario(lineaComentarios[cont]);
                    }
                    entrada.add(entradaActual);
                }
                else if(linea[0].equals("EntradaUnionAGrupo")){// , 0 el tipo , 1 el usuario, 2 me gusta, 3 fecha hora, 4 el nombro grupo
                    EntradaUnionAGrupo entradaActual= new EntradaUnionAGrupo(linea[1], linea[4]);
                    for(int cont=0; cont<=Integer.parseInt(linea[2]);cont++){
                        entradaActual.meGusta();
                    }
                    entradaActual.timepoDePublicacion(linea[3]);

                    entrada.add(entradaActual);
                }
            }
            sc.close();
        }
        catch (Exception e) 
        {
            System.out.println (e);

        }

        mostrarMuroEnNavegador();
    }


    

}
