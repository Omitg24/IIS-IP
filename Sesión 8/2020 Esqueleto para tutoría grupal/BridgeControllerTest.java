import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BridgeControllerTest.
 *
 * @author  Omar Teixeira González
 * @version 11-11-20
 */
public class BridgeControllerTest
{
    /**
     *  Test para comprobar el constructor por defecto sin parámetros
     *  
     */
    @Test
    public void testBridgeController()
    {
        BridgeController bridgeController = new BridgeController();
         // Comprobamos que todos los atributos tienen los valores por defecto
        assertEquals(BridgeController.DEFAULT_LEVER,bridgeController.getLever());
        assertEquals(BridgeController.DEFAULT_CLUTCH,bridgeController.getClutch());
        assertNotNull(bridgeController.getBridge());
        assertEquals(BridgeController.DEFAULT_ANGLE,bridgeController.getBridge().getSlope(),0.1);
    }    
    
    /**
     *  Test para probar el constructor con un parámetro, la posición de la palanca
     */
     @Test
    public void testBridgeControllerWithParams1()
    {
        // CASOS POSITIVOS        
        // caso 1 se crea controlador del puente con palanca a 0
        BasculeBridge basculeB1 = new BasculeBridge(0);
        BridgeController bridgeController = new BridgeController(0);        
        assertEquals(0,bridgeController.getLever());
        assertEquals(!BridgeController.PRESSED,bridgeController.getClutch());
        assertNotNull(bridgeController.getBridge());
        assertEquals(0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testBridgeControllerWithParams2()
    {       
        // CASOS POSITIVOS        
        // caso 2 se crea controlador del puente con palanca a 1
        BasculeBridge basculeB1 = new BasculeBridge(0);
        BridgeController bridgeController = new BridgeController(1);        
        assertEquals(1,bridgeController.getLever());
        assertEquals(!BridgeController.PRESSED,bridgeController.getClutch());
        assertNotNull(bridgeController.getBridge());
        assertEquals(12,bridgeController.getBridge().getSlope(),0.1);
     }
     
    @Test 
    public void testBridgeControllerWithParams3()
    {    
        // CASOS POSITIVOS        
        // caso 3 se crea controlador del puente con palanca a 2
        BasculeBridge basculeB1 = new BasculeBridge(0);
        BridgeController bridgeController = new BridgeController(2);        
        assertEquals(2,bridgeController.getLever());
        assertEquals(!BridgeController.PRESSED,bridgeController.getClutch());
        assertNotNull(bridgeController.getBridge());
        assertEquals(24,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testBridgeControllerWithParams4()
    {    
        // CASOS NEGATIVOS
        // caso 4 se crea controlador con palanca a posición incorrecta (valor positivo)
        BasculeBridge basculeB1 = new BasculeBridge(0);
        BridgeController bridgeController = new BridgeController(6);        
        assertEquals(0,bridgeController.getLever());
        assertEquals(!BridgeController.PRESSED,bridgeController.getClutch());
        assertNotNull(bridgeController.getBridge());
        assertEquals(0.0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testBridgeControllerWithParams5()
    {            
        // CASOS NEGATIVOS 
        // caso 5 se crea controlador con palanca a posición incorrecta (valor negativo)   
        BasculeBridge basculeB1 = new BasculeBridge(0);
        BridgeController bridgeController = new BridgeController(-1);        
        assertEquals(0,bridgeController.getLever());
        assertEquals(!BridgeController.PRESSED,bridgeController.getClutch());
        assertNotNull(bridgeController.getBridge());
        assertEquals(0.0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testChangeLever1()
    {
         // PRUEBAS POSITIVAS          
         // caso 1 con embrague puesto y posició a 0 cambio a posición 1
         BridgeController bridgeController = new BridgeController(0); 
         bridgeController.changeClutch();          
         bridgeController.changeLever(1);       
         assertEquals(1,bridgeController.getLever());
         assertEquals(BridgeController.PRESSED,bridgeController.getClutch());
         assertEquals(12.0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testChangeLever2()
    {       
         // PRUEBAS POSITIVAS           
         // caso 2 con embrague puesto y posición a 0 cambio a posición 2
         BridgeController bridgeController = new BridgeController(0); 
         bridgeController.changeClutch();          
         bridgeController.changeLever(2);       
         assertEquals(2,bridgeController.getLever());
         assertEquals(BridgeController.PRESSED,bridgeController.getClutch());
         assertEquals(24.0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testChangeLever3()
    {       
         // PRUEBAS POSITIVAS          
         // caso 3 con embrague puesto y posición 1 cambio a posición 2
         BridgeController bridgeController = new BridgeController(1); 
         bridgeController.changeClutch();          
         bridgeController.changeLever(2);       
         assertEquals(2,bridgeController.getLever());
         assertEquals(BridgeController.PRESSED,bridgeController.getClutch());
         assertEquals(24.0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testChangeLever4()
    {       
         // PRUEBAS POSITIVAS          
         // caso 4 con embrague puesto y posición 2 cambio a posición 0
         BridgeController bridgeController = new BridgeController(2); 
         bridgeController.changeClutch();          
         bridgeController.changeLever(0);       
         assertEquals(0,bridgeController.getLever());
         assertEquals(BridgeController.PRESSED,bridgeController.getClutch());
         assertEquals(0.0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testChangeLever5()
    {       
         // PRUEBAS POSITIVAS          
         // caso 5 con embrague puesto y posición 1 cambio a posición 0
         BridgeController bridgeController = new BridgeController(1); 
         bridgeController.changeClutch();          
         bridgeController.changeLever(0);       
         assertEquals(0,bridgeController.getLever());
         assertEquals(BridgeController.PRESSED,bridgeController.getClutch());
         assertEquals(0.0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testChangeLever6()
    {       
         // PRUEBAS POSITIVAS          
         // caso 6 con embrague puesto y posición 2 cambio a posción 1
         BridgeController bridgeController = new BridgeController(2); 
         bridgeController.changeClutch();          
         bridgeController.changeLever(1);       
         assertEquals(1,bridgeController.getLever());
         assertEquals(BridgeController.PRESSED,bridgeController.getClutch());
         assertEquals(12.0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testChangeLever7()
    {       
         // PRUEBAS NEGATIVAS          
         // caso 7 con embrague quitado y posición 0 cambio a posición 1
         BridgeController bridgeController = new BridgeController(0); 
         bridgeController.changeClutch();          
         bridgeController.changeLever(1);       
         assertEquals(1,bridgeController.getLever());
         assertEquals(BridgeController.PRESSED,bridgeController.getClutch());
         assertEquals(12.0,bridgeController.getBridge().getSlope(),0.1);
    }
    
    @Test
    public void testChangeLever8()
    {       
          // PRUEBAS NEGATIVAS          
          // caso 8 con embrague puesto intento cambiar a posición incorrecta positiva
          BridgeController bridgeController = new BridgeController(); 
          bridgeController.changeLever(6);          
          assertEquals(BridgeController.DEFAULT_LEVER,bridgeController.getLever());
          assertEquals(!BridgeController.PRESSED,bridgeController.getClutch());
          assertEquals(BridgeController.DEFAULT_ANGLE,bridgeController.getBridge().getSlope(),0.1);         
    }
    
    @Test
    public void testChangeLever9(){
          // PRUEBAS NEGATIVAS            
          // caso 9 con embrague puesto intento cambiar a posición incorrecta negativa
          BridgeController bridgeController = new BridgeController(); 
          bridgeController.changeLever(-1);          
          assertEquals(BridgeController.DEFAULT_LEVER,bridgeController.getLever());
          assertEquals(!BridgeController.PRESSED,bridgeController.getClutch());
          assertEquals(BridgeController.DEFAULT_ANGLE,bridgeController.getBridge().getSlope(),0.1);
    }
}

