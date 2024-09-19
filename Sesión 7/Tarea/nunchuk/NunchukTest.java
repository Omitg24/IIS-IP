import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NunchukTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NunchukTest
{
    /**
     * Default constructor for test class NunchukTest
     */
    public NunchukTest()
    {
    }

    /**
     * Prueba del constructor sin parámetros de la clase Nunchuk
     */
    @Test
    public void testConstructorWithoutParams(){
        Nunchuk nunchuk1 = new Nunchuk();
        assertNull(nunchuk1.getFigure());
        assertNull(nunchuk1.getWeapon());
    }
    
    /*
     * Pruebas para el método advance de la clase Nunchuk:
     * 1- Direction L -> Resta 1 posición en x
     * 2- Direction R -> Suma 1 posición en x
     * 3- Direction D -> Resta 1 posición en y
     * 4- Direction U -> Suma 1 posición en y
     */
    /**
     * 1- Direction L -> Resta 1 posición en x
     */
    @Test
    public void testAdvanceL()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.Advance('L');
        assertEquals(9, figure1.getXPos());
    }
    
    /**
     * 2- Direction R -> Suma 1 posición en x
     */
    @Test
    public void testAdvanceR()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.Advance('R');
        assertEquals(11, figure1.getXPos());
    }
    
    /**
     * 3- Direction D -> Resta 1 posición en y
     */
    @Test
    public void testAdvanceD()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.Advance('D');
        assertEquals(9, figure1.getYPos());
    }
    
    /**
     * 4- Direction U -> Suma 1 posición en y
     */
    @Test
    public void testAdvanceU()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.Advance('U');
        assertEquals(11, figure1.getYPos());
    }
    
    /*
     * Pruebas para el método middleAdvance de la clase Nunchuk:
     * 1- Direction L -> Resta 2 posición en x
     * 2- Direction R -> Suma 2 posición en x
     * 3- Direction D -> Resta 2 posición en y
     * 4- Direction U -> Suma 2 posición en y
     */
    
    /**
     * 1- Direction L -> Resta 1 posición en x
     */
    @Test
    public void testMiddleAdvanceL()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.middleAdvance('L');
        assertEquals(8, figure1.getXPos());
    }
    
    /**
     * 2- Direction R -> Suma 1 posición en x
     */
    @Test
    public void testMiddleAdvanceR()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.middleAdvance('R');
        assertEquals(12, figure1.getXPos());
    }
    
    /**
     * 3- Direction D -> Resta 1 posición en y
     */
    @Test
    public void testMiddleAdvanceD()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.middleAdvance('D');
        assertEquals(8, figure1.getYPos());
    }
    
    /**
     * 4- Direction U -> Suma 1 posición en y
     */
    @Test
    public void testMiddleAdvanceU()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.middleAdvance('U');
        assertEquals(12, figure1.getYPos());
    }
    
    /*
     * Pruebas para el método muchAdvance de la clase Nunchuk:
     * 1- Direction L -> Resta 5 posición en x
     * 2- Direction R -> Suma 5 posición en x
     * 3- Direction D -> Resta 5 posición en y
     * 4- Direction U -> Suma 5 posición en y
     */
    /**
     * 1- Direction L -> Resta 1 posición en x
     */
    @Test
    public void testMuchAdvanceL()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.muchAdvance('L');
        assertEquals(5, figure1.getXPos());
    }
    
    /**
     * 2- Direction R -> Suma 1 posición en x
     */
    @Test
    public void testMuchAdvanceR()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.muchAdvance('R');
        assertEquals(15, figure1.getXPos());
    }
    
    /**
     * 3- Direction D -> Resta 1 posición en y
     */
    @Test
    public void testMuchAdvanceD()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.muchAdvance('D');
        assertEquals(5, figure1.getYPos());
    }
    
    /**
     * 4- Direction U -> Suma 1 posición en y
     */
    @Test
    public void testMuchAdvanceU()
    {
        Figure figure1 = new Figure("Omar", 10, 10);
        Weapon weapon1 = new Weapon("AK-47", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        nunchuk1.muchAdvance('U');
        assertEquals(15, figure1.getYPos());
    }
    
    /*
     * Pruebas para el método shootWeapon de la clase Nunchuk:
     * 1- Parámetro true -> Un solo disparo
     * 2- Parámetro false -> Ráfaga
     */
    
    /**
     * 1- Parámetro true -> Un solo disparo
     */
    @Test
    public void testShootWeaponTrue()
    {
        Figure figure1 = new Figure("Omar", 18, 24);
        Weapon weapon1 = new Weapon("M416", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        assertEquals(30, weapon1.getAmmunition());
        nunchuk1.shootWeapon(true);
        assertEquals(29, weapon1.getAmmunition());
    }
    
    /**
     * 2- Parámetro false -> Ráfaga
     */
    @Test
    public void testShootWeaponFalse()
    {
        Figure figure1 = new Figure("Omar", 18, 24);
        Weapon weapon1 = new Weapon("M416", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        assertEquals(30, weapon1.getAmmunition());
        nunchuk1.shootWeapon(false);
        assertEquals(25, weapon1.getAmmunition());
    }
    /*
     * Pruebas para el método shootForward de la clase Nunchuk:
     * 1- Direction L -> Resta 1 posición en x
     * 2- Direction R -> Suma 1 posición en x
     * 3- Direction D -> Resta 1 posición en y
     * 4- Direction U -> Suma 1 posición en y
     */
    
    /**
     * 1- Direction L -> Resta 1 posición en x
     */
    @Test
    public void shootForwardL()
    {
        Figure figure1 = new Figure("Omar", 18, 24);
        Weapon weapon1 = new Weapon("M416", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        assertEquals(18, figure1.getXPos());
        assertEquals(30, weapon1.getAmmunition());
        nunchuk1.shootForward('L');
        assertEquals(17, figure1.getXPos());
        assertEquals(29, weapon1.getAmmunition());
    }
    
    /**
     * 2- Direction R -> Suma 1 posición en x
     */
    @Test
    public void shootForwardR()
    {
        Figure figure1 = new Figure("Omar", 18, 24);
        Weapon weapon1 = new Weapon("M416", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        assertEquals(18, figure1.getXPos());
        assertEquals(30, weapon1.getAmmunition());
        nunchuk1.shootForward('R');
        assertEquals(19, figure1.getXPos());
        assertEquals(29, weapon1.getAmmunition());
    }
    
    /**
     * 3- Direction D -> Resta 1 posición en y
     */
    @Test
    public void shootForwardD()
    {
        Figure figure1 = new Figure("Omar", 18, 24);
        Weapon weapon1 = new Weapon("M416", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        assertEquals(24, figure1.getYPos());
        assertEquals(30, weapon1.getAmmunition());
        nunchuk1.shootForward('D');
        assertEquals(23, figure1.getYPos());
        assertEquals(29, weapon1.getAmmunition());
    }
    
    /**
     * 4- Direction U -> Suma 1 posición en y
     */
    @Test
    public void shootForwardU()
    {
        Figure figure1 = new Figure("Omar", 18, 24);
        Weapon weapon1 = new Weapon("M416", 30);
        Nunchuk nunchuk1 = new Nunchuk(figure1, weapon1);
        assertEquals(24, figure1.getYPos());
        assertEquals(30, weapon1.getAmmunition());
        nunchuk1.shootForward('U');
        assertEquals(25, figure1.getYPos());
        assertEquals(29, weapon1.getAmmunition());
    }
    
}



