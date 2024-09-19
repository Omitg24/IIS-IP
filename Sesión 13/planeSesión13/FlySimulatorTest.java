import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba de la clase FlySimulator
 *
 * @author  Omar Teixeira Gonzalez
 * @version 14-12-20
 */
public class FlySimulatorTest
{
    /*
     * Pruebas de addPlane:
     * Positivos:
     * 1- A�adimos un avi�n que no existe en posici�n libre
     * 
     * Negativos:
     * 2- A�adimos un avi�n con identificador que ya existe
     * 3- A�adimos avi�n en posici�n ya ocupada
     * 4- A�adimos null      
     */
    
    /**
     * 1- A�adimos un avi�n que no existe en posici�n libre
     */
    @Test
    public void testAddPlaneNormal(){
        FlySimulator flySimulator = new FlySimulator();        
        flySimulator.addPlane(new Plane('A',100, 0,0,1,1));
        assertEquals(1,flySimulator.getPlanes().length);
    }
    
    /**
     * 2- A�adimos un avi�n con identificador que ya existe
     */
    @Test
    public void testAddPlaneSameIdentifier(){
        FlySimulator flySimulator = new FlySimulator();        
        flySimulator.addPlane(new Plane('A',100, 0,0,1,1));
        try{
            flySimulator.addPlane(new Plane('A', 100, 10, 0, 1, -1));
            fail("Esperaba excepci�n");
        }catch(RuntimeException msg){
            assertEquals("Ya existe un avi�n con el mismo identificador", msg.getMessage());
        }
    }
    
    /**
     * 3- A�adimos avi�n en posici�n ya ocupada
     */
    @Test
    public void testAddPlaneSamePosition(){
        FlySimulator flySimulator = new FlySimulator();        
        flySimulator.addPlane(new Plane('A',100, 0,0,1,1));
        try{
            flySimulator.addPlane(new Plane('B', 100, 0, 0, 1, 1));
            fail("Esperaba excepci�n");
        }catch(RuntimeException msg){
            assertEquals("La posici�n ya est� ocupada", msg.getMessage());
        }
    }
    
    /**
     * 4- A�adimos null      
     */
    @Test
    public void testAddPlaneNull(){
        FlySimulator flySimulator = new FlySimulator();        
        flySimulator.addPlane(new Plane('A',100, 10,10,-1,-1));
        try{
            Plane plane = null;
            flySimulator.addPlane(plane);
            fail("Esperaba excepci�n");
        }catch(RuntimeException msg){
            assertEquals("Esperaba avi�n y fue null", msg.getMessage());
        }
    }
    
    /*
     * Pruebas de animate
     * General-  Varios aviones vuelan varias veces hasta que chocan
     *    - Son 4 aviones
     *    - Son 3 aviones
     */
    
    /**
     * - Son 4 aviones
     */
    @Test
    public void testFlySymulatorCollision4Planes() {
        FlySimulator flySimulator = new FlySimulator();
        
        flySimulator.addPlane(new Plane('A',100, 0,0,1,1));
        flySimulator.addPlane(new Plane('B',100, 0,10,1,-1));
        flySimulator.addPlane(new Plane('C',100, 10,0,-1,1));
        flySimulator.addPlane(new Plane('D',100, 10,10,-1,-1));
        
        flySimulator.printMap();
        
        for (int i=1; i <= 5; i++) {
            assertEquals(4, flySimulator.getPlanes().length);
            flySimulator.animate();            
        }
        assertEquals(0, flySimulator.getPlanes().length);
        
        assertEquals(FlySimulator.COLLISION, flySimulator.getPosition(5,5));
        for (int i=0; i < Plane.MAX_X +1; i++){
            for (int j=0; j < Plane.MAX_Y +1; j++){
                if (i!= 5 && j != 5){
                    assertEquals(FlySimulator.FREE,flySimulator.getPosition(i,j));
                }
            }
        } 
    }    
    
    /**
     * - Son 3 aviones
     */
    @Test
    public void testFlySymulatorCollision3Planes() {
        FlySimulator flySimulator = new FlySimulator();        
         
        flySimulator.addPlane(new Plane('E',100, 0,10,0,-1));
        flySimulator.addPlane(new Plane('F',100, 0,4,0,1));
        flySimulator.addPlane(new Plane('G',100, 3,7,-1,0));
        flySimulator.printMap();
        
        for (int i=1; i <= 3; i++) {
            assertEquals(3, flySimulator.getPlanes().length);
            flySimulator.animate();
        }
        assertEquals(0, flySimulator.getPlanes().length);
        
        assertEquals(FlySimulator.COLLISION, flySimulator.getPosition(0,7));
        for (int i=0; i < Plane.MAX_X +1; i++){
            for (int j=0; j < Plane.MAX_Y +1; j++){
                if (i!= 0 && j != 7){
                    assertEquals(FlySimulator.FREE,flySimulator.getPosition(i,j));
                }
            }
        }
    }
    
    /*
     * Pruebas del m�todo getPosition:
     * Positivos:
     * 1- Columna y fila dentro de par�metros
     * 
     * Negativos:
     * 2- Columna y fila fuera de par�metros
     */
    
    /**
     * 1- Columna y fila dentro de par�metros
     */
    @Test
    public void testGetPositionOk(){
        FlySimulator flySimulator = new FlySimulator();
        Plane plane1 = new Plane('A', 100, 3, 7, 1, 1);
        flySimulator.addPlane(plane1);
        assertEquals('A', flySimulator.getPosition(3, 7));
    }

    // /**
     // * 
     // */
    // @Test
    // public void testGetPositionNotOk(){
        // FlySimulator flySimulator = new FlySimulator();
        // Plane plane1 = new Plane('A', 100, 0, 0, 1, 1);
        // flySimulator.addPlane(plane1);
        // try{
            // flySimulator.getPosition(12,12);
            // fail("Esperaba excepci�n");
        // }catch(RuntimeException msg){
            // assertEquals("Parametros no validos", msg.getMessage());
        // }
    // }
}

