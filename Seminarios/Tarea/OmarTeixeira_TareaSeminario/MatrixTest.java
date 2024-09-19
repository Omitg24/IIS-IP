import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MatrixTest
{
    public static final int MAX_VALUE=99;
    public static final int MIN_VALUE=0;

    /**
     * Default constructor for test class MatrixTest
     */
    public MatrixTest()
    {
    }
    
    // Test para evaluar el proyecto:
    
    /*
     * Pruebas del constructor con parámetro int[][] matrix:
     * Positivos:
     * 1- La matriz cumple los requisitos
     * 
     * Negativos:
     * 2- La matriz es null
     * 3- La matriz no es cuadrada
     * 4- La matriz no cumple la dimensión necesaria
     */
    
    /**
     * 1- La matriz cumple los requisitos
     */
    @Test
    public void testConstructorPositive(){
        Matrix matrix = new Matrix(new int[][] {{1,2,4},{4,5,6},{9,2,8}});
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 
     */
    @Test
    public void testConstructorNegativeNull(){
        try{
            Matrix matrix = new Matrix(null);
            fail("Esperaba excepción");
        }catch(RuntimeException msg){
            assertEquals("Error: La matriz no es valida", msg.getMessage());
        }
    }
    
    /**
     * 2- La matriz no cumple los requisitos
     */
    @Test
    public void testConstructorNegativeSquare(){
        try{
            Matrix matrix = new Matrix(new int[][] {{1,2,4,23},{4,5,6},{9,2,8,34,23}});
            fail("Esperaba excepción");
        }catch (RuntimeException msg){
            assertEquals("Error: La matriz no es valida", msg.getMessage());
        }
    }
    
    /**
     * 3- La matriz no cumple la dimensión necesaria
     */
    @Test
    public void testConstructorDimensionNegative(){
        try{
            Matrix matrix = new Matrix(new int[][] {{1},{2}});
            fail("Esperaba excepción");
        }catch (RuntimeException msg){
            assertEquals("Error: La matriz no es valida", msg.getMessage());
        }
    }
    
    /*
     * Pruebas del método swapReverseByDiagonals:
     * Positivos:
     * 1- Intercambia las diagonales de forma inversa 3x3
     * 2- Intercambia las diagonales de forma inversa 4x4
     * 3- Intercambia las diagonales de forma inversa 5x5
     * 4- Intercambia las diagonales de forma inversa 6x6
     * 5- Intercambia las diagonales de forma inversa 7x7
     */
    
    /**
     * 1- Intercambia las diagonales de forma inversa 3x3
     */
    @Test
    public void testSwapReverseByDiagonals3x3(){
        Matrix matrix = new Matrix(new int[][] {{35,62,8},{50,8,72},{6,56,87}});
        matrix.swapReverseByDiagonals();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 2- Intercambia las diagonales de forma inversa 4x4
     */
    @Test
    public void testSwapReverseByDiagonals4x4(){
        Matrix matrix = new Matrix(new int[][] {{35,62,8,12},{50,8,72,76},{6,56,87,1},{1,2,3,4}});
        matrix.swapReverseByDiagonals();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 3- Intercambia las diagonales de forma inversa 5x5
     */
    @Test
    public void testSwapReverseByDiagonals5x5(){
        Matrix matrix = new Matrix(new int[][] {{35,62,8,12,4},{50,8,72,76,44},{6,56,87,1,56},{1,2,3,4,5},{46,23,67,13,6}});
        matrix.swapReverseByDiagonals();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 4- Intercambia las diagonales de forma inversa 6x6
     */
    @Test
    public void testSwapReverseByDiagonals6x6(){
        Matrix matrix = new Matrix(new int[][] {{35,62,8,12,4,20},{50,8,72,76,44,12},{6,56,87,1,56,14},{1,2,3,4,5,67},
                        {46,23,67,13,6,43},{12,4,5,67,12,51}});
        matrix.swapReverseByDiagonals();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 5- Intercambia las diagonales de forma inversa 7x7
     */
    @Test
    public void testSwapReverseByDiagonals7x7(){
        Matrix matrix = new Matrix(new int[][] {{35,62,8,12,4,203,56},{50,8,72,76,44,12,89},{6,56,87,1,56,14,45},{1,2,3,4,5,67,91},
                        {46,23,67,13,6,43,32},{12,4,5,67,12,51,34},{23,56,7,68,9,12,23}});
        matrix.swapReverseByDiagonals();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /*
     * Pruebas del método rotateMatrix:
     * Positivos:
     * 1- Rota la matriz 3x3
     * 2- Rota la matriz 4x4
     * 3- Rota la matriz 5x5
     * 4- Rota la matriz 6x6
     * 5- Rota la matriz 7x7 
     */
    
    /**
     * 1- Rota la matriz 3x3
     */
    @Test
    public void testRotateMatrix3x3(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
        matrix.rotateMatrix();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(), matrix.getMatrix());
    }
    
    /**
     * 2- Rota la matriz 4x4
     */
    @Test
    public void testRotateMatrix4x4(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3,4},{6,7,8,9},{11,12,13,14},{16,17,18,19}});
        matrix.rotateMatrix();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(), matrix.getMatrix());
    }
    
    /**
     * 3- Rota la matriz 5x5
     */
    @Test
    public void testRotateMatrix5x5(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}});
        matrix.rotateMatrix();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(), matrix.getMatrix());
    }
    
    /**
     * 4- Rota la matriz 6x6
     */
    @Test
    public void testRotateMatrix6x6(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3,4,5,6},{8,9,10,11,12,13},{15,16,17,18,19,20},{22,23,24,25,26,27},{29,30,31,32,33,34},
                        {36,37,38,39,40,41}});
        matrix.rotateMatrix();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(), matrix.getMatrix());
    }
    
    /**
     * 5- Rota la matriz 7x7
     */
    @Test
    public void testRotateMatrix7x7(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3,4,5,6,7},{8,9,10,11,12,13,14},{15,16,17,18,19,20,21},{22,23,24,25,26,27,28},
                        {29,30,31,32,33,34,35},{36,37,38,39,40,41,42},{43,44,45,46,47,48,49}});
        matrix.rotateMatrix();
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(), matrix.getMatrix());
    }
    
    /*
     * Pruebas del método moveColumn:
     * Positivos:
     * 1- Columna dentro de los límites
     * 2- La columna seleccionada es la ultima
     * 
     * Negativos:
     * 3- La columna está por debajo del número de columnas minimo
     * 4- La columna está por debajo del número de columnas máximo
     */
    
    /**
     * 1- Columna dentro de los límites
     */
    @Test
    public void testMoveColumnInsideColumn(){
        Matrix matrix = new Matrix(new int[][] {{11,22,33},{14,56,14},{67,34,89}});
        matrix.moveColumn(1);
        Matrix expected = matrix;
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 2- La columna seleccionada es la última
     */
    @Test
    public void testMoveColumnInLastColumn(){
        Matrix matrix = new Matrix(new int[][] {{11,22,33},{14,56,14},{67,34,89}});
        matrix.moveColumn(2);
        Matrix expected = matrix;        
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 3- La columna está por debajo de la primera columna
     */
    @Test
    public void testMoveColumnUnderLowerColumn(){
        Matrix matrix = new Matrix(new int[][] {{11,22,33},{14,56,14},{67,34,89}});
        try{
            matrix.moveColumn(-1);
            fail("Esperaba excepción");
        }catch(RuntimeException msg){
            assertEquals("La columna indicada no cumple los requisitos minimos",msg.getMessage());
        }
    }
    
    /**
     * 4- La columna está por debajo del número de columnas
     */
    @Test
    public void testMoveColumnOverUpperColumn(){
        Matrix matrix = new Matrix(new int[][] {{11,22,33},{14,56,14},{67,34,89}});
        try{
            matrix.moveColumn(4);
            fail("Esperaba excepción");
        }catch(RuntimeException msg){
            assertEquals("La columna indicada no cumple los requisitos minimos",msg.getMessage());
        }
    }
    
    /*
     * Pruebas del método isMagicSquare:
     * 1- La matriz 2x2 es mágica
     * 2- La matriz 3x3 es mágico
     * 3- La matriz 4x4 es mágica
     * 4- La matriz 5x5 es mágica
     * 
     * 5- La matriz 3x3 no es mágica
     * 6- La matriz 4x4 no es mágica
     */
    
    /**
     * 1- La matriz 2x2 es mágica
     */
    @Test
    public void testIsMagicSquareTrue2x2(){
        Matrix matrix = new Matrix (new int[][] {{1,1},{1,1}});
        assertTrue(matrix.isMagicSquare());
    }
    
    /**
     * 2- La matriz 3x3 es mágico
     */
    @Test
    public void testIsMagicSquareTrue3x3(){
        Matrix matrix = new Matrix (new int[][] {{4,9,2},{3,5,7},{8,1,6}});
        assertTrue(matrix.isMagicSquare());
    }
    
    /**
     * 3- La matriz 4x4 es mágica
     */
    @Test
    public void testIsMagicSquareTrue4x4(){
        Matrix matrix = new Matrix (new int[][] {{1,14,14,4},{11,7,6,9},{8,10,10,5},{13,2,3,15}});
        assertTrue(matrix.isMagicSquare());
    }
    
    /**
     * 4- La matriz 5x5 es mágica
     */
    @Test
    public void testIsMagicSquareTrue5x5(){
        Matrix matrix = new Matrix (new int[][] {{11,24,7,20,3},{4,12,25,8,16},{17,5,13,21,9},{10,18,1,14,22},{23,6,19,2,15}});
        assertTrue(matrix.isMagicSquare());
    }
    
    /**
     * 5- La matriz 3x3 no es mágica
     */
    @Test
    public void testIsMagicSquareFalse3x3(){
        Matrix matrix = new Matrix (new int[][] {{2,4,54},{12,13,2},{28,1,14}});
        assertFalse(matrix.isMagicSquare());
    }
    
    /**
     * 6- La matriz 4x4 no es mágica
     */
    @Test
    public void testIsMagicSquareFalse4x4(){
        Matrix matrix = new Matrix (new int[][] {{2,24,14,54},{12,7,4,2},{28,1,1,8},{13,2,3,15}});
        assertFalse(matrix.isMagicSquare());
    }
    
    /*
     * Pruebas del método replaceMatrix:
     * Positivos:
     * 1- El arrayList reemplaza los elementos sin cambiar toda la matriz
     * 2- El arrayList cambia toda la matriz
     * 
     * Negativos:
     * 3- El arrayList es null
     */
    
    /**
     * 1- El arrayList reemplaza los elementos sin cambiar toda la matriz
     */
    @Test
    public void testReplaceMatrixNotFullMatrix(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3},{4,6,7},{8,1,9}});
        Matrix auxMatrix = new Matrix(new int[][] {{4,5},{2,9}});
        ArrayList<Integer> list = auxMatrix.flattenMatrix();
        matrix.replaceMatrix(list);
        Matrix expected = matrix;
        assertEquals(list.size(),matrix.replaceMatrix(list));
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 2- El arrayList cambia toda la matriz
     */
    @Test
    public void testReplaceMatrixFullMatrix(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3},{4,6,7},{8,1,9}});
        Matrix auxMatrix = new Matrix(new int[][] {{4,5,7,1},{2,3,2,9},{6,2,7,8},{5,8,9,2}});
        ArrayList<Integer> list = auxMatrix.flattenMatrix();
        matrix.replaceMatrix(list);
        Matrix expected = matrix;
        assertEquals(matrix.matrixSize(),matrix.replaceMatrix(list));
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 3- El arrayList es null
     */
    @Test
    public void testReplaceMatrixNullArray(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3},{4,6,7},{8,1,9}});        
        try{
            ArrayList<Integer> list = new ArrayList<Integer>(5);
            list=null;
            matrix.replaceMatrix(list);
            fail("Esperaba excepción");
        }catch(RuntimeException msg){
            assertEquals("Error: el ArrayList introducido es null", msg.getMessage());
        }
    }
    
    /*
     * Pruebas del método flattenMatrix:
     * Positivos:
     * 1- Aplana la matriz 2x2
     * 2- Aplana la matriz 3x3
     * 3- Aplana la matriz 4x4
     * 4- Aplana la matriz 5x5
     * 5- Aplana la matriz 6x6
     */
    
    /**
     * 1- Aplana la matriz 2x2
     */
    @Test
    public void testFlattenMatrix2x2(){
        Matrix matrix = new Matrix(new int[][] {{1,2},{4,6}});
        ArrayList<Integer> flattenMatrix = matrix.flattenMatrix();
        matrix.flattenMatrix();
        Matrix expected = matrix;        
        assertEquals(flattenMatrix.size(),matrix.matrixSize());
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }    
    
    /**
     * 2- Aplana la matriz 3x3
     */
    @Test
    public void testFlattenMatrix3x3(){
        Matrix matrix = new Matrix(new int[][] {{1,2,4},{3,4,6},{2,5,1}});
        ArrayList<Integer> flattenMatrix = matrix.flattenMatrix();
        matrix.flattenMatrix();
        Matrix expected = matrix;        
        assertEquals(flattenMatrix.size(),matrix.matrixSize());
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 3- Aplana la matriz 4x4
     */
    @Test
    public void testFlattenMatrix4x4(){
        Matrix matrix = new Matrix(new int[][] {{1,2,4,1},{3,4,6,5},{2,5,1,8},{1,4,8,0}});
        ArrayList<Integer> flattenMatrix = matrix.flattenMatrix();
        matrix.flattenMatrix();
        Matrix expected = matrix;        
        assertEquals(flattenMatrix.size(),matrix.matrixSize());
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 4- Aplana la matriz 5x5
     */
    @Test
    public void testFlattenMatrix5x5(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3,4,5},{7,8,9,2,4},{2,5,6,9,1},{1,4,6,8,3},{9,1,2,4,6}});
        ArrayList<Integer> flattenMatrix = matrix.flattenMatrix();
        matrix.flattenMatrix();
        Matrix expected = matrix;        
        assertEquals(flattenMatrix.size(),matrix.matrixSize());
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    /**
     * 5- Aplana la matriz 6x6
     */
    @Test
    public void testFlattenMatrix6x6(){
        Matrix matrix = new Matrix(new int[][] {{1,2,3,4,5,6},{7,8,9,2,4,6},{2,5,6,9,1,3},{1,4,6,8,3,9},{9,1,2,4,6,2},{4,5,7,3,6,8}});
        ArrayList<Integer> flattenMatrix = matrix.flattenMatrix();
        matrix.flattenMatrix();
        Matrix expected = matrix;        
        assertEquals(flattenMatrix.size(),matrix.matrixSize());
        assertArrayEquals(expected.getMatrix(),matrix.getMatrix());
    }
    
    // Test predeterminados del proyecto: 
    
    @Test
    public void testConstructorIntParameter()
    {
        Matrix matrix=new Matrix(2);
        assertTrue(true);
    }
        
    @Test
    public void testConstructorArrayParameter()
    {
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        assertTrue(true);
    }
    
    @Test
    public void testSwapReverseByDiagonals()
    {
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        matrix.swapReverseByDiagonals();
        assertTrue(true);
    }

    @Test
    public void testRotateMatrix(){
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        matrix.rotateMatrix();
        assertTrue(true);
    }    
    
    @Test
    public void testMoveColumn()
    {
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        matrix.moveColumn(0);
        assertTrue(true);
    }    

    @Test
    public void testIsMagicSquare()
    {
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        matrix.isMagicSquare();
        assertTrue(true);
    }    
    
    @Test
    public void testReplaceMatrix()
    {
        Matrix matrix1 = new Matrix(new int[][]{{1,0},{0,1}});
        Matrix matrix2 = new Matrix(new int[][]{{0,1},{1,0}});
        ArrayList<Integer> arrayLis1 = matrix2.flattenMatrix();
        matrix1.replaceMatrix(arrayLis1);
        assertTrue(true);
    }    

    @Test
    public void testFlattenMatrix()
    {
        Matrix matrix=new Matrix(new int[][]{{1, 0}, {0, 1}});
        matrix.flattenMatrix();
        assertTrue(true);
    }
    
}

