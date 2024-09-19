import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerTest
{
    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
    {
    }

    /**
     * Pruebas del constructor sin parámetros
     */
    @Test
    public void testConstructorNoParams(){
        Player player1 = new Player();
        assertEquals(Player.DEFAULT_NAME, player1.getName());
        assertEquals(Player.DEFAULT_NUMBER, player1.getNumber());
    }
    
    /*
     * Pruebas del constructor con parámetros:
     * 1- Name no es null -> Cambia el valor
     * 2- Name es null -> Por defecto
     */
    
    /**
     * 1- Name no es null -> Cambia el valor
     */
    @Test
    public void testConstructorWithParams(){
        Player player1 = new Player("Omar", 12);
        assertEquals("Omar", player1.getName());
        assertEquals(12, player1.getNumber());
    }
    
    /**
     * 2- Name es null -> Por defecto
     */
    @Test
    public void testConstructorWithParamsNull(){
        Player player1 = new Player(null, 12);
        assertEquals("Omar", player1.getName());
        assertEquals(12, player1.getNumber());
    }
    
    /**
     * Prueba del método toString
     */
    @Test
    public void testtoString(){
        Player player1 = new Player("Israel", 15);
        assertEquals("Israel", player1.getName());
        assertEquals(15, player1.getNumber());
        assertEquals("Israel - 15", player1.toString());
    }
}
