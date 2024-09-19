
/**
 * Write a description of class Joystick here.
 * 
 * @author Omar Teixeira González
 * @version 12-11-20
 */
public class Joystick
{
    // constantes
    public static final double MIN_POS = -35.0;     //posición mínima del joystick
    public static final double MAX_POS = 35.0;     //posición máxima del joystick
    public static final double DEFAULT_POS = 0.0;     //posición por defecto del joystick    
    
    // atributos variables
    private double position;        //atributo posición
    private Aileron left;       //alerón izquierdo
    private Aileron right;      //alerón derecho
    
    /**
     * Constructor sin parámetros para la clase Joystick
     */
    public Joystick()
    {
        setPosition(DEFAULT_POS);
        setLeft(new Aileron());
        setRight(new Aileron());
    }
    
    /**
     * Constructor con parámetros position, left y right para la clase Joystick
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
     * @param  condition, condición a evaluar, de tipo boolean
     * @return     true o false en función del parámetro
     */
    private boolean checkParam(boolean condition)
    {
        return condition;
    }
    
    /**
     * Método que devuelve la posición del joystick
     * 
     * @return     position, posición del joystick del avión, de tipo double
     */
    public double getPosition()
    {
       return position;
    }
    
    /**
     * Método que modifica el valor del atributo position
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
     * @param  aileron, nuevo valor para el alerón izquierdo, tipo Aileron
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
     * @param  aileron, nuevo valor para el alerón derecho, tipo Aileron
     * 
     */
    private void setRight(Aileron aileron)
    {
        if (checkParam(aileron != null)) {
            right = aileron;
        }
    }
    
    /**
     * Método que devuelve el valor del alerón izquierdo
     * 
     * @returm  left, el valor del alerón izquierdo, de tipo Aileron
     */
    public Aileron getLeft(){
        return left;
    }
    
    /**
     * Método que devuelve el valor del alerón derecho
     * 
     * @returm  right, el valor del alerón derecho, de tipo Aileron
     */
    public Aileron getRight(){
        return right;
    }
    
    /**
     * Método que mueve el joystick entre sus ángulos límites y modifica el ángulo de los alerones pertinentes, de manera proporcional
     * 
     * @param   position, nueva posición del joystick del avión, de tipo double
     */
    public void move(double position){
        if(checkParam(position >= MIN_POS && position <= MAX_POS)){
            this.position = position; 
            left.roll(-1*(position/MAX_POS)*left.MAX_ANGLE);
            right.roll((position/MAX_POS)*right.MAX_ANGLE);
        }
    }
}
