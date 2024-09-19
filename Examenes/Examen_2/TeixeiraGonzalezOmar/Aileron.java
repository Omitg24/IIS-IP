
/**
 * Clase Aileron:
 *      Constructor sin parámetros
 *      Constructor con parámetro
 *      Métodos set y get del atributo Angle
 *      Método roll
 * 
 * @author Omar Teixeira González
 * @version 14-12-20
 */
public class Aileron
{
    //constantes
    public static final double MIN_ANGLE = -65.0;     //mínimo angulo posible
    public static final double MAX_ANGLE = 65.0;      //máximo angulo posible
    public static final double DEAULT_ANGLE = 0.0;      //ángulo por defecto
    
    // atributos variables
    private double angle;       //atributo ángulo de tipo double

    /**
     * Constructor sin parámetros para la clase Aileron
     */
    public Aileron()
    {
        setAngle(DEAULT_ANGLE);
    }
    
    /**
     * Constructor con parámetro angle para la clase Aileron
     */
    public Aileron(double angle)
    {
        this();
        setAngle(angle);
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
     * Método que devuelve el ángulo del alerón del avión
     * 
     * @return     angle, ángulo del alerón del avión, de tipo double
     */
    public double getAngle()
    {
       return angle;
    }
    
    /**
     * Método que modifica el valor del atributo angle
     * 
     * @param   angle, nuevo ángulo para la clase Aileron, de tipo double
     */
    private void setAngle(double angle){
        if(checkParam(angle >= MIN_ANGLE && angle <= MAX_ANGLE)){
            this.angle = angle; 
        }
    }
    
    /**
     * Método que modifica el valor del ángulo del alerón al recibido como parámetro
     * 
     * @param   angle, nuevo angulo que tomara el alerón, de tipo double
     */
    public void roll(double angle){
        if(checkParam(angle >= MIN_ANGLE && angle <= MAX_ANGLE)){
            setAngle(angle);
        }
    }
}
