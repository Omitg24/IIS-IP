

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testTree.
 *
 * @author  Omar Teixeira González
 * @version 30/09/2020
 */
public class testTree
{
    /**
     * Default constructor for test class testTree
     */
    public testTree()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    /*
     * Escenarios:
     * 1- Parámetro igual al 0 (ninguna flor) -> Cambiar el valor
     * 2- Parámetro entre el 0 y el maxNumberOfFlowers -> Cambiar el valor
     * 3- Parámetro igual al maxNumberOfFlowers -> Cambiar el valor
     * 4- Parámetro superior al maxNumberOfFlowers -> No cambiar el valor
     */
    
    /**
     * 1- Parámetro igual al 0 (ninguna flor) -> Cambiar el valor
     */
    @Test
    public void testsetNumberOfFlowersInLowerLimit()
    {
        Tree tree1 = new Tree();
        tree1.setNumberOfFlowers(0);
        assertEquals(0, tree1.getNumberOfFlowers());
    }
    
    /**
     * 2- Parámetro entre el 0 y el maxNumberOfFlowers -> Cambiar el valor
     */
    @Test
    public void testsetNumberOfFlowersInsideLimits()
    {
        Tree tree1 = new Tree();
        tree1.setNumberOfFlowers(5);
        assertEquals(5, tree1.getNumberOfFlowers());
    }
    
    /**
     * 3- Parámetro igual al maxNumberOfFlowers -> Cambiar el valor
     */ 
    @Test
    public void testsetNumberOfFlowersInUpperLimit()
    {
        Tree tree1 = new Tree();
        tree1.setNumberOfFlowers(tree1.getmaxNumberOfFlowers());
        assertEquals(tree1.getmaxNumberOfFlowers(), tree1.getNumberOfFlowers());
    }
    
    /**
     * 3- Parámetro igual al maxNumberOfFlowers -> Cambiar el valor
     */ 
    @Test
    public void testsetNumberOfFlowersOverUpperLimit()
    {
        Tree tree1 = new Tree();
        tree1.setNumberOfFlowers(50);
        assertEquals(tree1.DEFAULT_NUMBER_OF_FLOWERS, tree1.getNumberOfFlowers());
    }
}

