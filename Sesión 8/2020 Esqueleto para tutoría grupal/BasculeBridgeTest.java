

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BasculeBridgeTest.
 *
 * @author  Omar Teixeira González
 * @version 6-10-20
 */
public class BasculeBridgeTest
{
   
   /**
    *  Pruebas del constructor con parámetro 
    */ 
   
    @Test
    public void BasculeBridge()
    {
        //PRUEBAS POSITIVAS        
        // caso 1: Creacción con valor de la inclinación del puente dentro del rango adecuado (entero entre 0 y 60)
        BasculeBridge basculeBridge = new BasculeBridge(40);
        assertEquals(40, basculeBridge.getSlope(),0.1);
        
        // caso 2: Creacción con valor de inclinación en el límite inferior
        basculeBridge = new BasculeBridge(BasculeBridge.MIN_SLOPE);
        assertEquals(BasculeBridge.MIN_SLOPE, basculeBridge.getSlope(),0.1);
       
        // caso 3: Creacción con valor de inclinación en el límite superior
        basculeBridge = new BasculeBridge(BasculeBridge.MAX_SLOPE);
        assertEquals(BasculeBridge.MAX_SLOPE, basculeBridge.getSlope(),0.1);        
        
        //PRUEBAS NEGATIVAS        
        // Caso 4: Creacción con valor de inclinación por debajo del límite inferior
        basculeBridge = new BasculeBridge(BasculeBridge.MIN_SLOPE -1);
        assertEquals(0, basculeBridge.getSlope(),0.1);
        
        // Caso 5: Creacción con valor de inclinación por encima del límite superior
        basculeBridge = new BasculeBridge(BasculeBridge.MAX_SLOPE + 1);
        assertEquals(0, basculeBridge.getSlope(),0.1);        
    }
    
   /**
    * Pruebas del método raiseBridge
    */
   @Test
   public void testRaiseBridge()
   {
        BasculeBridge basculeBridge = new BasculeBridge(0);
        // PRUEBAS POSITIVAS
        // caso 1 levantar una cantidad que permita no superar el máximo
        basculeBridge.raiseBridge(30);
        assertEquals(30,basculeBridge.getSlope(),0.1);
         
        // caso 2 levantar una cantidad hasta llegar al límite
        basculeBridge.raiseBridge(30);
        assertEquals(60,basculeBridge.getSlope(),0.1);        
         
        // PRUEBAS NEGATIVAS          
        // caso 3 levantar una cantidad mayor que el máximo posible
        basculeBridge.raiseBridge(100);
        assertEquals(60,basculeBridge.getSlope(),0.1);
          
        // caso 4 levantar una cantidad negativa
        basculeBridge.raiseBridge(-30);
        assertEquals(60,basculeBridge.getSlope(),0.1);
   }
     
   /**
    * Pruebas del método dropBridge
    */
   @Test
   public void testDropBridge()
   {
        BasculeBridge basculeBridge = new BasculeBridge(60);          
        // PRUEBAS POSITIVAS
        // caso 1 Bajar una cantidad permitida que deje el puente entre 0 y 60
        basculeBridge.dropBridge(20);
        assertEquals(40,basculeBridge.getSlope(),0.1);
          
        // caso 2 Bajar una cantidad que deja el puente en límite inferior
        basculeBridge.dropBridge(40);
        assertEquals(0,basculeBridge.getSlope(),0.1);
          
        // PRUEBAS NEGATIVAS
        // caso 3 Bajar una cantidad mayor que la máxima permitida
        basculeBridge = new BasculeBridge(60);
        basculeBridge.dropBridge(100);
        assertEquals(60,basculeBridge.getSlope(),0.1);
          
        // caso 4 Bajar una cantidad negativa
        basculeBridge.dropBridge(-30);
        assertEquals(60,basculeBridge.getSlope(),0.1);
     }
          
          
        
}
