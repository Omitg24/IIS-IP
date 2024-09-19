import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase Test para la Clase Switch
 *
 * @author  Omar Teixeira González
 * @version 23-10-20
 */
public class SwitchTest
{
    /**
     * Default constructor for test class LampTest
     */
    public SwitchTest()
    {
    }
    
    /*
     * Pruebas del método press de la clase Lamp:
     * 1- Si el Switch está On (true) -> Cambiar a false
     * 2- Si el Switch está Off (false) -> Cambiar a true
     */
    
    /**
     * 1- Si el Switch está On (true) -> Cambiar a false
     */
    @Test       //test del primer escenario
    public void testSwitchPressFalse()
    {
        Switch switch1 = new Switch(true);
        switch1.press();
        assertEquals(false, switch1.getState());
    }
    
    /**
     * 2- Si el Switch está Off (false) -> Cambiar a true
     */
    @Test       //test del segundo escenario
    public void testSwitchPressTrue()
    {
        Switch switch1 = new Switch(false);
        switch1.press();
        assertEquals(true, switch1.getState());
    }
    
    /*
     * Pruebas para el método toString:
     * 1- Si el Switch está Off (false) -> Mostrar "ON"
     * 2- Si el Switch está On (true) -> Mostrar "OFF"
     */
    
    /*
     * 1- Si el Switch está Off (false) -> Mostrar "ON"
     */
    @Test       //test del primer escenario
    public void testSwitchToStringOn(){
        Switch switch1 = new Switch(false);
        switch1.press();
        assertEquals("ON", switch1.toString());    
    }
    
    /*
     * 2- Si el Switch está On (true) -> Mostrar "OFF"
     */
    @Test       //test del segundo escenario
    public void testSwitchToStringOff(){
        Switch switch1 = new Switch(true);
        switch1.press();
        assertEquals("OFF", switch1.toString());    
    }
}

