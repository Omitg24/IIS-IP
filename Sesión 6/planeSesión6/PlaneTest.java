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
     * Pruebas del método toString:
     * 1- Piloto no existe -> devuelve entre otras cosas NO PILOT
     * 2- Pilot existe -> deuvelve el hashcode del piloto
     */
    
    /**
     * 1- Piloto no existe -> devuelve entre otras cosas NO PILOT
     */
    @Test
    public void testToStringNoPilot(){
        Plane plane1 = new Plane(null, 'X', 100);
        String result = plane1.toString();
        assertEquals("X-100-NO PILOT", result);
    }
    
    /**
     * 2- Pilot existe -> deuvelve el hashcode del piloto
     */
    @Test
    public void testToStringPilot(){
        Plane plane1 = new Plane(new Person("Ana","Alonso",18,Person.GENDER_FEMALE),'X',100);
        String result = plane1.toString();
        assertEquals("X-100-18-AN-ALON-ADULT", result);
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
     * Pruebas del método readyToFly:
     * Positivos:
     * 1- km>50, Identificador Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     * 2- km>50, Identificador distinto a Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     * 3- km=50, Identificador Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     * 4- km=50, Identificador distinto a Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     * 
     * Negativos:
     * 5- km>50, Identificador Z y fuel insuficiente -> NO reduce combustible y devuelve REFUEL (a repostar)
     * 6- km>50, Identificador distinto a Z y fuel insuficiente -> NO reduce combustible y devuelve REFUEL (a repostar)
     * 7- km<50, Identificador Z y fuel suficiente -> NO reduce combustible y devuelve FLY FAILED
     * 8- km<50, Identificador distinto a Z y fuel suficiente -> NO reduce combustible y devuelve FLY FAIELD
     */
    /**
     * 1- km>50, Identificador Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     */
    @Test
    public void testFlyOver50_Z_EnoughFuel(){
        Plane plane1 = new Plane('Z',600);
        assertEquals("FLY OK", plane1.fly(60));
        assertEquals(0, plane1.getFuel());
    }
    
    /**
     * 2- km>50, Identificador distinto a Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     */
    @Test
    public void testFlyOver50_NotZ_EnoughFuel(){
        Plane plane1 = new Plane('X',3000);
        assertEquals("FLY OK", plane1.fly(60));
        assertEquals(0, plane1.getFuel());
    }
    
    /**
     * 3- km=50, Identificador Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     */
    @Test
    public void testFly50_Z_EnoughFuel(){
        Plane plane1 = new Plane('Z',3000);
        assertEquals("FLY OK", plane1.fly(50));
        assertEquals(2500, plane1.getFuel());
    }
    
    /**
     * 4- km=50, Identificador distinto a Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     */
    @Test
    public void testFly50_NotZ_EnoughFuel(){
        Plane plane1 = new Plane('A',3000);
        assertEquals("FLY OK", plane1.fly(50));
        assertEquals(500, plane1.getFuel());
    }
    
    /**
     * 5- km>50, Identificador Z y fuel insuficiente -> NO reduce combustible y devuelve REFUEL (a repostar)
     */
    @Test
    public void testFlyOver50_Z_NotEnoughFuel(){
        Plane plane1 = new Plane('Z',100);
        assertEquals("REFUEL 500", plane1.fly(60));
        assertEquals(100, plane1.getFuel());
    }
    
    /**
     * 6- km>50, Identificador distinto a Z y fuel insuficiente -> NO reduce combustible y devuelve REFUEL (a repostar)
     */
    @Test
    public void testFlyOver50_NotZ_NotEnoughFuel(){
        Plane plane1 = new Plane('A',100);
        assertEquals("REFUEL 2900", plane1.fly(60));
        assertEquals(100, plane1.getFuel());
    }
    
    /**
     * 7- km<50, Identificador Z y fuel suficiente -> NO reduce combustible y devuelve FLY FAILED
     */
    @Test
    public void testFlyLess50_Z_EnoughFuel(){
        Plane plane1 = new Plane('Z',3000);
        assertEquals("FLY FAILED", plane1.fly(40));
        assertEquals(3000, plane1.getFuel());
    }
    
    /**
     * 8- km<50, Identificador distinto a Z y fuel suficiente -> NO reduce combustible y devuelve FLY FAIELD
     */
    @Test
    public void testFlyLess50_NotZ_EnoughFuel(){
        Plane plane1 = new Plane('X',3000);
        assertEquals("FLY FAILED", plane1.fly(40));
        assertEquals(3000, plane1.getFuel());
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
    
    
    /**
     * 2- Que reciba null
     */
    @Test
    public void testConstuctorWithPilot(){
        Person pilot = new Person();
        Plane plane1 = new Plane(pilot);
        
        assertNotNull(plane1);      //Comprueba que se ha creado el avión
                                        //comprueba que los atributos son los esperados       
        assertNotNull(plane1.getPilot());
        assertEquals(Plane.DEFAULT_IDENTIFIER, plane1.getIdentifier());
        assertEquals(Plane.DEFAULT_FUEL, plane1.getFuel());
    }
}







