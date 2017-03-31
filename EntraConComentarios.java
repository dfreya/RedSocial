import java.util.*;
/**
 * Write a description of class EntraConComentarios here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntraConComentarios extends Entrada
{
    private ArrayList<String> comentarios;
    public EntraConComentarios(String autor) {
        super(autor);
        comentarios = new ArrayList<String>();
    }

    public void addComentario(String texto){
        comentarios.add(texto);
    }

    public ArrayList<String> getComentarios(){
        return comentarios;
    }

    public String toString(){
        String cadenaDevolver= super.toString();
        if (getComentarios().isEmpty()) {
            cadenaDevolver =cadenaDevolver + " - No contiene comentarios"+"\n";
        }
        else{
            for(String comentario: getComentarios()){
                cadenaDevolver+= comentario +"\n";
            }
        }
        return cadenaDevolver;
    }
    
    public String toStringWeb(){
        String cadenaDevolver= super.toStringWeb();
        if (getComentarios().isEmpty()) {
            cadenaDevolver =cadenaDevolver + " - No contiene comentarios"+"</br>"+"\n";
        }
        else{
            for(String comentario: getComentarios()){
                cadenaDevolver+= comentario +"</br>"+"\n";
            }
        }
        return cadenaDevolver;
    }

}
