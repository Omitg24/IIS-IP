import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase Test para la Clase ControlPanel
 *
 * @author  Omar Teixeira González
 * @version 23-10-20
 */
public class ControlPanelTest
{
    /**
     * Default constructor for test class ControlPanelTest
     */
    public ControlPanelTest()
    {
    }
    
    /**
     * Prueba del constructor sin parámetros
     */
    @Test
    public void testConstructorWithoutParams(){
        Switch switch1 = new Switch();
        Lamp lamp1 = new Lamp();
        Potentiometer potentio1 = new Potentiometer();
        Heater heater1 = new Heater();
        ControlPanel controlP1 = new ControlPanel(switch1, lamp1, potentio1, heater1);
        assertNotNull(controlP1.getSwitch());
        assertNotNull(controlP1.getLamp());
        assertNotNull(controlP1.getPotentiometer());
        assertNotNull(controlP1.getHeater());
        assertEquals(switch1, controlP1.getSwitch());
        assertEquals(lamp1, controlP1.getLamp());
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /*
     *Pruebas para el constructor con parámetros:
     * 1- Valor del Switch y la Lampara es null
     * 2- Valor del Switch y la Lampara no es null
     */
    
    /**
     * 1- Valor del Switch y la Lampara es null
     */
    @Test
    public void testConstructorWithParamsOff()
    {
        Switch switch1 = new Switch();
        Lamp lamp1 = new Lamp();
        ControlPanel controlP1 = new ControlPanel(switch1, lamp1);
        assertEquals(switch1, controlP1.getSwitch());
        assertEquals(lamp1, controlP1.getLamp());
    }
    
    /**
     * 2- Valor del Switch y la Lampara no es null
     */
    @Test
    public void testConstructorWithParamsOn()
    {
        Switch switch1 = new Switch();
        Lamp lamp1 = new Lamp();
        ControlPanel controlP1 = new ControlPanel(switch1, lamp1);
        assertNotNull(controlP1.getSwitch());
        assertNotNull(controlP1.getLamp());
    }
    
    /*
     * Pruebas para el constructor con parámetros Potentiometer y Heater:
     * Positivo:
     * 1- Igual a los valores límites inferiores -> Cambiar los valores
     * 2- Igual a los valores límites superiores -> Cambiar los valores
     * 3- Entre los valores límites -> Cambiar los valores
     * 
     * Negativos:
     * 4- Inferiores a los valores límites -> No cambiar los valores
     * 5- Superiores a los valores límites -> No cambiar los valores
     */
    
    /**
     * 1- Igual a los valores límites inferiores -> Cambiar los valores
     */
    @Test
    public void testConstructorWithParamsInLowerLimits()
    {
        Potentiometer potentio1 = new Potentiometer(0);
        Heater heater1 = new Heater(10.0);
        ControlPanel controlP1 = new ControlPanel(potentio1, heater1);
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /**
     * 2- Igual a los valores límites superiores -> Cambiar los valores
     */
    @Test
    public void testConstructorWithParamsInUpperLimits()
    {
        Potentiometer potentio1 = new Potentiometer(10);
        Heater heater1 = new Heater(27.0);
        ControlPanel controlP1 = new ControlPanel(potentio1, heater1);
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /**
     * 3- Entre los valores límites -> Cambiar los valores
     */
    @Test
    public void testConstructorWithParamsInsideLimits()
    {
        Potentiometer potentio1 = new Potentiometer(5);
        Heater heater1 = new Heater(15.0);
        ControlPanel controlP1 = new ControlPanel(potentio1, heater1);
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /**
     * 4- Inferiores a los valores límites -> No cambiar los valores
     */
    @Test
    public void testConstructorWithParamsUnderLimits()
    {
        Potentiometer potentio1 = new Potentiometer(-5);
        Heater heater1 = new Heater(5.0);
        ControlPanel controlP1 = new ControlPanel(potentio1, heater1);
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /**
     * 5- Superiores a los valores límites -> No cambiar los valores
     */
    @Test
    public void testConstructorWithParamsOverLimits()
    {
        Potentiometer potentio1 = new Potentiometer(15);
        Heater heater1 = new Heater(30.0);
        ControlPanel controlP1 = new ControlPanel(potentio1, heater1);
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /*
     *Pruebas para el constructor con parámetros Switch, Lamp, Potentiometer y Heater:
     * 1- Valor de los objetos false, 5 y 15.0
     * 2- Valor de los objetos true, 10 y 27.0
     */
    /**
     * 1- Valor de los objetos false, 5 y 15.0
     */
    @Test
    public void testConstructorWithParams1()
    {
        Switch switch1 = new Switch(false);
        Lamp lamp1 = new Lamp(false);
        Potentiometer potentio1 = new Potentiometer (5);
        Heater heater1 = new Heater (15.0);
        ControlPanel controlP1 = new ControlPanel(switch1, lamp1, potentio1, heater1);
        assertEquals(switch1, controlP1.getSwitch());
        assertEquals(lamp1, controlP1.getLamp());
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /**
     * 2- Valor de los objetos true, 10 y 27.0
     */
    @Test
    public void testConstructorWithParams2()
    {
        Switch switch1 = new Switch(true);
        Lamp lamp1 = new Lamp(true);
        Potentiometer potentio1 = new Potentiometer (10);
        Heater heater1 = new Heater (27.0);
        ControlPanel controlP1 = new ControlPanel(switch1, lamp1, potentio1, heater1);
        assertEquals(switch1, controlP1.getSwitch());
        assertEquals(lamp1, controlP1.getLamp());
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /*
     * Pruebas del método press de la clase ControlPanel:
     * 1- El valor del switch y de la lampara es, respectivamente, ON y ENCENDIDA -> Cambiar a OFF y APAGADA
     * 2- El valor del switch y de la lampara es, respectivamente, OFF y APAGADA -> Cambiar a ON y ENCENDIDA
     */
    
    /**
     * 1- El valor del switch y de la lampara es, respectivamente, ON y ENCENDIDA -> Cambiar a OFF y APAGADA
     */
    @Test
    public void testPressOn()
    {
        Switch switch1 = new Switch(false);
        Lamp lamp1 = new Lamp(false);
        ControlPanel controlP1 = new ControlPanel(switch1, lamp1);
        controlP1.press();
        assertEquals(switch1, controlP1.getSwitch());
        assertEquals(lamp1, controlP1.getLamp());
    }
    
    /**
     * 2- El valor del switch y de la lampara es, respectivamente, OFF y APAGADA -> Cambiar a ON y ENCENDIDA
     */
    @Test
    public void testPressOff()
    {
        Switch switch1 = new Switch(true);
        Lamp lamp1 = new Lamp(true);
        ControlPanel controlP1 = new ControlPanel(switch1, lamp1);
        controlP1.press();
        assertEquals(switch1, controlP1.getSwitch());
        assertEquals(lamp1, controlP1.getLamp());
    }
    
    /*
     * Pruebas del método movePosition de la clase ControlPanel:
     * 1- Cuando el valor de la posición es 0 -> Temperatura del radiador es 10.0
     * 2- Cuando el valor de la posición esta entre 0 y 10 -> Calcular temperatura del radiador
     * 3- Cuando el valor de la posición es 10 -> Temperatura del radiador es 27.0 
     */
    
    /**
     * 1- Cuando el valor de la posición es 0 -> Temperatura del radiador es 10.0
     */
    @Test
    public void testMovePosition0()
    {
        Potentiometer potentio1 = new Potentiometer();
        Heater heater1 = new Heater();
        ControlPanel controlP1 = new ControlPanel(potentio1, heater1);
        controlP1.movePotentiometer(0);
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /**
     * 2- Cuando el valor de la posición esta entre 0 y 10 -> Calcular temperatura del radiador
     */
    @Test
    public void testMovePosition5()
    {
        Potentiometer potentio1 = new Potentiometer();
        Heater heater1 = new Heater();
        ControlPanel controlP1 = new ControlPanel(potentio1, heater1);
        controlP1.movePotentiometer(5);
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
    
    /**
     * 3- Cuando el valor de la posición es 10 -> Temperatura del radiador es 27.0 
     */
    @Test
    public void testMovePosition10()
    {
        Potentiometer potentio1 = new Potentiometer();
        Heater heater1 = new Heater();
        ControlPanel controlP1 = new ControlPanel(potentio1, heater1);
        controlP1.movePotentiometer(10);
        assertEquals(potentio1, controlP1.getPotentiometer());
        assertEquals(heater1, controlP1.getHeater());
    }
}


