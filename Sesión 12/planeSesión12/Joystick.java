
/**
 * Write a description of class Joystick here.
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 12-11-20
 */
public class Joystick
{
    // constantes
    public static final double MIN_POS = -35.0;     //posici�n m�nima del joystick
    public static final double MAX_POS = 35.0;     //posici�n m�xima del joystick
    public static final double DEFAULT_POS = 0.0;     //posici�n por defecto del joystick    
    
    // atributos variables
    private double position;        //atributo posici�n
    private Aileron left;       //aler�n izquierdo
    private Aileron right;      //aler�n derecho
    
    /**
     * Constructor sin par�metros para la clase Joystick
     */
    public Joystick()
    {
        setPosition(DEFAULT_POS);
        setLeft(new Aileron());
        setRight(new Aileron());
    }
    
    /**
     * Constructor con par�metros position, left y right para la clase Joystick
     */
    public Joystick(double position, Aileron left, Aileron right)
    {
        this();
        setPosition(position);
        setLeft(new Aileron((position/MAX_POS)*left.MAX_ANGLE));
        setRight(new Aileron(-1*(position/MAX_POS)*left.MAX_ANGLE));
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
     * M�todo que devuelve la posici�n del joystick
     * 
     * @return     position, posici�n del joystick del avi�n, de tipo double
     */
    public double getPosition()
    {
       return position;
    }
    
    /**
     * M�todo que modifica el valor del atributo position
     * 
     * @param   position, nueva position para la clase Joystick, de tipo double
     */
    private void setPosition(double position){
        if(checkParam(position >= MIN_POS && position <= MAX_POS)){
            this.position = position; 
        }
    }
    
    /**
     * Modifica el atributo leftAileron
     * 
     * @param  aileron, nuevo valor para el aler�n izquierdo, tipo Aileron
     * 
     */
    private void setLeft(Aileron aileron)
    {
        if (checkParam(aileron != null)) {
            left = aileron;
        }
    }
    
    /**
     * Modifica el atributo rightAileron
     * 
     * @param  aileron, nuevo valor para el aler�n derecho, tipo Aileron
     * 
     */
    private void setRight(Aileron aileron)
    {
        if (checkParam(aileron != null)) {
            right = aileron;
        }
    }
    
    /**
     * M�todo que devuelve el valor del aler�n izquierdo
     * 
     * @returm  left, el valor del aler�n izquierdo, de tipo Aileron
     */
    public Aileron getLeft(){
        return left;
    }
    
    /**
     * M�todo que devuelve el valor del aler�n derecho
     * 
     * @returm  right, el valor del aler�n derecho, de tipo Aileron
     */
    public Aileron getRight(){
        return right;
    }
    
    /**
     * M�todo que mueve el joystick entre sus �ngulos l�mites y modifica el �ngulo de los alerones pertinentes, de manera proporcional
     * 
     * @param   position, nueva posici�n del joystick del avi�n, de tipo double
     */
    public void move(double position){
        if(checkParam(position >= MIN_POS && position <= MAX_POS)){
            this.position = position; 
            left.roll(-1*(position/MAX_POS)*left.MAX_ANGLE);
            right.roll((position/MAX_POS)*right.MAX_ANGLE);
        }
    }
}
