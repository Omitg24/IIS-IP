
/**
 * Write a description of class Potentiometer here.
 * 
 * @author Omar Teixeira González
 * @version 23-10-20
 */
public class Potentiometer
{
    //constantes
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;
    
    public static final int DEFAULT_POSITION = 10;
    
    //atributos variables
    private int position;

    /**
     * Constructor sin parámetros para la clase Potentiometer
     */
    public Potentiometer()
    {
        movePosition(DEFAULT_POSITION);
    }
    
    /**
     * Constructor con parámetro Potentiometer para la clase Potentiometer
     */
    public Potentiometer(int position)
    {
        this();
        movePosition(position);
    }

    /**
     * Comprueba que el parametro es o no correcto
     *
     * @param  condition, condición a evaluar, de tipo boolean
     * @return     true o false en función del parámetro
     */
    private boolean checkParam(boolean condition)
    {
        return condition;
    }
    
    /**
     * Método que devuelve el valor de la posicion
     * 
     * @return position, el valor de la posición, de tipo int
     */
    public int getPosition(){
        return position;
    }
    
    /**
     * Método que modifica el valor de la posicion
     * 
     * @param position, nuevo valor para la posición, de tipo int
     */
    public void movePosition(int position){
        if(checkParam(position >= MIN_POSITION && position <= MAX_POSITION)){
            this.position = position;
        }
    }
    
    /**
     * Método que devuelve la cadena con el valor de la temperatura correspondiente
     * 
     * @return toString, cadena con el valor correspondiente, de tipo String
     */
    public String toString(){
        return getPosition() + "";
    }
}
