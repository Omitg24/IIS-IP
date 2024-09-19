import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba de la clase Aileron
 *
 * @author  Omar Teixeira
 * @version 14-12-20
 */
public class AileronTest
{
    /**
     * Default constructor for test class AileronTest
     */
    public AileronTest()
    {
    }
    
    /**
     * Pruebas para el constructor sin par�metros de la clase Aileron
     */    
    @Test
    public void testConstructorWithoutParams()
    {
        Aileron aileron1 = new Aileron();
        assertNotNull(aileron1);
        assertEquals(0.0, aileron1.getAngle(), 0.1);
    }
    
    /*
     * Pruebas para el m�todo roll de la clase Aileron:
     * Positivos:
     * 1- Par�metro en el l�mite inferior -> Se cambia el valor
     * 2- Par�metro en el l�mite superior -> Se cambia el valor
     * 3- Par�metro entre el l�mite inferior y el superior -> Se cambia el valor
     * 
     * Negativos:
     * 4- Par�metro por debajo del l�mite inferior -> No se cambia el valor
     * 5- Par�metro por encima del l�mite superior -> No se cambia el valor
     */
    
    /**
     * 1- Par�metro en el l�mite inferior -> Se cambia el valor
     */
    @Test
    public void testRollInMinLimit(){
        Aileron aileron1 = new Aileron();
        assertNotNull(aileron1);
        assertEquals(0.0, aileron1.getAngle(), 0.1);
        aileron1.roll(-65.0);
        assertEquals(-65.0, aileron1.getAngle(),0.1);
    }
    
    /**
     * 2- Par�metro en el l�mite superior -> Se cambia el valor
     */
    @Test
    public void testRollInMaxLimit(){
        Aileron aileron1 = new Aileron();
        assertNotNull(aileron1);
        assertEquals(0.0, aileron1.getAngle(), 0.1);
        aileron1.roll(65.0);
        assertEquals(65.0, aileron1.getAngle(),0.1);
    }
    
    /**
     * 3- Par�metro entre el l�mite inferior y el superior -> Se cambia el valor
     */
    @Test
    public void testRollInsideLimits(){
        Aileron aileron1 = new Aileron();
        assertNotNull(aileron1);
        assertEquals(0.0, aileron1.getAngle(), 0.1);
        aileron1.roll(32.0);
        assertEquals(32.0, aileron1.getAngle(),0.1);
    }
    
    /**
     * 4- Par�metro por debajo del l�mite inferior -> No se cambia el valor
     */
    @Test
    public void testRollUnderMinLimit(){
        Aileron aileron1 = new Aileron();
        assertNotNull(aileron1);
        assertEquals(0.0, aileron1.getAngle(), 0.1);
        aileron1.roll(-80.0);
        assertEquals(0.0, aileron1.getAngle(),0.1);
    }
    
    /**
     * 5- Par�metro por encima del l�mite superior -> No se cambia el valor
     */
    @Test
    public void testRollOverMaxLimit(){
        Aileron aileron1 = new Aileron();
        assertNotNull(aileron1);
        assertEquals(0.0, aileron1.getAngle(), 0.1);
        aileron1.roll(80);
        assertEquals(0.0, aileron1.getAngle(),0.1);
    }
}

