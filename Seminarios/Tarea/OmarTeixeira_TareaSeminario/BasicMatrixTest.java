import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasicMatrixTest
{
    // constantes
    public static final int MAX_VALUE=99;
    public static final int MIN_VALUE=0;

    /**
     * Default constructor for test class MatrixTest
     */
    public BasicMatrixTest()
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
    
    @Test
    public void testConstructorIntParameterBASIC()
    {
        Matrix matrix=new Matrix(2);
        assertTrue(true);
    }
    
    @Test
    public void testConstructorArrayParameterBASIC()
    {
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        assertTrue(true);
    }
    
    @Test
    public void testSwapReverseByDiagonalsBASIC()
    {
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        matrix.swapReverseByDiagonals();
        assertTrue(true);
    }

    @Test
    public void testRotateMatrix BASIC()
    {
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        matrix.rotateMatrix ();
        assertTrue(true);
    }    
    
    @Test
    public void testMoveColumnBASIC()
    {
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        matrix.moveColumn(0);
        assertTrue(true);
    }    
   
}
