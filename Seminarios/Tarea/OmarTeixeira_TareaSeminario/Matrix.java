import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;
/**
 * Clase Matrix para la Tarea de Seminario:
 *  -> Implementación de constructores con parámetros: size e int[][]
 *  -> Implementación de variables de instancia: matrix; y constantes: MIN_DIMENSION, MAX_DIMENSION. MIN_NUMBER, MAX_NUMBER
 *  -> Implementación de métodos: swapReverseByDiagonals(), rotateMatrix(), moveColumn(), print(), isMagicSquare(), replaceMatrix(), flattenMatrix()
 * 
 *  -> Creación de pruebas de los métodos en la clase MatrixTest.
 * 
 * @author Omar Teixeira González
 * @version 11-12-2020 (última versión)
 */
public class Matrix
{
    // constantes:
    public static final int MIN_DIMENSION = 2;
    public static final int MAX_DIMENSION = 10;
    
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 99;
    
    // atributos variables/ variables de instancia:
    private int[][] matrix;

    /**
     * Constructor con parámtetro size para la clase Matrix
     */
    public Matrix(int size)
    {
        checkParam(size >= MIN_DIMENSION && size <= MAX_DIMENSION, "La dimensión debe estar entre " + MIN_DIMENSION + " y " + MAX_DIMENSION);
        matrix = new int[size][size];
        for (int i=0 ; i<matrix.length ; i++){
            for (int j=0 ; j<matrix[i].length ; j++){
                matrix[i][j] = randomNumber();
            }
        }
    }

    /**
     * Constructor con parámtetro matrix para la clase Matrix
     */
    public Matrix(int[][] matrix)
    {
        checkParam(matrix!=null && matrix.length!=0 && matrix.length>=MIN_DIMENSION && matrix[0].length>=MIN_DIMENSION && matrix.length<=MAX_DIMENSION 
                   && matrix[0].length<=MAX_DIMENSION && matrix.length==matrix[0].length , "Error: La matriz no es valida");
        this.matrix=matrix;
    }
    
    /**
     * Método que intercambia los elementos de las dos diagonales invirtiendo los elementos. 
     */
    public void swapReverseByDiagonals(){
        for (int i=0 ; i < matrix.length ; i++){
            int reversedMatrix = matrix[i][i];
            matrix[i][i] = matrix[matrix[i].length-1-i][i];
            matrix[matrix[i].length-1-i][i] = reversedMatrix;            
        }    
    }
    
    /**
     * Método que gira la matriz 90º a la izquierda 
     */
    public void rotateMatrix(){
        for(int i = 0; i < matrix.length/2; i++){
            for(int j = i; j < matrix.length-1-i; j++){
                int rotatedMatrix = matrix[j][i];
                matrix[j][i] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = matrix[matrix.length-j-1][matrix.length-i-1];
                matrix[matrix.length-j-1][matrix.length-i-1] = matrix[matrix.length-i-1][j];
                matrix[matrix.length-i-1][j] = rotatedMatrix;
            }
        }
    }   
     
    /**
     * Método que mueve los elementos de una columna como parámetro al final de la matriz.
     * 
     * @param   column, columna para mover a la izquierda, de tipo int
     */
    public void moveColumn(int column){
        checkParam(column>=0 && column<matrix[0].length,"La columna indicada no cumple los requisitos minimos");
        int[][] movedMatrix = new int[matrix.length][matrix[0].length];
        for (int k = 0; k<matrix.length; k++){
            for (int l = matrix.length-2; l >= column; l--){
                movedMatrix[k][l] = matrix[k][l+1];
            }
        }
                      
        for(int i = 0; i < matrix.length; i++){
            movedMatrix[i][matrix[i].length-1]=matrix[i][column];
            for(int j = 0; j < column; j++){
                movedMatrix[i][j] = matrix[i][j];
            }
        }
        matrix = movedMatrix;
    }
    
    /**
     * Método que imprime por pantalla la matriz
     */
    public void print(){
        System.out.println("");
        for (int i=0; i<matrix.length;i++){
            for (int j=0; j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    /**
     * Método que devuelve true o false si la matriz es un cuadrado mágico, es decir, la suma de los elementos de las filas, la suma de los elementos de
     * las columnas y la suma de los elementos de las diagonales es la misma.
     * 
     * @return  true o false, en función de si cumple los requisitos.
     */
    public boolean isMagicSquare(){
        int sumaMagic=sumaFilas(0);
        
        for (int i=0; i<matrix.length;i++){
            if(sumaFilas(i)!=sumaMagic || sumaColumnas(i)!=sumaMagic || sumaDiagonalPrincipal()!=sumaMagic || sumaDiagonalSecundaria()!=sumaMagic){
                return false;
            }
        }        
        return true;
    }
    
    /**
     * Método que recibe un arrayList y remplaza todos los elementos en la matiz, y devuelve el numero de elementos que se han reemplazado en la matriz
     * 
     * @return count, numero de elementos que se han modificado en la matriz
     */
    public int replaceMatrix(ArrayList<Integer> flatMatrix){
        checkParam(flatMatrix!=null, "Error: el ArrayList introducido es null");
        int count=0;
        int newMatrixReplaced=0;
        for (int i=0; i<matrix.length;i++){
            for (int j=0; j<matrix[i].length; j++){
                if (newMatrixReplaced<flatMatrix.size()){
                    matrix[i][j]=flatMatrix.get(newMatrixReplaced);
                    count++;
                }
                newMatrixReplaced++;
            }
        }
        return count;
    }
    
    /**
     * Método que devuelve el contenido de la matriz en una sola linea
     */
    public ArrayList<Integer> flattenMatrix(){
        ArrayList<Integer>  convertedMatrix = new ArrayList<Integer>();
            
        for (int i=0; i<matrix.length;i++){
            for (int j=0; j<matrix.length;j++){
                convertedMatrix.add(matrix[i][j]);
            }
        }
        return convertedMatrix;
    }
    
    // Métodos secundarios
    
    /**
     * Método que devuelve la matriz
     * 
     * @return  matrix
     */
    public int[][] getMatrix(){
       int[][] auxMatrix = new int[matrix.length][matrix.length];
       for (int i=0; i<matrix.length;i++){
           for (int j=0; j<matrix.length;j++){
               auxMatrix[i][j]=matrix[i][j];
           }
       }
       return auxMatrix;
    }
    
    /**
     * Devuelve el número de celdas de la matriz
     * 
     * @return size, numero de elementos de la matriz
     */
    public int matrixSize(){
        int size = matrix.length*matrix.length;
        return size;
    }
    
    /**
     * Método que suma la columna introducida como parámetro y devuelve su valor
     * 
     * @param   column, columna a sumar, de tipo int
     * @return  suma, suma de la columna introducida como parámetro
     */
    private int sumaColumnas(int column){
        int suma=0;
        for (int i=0; i<matrix.length;i++){
            suma+=matrix[i][column];
        }
        return suma;
    }
    
    /**
     * Método que suma la fila introducida como parámetro y devuelve su valor
     * 
     * @param   row, fila a sumar, de tipo int
     * @return  suma, suma de la fila introducida como parámetro
     */
    private int sumaFilas(int row){
        int suma=0;
        for (int i=0; i<matrix.length;i++){
            suma+=matrix[row][i];
        }
        return suma;
    }
    
    /**
     * Método que suma la diagonal principal
     * 
     * @return  suma, la suma de la diagonal principal
     */
    private int sumaDiagonalPrincipal(){
        int suma=0;
        for (int i=0; i<matrix.length;i++){
            suma+=matrix[i][i];
        }
        return suma;
    }
    
    /**
     * Método que suma la diagonal secundaria
     * 
     * @return  suma, la suma de la diagonal secundaria
     */
    private int sumaDiagonalSecundaria(){
        int suma=0;
        for (int i=0; i<matrix.length;i++){
            suma+=matrix[i][matrix.length-1-i];
        }
        return suma;
    }
        
    /**
     * Método que devuelve un número aleatorio entre 0 y 99
     * 
     * @return  randomNumber, numero aleatorio entre 0 y 99, de tipo int
     */
    private int randomNumber(){
        Random randomNumber = new Random();
        return randomNumber.nextInt(MAX_VALUE);
    }  
          
    // Controladores
    
    /**
     * Método que controla el parámetro y devuelve una excepción en caso de que no la cumpla
     * 
     * @param   condition, la condición a analizar, de tipo boolean
     *          msg, mensaje que devolverá en caso de que no se cumpla, de tipo String
     * @return  msg, mensaje que devolverá en caso de que no se cumpla, de tipo String
     */
    private void checkParam(boolean condition, String msg){
        if(!condition){
            throw new RuntimeException(msg);
        }
    }
}
