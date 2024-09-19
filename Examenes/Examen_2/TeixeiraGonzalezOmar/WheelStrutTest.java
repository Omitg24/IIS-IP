import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba de la clase WheelStrut
 *
 * @author  Omar Teixeira González
 * @version 14-12-20
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
        assertEquals(WheelStrut.IS_DEPLOYED, wheelStrut1.isDeployed());
        for( int i=0; i<wheelStrut1.size(); i++){
            assertNotNull(wheelStrut1.getWheel(i));
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getPressure(),0.1);
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getMaxPressure(),0.1);
        }
    }
    
    /*
     * Pruebas del constructor con un parámetro, numero de ruedas:
     * Positivos:
     * 1- Número de ruedas > 0
     * Negativos:
     * 2- Numero de ruedas 0
     * 3- Numero de ruedas <0
     */
    
    /**
     * 1- Número de ruedas > 0
     */
    @Test
    public void testConstructorWithWheelsPositive(){
        WheelStrut wheelStrut1 = new WheelStrut(10);
        assertNotNull(wheelStrut1);
        assertEquals(WheelStrut.IS_DEPLOYED, wheelStrut1.isDeployed());
        for( int i=0; i<wheelStrut1.size(); i++){
            assertNotNull(wheelStrut1.getWheel(i));
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getPressure(),0.1);
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getMaxPressure(),0.1);
        }
    }
    
    /**
     * 2- Numero de ruedas 0
     */
    @Test
    public void testConstructorWithWheels0(){
        try{
            WheelStrut wheelStrut1 = new WheelStrut(0);
            assertNotNull(wheelStrut1);
            assertEquals(WheelStrut.IS_DEPLOYED, wheelStrut1.isDeployed());
            for( int i=0; i<wheelStrut1.size(); i++){
                assertNotNull(wheelStrut1.getWheel(i));
                assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getPressure(),0.1);
                assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getMaxPressure(),0.1);
            }
        }catch (RuntimeException rte){
            assertEquals("El número de ruedas debe ser mayor que 0", rte.getMessage());
        }        
    }
    
    /**
     * 3- Numero de ruedas <0
     */
    @Test
    public void testConstructorWithWheels(){
        WheelStrut wheelStrut1 = new WheelStrut(10);
        assertNotNull(wheelStrut1);
        assertEquals(WheelStrut.IS_DEPLOYED, wheelStrut1.isDeployed());
        for( int i=0; i<wheelStrut1.size(); i++){
            assertNotNull(wheelStrut1.getWheel(i));
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getPressure(),0.1);
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getMaxPressure(),0.1);
        }
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
        WheelStrut  wheelStrut1 = new WheelStrut(4);
        for (int i = 0; i<wheelStrut1.size();i++){
            wheelStrut1.getWheel(i).changePressure(1478);
        }
        assertFalse(wheelStrut1.test());        
    }
    
    /**
     * 2- Las dos ruedas inoperativas -> False
     */
    @Test
    public void testTestBothWheelNotOk(){
        WheelStrut wheelStrut1 =  new WheelStrut(2);
        for (int i=0; i<wheelStrut1.size();i++){
            wheelStrut1.getWheel(i).changePressure(1000);            
        }
        assertFalse(wheelStrut1.test());        
    }
    
    /**
     * 3- Una de ellas operativas -> False
     */
    @Test
    public void testTestOneWheelOk(){
        try{
            WheelStrut wheelStrut1 = new WheelStrut(2);
            for (int i=0; i<wheelStrut1.size();i++){
                wheelStrut1.getWheel(i).changePressure(3000);
            }
            assertTrue(wheelStrut1.test());
        }catch (RuntimeException rte){
            assertEquals("Valor fuera de rango", rte.getMessage());
        }
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
        WheelStrut wheelStrut1 = new WheelStrut(4);
        assertNotNull(wheelStrut1);
        assertEquals(WheelStrut.IS_DEPLOYED, wheelStrut1.isDeployed());
        for( int i=0; i<wheelStrut1.size(); i++){
            assertNotNull(wheelStrut1.getWheel(i));
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getPressure(),0.1);
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getMaxPressure(),0.1);
        }
        wheelStrut1.print();
    }
    
    /**
     * 1- Puntal replegado y test false
     */
    @Test
    public void testPrint2() {
        WheelStrut wheelStrut1 = new WheelStrut(4);
        wheelStrut1.retract();
        assertNotNull(wheelStrut1);
        assertEquals(!WheelStrut.IS_DEPLOYED, wheelStrut1.isDeployed());
        for( int i=0; i<wheelStrut1.size(); i++){
            assertNotNull(wheelStrut1.getWheel(i));
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getPressure(),0.1);
            assertEquals(WheelStrut.BOEING_737_PRESSURE, wheelStrut1.getWheel(i).getMaxPressure(),0.1);
        }
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

