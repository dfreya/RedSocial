
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
                if(tipoEntrada.equals(entradaBuscada) || tipoEntrada==null){
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
                else{
                    System.out.println("Este Usuario no a publicado este tipo de Entrada");
                }
            }
            else{
                System.out.println("Este Usuario no ha publicadonada");
            }
        }
    }
}
