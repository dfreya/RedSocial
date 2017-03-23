

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PruevaInteractiva.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PruevaInteractiva
{
    private EntradaTexto entradaT1;
    private EntradaFoto entradaF1;
    private EntadaUnionAGrupo entadaUn1;
    private EntradaTexto entradaT2;
    private EntradaFoto entradaF2;
    private EntadaUnionAGrupo entadaUn2;
    private Muro muro1;
    private EntradaTexto entradaT3;

    /**
     * Default constructor for test class PruevaInteractiva
     */
    public PruevaInteractiva()
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
        entradaT1 = new EntradaTexto("Borja", "hola clase");
        entradaF1 = new EntradaFoto("Borja", "htt//borja", "Foto Clase Borja");
        entadaUn1 = new EntadaUnionAGrupo("Borja", "Cena Semana Santa");
        entradaT2 = new EntradaTexto("Azahara", "holis a todos");
        entradaF2 = new EntradaFoto("Azahara", "htt//azahara", "Aki esperando con borja");
        entadaUn2 = new EntadaUnionAGrupo("Azahara", "Cena Semana Santa");
        muro1 = new Muro();
        entradaT3 = new EntradaTexto("Oscarino", "Yo paso");
        muro1.addEntrada(entradaT3);
        muro1.addEntrada(entadaUn2);
        muro1.addEntrada(entradaF2);
        muro1.addEntrada(entradaT2);
        muro1.addEntrada(entadaUn1);
        muro1.addEntrada(entradaF1);
        muro1.addEntrada(entradaT1);
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
