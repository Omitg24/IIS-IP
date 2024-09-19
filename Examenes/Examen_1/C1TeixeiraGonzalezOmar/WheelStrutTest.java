import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WheelStrutTest.
 *
 * @author  Omar Teixeira González
 * @version 28-10-20
 */
public class WheelStrutTest
{
    /**
     * Pruebas de constructor sin parámetros
     * Agina los siguientes datos
     * Puntal desplegado
     * Ruedas izquiderda y derecha con la presión máxima y actual del Boeing 7373
     */
    @Test 
    public void testConstructorWithoutParams(){
        WheelStrut wheelStrut1 = new WheelStrut();
        assertNotNull(wheelStrut1);
        assertNotNull(wheelStrut1.getLeftWheel());
        assertNotNull(wheelStrut1.getRightWheel());
        assertEquals(WheelStrut.IS_DEPLOYED, wheelStrut1.isDeployed());
        assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getLeftWheel().getPressure(),0.1);
        assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getLeftWheel().getMaxPressure(),0.1);
        assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getRightWheel().getPressure(),0.1);
        assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getRightWheel().getMaxPressure(),0.1);        
    }
    
    /*
     * Pruebas para el método Test de la clase WheelStrut:
     * 1- Las dos ruedas operativas -> Truea
     * 2- Las dos ruedas inoperativas -> False
     * 3- Una de ellas operativas -> False
     */
    
    /**
     * 1- Las dos ruedas operativas -> TrueassertNotNull(wheelStrut1.getLeftWheel());
     */
    @Test
    public void testTestBothWheelOk(){
        Wheel leftWheelOk = new Wheel(1000,900);
        Wheel rightWheelOk = new Wheel(1000,900);   
        WheelStrut wheelStrut1 = new WheelStrut(WheelStrut.IS_DEPLOYED, leftWheelOk, rightWheelOk);
        //assertEquals(true, wheelStrut1.test());
        assertTrue(wheelStrut1.test());
    }
    
    /**
     * 1- Las dos ruedas operativas -> TrueassertNotNull(wheelStrut1.getLeftWheel());
     */
    @Test
    public void testTestBothWheelNotOk(){
        Wheel leftWheelNotOk = new Wheel(1000,500);
        Wheel rightWheelNotOk = new Wheel(1000,500);        
        WheelStrut wheelStrut1 = new WheelStrut(WheelStrut.IS_DEPLOYED, leftWheelNotOk, rightWheelNotOk);
        //assertEquals(true, wheelStrut1.test());
        assertFalse(wheelStrut1.test());
    }
    
    /**
     * 1- Las dos ruedas operativas -> TrueassertNotNull(wheelStrut1.getLeftWheel());
     */
    @Test
    public void testTestOneWheelOk(){
        Wheel leftWheelOk = new Wheel(1000,900);
        Wheel rightWheelNotOk = new Wheel(1000,500);        
        WheelStrut wheelStrut1 = new WheelStrut(WheelStrut.IS_DEPLOYED, leftWheelOk, rightWheelNotOk);
        //assertEquals(true, wheelStrut1.test());
        assertFalse(wheelStrut1.test());
    }
    
    /*
     * Pruebas para el método Print de la clase WheelStrut:
     * 1- Puntal desplegado y test true
     * 2- Puntal replegado y test false
     */
    
    /**
     * 1- Puntal desplegado y test true
     */
    @Test
    public void testPrint1() {
        Wheel leftWheelOk = new Wheel(1000,900);
        Wheel rightWheelOk = new Wheel(1000,900);        
        WheelStrut wheelStrut1 = new WheelStrut(WheelStrut.IS_DEPLOYED, leftWheelOk, rightWheelOk);
        wheelStrut1.print();
    }
    
    /**
     * 1- Puntal replegado y test false
     */
    @Test
    public void testPrint2() {
        Wheel leftWheelNotOk = new Wheel(1000,500);
        Wheel rightWheelNotOk = new Wheel(1000,500);        
        WheelStrut wheelStrut1 = new WheelStrut(!WheelStrut.IS_DEPLOYED, leftWheelNotOk, rightWheelNotOk);
        wheelStrut1.print();
    }
    
    /*
     * Pruebas del método Deploy de la clase WheelStrut:
     * 1- Está replegado -> Lo despliega
     * 2- Está desplegado -> Lo deja como está
     */
    
    /**
     * 1- Está replegado -> Lo despliega
     */
    @Test
    public void testDeployFalse()
    {
        WheelStrut wheelStr1 = new WheelStrut(false);
        assertEquals(false, wheelStr1.isDeployed());
        wheelStr1.deploy();
        assertEquals(wheelStr1.IS_DEPLOYED, wheelStr1.isDeployed());
    }
    
    /**
     * 2- Está desplegado -> Lo deja como está
     */
    @Test
    public void testDeployTrue()
    {
        WheelStrut wheelStr1 = new WheelStrut(true);
        assertEquals(true, wheelStr1.isDeployed());
        wheelStr1.deploy();
        assertEquals(wheelStr1.IS_DEPLOYED, wheelStr1.isDeployed());
    }

    /*
     * Pruebas del método Deploy de la clase WheelStrut:
     * 1- Está replegado -> Lo deja como está
     * 2- Está desplegado -> Lo despliega
     */
    
    /**
     * 1- Está replegado -> Lo deja como está
     */
    @Test
    public void testRetractFalse()
    {
        WheelStrut wheelStr1 = new WheelStrut(false);
        assertEquals(false, wheelStr1.isDeployed());
        wheelStr1.retract();
        assertEquals(!wheelStr1.IS_DEPLOYED, wheelStr1.isDeployed());
    }
    
    /**
     * 2- Está desplegado -> Lo despliega
     */
    @Test
    public void testRetractTrue()
    {
        WheelStrut wheelStr1 = new WheelStrut(true);
        assertEquals(true, wheelStr1.isDeployed());
        wheelStr1.retract();
        assertEquals(!wheelStr1.IS_DEPLOYED, wheelStr1.isDeployed());
    }
    
}

