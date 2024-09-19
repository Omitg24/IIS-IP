

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class personTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class personTest
{
    /**
     * Default constructor for test class personTest
     */
    public personTest()
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
     * Prueba para el m�todo setAge
     * Escenarios de prueba (o casos de uso)
     * Positivos            //casos positivos dentro de los par�metros age
     * 1- par�metro dentro de los l�mites -> Cambia la edad
     * 4- par�metro igual al primer l�mite -> Cambia la edad
     * 
     * Negativos            //casos negativos dentro de los par�metros age
     * 2- par�metro superior al segundo l�mite -> No cambia la edad
     * 3- par�metro inferior al primer l�mite -> No cambia la edad
     * 5- par�metro igual al segundo l�mite -> No cambia la edad
     * 
     */
    
    /**
     * 1- par�metro dentro de los l�mites -> Cambia la edad
     */
    @Test
    public void testSetAgeInsideLimits()
    {
        Person person1 = new Person(20);    //situaci�n inicial
        person1.setAge(22);                 //llamnamos al m�todo a probar con el escenario a probar
        assertEquals(22, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 2- par�metro superior al segundo l�mite -> No cambia la edad
     */
    @Test
    public void testSetAgeOverUpperLimit()
    {
        Person person1 = new Person(30);    //situaci�n inicial
        person1.setAge(125);                 //llamnamos al m�todo a probar con el escenario a probar
        assertEquals(30, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 3- par�metro inferior al primer l�mite -> No cambia la edad
     */
    @Test
    public void testSetAgeUnderneathLowerLimit()
    {
        Person person1 = new Person(40);    //situaci�n inicial
        person1.setAge(-30);                 //llamnamos al m�todo a probar con el escenario a probar
        assertEquals(40, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 4- par�metro igual al primer l�mite -> Cambia la edad
     */
    @Test
    public void testSetAgeInLowerLimit()
    {
        Person person1 = new Person(25);    //situaci�n inicial
        person1.setAge(Person.MIN_AGE);                 //llamnamos al m�todo a probar con el escenario a probar
        assertEquals(0, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 5- par�metro igual al segundo l�mite -> No cambia la edad
     */
    @Test
    public void testSetAgeInUpperLimit()
    {
        Person person1 = new Person(18);    //situaci�n inicial
        person1.setAge(Person.MAX_AGE);                 //llamnamos al m�todo a probar con el escenario a probar
        assertEquals(18, person1.getAge()); //comprobamos el resultado
    }
    /*
     * Pruebas de getCriticaAge
     * Escenarios:
     * 1-
     */
     
        
}

