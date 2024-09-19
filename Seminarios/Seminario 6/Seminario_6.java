
/**
 * Write a description of class Seminario_6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seminario_6
{
    /**
     * Ejercicio 3:
     *
     * @param   v1, vector de enteros
     * @param   v2, vector de enteros
     * @return un vector de enteros resultado de la concatenación de los que se recibe como parámetrs
     */
    
    public int[] concatenate (int[] v1, int[] v2){
        checkParam (v1 != null || v2 != null, "Error: alguno de los vectores es null");
        checkParam (v1.length != 0 || v2.length != 0, "Error: alguno de los vectores tiene 0 coordenadas");
        
        int[] result = new int[v1.length + v2.length];
        for (int i=0; i < v1.length; i++){
            result[i]  = v1[i];
        }
        
        for (int i=0; i < v1.length; i++){
            result[i+v1.length]  = v2[i];
        }
        return result;
    }
    
    /**
     * Método que controla el parámetro y devuelve un mensaje
     * 
     */
    private void checkParam(boolean condition, String msg){
        if(! condition){
            throw new RuntimeException(msg);
        }
    }
    
    /**
     * Ejercicio 4:
     * 
     * 
     */
    public int[][] columsSwap(int[][] input, int column1, int column2){
        checkParam (input != null , "Error: la matriz es null");
        checkParam (input.length != 0 ,"Error: la matriz es null");
        checkParam(column1 >= 0 && column1 < input.length, "Error en el indice de la columna col");
        checkParam(column2 >= 0 && column2 < input.length, "Error en el indice de la columna col");       
        
        for (int i=0; i< input.length; i++){
            int aux = input[i][column1];
            input[i][column1] = input[i][column2];
            input[i][column2] = aux;            
        }
        return input;
    }
    
    /**
     * Ejercicio 5:
     * 
     * 
     */
    public int[][] traspose(int[][] input){
        checkParam (input != null , "Error: la matriz es null");
        checkParam (input.length != 0 ,"Error: la matriz es null");
        checkParam (isRowsSize(), "Error: las filas no tienen el mismo tamaño");
        
        int[][] output = new int[input[0].length][input.length];
        
        for(int i=0; i< input.length; i++){
            for(int j=0; j<input[0].length; j++){
                output[j][i] = input[i][j];
            }
        }
        return output;        
    }
}
