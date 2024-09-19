import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlaneTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlaneTest
{
    /**
     * Default constructor for test class PlaneTest
     */
    public PlaneTest()
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
     * Pruebas del fly
     * Escenarios:
     * 1- No hay combustible -> devuelve false
     * 2- Si hay combustible -> devuelve true y reduce en 1 el combustible
     */

    /**
     * 1- No hay combustible -> devuelve false
     */
    @Test
    public void testFlyNoFuel()
    {
        Plane plane1 = new Plane(null, 'X', 0);
        assertEquals(false, plane1.fly());
        assertEquals(0, plane1.getFuel());
    }
    
    /**
     * 2- Si hay combustible -> devuelve true y reduce en 1 el combustible
     */
    @Test
    public void testFlyWithFuel()
    {
        Plane plane1 = new Plane(null, 'X', 100);
        assertEquals(true, plane1.fly());
        assertEquals(99, plane1.getFuel());
    }
    /*
     * Escenarios de los test de los constructores:
     * 1- Constructor con parámetro Pilot -> Cambia el nombre
     * 2- Constructor con parámetro Identifier -> Cambia el identificador
     * 3- Constructor con parámetro Fuel -> Cambia el combustible
     */
    
    /**
     * 1- Constructor con parámetro Pilot -> Cambia el nombre
     */
    
    @Test          //test del primer escenario
    public void testConstructor3()
    {
        Plane plane1 = new Plane(null);
        assertEquals(null, plane1.getPilot());
    }

    /**
     * 2- Constructor con parámetro Identifier -> Cambia el identificador
     */
    
    @Test           //test del segundo escenario
    public void testConstructor4()
    {
        Plane plane1 = new Plane('X');
        assertEquals('X', plane1.getIdentifier());
    }

    /**
     * 3- Constructor con parámetro Fuel -> Cambia el combustible
     */
    
    @Test           //test del tercer escenario
    public void testConstructor5()
    {
        Plane plane1 = new Plane(100);
        assertEquals(100, plane1.getFuel());
    }
    /*
     * Escenarios de los test del método accelerate():
     * 1- xSpeed e ySpeed dentro de los límites -> Cambiar el valor de los atributos
     * 2- xSpeed dentro de los límites e ySpeed fuera de ellos -> No cambiar el valor de los atributos
     * 3- xSpeed fuera de los límites e ySpeed dentro de ellos -> No cambiar el valor de los atributos
     * 4- xSpeed e ySpeed fuera de los límites -> No cambiar el valor de los atributos
     */
    
    
    /**
     * 1- xSpeed e ySpeed dentro de los límites -> Cambiar el valor de los atributos
     */
    @Test       //test del primer escenario
    public void testAccelerateInsideLimits()
    {
        Plane plane1 = new Plane();
        plane1.accelerate(1, -1);
        assertEquals(1, plane1.getXSpeed());
        assertEquals(-1, plane1.getYSpeed());
    }
    
    /**
     * 2- xSpeed dentro de los límites e ySpeed fuera de ellos -> No cambiar el valor de los atributos
     */
    @Test       //test del segundo escenario
    public void testAccelerateYOutOfTheLimits()
    {
        Plane plane1 = new Plane();
        plane1.accelerate(1, -2);
        assertEquals(0, plane1.getXSpeed());
        assertEquals(0, plane1.getYSpeed());
    }
    
    /**
     * 3- xSpeed fuera de los límites e ySpeed dentro de ellos -> No cambiar el valor de los atributos
     */
    @Test       //test del tercer escenario
    public void testAccelerateXOutOfTheLimits()
    {
        Plane plane1 = new Plane();
        plane1.accelerate(2, -1);
        assertEquals(0, plane1.getXSpeed());
        assertEquals(0, plane1.getYSpeed());
    }
    
    /**
     * 4- xSpeed e ySpeed fuera de los límites -> No cambiar el valor de los atributos
     */
    @Test       //test del cuarto escenario
    public void testAccelerateOutOfTheLimits()
    {
        Plane plane1 = new Plane();
        plane1.accelerate(2, -2);
        assertEquals(0, plane1.getXSpeed());
        assertEquals(0, plane1.getYSpeed());
    }
}







