import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase Test para la Clase Heater
 *
 * @author  Omar Teixeira González
 * @version 23-10-20
 */
public class HeaterTest
{
    /**
     * Default constructor for test class HeaterTest
     */
    public HeaterTest()
    {
    }
    
    /*
     * Pruebas del método changeTemperature para la clase Heater:
     * Positivos:
     * 1- Valor igual a 10 grados -> Cambiar el valor
     * 2- Valor entre 10 y 27 grados -> Cambiar el valor
     * 3- Valor igual a 27 grados -> Cambiar el valor
     * 
     * Negativos:
     * 4- Valor inferior a 10 grados -> No cambiar el valor
     * 5- Valor superior a 27 grados -> No cambiar el valor
     */
    
    /**
     * 1-Valor igual a 10 grados -> Cambiar el valor
     */
    @Test       //test del primer escenario
    public void testChangeTemperatureEqualMinTemp(){
        Heater heater1 = new Heater(10.0);
        assertEquals(10.0, heater1.getTemperature(),0.1);
    }
    
    /**
     * 2- Valor entre 10 y 27 grados -> Cambiar el valor
     */
    @Test       //test del segundo escenario
    public void testChangeTemperatureBetweenMinTempMaxTemp(){
        Heater heater1 = new Heater(15.0);
        assertEquals(15.0, heater1.getTemperature(),0.1);
    }
    
    /**
     * 3- Valor igual a 27 grados -> Cambiar el valor
     */
    @Test       //test del tercer escenario
    public void testChangeTemperatureEqualMaxTemp(){
        Heater heater1 = new Heater(27.0);
        assertEquals(27.0, heater1.getTemperature(),0.1);
    }
    
    /**
     * 4- Valor inferior a 10 grados -> No cambiar el valor
     */
    @Test       //test del cuarto escenario
    public void testChangeTemperatureBelowMinTemp(){
        Heater heater1 = new Heater(5.0);
        assertEquals(27.0, heater1.getTemperature(),0.1);
    }
    
    /**
     * 5- Valor superior a 27 grados -> No cambiar el valor
     */
    @Test       //test del quinto escenario
    public void testChangeTemperatureOverMaxTemp(){
        Heater heater1 = new Heater(30.0);
        assertEquals(27.0, heater1.getTemperature(),0.1);
    }
    
    /*
     * Prueba método toString de la clase Heater:
     */
    
    /**
     * Unico escenario para la prueba del método toString de la clase Heater
     */
    @Test       //test del único escenario
    public void testToString()
    {
        Heater heater1 = new Heater();
        assertEquals(heater1.getTemperature()+" ºC", heater1.toString());
    }
}


