

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba de la clase Person
 *
 * @author  Omar Teixeira Gonz�lez
 * @version 07/10/2020
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
     *   1- par�metro dentro de los l�mites -> Cambia la edad
     *   4- par�metro igual al primer l�mite -> Cambia la edad
     *   5- par�metro igual al segundo l�mite -> Cambia la edad
     * Negativos            //casos negativos dentro de los par�metros age
     *   2- par�metro superior al segundo l�mite -> No cambia la edad
     *   3- par�metro inferior al primer l�mite -> No cambia la edad
     *    
     */
    /**
     * 1- par�metro dentro de los l�mites -> Cambia la edad
     */
    @Test       //test del primer escenario
    public void testSetAgeInsideLimits()
    {
        Person person1 = new Person(20);    //situaci�n inicial
        person1.setAge(22);                 //llamnamos al m�todo a probar con el escenario a probar
        assertEquals(22, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 2- par�metro superior al segundo l�mite -> No cambia la edad
     */
    @Test       //test del segundo escenario
    public void testSetAgeOverUpperLimit()
    {
        Person person1 = new Person(30);    //situaci�n inicial
        person1.setAge(125);                 //llamnamos al m�todo a probar con el escenario a probar
        assertEquals(30, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 3- par�metro inferior al primer l�mite -> No cambia la edad
     */
    @Test       //test del tercer escenario
    public void testSetAgeUnderneathLowerLimit()
    {
        Person person1 = new Person(40);    //situaci�n inicial
        person1.setAge(-30);                 //llamnamos al m�todo a probar con el escenario a probar
        assertEquals(40, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 4- par�metro igual al primer l�mite -> Cambia la edad
     */
    @Test       //test del cuarto escenario
    public void testSetAgeInLowerLimit()
    {
        Person person1 = new Person(25);    //situaci�n inicial
        person1.setAge(Person.MIN_AGE);                 //llamnamos al m�todo a probar con el escenario a probar
        assertEquals(0, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 5- par�metro igual al segundo l�mite -> Cambia la edad
     */
    @Test       //test del quinto escenario
    public void testSetAgeInUpperLimit()
    {
        Person person1 = new Person(18);    //situaci�n inicial
        person1.setAge(Person.MAX_AGE);                 //llamamos al m�todo a probar con el escenario a probar
        assertEquals(120, person1.getAge()); //comprobamos el resultado
    }
    /*
     * Pruebas de getCriticaAge
     * Escenarios:
     * 1- Par�metro igual a MIN_AGE -> A�os restantes para tener 18
     * 2- Par�metro comprendido entre MIN_AGE y ADULTHOOD_AGE -> A�os restantes para tener 18
     * 3- Par�metro igual a ADULTHOOD_AGE -> A�os restantes para tener 65
     * 4- Par�metro comprendido entre ADULTHOOD_AGE y RETIREMENT_AGE -> A�os restantes para tener 65
     * 5- Par�metro igual a RETIREMENT_AGE -> Como ya hemos alcanzado los 65, el resultado ser� 65-65=0
     * 6- Par�metro comprendido entre RETIREMENT_AGE y MAX_AGE -> A�os pasados desde los 65
     * 7- Par�metro igual a MAX_AGE -> A�os pasados desde los 65
     */
     
    /**
     * 1- Par�metro igual a MIN_AGE -> A�os restantes para tener 18
     */
    @Test       //test del primer escenario
    public void testgetCriticalAgeInLowerLimit1()
    {
        Person person1 = new Person(Person.MIN_AGE);    //situaci�n inicial y m�todo a probar con el escenario a probar
        assertEquals(person1.ADULTHOOD_AGE-person1.getAge(), person1.getCriticalAge()); //comprobamos el resultado
    }
    
    /**
     * 2- Par�metro comprendido entre MIN_AGE y ADULTHOOD_AGE -> A�os restantes para tener 18
     */
    @Test       //test del segundo escenario
    public void testgetCriticalAgeInsideLowerLimits()
    {
        Person person1 = new Person(16);    //situaci�n inicial y m�todo a probar con el escenario a probar
        assertEquals(person1.ADULTHOOD_AGE-person1.getAge(), person1.getCriticalAge()); //comprobamos el resultado
    }
    
    /**
     * 3- Par�metro igual a ADULTHOOD_AGE -> A�os restantes para tener 65
     */
    @Test       //test del tercer escenario
    public void testgetCriticalAgeInLowerLimit2()
    {
        Person person1 = new Person(Person.ADULTHOOD_AGE);  //situaci�n inicial y m�todo a probar con el escenario a probar
        assertEquals(person1.RETIREMENT_AGE  - person1.getAge(), person1.getCriticalAge()); //comprobamos el resultado
    }
    
    /**  
     * 4- Par�metro comprendido entre ADULTHOOD_AGE y RETIREMENT_AGE -> A�os restantes para tener 65
     */
    @Test       //test del cuarto escenario
    public void testgetCriticalAgeInsideMediumLimits()
    {
        Person person1 = new Person(42);    //situaci�n inicial y m�todo a probar con el escenario a probar
        assertEquals(person1.RETIREMENT_AGE - person1.getAge(), person1.getCriticalAge());  //comprobamos el resultado
    }
    
    /**  
     * 5- Par�metro igual a RETIREMENT_AGE -> Como ya hemos alcanzado los 65, el resultado ser� 65-65=0
     */
    @Test       //test del quinto escenario
    public void testgetCriticalAgeInUpperLimit2()
    {
        Person person1 = new Person(Person.RETIREMENT_AGE); //situaci�n inicial y m�todo a probar con el escenario a probar
        assertEquals(person1.RETIREMENT_AGE - person1.getAge(), person1.getCriticalAge());  //comprobamos el resultado
    }
    
    /**
     * 6- Par�metro comprendido entre RETIREMENT_AGE y MAX_AGE -> A�os pasados desde los 65      
     */
    @Test       //test del sexto escenario
    public void testgetCriticalAgeInsideUpperLimits()
    {
        Person person1 = new Person(76);    //situaci�n inicial y m�todo a probar con el escenario a probar
        assertEquals(person1.getAge() - person1.RETIREMENT_AGE, person1.getCriticalAge());  //comprobamos el resultado
    }
    
    /**
     * 7- Par�metro igual a MAX_AGE -> A�os pasados desde los 65
     */
    @Test
    public void testgetCriticalAgeInUpperLimit1()
    {
        Person person1 = new Person(Person.MAX_AGE);    //situaci�n inicial y m�todo a probar con el escenario a probar
        assertEquals(person1.getAge() - person1.RETIREMENT_AGE, person1.getCriticalAge());  //comprobamos el resultado
    }
    
    
    /*
     * Pruebas de getHashCode
     * Escenarios:
     * 1-Cambio de la edad para el m�todo getHashCode -> Cambiar la edad
     * 2-Cambio del nombre para el m�todo getHashCode -> Cambiar el nombre
     * 3-Cambio del apellido para el m�todo getHashCode -> Cambiar el apellido
     * 4-Cambio de la etapa de la edad para el m�todo getHashCode -> Cambiar 
     * la etapa
     */
    
    /**
     * 1-Cambio de la edad para el m�todo getHashCode -> Cambiar la edad
     */
       
    @Test       //test del primer escenario
    public void testgetHashCodeSetAge()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setAge(18); //llamamos al m�todo a probar con el escenario a probar
        assertEquals("18-OM-TEIX-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /**
     * 2-Cambio del nombre para el m�todo getHashCode -> Cambiar el nombre
     */
       
    @Test       //test del segundo escenario
    public void testgetHashCodeSetName()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setName("OMAR");    //llamamos al m�todo a probar con el escenario a probar
        assertEquals("18-OM-TEIX-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /**
     * 3-Cambio del apellido para el m�todo getHashCode -> Cambiar el apellido
     */
       
    @Test           //test del tercer escenario
    public void testgetHashCodeSetSurname()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setSurname("TEIXEIRA"); //llamamos al m�todo a probar con el escenario a probar
        assertEquals("18-OM-TEIX-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /**
     * 3-Cambio del apellido para el m�todo getHashCode -> Cambiar el apellido
     */
       
    @Test           //test del tercer escenario
    public void testgetHashCodeGetAgeCategory()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setAge(18); //llamamos al m�todo a probar con el escenario a probar
        assertEquals("18-OM-TEIX-ADULT", person1.getHashCode());    //comprobamos el resultado
    }

    /**
     * Test del constructor sin par�metros
     */@Test        //unico escenario
    public void testConstructorWithoutParameters()
    {
        Person person1 = new Person();
        assertEquals("Omar", person1.getName());
        assertEquals(18, person1.getAge());
        assertEquals("Teixeira", person1.getSurname());
        assertEquals(true, person1.getGender());
        assertEquals("00000000A", person1.getDni());
    }
}
