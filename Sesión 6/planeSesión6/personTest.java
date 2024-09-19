

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
     * Negativos            //casos negativos dentro de los parámetros age
     *   2- parámetro superior al segundo límite -> No cambia la edad
     *   3- parámetro inferior al primer límite -> No cambia la edad
     *   5- parámetro igual al segundo límite -> No cambia la edad
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
     * 5- parámetro igual al segundo límite -> No cambia la edad
     */
    @Test       //test del quinto escenario
    public void testSetAgeInUpperLimit()
    {
        Person person1 = new Person(50);    //situación inicial
        person1.setAge(Person.MAX_AGE);                 //llamamos al método a probar con el escenario a probar
        assertEquals(50, person1.getAge()); //comprobamos el resultado
    }
    /*
     * Pruebas de getCriticaAge
     * Escenarios:
     * 1- Parámetro comprendido entre MIN_AGE y ADULTHOOD_AGE -> Años restantes para tener 18
     * 2- Parámetro igual a ADULTHOOD_AGE -> Años restantes para tener 65
     * 3- Parámetro comprendido entre ADULTHOOD_AGE y RETIREMENT_AGE -> Años restantes para tener 65
     * 4- Parámetro igual a RETIREMENT_AGE -> Como ya hemos alcanzado los 65, el resultado será 65-65=0
     * 5- Parámetro comprendido entre RETIREMENT_AGE y MAX_AGE -> Años pasados desde los 65
     */
            
    /**
     * 1- Parámetro comprendido entre MIN_AGE y ADULTHOOD_AGE -> Años restantes para tener 18
     */
    @Test       //test del primer escenario
    public void testgetCriticalAgeInsideLowerLimits()
    {
        Person person1 = new Person(16);    //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.ADULTHOOD_AGE-person1.getAge(), person1.getCriticalAge()); //comprobamos el resultado
    }
    
    /**
     * 2- Parámetro igual a ADULTHOOD_AGE -> Años restantes para tener 65
     */
    @Test       //test del segundo escenario
    public void testgetCriticalAgeInLowerLimit2()
    {
        Person person1 = new Person(Person.ADULTHOOD_AGE);  //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.RETIREMENT_AGE  - person1.getAge(), person1.getCriticalAge()); //comprobamos el resultado
    }
    
    /**  
     * 3- Parámetro comprendido entre ADULTHOOD_AGE y RETIREMENT_AGE -> Años restantes para tener 65
     */
    @Test       //test del tercer escenario
    public void testgetCriticalAgeInsideMediumLimits()
    {
        Person person1 = new Person(42);    //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.RETIREMENT_AGE - person1.getAge(), person1.getCriticalAge());  //comprobamos el resultado
    }
    
    /**  
     * 4- Parámetro igual a RETIREMENT_AGE -> Como ya hemos alcanzado los 65, el resultado será 65-65=0
     */
    @Test       //test del cuarto escenario
    public void testgetCriticalAgeInUpperLimit2()
    {
        Person person1 = new Person(Person.RETIREMENT_AGE); //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.RETIREMENT_AGE - person1.getAge(), person1.getCriticalAge());  //comprobamos el resultado
    }
    
    /**
     * 5- Parámetro comprendido entre RETIREMENT_AGE y MAX_AGE -> Años pasados desde los 65      
     */
    @Test       //test del quinto escenario
    public void testgetCriticalAgeInsideUpperLimits()
    {
        Person person1 = new Person(76);    //situación inicial y método a probar con el escenario a probar
        assertEquals(person1.getAge() - person1.RETIREMENT_AGE, person1.getCriticalAge());  //comprobamos el resultado
    }
    
    /*
     * Pruebas de getHashCode
     * Escenarios:
     * 1-Cambio de la edad para el método getHashCode -> Cambiar la edad
     * 2-Cambio del nombre para el método getHashCode -> Cambiar el nombre
     * 3-Cambio del apellido para el método getHashCode -> Cambiar el apellido
     * 4-Cambio de la etapa de la edad para el método getHashCode -> Cambiar la etapa
     */
    
    /**
     * 1-Cambio de la edad para el método getHashCode -> Cambiar la edad
     */
       
    @Test       //test del primer escenario
    public void testgetHashCodeSetAge()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setAge(39); //llamamos al método a probar con el escenario a probar
        assertEquals("39-FE-ALON-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /**
     * 2-Cambio del nombre para el método getHashCode -> Cambiar el nombre
     */
       
    @Test       //test del segundo escenario
    public void testgetHashCodeSetName()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setName("FERNANDO");    //llamamos al método a probar con el escenario a probar
        assertEquals("39-FE-ALON-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /**
     * 3-Cambio del apellido para el método getHashCode -> Cambiar el apellido
     */
       
    @Test           //test del tercer escenario
    public void testgetHashCodeSetSurname()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setSurname("ALONSO"); //llamamos al método a probar con el escenario a probar
        assertEquals("39-FE-ALON-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /**
     * 3-Cambio del apellido para el método getHashCode -> Cambiar el apellido
     */
       
    @Test           //test del tercer escenario
    public void testgetHashCodeGetAgeCategory()
    {
        Person person1 = new Person();  //comprobamos el resultado
        person1.setAge(39); //llamamos al método a probar con el escenario a probar
        assertEquals("39-FE-ALON-ADULT", person1.getHashCode());    //comprobamos el resultado
    }
    
    /*
     * Pruebas para el método changeAge:
     * Positivos
     * 1- Masculino y nueva edad menor que el límite (100)
     * 2- Femenino y mayor de edad y nueva edad mayor que el mínimo (20)
     * 3- Masculino y nueva edad igual que el máximo (100)
     * 4- Femenino y mayor de edad y nueva edad igual que el mínimo (20)
     * 
     * Negativos
     * 5- Masculino y nueva edad mayor que el máximo (100)
     * 6- Femenino y nueva edad menor que el mínimo
     * 7- Femenino y edad menor de 18
     */
    
    /**
     * Test changeAge
     * 1- Masculino y nueva edad menor que el límite (100).
     */
    public void testChangeAgeMaleLessMaxAge(){
        Person person1 = new Person ("Pepe", "Álvarez", 20, Person.GENDER_MALE);
        person1.changeAge();
        assertEquals(27, person1.getAge());
    }
    
    /**
     * Test changeAge
     * 2- Femenino y mayor de edad y nueva edad mayor que el mínimo (20)
     */
    public void testChangeAgeFemaleOverMinAge(){
        Person person1 = new Person ("Ana", "Álvarez", 40, Person.GENDER_FEMALE);
        person1.changeAge();
        assertEquals(37, person1.getAge());
    }
    
    /**
     * Test changeAge
     * 3- Masculino y nueva edad igual que el máximo (100)
     */
    public void testChangeAgeMaleEqualsMaxAge(){
        Person person1 = new Person ("Pepe", "Álvarez", 93, Person.GENDER_MALE);
        person1.changeAge();
        assertEquals(100, person1.getAge());
    }
    
    /**
     * Test changeAge
     * 4- Femenino y mayor de edad y nueva edad igual que el mínimo (20)
     */
    public void testChangeAgeFemaleEqualsMinAge(){
        Person person1 = new Person ("Ana", "Álvarez", 93, Person.GENDER_FEMALE);
        person1.changeAge();
        assertEquals(20, person1.getAge());
    }
    
    /**
     * Test changeAge
     * 5- Masculino y nueva edad mayor que el máximo (100)
     */
    public void testChangeAgMalealeOverMaxAge(){
        Person person1 = new Person ("Pepe", "Álvarez", 95, Person.GENDER_FEMALE);
        person1.changeAge();
        assertEquals(95, person1.getAge());
    }
    
    /**
     * Test changeAge
     * 6- Femenino y nueva edad menor que el mínimo
     */
    public void testChangeAgeFemaleLessMaxAge(){
        Person person1 = new Person ("Ana", "Álvarez", 22, Person.GENDER_FEMALE);
        person1.changeAge();
        assertEquals(22, person1.getAge());
    }
    
    /**
     * Test changeAge
     * 7- Femenino y edad menor de 18
     */
    public void testChangeAgeFemaleLessAdulthood_Age(){
        Person person1 = new Person ("Ana", "Álvarez", 17, Person.GENDER_FEMALE);
        person1.changeAge();
        assertEquals(17, person1.getAge());
    }
}