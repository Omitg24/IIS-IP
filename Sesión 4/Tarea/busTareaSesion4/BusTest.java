

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase Test para la clase Bus
 *
 * @author  Omar Teixeira González
 * @version 08/10/20
 */
public class BusTest
{
    /**
     * Default constructor for test class BusTest
     */
    public BusTest()
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
    
    /**
     * Prueba del constructor con parámetros 
     */
    @Test
    public void testConstructorWithParameters()
    {
        Bus bus1 = new Bus(true, 18);
        assertEquals(18, bus1.getAvailableSeats());
        assertEquals(true, bus1.getDriverPresent());
    }
    /*
     * Pruebas del método SitDriver:
     * Escenarios:
     * 1- driverPresent es true (primer constructor)-> se deja como está.
     * 2- driverPresent es false (segundo constructor) -> se cambia a true.
     */
    /**
     * 1- driverPresent es true (primer constructor)-> se deja como está.
     */@Test        //test del primer escenario
    public void testSitDriver1()
    {
        Bus bus1 = new Bus(true, 18);
        bus1.sitDrive();
        assertEquals(true, bus1.getDriverPresent());
    }
    
    /**
     * 2- driverPresent es false (segundo constructor) -> se cambia a true.
     */@Test        //test del segundo escenario
    public void testSitDriver2()
    {
        Bus bus1 = new Bus();
        bus1.sitDrive();
        assertEquals(true, bus1.getDriverPresent());
    }
    
    /*
     * Pruebas del método getOn:
     * Escenarios:
     * 1- El conductor está en el autobús y hay sitio para los pasajeros -> 
     * Cambia el número de asientos disponibles y devuelve true.
     * 2- El conductor no está en el autobús y no hay sitio para los pasajeros
     * -> No cambia el número de asientos disponibles y devuelve false.
     */
    
    /**
     * 1- El conductor está en el autobús y hay sitio para los pasajeros -> 
     * Cambia el número de asientos disponibles y devuelve true.
     */
    @Test       //test del primer escenario
    public void testgetOnTrue()
    {
        Bus bus1 = new Bus(true, 48);
        assertEquals(true, bus1.getOn(24));
        assertEquals(24, bus1.getAvailableSeats());
    }

    /**
     * 2- El conductor no está en el autobús y no hay sitio para los pasajeros
     * -> No cambia el número de asientos disponibles y devuelve false.
     */
    @Test        //test del primer escenario
    public void testgetOnFalse()
    {
        Bus bus1 = new Bus(false, 10);
        assertEquals(false, bus1.getOn(24));
        assertEquals(10, bus1.getAvailableSeats());
    }
    /*
     * Pruebas del método toString.
     * Escenarios:
     * 1- El conductor está en el autobús -> ON DUTY
     * 2- El conductor no está en el autobús -> OUT OF SERVICE
     */
    
    /**
     * 1- El conductor está en el autobús -> ON DUTY
     */
    @Test       //test del primer escenario
    public void testtoSringOnDuty()
    {
        Bus bus1 = new Bus(true, 45);
        assertEquals("ON DUTY-45", bus1.toString());
    }
    
    /**
     * 2- El conductor no está en el autobús -> OUT OF SERVICE
     */
    @Test       //test del segundo escenario
    public void testtoSringOutOfService()
    {
        Bus bus1 = new Bus(false, 45);
        assertEquals("OUT OF SERVICE-45", bus1.toString());
    }
}







