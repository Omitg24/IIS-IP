import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase test de la clase Weapon
 *
 * @author  Omar Teixeira González
 * @version 31-10-20
 */
public class WeaponTest
{
    /**
     * Default constructor for test class WeaponTest
     */
    public WeaponTest()
    {
    }

    /**
     * Prueba del constructor sin parámetros de la clase Weapon
     */
    @Test
    public void testConstructorWithoutParams(){
        Weapon weapon1 = new Weapon();
        assertNotNull(weapon1.getWeaponName());
        assertNotNull(weapon1.getAmmunition());
        assertEquals("M416",weapon1.getWeaponName());
        assertEquals(30, weapon1.getAmmunition());
    }
    
    /*
     * Pruebas para el constructor con parámetos weaponName y ammunition:
     * Positivos:
     * 1- weaponName no null y ammunition superior a 0 -> cambiar la munición
     * 2- weaponName no null y ammunition igual a 0 -> munición igual a 0
     * 
     * Negativos:
     * 3- weaponName no null y ammunition inferior a 0 -> munición por defecto
     */
    
    /**
     * 1- weaponName no null y ammunition superior a 0 -> cambiar la munición
     */
    @Test
    public void testConstructorWithParamsOk1(){
        Weapon weapon1 = new Weapon("AK-47",30);
        assertNotNull(weapon1.getAmmunition());
        assertEquals("AK-47", weapon1.getWeaponName());
        assertEquals(30, weapon1.getAmmunition());
    }
    
    /**
     * 2- weaponName no null y ammunition igual a 0 -> munición igual a 0
     */
    @Test
    public void testConstructorWithParamsOk2(){
        Weapon weapon1 = new Weapon("AK-47",0);
        assertNotNull(weapon1.getAmmunition());
        assertEquals("AK-47", weapon1.getWeaponName());
        assertEquals(0, weapon1.getAmmunition());
    }
    
    /**
     * 3- weaponName no null y ammunition inferior a 0 -> munición por defecto
     */
    @Test
    public void testConstructorWithParamsNotOk(){
        Weapon weapon1 = new Weapon("AK-47",-5);
        assertNotNull(weapon1.getAmmunition());
        assertEquals("AK-47", weapon1.getWeaponName());
        assertEquals(30, weapon1.getAmmunition());
    }
    
    /*
     * Pruebas del método shoot de la clase Weapon:
     * 1-Tiene munción -> Resta una bala e imprime "BANG"
     * 2- No tiene munción -> No hace nada
     */
    
    /**
     * 1-Tiene munción -> Resta una bala e imprime "BANG"
     */
    @Test
    public void testShoot()
    {
        Weapon weapon1 = new Weapon();
        assertEquals(30, weapon1.getAmmunition());
        weapon1.shoot();
        assertEquals(29, weapon1.getAmmunition());
    }
    
    /**
     * 2- No tiene munción -> No hace nada
     */
    @Test
    public void testDontShoot()
    {
        Weapon weapon1 = new Weapon("M416",0);
        assertEquals(0, weapon1.getAmmunition());
        weapon1.shoot();
        assertEquals(0, weapon1.getAmmunition());
    }
    
    /**
     * Prueba del método toString de la clase Weapon
     */    
    @Test
    public void testToString()
    {
        Weapon weapon1 = new Weapon("M416", 30);
        assertNotNull(weapon1.getWeaponName());
        assertNotNull(weapon1.getAmmunition());
        assertEquals("M416-(30)", weapon1.toString());
    }
}

