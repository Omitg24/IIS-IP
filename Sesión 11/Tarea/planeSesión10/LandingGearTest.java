import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LandingGearTest.
 *
 * @author  Omar Teixeira González
 * @version 4-10-20
 */
public class LandingGearTest
{
    /**
     * Default constructor for test class LandingGearTest
     */
    public LandingGearTest()
    {
    }
    
    /**
     * Prueba del constructor sin parámetros para la clase LandingGear
     */
    @Test
    public void testConstructorWithoutParams()
    {
        LandingGear landingGear1 = new LandingGear();
        assertNotNull(landingGear1.getLeft());
        assertNotNull(landingGear1.getNose());
        assertNotNull(landingGear1.getRight());        
        assertTrue(landingGear1.getNose().isDeployed());
        assertTrue(landingGear1.getNose().isDeployed());
        assertTrue(landingGear1.getNose().isDeployed());
        assertFalse(landingGear1.getLever());
    }
    
    // /*
     // * Pruebas para el constructor con parámetros para la clase LandingGear:
     // * 1- Todo es true
     // * 2- Todo es false
     // */
    
    // /**
     // * 1- Todo es true
     // */
    // @Test
    // public void testConstructorWithParamsTrue()
    // {
        // WheelStrut nose = new WheelStrut(true);
        // WheelStrut left = new WheelStrut(true);
        // WheelStrut right = new WheelStrut(true);
        // LandingGear landingG1 = new LandingGear(nose, left, right, true);
        // assertEquals(true, nose.isDeployed());
        // assertEquals(true, left.isDeployed());
        // assertEquals(true, right.isDeployed());
        // assertEquals(true, landingG1.getLever());
    // }
    
    // /**
     // * 2- Todo es false
     // */
    // @Test
    // public void testConstructorWithParamsFalse()
    // {
        // WheelStrut nose = new WheelStrut(false);
        // WheelStrut left = new WheelStrut(false);
        // WheelStrut right = new WheelStrut(false);
        // LandingGear landingG1 = new LandingGear(nose, left, right, false);
        // assertEquals(false, nose.isDeployed());
        // assertEquals(false, left.isDeployed());
        // assertEquals(false, right.isDeployed());
        // assertEquals(false, landingG1.getLever());
    // }

    /*
     * Pruebas de moveLever:
     * 1- Si está Up y llamo action = Up -> todo queda igual
     * 2- Si está Down y llamo action = Up -> Palanca pasa a Up y puntales quedan replegados
     * 3- Si está Up y action = Down -> Palaca pasa a down y puntales se despliegan
     * 4- Si está down y action = down -> No se modifica nada
     */
    
    /**
     * 1- Si está Up y llamo action = Up -> todo queda igual
     */
    @Test
    public void testMoveLeverUpWhenUp()
    {
        LandingGear landingGear1 =  new LandingGear();
        landingGear1.moveLever(LandingGear.LEVER_UP);
        landingGear1.moveLever(LandingGear.LEVER_UP);
        assertEquals(landingGear1.LEVER_UP, landingGear1.getLever());
        assertFalse(landingGear1.getNose().isDeployed());
        assertFalse(landingGear1.getLeft().isDeployed());
        assertFalse(landingGear1.getRight().isDeployed());        
    }
    
    /**
     * 2- Si está Down y llamo action = Up -> Palanca pasa a Up y puntales quedan replegados
     */
    @Test
    public void testMoveLeverUpWhenDown()
    {
        LandingGear landingGear1 =  new LandingGear();
        landingGear1.moveLever(LandingGear.LEVER_UP);
        assertEquals(landingGear1.LEVER_UP, landingGear1.getLever());
        assertFalse(landingGear1.getNose().isDeployed());
        assertFalse(landingGear1.getLeft().isDeployed());
        assertFalse(landingGear1.getRight().isDeployed());        
    }
    
    /**
     * 3- Si está Up y action = Down -> Palaca pasa a down y puntales se despliegan
     */
    @Test
    public void testMoveLeverDownWhenUp()
    {
        LandingGear landingGear1 =  new LandingGear();
        landingGear1.moveLever(LandingGear.LEVER_UP);
        assertEquals(landingGear1.LEVER_UP, landingGear1.getLever());
        assertFalse(landingGear1.getNose().isDeployed());
        assertFalse(landingGear1.getLeft().isDeployed());
        assertFalse(landingGear1.getRight().isDeployed());        
    }
    
    /**
     * 4- Si está down y action = down -> No se modifica nada
     */
    @Test
    public void testMoveLeverDownWhenDown()
    {
        LandingGear landingGear1 =  new LandingGear();
        landingGear1.moveLever(LandingGear.LEVER_DOWN);
        assertEquals(landingGear1.LEVER_DOWN, landingGear1.getLever());
        assertTrue(landingGear1.getNose().isDeployed());
        assertTrue(landingGear1.getLeft().isDeployed());
        assertTrue(landingGear1.getRight().isDeployed());        
    }
    
    /*
     * Pruebas para el método test de la clase LandingGear:
     * 1- Los test de los tres puntales son true -> Devuelve true
     * 2- 1 de los puntales tiene test false, el resto true -> Devuelve false
     * 3- 2 de los puntales tienen test false, el otro true -> Devuelve false
     * 4- Los test de los tres test son false -> Devuelve false
     */
    
    /**
     * 1- Los test de los tres puntales son true -> Devuelve true
     */
    @Test
    public void testTestAllTrue(){               
        LandingGear landingGear1  = new LandingGear();
        assertTrue(landingGear1.test());
    }
    
    /**
     * 2- 1 de los puntales tiene test false, el resto true -> Devuelve false
     */
    @Test
    public void testTestOneFalse(){
        LandingGear landingGear1 = new LandingGear();
        landingGear1.getNose().getWheel(0).changePressure(10);
        assertFalse(landingGear1.test());
    }
    
    /**
     * 3- 2 de los puntales tienen test false, el otro true -> Devuelve false
     */
    @Test
    public void testTestTwoFalse(){
        LandingGear landingGear1 = new LandingGear();
        landingGear1.getNose().getWheel(0).changePressure(10);
        landingGear1.getRight().getWheel(0).changePressure(10);
        assertFalse(landingGear1.test());
    }
    
    /**
     * 4- Los test de los tres test son false -> Devuelve false
     */
    @Test
    public void testTestAllFalse(){
        LandingGear landingGear1 = new LandingGear();
        landingGear1.getNose().getWheel(0).changePressure(10);
        landingGear1.getLeft().getWheel(0).changePressure(10);
        landingGear1.getRight().getWheel(0).changePressure(10);
        assertFalse(landingGear1.test());
    }
    
    /*
     * Pruebas para el método testResult de la clase LandingGear:
     * 1- El test es true -> Devuelve true
     * 2- El test es false -> Devuelve false
     */
    
    /**
     * 1- El test es true -> Devuelve true
     */
    @Test
    public void testTestResultTrue(){               
        LandingGear landingGear1  = new LandingGear();
        assertTrue(landingGear1.test());
        assertEquals("OK", landingGear1.testResult());
    }
    
    /**
     * 2- El test es false -> Devuelve false
     */
    @Test
    public void testTestResultFalse(){
        LandingGear landingGear1 = new LandingGear();
        landingGear1.getNose().getWheel(0).changePressure(10);
        landingGear1.getLeft().getWheel(0).changePressure(10);
        landingGear1.getRight().getWheel(0).changePressure(10);
        assertFalse(landingGear1.test());
        assertEquals("FAILURE", landingGear1.testResult());
    }
    
    // /*
     // * Pruebas para el método strutState de la clase LandingGear (solo con un parámetro, para el resto de los puntales es igual):
     // * 1- Puntal desplegado y las presiones están bien-> Devuelve "ON"
     // * 2- Puntal replegado y las presines están bien-> Devuelve "OFF"
     // * 3- Necesita camibos en las presiones -> Devuelve "PRESS"
     // */
    
    /**
     * 1- Puntal desplegado y las presiones están bien-> Devuelve "ON"
     */
    @Test
    public void testStrutStateOn(){
        LandingGear landingGear1 = new LandingGear();
        assertEquals("ON", landingGear1.strutState(landingGear1.getNose()));
    }
    
    /**
     * 2- Puntal replegado y las presines están bien-> Devuelve "OFF"
     */
    @Test
    public void testStrutStateOff(){
        LandingGear landingGear1 = new LandingGear();
        landingGear1.getNose().retract();
        assertEquals("OFF", landingGear1.strutState(landingGear1.getNose()));
    }
    
    /**
     * 3- Necesita camibos en las presiones -> Devuelve "PRESS"
     */
    @Test
    public void testStrutStatePress(){
        LandingGear landingGear1 = new LandingGear();
        landingGear1.getNose().getWheel(0).changePressure(500);
        assertEquals("PRESS", landingGear1.strutState(landingGear1.getNose()));
    }
    
    /*
     * Pruebas del método leverToString de la clase LandingGear:
     * 1- La palanca es true -> Devuelve UP
     * 1- La palanca es false -> Devuelve DOWN
     */
    
    /**
     * 1- La palanca es true -> Devuelve UP
     */
    @Test
    public void testLeverToStringTrue(){
        LandingGear landingGear1 = new LandingGear();
        landingGear1.moveLever(true);
        assertEquals(true, landingGear1.getLever());
        assertEquals("UP", landingGear1.leverToString());
    }
    
    /**
     * 1- La palanca es false -> Devuelve DOWN
     */
    @Test
    public void testLeverToStringFalse(){
        LandingGear landingGear1 = new LandingGear();
        assertEquals(false, landingGear1.getLever());
        assertEquals("DOWN", landingGear1.leverToString());
    }
    
    /*
     * Pruebas del método toString de la clase LandingGear:
     * 1- Lever: UP    Status: OK   Nose: ON    Right: ON   Left: ON
     * 2- Lever: DOWN Status: FAILURE Nose: OFF Left: OFF Right: OFF
     */
    
    // /**
     // * 1- Lever: UP    Status:OK   Nose: ON    Right: ON   Left: ON
     // */
    // @Test
    // public void tesToStringAllOk(){
        // LandingGear landingGear1 = new LandingGear();
        // landingGear1.moveLever(LandingGear.LEVER_UP);
        // assertEquals("Lever: UP Status: OK Nose: ON Right: ON Left: ON", landingGear1.toString());
    // }
    
    /**
     * 2- Lever: DOWN Status: FAILURE Nose: OFF Left: OFF Right: OFF
     */
    @Test
    public void tesToStringAllNotOk(){
        LandingGear landingGear1 = new LandingGear();
        landingGear1.getNose().getWheel(0).changePressure(10);
        landingGear1.getLeft().getWheel(0).changePressure(10);
        landingGear1.getRight().getWheel(0).changePressure(10);
        assertEquals("Lever: DOWN Status: FAILURE Nose: PRESS Right: PRESS Left: PRESS", landingGear1.toString());
    }
}
