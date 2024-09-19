import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase Test para la Clase Lamp
 *
 * @author  Omar Teixeira González
 * @version 23-10-20
 */
public class LampTest
{
    /**
     * Default constructor for test class LampTest
     */
    public LampTest()
    {
    }
    
    /*
     * Prueba del método Turn On de la clase Lamp
     */
    
    /**
     * 
     */@Test        //test del único escenario
    public void testLampTurnOn()
    {
        Lamp lamp1 = new Lamp();
        lamp1.turnOn();
        assertEquals(true, lamp1.getState());
    }
    
    /*
     * Prueba del método Turn Off de la clase Lamp
     */
    
    /**
     * 
     */@Test        //test del único escenario
    public void testLampTurnOff()
    {
        Lamp lamp1 = new Lamp();
        lamp1.turnOff();
        assertEquals(false, lamp1.getState());
    }
    
    /*
     * Pruebas del método toString de la clase Lamp:
     * 1- Si utilizamos el método Turn On -> "ENCENDIDA"
     * 2- Si utilizamos el método Turn Off -> "APAGADA"
     */
    
    /**
     * 1- Si utilizamos el método Turn On -> "ENCENDIDA"
     */@Test        //test del primer escenario
    public void testLampOnToString()
    {
        Lamp lamp1 = new Lamp();
        lamp1.turnOn();
        assertEquals(true, lamp1.getState());
        assertEquals("ENCENDIDA", lamp1.toString());
    }
    
    /**
     * 2- Si utilizamos el método Turn Off -> "APAGADA"
     */@Test        //test del segundo escenario
    public void testLampOffToString()
    {
        Lamp lamp1 = new Lamp();
        lamp1.turnOff();
        assertEquals(false, lamp1.getState());
        assertEquals("APAGADA", lamp1.toString());
    }
}

