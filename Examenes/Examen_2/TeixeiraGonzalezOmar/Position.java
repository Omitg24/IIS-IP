
/**
 * Clase Position:
 * Tarea No Presencial Sesión 13:
 *      Implementacion de set y get de column
 * 
 * @author Omar Teixeira González
 * @version 14-12-20
 */
public class Position
{
    // atributos variables
    private int row;
    private int column;

    /**
     * Constructor con parámetros row y column para la clase Position
     */
    public Position(int row, int column)
    {
        setRow(row);
        setColumn(column);
    }

    /**
     * Método que modifica el valor del atributo row
     * 
     * @param   row, fila del avión de tipo int
     */
    private void setRow(int row)
    {
        this.row=row;
    }
    
    /**
     * Método que modifica el valor del atributo column
     * 
     * @param   column, columna del avión de tipo int
     */
    private void setColumn(int column)
    {
        this.column=column;
    }    
    
    /**
     * Método que devuelve la fila
     * 
     * @return  row
     */
    public int getRow(){
        return row;
    }
    
    /**
     * Método que devuelve la columna
     * 
     * @returm  column
     */
    public int getColumn(){
        return column;
    }
}
