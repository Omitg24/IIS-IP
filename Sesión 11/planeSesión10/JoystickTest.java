import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JoystickTest.
 *
 * @author  Omar Teixeira González
 * @version 12-11-20
 */
public class JoystickTest
{
    /**
     * Default constructor for test class JoystickTest
     */
    public JoystickTest()
    {
    }
    
    /*
     * Pruebas para el método move de la clase Joystick:
     * Positivos:
     * 1- El valor de position está en el limite inferior -> Cambiar la posición del Joystick y como consecuencia el ángulo de los dos alerones, con signo opuesto
     * 2- El valor de position está en el limite superior -> Cambiar la posición del Joystick y como consecuencia el ángulo de los dos alerones, con signo opuesto
     * 3- El valor de position está entre los límites -> Cambiar la posición del Joystick y como consecuencia el ángulo de los dos alerones, con signo opuesto
     * 4- El valor de position es igual a 0 -> Cambia la posición del Joystick y como consecuencia el ángulo de los dos alerones, ambos a 0
     * 
     * Negativos:
     * 5- El valor de position es menor al límite inferior -> No se cambia el valor de position, así como tampoco se cambia el valor de los dos alerones
     * 6- El valor de position es mayor al límite superior -> No se cambia el valor de position, así como tampoco se cambia el valor de los dos alerones
     */
    
    
    /**
     * 1- El valor de position está en el limite inferior -> Cambiar la posición del Joystick y como consecuencia el ángulo de los dos alerones, con signo opuesto
     */
    @Test
    public void testMoveInMinLimit()
    {
        Joystick joystick1 = new Joystick();
        assertNotNull(joystick1);       
        assertEquals(0.0, joystick1.getPosition(), 0.1);
        assertEquals(0.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(0.0, joystick1.getRight().getAngle(), 0.1);
        joystick1.move(-35.0);
        assertEquals(-35.0, joystick1.getPosition(), 0.1);
        assertEquals(65.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(-65.0, joystick1.getRight().getAngle(), 0.1);
    }
    
    /**
     * 2- El valor de position está en el limite superior -> Cambiar la posición del Joystick y como consecuencia el ángulo de los dos alerones, con signo opuesto
     */
    @Test
    public void testMoveInMaxLimit()
    {
        Joystick joystick1 = new Joystick();
        assertNotNull(joystick1);       
        assertEquals(0.0, joystick1.getPosition(), 0.1);
        assertEquals(0.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(0.0, joystick1.getRight().getAngle(), 0.1);
        joystick1.move(35.0);
        assertEquals(35.0, joystick1.getPosition(), 0.1);
        assertEquals(-65.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(65.0, joystick1.getRight().getAngle(), 0.1);
    }

    /**
     * 3- El valor de position está entre los límites -> Cambiar la posición del Joystick y como consecuencia el ángulo de los dos alerones, con signo opuesto
     */
    @Test
    public void testMoveInsideLimits()
    {
        Joystick joystick1 = new Joystick();
        assertNotNull(joystick1);       
        assertEquals(0.0, joystick1.getPosition(), 0.1);
        assertEquals(0.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(0.0, joystick1.getRight().getAngle(), 0.1);
        joystick1.move(20.0);
        assertEquals(20.0, joystick1.getPosition(), 0.1);
        assertEquals(-37.1428, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(37.1428, joystick1.getRight().getAngle(), 0.1);
    }
    
    /**
     * 4- El valor de position es igual a 0 -> Cambia la posición del Joystick y como consecuencia el ángulo de los dos alerones
     */
    @Test
    public void testMoveIn0()
    {
        Joystick joystick1 = new Joystick();
        assertNotNull(joystick1);       
        assertEquals(0.0, joystick1.getPosition(), 0.1);
        assertEquals(0.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(0.0, joystick1.getRight().getAngle(), 0.1);
        joystick1.move(0.0);
        assertEquals(0.0, joystick1.getPosition(), 0.1);
        assertEquals(0.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(0.0, joystick1.getRight().getAngle(), 0.1);
    }
    
    /**
     * 5- El valor de position es menor al límite inferior -> No se cambia el valor de position, así como tampoco se cambia el valor de los dos alerones
     */
    @Test
    public void testMoveUnderMinLimit()
    {
        Joystick joystick1 = new Joystick();
        assertNotNull(joystick1);       
        assertEquals(0.0, joystick1.getPosition(), 0.1);
        assertEquals(0.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(0.0, joystick1.getRight().getAngle(), 0.1);
        joystick1.move(-40.0);
        assertEquals(0.0, joystick1.getPosition(), 0.1);
        assertEquals(0.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(0.0, joystick1.getRight().getAngle(), 0.1);
    }
    
    /**
     * 6- El valor de position es mayor al límite superior -> No se cambia el valor de position, así como tampoco se cambia el valor de los dos alerones
     */
    @Test
    public void testMoveOverMaxLimit()
    {
        Joystick joystick1 = new Joystick();
        assertNotNull(joystick1);       
        assertEquals(0.0, joystick1.getPosition(), 0.1);
        assertEquals(0.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(0.0, joystick1.getRight().getAngle(), 0.1);
        joystick1.move(40.0);
        assertEquals(0.0, joystick1.getPosition(), 0.1);
        assertEquals(0.0, joystick1.getLeft().getAngle(), 0.1);
        assertEquals(0.0, joystick1.getRight().getAngle(), 0.1);
    }
}


