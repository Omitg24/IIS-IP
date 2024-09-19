
/**
 * Clase Aileron:
 *      Constructor sin par�metros
 *      Constructor con par�metro
 *      M�todos set y get del atributo Angle
 *      M�todo roll
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 14-12-20
 */
public class Aileron
{
    //constantes
    public static final double MIN_ANGLE = -65.0;     //m�nimo angulo posible
    public static final double MAX_ANGLE = 65.0;      //m�ximo angulo posible
    public static final double DEAULT_ANGLE = 0.0;      //�ngulo por defecto
    
    // atributos variables
    private double angle;       //atributo �ngulo de tipo double

    /**
     * Constructor sin par�metros para la clase Aileron
     */
    public Aileron()
    {
        setAngle(DEAULT_ANGLE);
    }
    
    /**
     * Constructor con par�metro angle para la clase Aileron
     */
    public Aileron(double angle)
    {
        this();
        setAngle(angle);
    }
    
    /**
     * Comprueba que el parametro es o no correcto
     *
     * @param  condition, condici�n a evaluar, de tipo boolean
     * @return     true o false en funci�n del par�metro
     */
    private boolean checkParam(boolean condition)
    {
        return condition;
    }
    
    /**
     * M�todo que devuelve el �ngulo del aler�n del avi�n
     * 
     * @return     angle, �ngulo del aler�n del avi�n, de tipo double
     */
    public double getAngle()
    {
       return angle;
    }
    
    /**
     * M�todo que modifica el valor del atributo angle
     * 
     * @param   angle, nuevo �ngulo para la clase Aileron, de tipo double
     */
    private void setAngle(double angle){
        if(checkParam(angle >= MIN_ANGLE && angle <= MAX_ANGLE)){
            this.angle = angle; 
        }
    }
    
    /**
     * M�todo que modifica el valor del �ngulo del aler�n al recibido como par�metro
     * 
     * @param   angle, nuevo angulo que tomara el aler�n, de tipo double
     */
    public void roll(double angle){
        if(checkParam(angle >= MIN_ANGLE && angle <= MAX_ANGLE)){
            setAngle(angle);
        }
    }
}
