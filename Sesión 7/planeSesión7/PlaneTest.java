import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlaneTest.
 *
 * @author  Omar Teixeira González
 * @version 28-10-20
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
        assertNotNull(plane1);
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
        assertNotNull(plane1);
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
        assertNotNull(plane1);
        String result = plane1.toString();
        assertEquals("X-100-NO PILOT", result);
    }
    
    /**
     * 2- Pilot existe -> deuvelve el hashcode del piloto
     */
    @Test
    public void testToStringPilot(){
        Plane plane1 = new Plane(new Person("Ana","Alonso",18,Person.GENDER_FEMALE),'X',100);
        assertNotNull(plane1);
        String result = plane1.toString();
        assertEquals("X-100-18-AN-ALON-ADULT", result);
    }
    
    /*
     * Pruebas para el constructor con parámetro Pilot:
     * 1- Pilot es null
     * 2- Pilot no es null
     */
    
    /**
     * 1- Pilot es null
     */
    @Test          //test del primer escenario
    public void testConstructorPilotNull()
    {
        Plane plane1 = new Plane();
        assertNotNull(plane1);
        assertEquals(null, plane1.getPilot());
        assertEquals('A',plane1.getIdentifier());
        assertEquals(0,plane1.getFuel());
    }
    
    /**
     * 2- Pilot no es null 
     */
    @Test       //test del segundo escenario
    public void testConstructorPilotNotNull()
    {
        Person person1 = new Person();
        Plane plane1 = new Plane(person1);
        assertNotNull(plane1);
        assertEquals(person1, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
    }
    
    /*
     * Pruebas para el constructor con parámetro Identifier:
     * 1- Identifier es 'A' 
     * 2- Identifier esta entre 'A' y 'Z'
     * 3- Identifier es 'Z'
     */
    
    /**
     * 1- Identifier es 'A' 
     */
    @Test       //test del primer escenario
    public void testConstructorIdentifierInMinLimit()
    {
        Plane plane1 = new Plane('A');
        assertNotNull(plane1);
        assertEquals(null, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
    }

    /**
     * 2- Identifier esta entre 'A' y 'Z'
     */
    @Test       //test del segundo escenario
    public void testConstructorIdentifierBetweenLimits()
    {
        Plane plane1 = new Plane('O');
        assertNotNull(plane1);
        assertEquals(null, plane1.getPilot());
        assertEquals('O', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
    }
    
    /**
     * 3- Identifier es 'Z' 
     */
    @Test       //test del tercer escenario
    public void testConstructorIdentifierInMaxLimit()
    {
        Plane plane1 = new Plane('Z');
        assertNotNull(plane1);
        assertEquals(null, plane1.getPilot());
        assertEquals('Z', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
    }
    
    /*
     * Pruebas para el constructor con parámetro Fuel:
     * Positivos:
     * 1- Fuel igual a 0 -> Nuevo valor
     * 2- Fuel entre 0 y 5000 -> Nuevo valor
     * 3- Fuel igual a 5000 -> Nuevo valor
     * 
     * Negativos:
     * 4- Fuel menor que 0 -> Valor por defecto
     * 5- Fuel mayor que 5000 -> Valor por defecto
     */
    
    /**
     * 1- Fuel igual a 0 -> Nuevo valor
     */
    @Test       //test del primer escenario
    public void testConstructorFuelInMinLimit()
    {
        Plane plane1 = new Plane(0);
        assertNotNull(plane1);
        assertEquals(null, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
    }
    
    /**
     * 2- Fuel entre 0 y 5000 -> Nuevo valor
     */
    @Test       //test del segundo escenario
    public void testConstructorFuelBetweenLimits()
    {
        Plane plane1 = new Plane(2500);
        assertNotNull(plane1);
        assertEquals(null, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(2500, plane1.getFuel());
    }
    
    /**
     * 3- Fuel igual a 5000 -> Nuevo valor
     */
    @Test       //test del tercer escenario
    public void testConstructorFuelInMaxLimit()
    {
        Plane plane1 = new Plane(5000);
        assertNotNull(plane1);
        assertEquals(null, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(5000, plane1.getFuel());
    }
    
    /**
     * 4- Fuel menor que 0 -> Valor por defecto
     */
    @Test       //test del cuarto escenario
    public void testConstructorFuelUnderMinLimit()
    {
        Plane plane1 = new Plane(-100);
        assertNotNull(plane1);
        assertEquals(null, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
    }
    
    /**
     * 5- Fuel mayor que 5000 -> Valor por defecto
     */
    @Test       //test del quinto escenario
    public void testConstructorFuelOverMaxLimit()
    {
        Plane plane1 = new Plane(6000);
        assertNotNull(plane1);
        assertEquals(null, plane1.getPilot());
        assertEquals('A', plane1.getIdentifier());
        assertEquals(0, plane1.getFuel());
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
        assertNotNull(plane1);
        assertEquals("FLY OK", plane1.fly(60));
        assertEquals(0, plane1.getFuel());
    }
    
    /**
     * 2- km>50, Identificador distinto a Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     */
    @Test
    public void testFlyOver50_NotZ_EnoughFuel(){
        Plane plane1 = new Plane('X',3000);
        assertNotNull(plane1);
        assertEquals("FLY OK", plane1.fly(60));
        assertEquals(0, plane1.getFuel());
    }
    
    /**
     * 3- km=50, Identificador Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     */
    @Test
    public void testFly50_Z_EnoughFuel(){
        Plane plane1 = new Plane('Z',3000);
        assertNotNull(plane1);
        assertEquals("FLY OK", plane1.fly(50));
        assertEquals(2500, plane1.getFuel());
    }
    
    /**
     * 4- km=50, Identificador distinto a Z y fuel suficiente -> reduce combustible y devuelve FLY-OK
     */
    @Test
    public void testFly50_NotZ_EnoughFuel(){
        Plane plane1 = new Plane('A',3000);
        assertNotNull(plane1);
        assertEquals("FLY OK", plane1.fly(50));
        assertEquals(500, plane1.getFuel());
    }
    
    /**
     * 5- km>50, Identificador Z y fuel insuficiente -> NO reduce combustible y devuelve REFUEL (a repostar)
     */
    @Test
    public void testFlyOver50_Z_NotEnoughFuel(){
        Plane plane1 = new Plane('Z',100);
        assertNotNull(plane1);
        assertEquals("REFUEL 500", plane1.fly(60));
        assertEquals(100, plane1.getFuel());
    }
    
    /**
     * 6- km>50, Identificador distinto a Z y fuel insuficiente -> NO reduce combustible y devuelve REFUEL (a repostar)
     */
    @Test
    public void testFlyOver50_NotZ_NotEnoughFuel(){
        Plane plane1 = new Plane('A',100);
        assertNotNull(plane1);
        assertEquals("REFUEL 2900", plane1.fly(60));
        assertEquals(100, plane1.getFuel());
    }
    
    /**
     * 7- km<50, Identificador Z y fuel suficiente -> NO reduce combustible y devuelve FLY FAILED
     */
    @Test
    public void testFlyLess50_Z_EnoughFuel(){
        Plane plane1 = new Plane('Z',3000);
        assertNotNull(plane1);
        assertEquals("FLY FAILED", plane1.fly(40));
        assertEquals(3000, plane1.getFuel());
    }
    
    /**
     * 8- km<50, Identificador distinto a Z y fuel suficiente -> NO reduce combustible y devuelve FLY FAIELD
     */
    @Test
    public void testFlyLess50_NotZ_EnoughFuel(){
        Plane plane1 = new Plane('X',3000);
        assertNotNull(plane1);
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
        assertNotNull(plane1);
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
        assertNotNull(plane1);
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
        assertNotNull(plane1);
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
        assertNotNull(plane1);
        plane1.accelerate(2, -2);
        assertEquals(0, plane1.getXSpeed());
        assertEquals(0, plane1.getYSpeed());
    }
}








