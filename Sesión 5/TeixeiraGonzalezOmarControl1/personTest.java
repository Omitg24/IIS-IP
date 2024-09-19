

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba de la clase Person
 *
 * @author  Omar Teixeira González
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
     * Prueba para el método setAge
     * Escenarios de prueba (o casos de uso)
     * Positivos            //casos positivos dentro de los parámetros age
     *   1- parámetro dentro de los límites -> Cambia la edad
     *   4- parámetro igual al primer límite -> Cambia la edad
     *   5- parámetro igual al segundo límite -> Cambia la edad
     * Negativos            //casos negativos dentro de los parámetros age
     *   2- parámetro superior al segundo límite -> No cambia la edad
     *   3- parámetro inferior al primer límite -> No cambia la edad
     *    
     */
    /**
     * 1- parámetro dentro de los límites -> Cambia la edad
     */
    @Test       //test del primer escenario
    public void testSetAgeInsideLimits()
    {
        Person person1 = new Person(20);    //situación inicial
        person1.setAge(22);                 //llamnamos al método a probar con el escenario a probar
        assertEquals(22, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 2- parámetro superior al segundo límite -> No cambia la edad
     */
    @Test       //test del segundo escenario
    public void testSetAgeOverUpperLimit()
    {
        Person person1 = new Person(30);    //situación inicial
        person1.setAge(125);                 //llamnamos al método a probar con el escenario a probar
        assertEquals(30, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 3- parámetro inferior al primer límite -> No cambia la edad
     */
    @Test       //test del tercer escenario
    public void testSetAgeUnderneathLowerLimit()
    {
        Person person1 = new Person(40);    //situación inicial
        person1.setAge(-30);                 //llamnamos al método a probar con el escenario a probar
        assertEquals(40, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 4- parámetro igual al primer límite -> Cambia la edad
     */
    @Test       //test del cuarto escenario
    public void testSetAgeInLowerLimit()
    {
        Person person1 = new Person(25);    //situación inicial
        person1.setAge(Person.MIN_AGE);                 //llamnamos al método a probar con el escenario a probar
        assertEquals(0, person1.getAge()); //comprobamos el resultado
    }
    
    /**
     * 5- parámetro igual al segundo límite -> Cambia la edad
     */
    @Test       //test del quinto escenario
    public void testSetAgeInUpperLimit()
    {
        Person person1 = new Person(18);    //situación inicial
        person1.setAge(Person.MAX_AGE);                 //llamamos al método a probar con el escenario a probar
        assertEquals(120, person1.getAge()); //comprobamos el resultado
    }
    /*
     * Pruebas de getCriticaAge
     * Escenarios:
     * 1- Parámetro igual a MIN_AGE -> Años restantes para tener 18
     * 2- Parámetro comprendido entre MIN_AGE y ADULTHOOD_AGE -> Años restantes para tener 18
     * 3- Parámetro igual a ADULTHOOD_AGE -> Años restantes para tener 65
     * 4- Parámetro comprendido entre ADULTHOOD_AGE y RETIREMENT_AGE -> Años restantes para tener 65
     * 5- Parámetro igual a RETIREMENT_AGE -> Como ya hemos alcanzado los 65, el resultado será 65-65=0
     * 6- Parámetro comprendido entre RETIREMENT_AGE y MAX_AGE -> Años pasados desde los 65
     * 7- Parámetro igual a MAX_AGE -> Años pasados desde los 65
     */
     
    /**
     * 1- Parámetro igual a MIN_AGE -> Años restantes para tener 18
     */
    @Test       //test del primer escenario
    public void testgetCriticalAgeInLowerLimit1()
    {
        Person person1 = new Person(Person.MIN_AGE);    //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.ADULTHOOD_AGE-person1.getAge(), person1.getCriticalAge()); //comprobamos el resultado
    }
    
    /**
     * 2- Parámetro comprendido entre MIN_AGE y ADULTHOOD_AGE -> Años restantes para tener 18
     */
    @Test       //test del segundo escenario
    public void testgetCriticalAgeInsideLowerLimits()
    {
        Person person1 = new Person(16);    //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.ADULTHOOD_AGE-person1.getAge(), person1.getCriticalAge()); //comprobamos el resultado
    }
    
    /**
     * 3- Parámetro igual a ADULTHOOD_AGE -> Años restantes para tener 65
     */
    @Test       //test del tercer escenario
    public void testgetCriticalAgeInLowerLimit2()
    {
        Person person1 = new Person(Person.ADULTHOOD_AGE);  //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.RETIREMENT_AGE  - person1.getAge(), person1.getCriticalAge()); //comprobamos el resultado
    }
    
    /**  
     * 4- Parámetro comprendido entre ADULTHOOD_AGE y RETIREMENT_AGE -> Años restantes para tener 65
     */
    @Test       //test del cuarto escenario
    public void testgetCriticalAgeInsideMediumLimits()
    {
        Person person1 = new Person(42);    //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.RETIREMENT_AGE - person1.getAge(), person1.getCriticalAge());  //comprobamos el resultado
    }
    
    /**  
     * 5- Parámetro igual a RETIREMENT_AGE -> Como ya hemos alcanzado los 65, el resultado será 65-65=0
     */
    @Test       //test del quinto escenario
    public void testgetCriticalAgeInUpperLimit2()
    {
        Person person1 = new Person(Person.RETIREMENT_AGE); //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.RETIREMENT_AGE - person1.getAge(), person1.getCriticalAge());  //comprobamos el resultado
    }
    
    /**
     * 6- Parámetro comprendido entre RETIREMENT_AGE y MAX_AGE -> Años pasados desde los 65      
     */
    @Test       //test del sexto escenario
    public void testgetCriticalAgeInsideUpperLimits()
    {
        Person person1 = new Person(76);    //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.getAge() - person1.RETIREMENT_AGE, person1.getCriticalAge());  //comprobamos el resultado
    }
    
    /**
     * 7- Parámetro igual a MAX_AGE -> Años pasados desde los 65
     */
    @Test
    public void testgetCriticalAgeInUpperLimit1()
    {
        Person person1 = new Person(Person.MAX_AGE);    //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.getAge() - person1.RETIREMENT_AGE, person1.getCriticalAge());  //comprobamos el resultado
    }
    
    
    /*
     * Pruebas de getHashCode
     * Escenarios:
     * 1-Cambio de la edad para el método getHashCode -> Cambiar la edad
     * 2-Cambio del nombre para el método getHashCode -> Cambiar el nombre
     * 3-Cambio del apellido para el método getHashCode -> Cambiar el apellido
     * 4-Cambio de la etapa de la edad para el método getHashCode -> Cambiar 
     * la etapa
     */
    
    /**
     * 1-Cambio de la edad para el método getHashCode -> Cambiar la edad
     */
       
    @Test       //test del primer escenario
    public void testgetHashCodeSetAge()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setAge(18); //llamamos al método a probar con el escenario a probar
        assertEquals("18-OM-TEIX-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /**
     * 2-Cambio del nombre para el método getHashCode -> Cambiar el nombre
     */
       
    @Test       //test del segundo escenario
    public void testgetHashCodeSetName()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setName("OMAR");    //llamamos al método a probar con el escenario a probar
        assertEquals("18-OM-TEIX-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /**
     * 3-Cambio del apellido para el método getHashCode -> Cambiar el apellido
     */
       
    @Test           //test del tercer escenario
    public void testgetHashCodeSetSurname()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setSurname("TEIXEIRA"); //llamamos al método a probar con el escenario a probar
        assertEquals("18-OM-TEIX-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /**
     * 3-Cambio del apellido para el método getHashCode -> Cambiar el apellido
     */
       
    @Test           //test del tercer escenario
    public void testgetHashCodeGetAgeCategory()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setAge(18); //llamamos al método a probar con el escenario a probar
        assertEquals("18-OM-TEIX-ADULT", person1.getHashCode());    //comprobamos el resultado
    }

    /**
     * Test del constructor sin parámetros
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
