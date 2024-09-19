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
        WheelStrut nose = new WheelStrut();
        WheelStrut left = new WheelStrut();
        WheelStrut right = new WheelStrut();
        LandingGear landingG1 = new LandingGear();
        assertNull(landingG1.getWheelStrutLeft());
        assertNull(landingG1.getWheelStrutNose());
        assertNull(landingG1.getWheelStrutRight());
        assertFalse(landingG1.getLever());
    }
    
    /*
     * Pruebas para el constructor con parámetros para la clase LandingGear:
     * 1- Todo es true
     * 2- Todo es false
     */
    
    /**
     * 1- Todo es true
     */
    @Test
    public void testConstructorWithParamsTrue()
    {
        WheelStrut nose = new WheelStrut(true);
        WheelStrut left = new WheelStrut(true);
        WheelStrut right = new WheelStrut(true);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals(true, nose.isDeployed());
        assertEquals(true, left.isDeployed());
        assertEquals(true, right.isDeployed());
        assertEquals(true, landingG1.getLever());
    }
    
    /**
     * 2- Todo es false
     */
    @Test
    public void testConstructorWithParamsFalse()
    {
        WheelStrut nose = new WheelStrut(false);
        WheelStrut left = new WheelStrut(false);
        WheelStrut right = new WheelStrut(false);
        LandingGear landingG1 = new LandingGear(nose, left, right, false);
        assertEquals(false, nose.isDeployed());
        assertEquals(false, left.isDeployed());
        assertEquals(false, right.isDeployed());
        assertEquals(false, landingG1.getLever());
    }

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
        WheelStrut nose = new WheelStrut();
        WheelStrut left = new WheelStrut();
        WheelStrut right = new WheelStrut();
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals("UP", landingG1.leverToString());
        landingG1.moveLever(true);
        assertEquals("UP", landingG1.leverToString());
    }
    
    /**
     * 2- Si está Down y llamo action = Up -> Palanca pasa a Up y puntales quedan replegados
     */
    @Test
    public void testMoveLeverUpWhenDown()
    {
        WheelStrut nose = new WheelStrut();
        WheelStrut left = new WheelStrut();
        WheelStrut right = new WheelStrut();
        LandingGear landingG1 = new LandingGear(nose, left, right, false);
        assertEquals("DOWN", landingG1.leverToString());
        landingG1.moveLever(true);
        assertEquals("UP", landingG1.leverToString());
    }
    
    /**
     * 3- Si está Up y action = Down -> Palaca pasa a down y puntales se despliegan
     */
    @Test
    public void testMoveLeverDownWhenUp()
    {
        WheelStrut nose = new WheelStrut();
        WheelStrut left = new WheelStrut();
        WheelStrut right = new WheelStrut();
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals("UP", landingG1.leverToString());
        landingG1.moveLever(false);
        assertEquals("DOWN", landingG1.leverToString());
    }
    
    /**
     * 4- Si está down y action = down -> No se modifica nada
     */
    @Test
    public void testMoveLeverDownWhenDown()
    {
        WheelStrut nose = new WheelStrut();
        WheelStrut left = new WheelStrut();
        WheelStrut right = new WheelStrut();
        LandingGear landingG1 = new LandingGear(nose, left, right, false);
        assertEquals("DOWN", landingG1.leverToString());
        landingG1.moveLever(false);
        assertEquals("DOWN", landingG1.leverToString());
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
        Wheel wheel1 = new Wheel(1000, 500);
        Wheel wheel2 = new Wheel(1000, 900);
        Wheel wheel3 = new Wheel(1000, 900);
        WheelStrut nose = new WheelStrut(true, wheel2, wheel3);
        WheelStrut left = new WheelStrut(true, wheel2, wheel3);
        WheelStrut right = new WheelStrut(true, wheel2, wheel3);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals(true, landingG1.test());
    }
    
    /**
     * 2- 1 de los puntales tiene test false, el resto true -> Devuelve false
     */
    @Test
    public void testTestOneFalse(){
        Wheel wheel1 = new Wheel(1000, 500);
        Wheel wheel2 = new Wheel(1000, 900);
        Wheel wheel3 = new Wheel(1000, 900);
        WheelStrut nose = new WheelStrut(false, wheel1, wheel2);
        WheelStrut left = new WheelStrut(true, wheel2, wheel3);
        WheelStrut right = new WheelStrut(true, wheel2, wheel3);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals(false, landingG1.test());
    }
    
    /**
     * 3- 2 de los puntales tienen test false, el otro true -> Devuelve false
     */
    @Test
    public void testTestTwoFalse(){
        Wheel wheel1 = new Wheel(1000, 500);
        Wheel wheel2 = new Wheel(1000, 900);
        Wheel wheel3 = new Wheel(1000, 900);
        WheelStrut nose = new WheelStrut(false, wheel1, wheel2);
        WheelStrut left = new WheelStrut(false, wheel1, wheel2);
        WheelStrut right = new WheelStrut(true,wheel2, wheel3);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals(false, landingG1.test());
    }
    
    /**
     * 4- Los test de los tres test son false -> Devuelve false
     */
    @Test
    public void testTestAllFalse(){
        Wheel wheel1 = new Wheel(1000, 500);
        Wheel wheel2 = new Wheel(1000, 900);
        WheelStrut nose = new WheelStrut(false, wheel1, wheel2);
        WheelStrut left = new WheelStrut(false, wheel1, wheel2);
        WheelStrut right = new WheelStrut(false,wheel1, wheel2);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals(false, landingG1.test());
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
        Wheel wheel1 = new Wheel(1000, 500);
        Wheel wheel2 = new Wheel(1000, 900);
        Wheel wheel3 = new Wheel(1000, 900);
        WheelStrut nose = new WheelStrut(true, wheel2, wheel3);
        WheelStrut left = new WheelStrut(true, wheel2, wheel3);
        WheelStrut right = new WheelStrut(true, wheel2, wheel3);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals(true, landingG1.test());
        assertEquals("OK", landingG1.testResult());
    }
    
    /**
     * 2- El test es false -> Devuelve false
     */
    @Test
    public void testTestResultFalse(){
        Wheel wheel1 = new Wheel(1000, 500);
        Wheel wheel2 = new Wheel(1000, 900);
        WheelStrut nose = new WheelStrut(false, wheel1, wheel2);
        WheelStrut left = new WheelStrut(false, wheel1, wheel2);
        WheelStrut right = new WheelStrut(false,wheel1, wheel2);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals(false, landingG1.test());
        assertEquals("FAILURE", landingG1.testResult());
    }
    
    /*
     * Pruebas para el método strutState de la clase LandingGear (solo con un parámetro, para el resto de los puntales es igual):
     * 1- Puntal desplegado y las presiones están bien-> Devuelve "ON"
     * 2- Puntal replegado y las presines están bien-> Devuelve "OFF"
     * 3- Necesita camibos en las presiones -> Devuelve "PRESS"
     */
    
    /**
     * 1- Puntal desplegado y las presiones están bien-> Devuelve "ON"
     */
    @Test
    public void testStrutStateOn(){
        Wheel wheel1 = new Wheel(1000,900);
        Wheel wheel2 = new Wheel(1000,900);
        WheelStrut nose = new WheelStrut(true, wheel1, wheel2);
        WheelStrut left = new WheelStrut(false, wheel1, wheel2);
        WheelStrut right = new WheelStrut(false,wheel1, wheel2);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals("ON", landingG1.strutState(nose));
    }
    
    /**
     * 2- Puntal replegado y las presines están bien-> Devuelve "OFF"
     */
    @Test
    public void testStrutStateOff(){
        Wheel wheel1 = new Wheel(1000,900);
        Wheel wheel2 = new Wheel(1000,900);
        WheelStrut nose = new WheelStrut(false, wheel1, wheel2);
        WheelStrut left = new WheelStrut(false, wheel1, wheel2);
        WheelStrut right = new WheelStrut(false,wheel1, wheel2);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals("OFF", landingG1.strutState(nose));
    }
    
    /**
     * 3- Necesita camibos en las presiones -> Devuelve "PRESS"
     */
    @Test
    public void testStrutStatePress(){
        Wheel wheel1 = new Wheel(1000,900);
        Wheel wheel2 = new Wheel(1000,500);
        WheelStrut nose = new WheelStrut(false, wheel1, wheel2);
        WheelStrut left = new WheelStrut(false, wheel1, wheel2);
        WheelStrut right = new WheelStrut(false,wheel1, wheel2);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals("PRESS", landingG1.strutState(nose));
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
        WheelStrut nose = new WheelStrut();
        WheelStrut left = new WheelStrut();
        WheelStrut right = new WheelStrut();
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals(true, landingG1.getLever());
        assertEquals("UP", landingG1.leverToString());
    }
    
    /**
     * 1- La palanca es false -> Devuelve DOWN
     */
    @Test
    public void testLeverToStringFalse(){
        WheelStrut nose = new WheelStrut();
        WheelStrut left = new WheelStrut();
        WheelStrut right = new WheelStrut();
        LandingGear landingG1 = new LandingGear(nose, left, right, false);
        assertEquals(false, landingG1.getLever());
        assertEquals("DOWN", landingG1.leverToString());
    }
    
    /*
     * Pruebas del método toString de la clase LandingGear:
     * 1- Lever: UP    Status:OK   Nose: ON    Right: ON   Left: ON
     * 2- Lever: DOWN Status: FAILURE Nose: OFF Left: OFF Right: OFF
     */
    
    /**
     * 1- Lever: UP    Status:OK   Nose: ON    Right: ON   Left: ON
     */
    @Test
    public void tesToStringAllOk(){
        Wheel wheel1 = new Wheel(1000,900);
        Wheel wheel2 = new Wheel(1000,900);
        WheelStrut nose = new WheelStrut(true, wheel1, wheel2);
        WheelStrut left = new WheelStrut(true, wheel1, wheel2);
        WheelStrut right = new WheelStrut(true,wheel1, wheel2);
        LandingGear landingG1 = new LandingGear(nose, left, right, true);
        assertEquals("Lever: UP Status: OK Nose: ON Right: ON Left: ON", landingG1.toString());
    }
    
    /**
     * 2- Lever: DOWN Status: FAILURE Nose: OFF Left: OFF Right: OFF
     */
    @Test
    public void tesToStringAllNotOk(){
        Wheel wheel1 = new Wheel(1000,500);
        Wheel wheel2 = new Wheel(1000,500);
        WheelStrut nose = new WheelStrut(false, wheel1, wheel2);
        WheelStrut left = new WheelStrut(false, wheel1, wheel2);
        WheelStrut right = new WheelStrut(false,wheel1, wheel2);
        LandingGear landingG1 = new LandingGear(nose, left, right, false);
        assertEquals("Lever: DOWN Status: FAILURE Nose: PRESS Right: PRESS Left: PRESS", landingG1.toString());
    }
}




