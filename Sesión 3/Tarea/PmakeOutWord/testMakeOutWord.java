

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testMakeOutWord.
 *
 * @author  Omar Teixeira González
 * @version 30/09/2020
 */
public class testMakeOutWord
{
    /**
     * Default constructor for test class testMakeOutWord
     */
    public testMakeOutWord()
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
    
    /*
     * Escenarios:
     * 1- Palabra "Yay" entre "<<>>"
     * 2- Palabra "WooHoo" entre "<<>>"
     */
    
    /**
     * 1- Palabra "Yay" entre "<<>>"
     */
    
    @Test       //Test del primer escenario
    public void testmakeOutWord1()
    {
        makeOutWord makeOutW1 = new makeOutWord();
        assertEquals("<<Yay>>", makeOutW1.makeOutWord("<<>>", "Yay"));
    }
    
    /**
     * 2- Palabra "WooHoo" entre "<<>>"
     */
    
    @Test       //Test del segundo escenario
    public void testmakeOutWord2()
    {
        makeOutWord makeOutW1 = new makeOutWord();
        assertEquals("<<WooHoo>>", makeOutW1.makeOutWord("<<>>", "WooHoo"));
    }
}

