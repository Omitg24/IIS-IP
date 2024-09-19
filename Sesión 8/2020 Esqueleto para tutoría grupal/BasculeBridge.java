/**
 * Ejercicio de tutoría grupal I
 * Control de un puente levadizo a través de un controlador. 
 * 
 * @author Omar Teixeira González
 * @version 6-10-20
 */
public class BasculeBridge
{
    //constantes
    public static final int MIN_SLOPE = 0;
    public static final int MAX_SLOPE = 60;
    //atributos variables
    private float slope;        // inclinación del puente     

     /**
     * Constructor con un parámetro 
     * @param angle valor entero para almacenar el ángulo [0º y 60º]
     */
    public BasculeBridge(float angle)
    {
        setSlope(angle);
    }
    
    /**
     * Modifica la inclinación del puente
     * 
     * @param newSlope valor entero, nuevo ángulo de inclinación
     *
     */
    private void setSlope(float newSlope)
    {
        if (newSlope >= MIN_SLOPE && newSlope <= MAX_SLOPE){
          slope = newSlope;
        }
    }
    
    /**
     * @return valor entero correspondiente al atributo ángulo  
     */
    public float getSlope()
    {
        return slope;
    }
    
    /**
     *  Incrementa la posición en un valor igual al parámetro de entrada
     *  @param  increment valor entero positivo correspondiente al incremento de ángulo a realizar en la inclinación del puente  
     */
    public void raiseBridge(float increment)
    {
         if(increment>=0){
             setSlope(getSlope()+increment);
         }
    }    
    
    /**
     *  Decrementa la posición en un valor igual al parámetro de entrada
     *  @param decrement valor entero positivo correspondiente al decremento de ángulo que se realizará en la inclinación del puente 
     */
    public void dropBridge(float decrement)
    {
         if(decrement>=0){
             setSlope(getSlope()-decrement);
         }
    }    
    
    
}
