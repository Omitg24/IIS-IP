import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase test de la clase Figure
 *
 * @author  Omar Teixeira González
 * @version 23-10-20
 */
public class FigureTest
{
    /**
     * Default constructor for test class FigureTest
     */
    public FigureTest()
    {
    }

    /**
     * Prueba del constructor sin parámetros de la clase Figure
     */
    @Test
    public void testConstructorWithoutParams(){
        Figure figure1 = new Figure();
        assertNotNull(figure1.getName());
        assertNotNull(figure1.getXPos());
        assertNotNull(figure1.getYPos());
        assertEquals("Omar",figure1.getName());
        assertEquals(10,figure1.getXPos());
        assertEquals(10,figure1.getYPos());
    }
    
    /*
     * Pruebas para el constructor con parámetros de la clase Figure:
     * Positivos:
     * 1- El nombre no es null, y los valores están dentro de los límites
     * 
     * Negativos:
     * 2- El nombre no es null, y el valor x está dentro de los límites, pero el y no
     * 3- El nombre no es null, y el valor y está dentro de los límites, pero el x no
     * 4- El nombre no es null, y ambos valores están fuera de los límites
     */
    /**
     * 1- El nombre no es null, y los valores están dentro de los límites
     */
    @Test
    public void testConstructorWithParamsOk(){
        Figure figure1 = new Figure("Omar", 18, 24);
        assertNotNull(figure1.getName());
        assertNotNull(figure1.getXPos());
        assertNotNull(figure1.getYPos());
        assertEquals("Omar",figure1.getName());
        assertEquals(18,figure1.getXPos());
        assertEquals(24,figure1.getYPos());
    }
       
    /**
     * 2- El nombre no es null, y el valor x está dentro de los límites, pero el y no
     */
    @Test
    public void testConstructorWithParamsNotOk1(){
        Figure figure1 = new Figure("Omar", 18, -2);
        assertNotNull(figure1.getName());
        assertNotNull(figure1.getXPos());
        assertNotNull(figure1.getYPos());
        assertEquals("Omar",figure1.getName());
        assertEquals(18,figure1.getXPos());
        assertEquals(10,figure1.getYPos());
    }
    
    /**
     * 3- El nombre no es null, y el valor y está dentro de los límites, pero el x no
     */
    @Test
    public void testConstructorWithParamsNotOk2(){
        Figure figure1 = new Figure("Omar", -2, 24);
        assertNotNull(figure1.getName());
        assertNotNull(figure1.getXPos());
        assertNotNull(figure1.getYPos());
        assertEquals("Omar",figure1.getName());
        assertEquals(10,figure1.getXPos());
        assertEquals(24,figure1.getYPos());
    }
    
    /**
     * 4- El nombre no es null, y ambos valores están fuera de los límites
     */
    @Test
    public void testConstructorWithParamsNotOk3(){
        Figure figure1 = new Figure("Omar", -2, -2);
        assertNotNull(figure1.getName());
        assertNotNull(figure1.getXPos());
        assertNotNull(figure1.getYPos());
        assertEquals("Omar",figure1.getName());
        assertEquals(10,figure1.getXPos());
        assertEquals(10,figure1.getYPos());
    }
    
    /*
     * Pruebas para el método move de la clase Figure:
     * Positivos:
     * 1- Parámetro L -> Figure se desplaza -1 en X
     * 2- Parámetro R -> Figure se desplaza +1 en X
     * 3- Parámetro D -> Figure se desplaza -1 en Y
     * 4- Parámetro U -> Figure se desplaza +1 en Y
     * 
     * Negativos:
     * 5- Parámetro L con posición X = 0 -> Figure no se desplaza
     * 6- Parámetro R con posición X = 640 -> Figure no se desplaza
     * 7- Parámetro D con posición Y = 0 -> Figure no se desplaza
     * 8- Parámetro U con posición Y = 320 -> Figure no se desplaza
     */
    /**
     * 1- Parámetro L -> Figure se desplaza -1 en X
     */
    @Test
    public void testMoveL()
    {
        Figure figure1 = new Figure();
        figure1.move('L');
        assertEquals(9, figure1.getXPos());
        assertEquals(10, figure1.getYPos());
    }
    
    /**
     * 2- Parámetro R -> Figure se desplaza +1 en X
     */
    @Test
    public void testMoveR()
    {
        Figure figure1 = new Figure();
        figure1.move('R');
        assertEquals(11, figure1.getXPos());
        assertEquals(10, figure1.getYPos());
    }
    
    /**
     * 3- Parámetro D -> Figure se desplaza -1 en Y
     */
    @Test
    public void testMoveD()
    {
        Figure figure1 = new Figure();
        figure1.move('D');
        assertEquals(10, figure1.getXPos());
        assertEquals(9, figure1.getYPos());
    }
    
    /**
     * 4- Parámetro U -> Figure se desplaza +1 en Y
     */
    @Test
    public void testMoveU()
    {
        Figure figure1 = new Figure();
        figure1.move('U');
        assertEquals(10, figure1.getXPos());
        assertEquals(11, figure1.getYPos());
    }
    
    /**
     * 5- Parámetro L con posición X = 0 -> Figure no se desplaza
     */
    @Test
    public void testNotMoveL()
    {
        Figure figure1 = new Figure("Omar",0,10);
        figure1.move('L');
        assertEquals(0, figure1.getXPos());
        assertEquals(10, figure1.getYPos());
    }
    
    /**
     * 6- Parámetro R con posición X = 640 -> Figure no se desplaza
     */
    @Test
    public void testNotMoveR()
    {
        Figure figure1 = new Figure("Omar",640,10);
        figure1.move('R');
        assertEquals(640, figure1.getXPos());
        assertEquals(10, figure1.getYPos());
    }
    
    /**
     * 7- Parámetro D con posición Y = 0 -> Figure no se desplaza
     */
    @Test
    public void testNotMoveD()
    {
        Figure figure1 = new Figure("Omar",10,0);
        figure1.move('D');
        assertEquals(10, figure1.getXPos());
        assertEquals(0, figure1.getYPos());
    }
    
    /**
     * 8- Parámetro U con posición Y = 320 -> Figure no se desplaza
     */
    @Test
    public void testNotMoveU()
    {
        Figure figure1 = new Figure("Omar",10,320);
        figure1.move('U');
        assertEquals(10, figure1.getXPos());
        assertEquals(320, figure1.getYPos());
    }
    
    
    /**
     * Prueba del método toString de la clase Figure
     */    
    @Test
    public void testToString()
    {
        Figure figure1 = new Figure("Omar", 18, 24);
        assertNotNull(figure1.getName());
        assertNotNull(figure1.getXPos());
        assertNotNull(figure1.getYPos());
        assertEquals("Omar-(18,24)", figure1.toString());
    }
}


