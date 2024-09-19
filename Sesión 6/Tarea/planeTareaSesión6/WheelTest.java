import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase test para la clase Wheel
 *
 * @author  Omar Teixeira González
 * @version 21-10-2020
 */
public class WheelTest
{
    /**
     * Prueba para el constructor sin parámetros -> Dejará los valores estándar
     * 
     */
    @Test       //test del constructor sin parámetros
    public void testConstructorWithoutParams(){
      Wheel wheel1 = new Wheel();      
      assertNotNull(wheel1);
      assertEquals(Wheel.DEFAULT_MAX_PRESSURE, wheel1.getMaxPressure(),0.1);
      assertEquals(Wheel.DEFAULT_PRESSURE, wheel1.getPressure(),0.1);
    }
    
    /**
     * Prueba para el constructor con parámetros -> Cambiará los valores
     * 
     */
    @Test       //test del constructor con parámetros
    public void testConstructorWithParams()
    {
        Wheel wheel1 = new Wheel(1500, 1100);
        assertNotNull(wheel1);
        assertEquals(1500.0, wheel1.getMaxPressure(), 0.1);
        assertEquals(1100.0, wheel1.getPressure(), 0.1);
    }
    /*
     * Escenarios de prueba para el método toString
     * 1- Rueda con test true
     * 2- Rueda con test false
     */
    /**
     * 1- Rueda con test true
     */
    @Test       //test del primer escenario
    public void testWheelTrue()
    {
        Wheel wheel1 = new Wheel(1000, 950);
        assertEquals("MaxP: 1000,0 Mb - Pressure: 950,0 Mb - Percentage: 95,00 - Test: true", wheel1.toString());
    }
    
    /**
     * 2- Rueda con test false
     */
    @Test       //test del segundo escenario
    public void testWheelFalse()
    {
        Wheel wheel1 = new Wheel(1000, 500);
        assertEquals("MaxP: 1000,0 Mb - Pressure: 500,0 Mb - Percentage: 50,00 - Test: false", wheel1.toString());
    }
}





