import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase Test para la Clase Potentiometer
 *
 * @author  Omar Teixeira González
 * @version 23-10-20
 */
public class PotentiometerTest
{
    /**
     * Default constructor for test class PotentiometerTest
     */
    public PotentiometerTest()
    {
    }

    /*
     * Pruebas del método changeTemperature para la clase Potentiometer:
     * Positivos:
     * 1- Valor igual a 0 grados -> Cambiar el valor
     * 2- Valor entre 0 y 10 grados -> Cambiar el valor
     * 3- Valor igual a 10 grados -> Cambiar el valor
     * 
     * Negativos:
     * 4- Valor inferior a 0 grados -> No cambiar el valor
     * 5- Valor superior a 10 grados -> No cambiar el valor
     */
    
    /**
     * 2- Valor entre 0 y 10 grados -> Cambiar el valor
     */
    @Test       //test del primer escenario
    public void testChangeTemperatureEqualMinPos(){
        Potentiometer potentio1 = new Potentiometer(0);
        assertEquals(0, potentio1.getPosition());
    }
    
    /**
     * 1-Valor igual a 10 grados -> Cambiar el valor
     */
    @Test       //test del segundo escenario
    public void testChangeTemperatureEqualMaxPos(){
        Potentiometer potentio1 = new Potentiometer(10);
        assertEquals(10, potentio1.getPosition());
    }
    
    /**
     * 3- Valor igual a 10 grados -> Cambiar el valor
     */
    @Test       //test del tercer escenario
    public void testChangeTemperatureBetweenMinPosMaxPos(){
        Potentiometer potentio1 = new Potentiometer(5);
        assertEquals(5, potentio1.getPosition());
    }
    
    /**
     * 4- Valor inferior a 0 grados -> No cambiar el valor
     */
    @Test       //test del cuarto escenario
    public void testChangeTemperatureUnderMinPos(){
        Potentiometer potentio1 = new Potentiometer(-5);
        assertEquals(10, potentio1.getPosition());
    }
    
    /**
     * 5- Valor superior a 10 grados -> No cambiar el valor
     */
    @Test       //test del quinto escenario
    public void testChangeTemperatureOverMaxPos(){
        Potentiometer potentio1 = new Potentiometer(15);
        assertEquals(10, potentio1.getPosition());
    }
    
    /*
     * Prueba método toString de la clase Heater:
     */
    
    /**
     * Unico escenario para la prueba del método toString de la clase Potentiometer
     */
    @Test       //test del único escenario
    public void testToString()
    {
        Potentiometer potentio1 = new Potentiometer();
        assertEquals(potentio1.getPosition()+"", potentio1.toString());
    }
}
