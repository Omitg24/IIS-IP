
/**
 * Clase Position:
 * Tarea No Presencial Sesi�n 13:
 *      Implementacion de set y get de column
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 14-12-20
 */
public class Position
{
    // atributos variables
    private int row;
    private int column;

    /**
     * Constructor con par�metros row y column para la clase Position
     */
    public Position(int row, int column)
    {
        setRow(row);
        setColumn(column);
    }

    /**
     * M�todo que modifica el valor del atributo row
     * 
     * @param   row, fila del avi�n de tipo int
     */
    private void setRow(int row)
    {
        this.row=row;
    }
    
    /**
     * M�todo que modifica el valor del atributo column
     * 
     * @param   column, columna del avi�n de tipo int
     */
    private void setColumn(int column)
    {
        this.column=column;
    }    
    
    /**
     * M�todo que devuelve la fila
     * 
     * @return  row
     */
    public int getRow(){
        return row;
    }
    
    /**
     * M�todo que devuelve la columna
     * 
     * @returm  column
     */
    public int getColumn(){
        return column;
    }
}
