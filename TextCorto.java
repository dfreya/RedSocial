

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TextCorto.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TextCorto
{
    private Muro muro1;
    private EntradaTexto entradaT1;
    private EntradaFoto entradaF1;
    private EntadaUnionAGrupo entadaUn1;

    
    
    
    

    
    
    
    

    /**
     * Default constructor for test class TextCorto
     */
    public TextCorto()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        muro1 = new Muro();
        entradaT1 = new EntradaTexto("borja", "sdfgsd");
        entradaF1 = new EntradaFoto("borja", "http://imagenesyfotos.net/wp-content/uploads/2015/06/imagen-aerea-islas-marietas-620x315.jpg", "de relax");
        entadaUn1 = new EntadaUnionAGrupo("borja", "de relax en la playita");
        muro1.addEntrada(entradaT1);
        muro1.addEntrada(entadaUn1);
        muro1.addEntrada(entradaF1);
        muro1.mostrarMuroEnNavegador();
        entradaF1.addComentario("yo tambien kiero a ver cuando me llevas");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
