
/**
 * Modela el puntal del avión
 * Tendrá rueda izquierda y derecha y estado para indicar si está o no desplegada
 * 
 * @author  Omar Teixeira Gonz�lez
 * @version 28-10-20
 */
public class WheelStrut
{
    public static final double BOEING_737_PRESSURE = 1739; //Mb presión
    public static final boolean IS_DEPLOYED = true;
    public static final boolean IS_RETRACTED = false;
    
    private boolean deployed;   // indica si el puntal está desplegado
    private Wheel leftWheel;
    private Wheel rightWheel;

    /**
     * Constructor for objects of class WheelStrut
     */
    public WheelStrut()
    {
        setDeployed(IS_DEPLOYED);
        setLeftWheel(new Wheel(BOEING_737_PRESSURE,BOEING_737_PRESSURE));
        setRightWheel(new Wheel(BOEING_737_PRESSURE,BOEING_737_PRESSURE));
    }

    /**
     * Constructor que recibe valores para las ruedas
     */
    public WheelStrut (boolean deployed, Wheel left, Wheel right) {
        this();
        setDeployed(deployed);
        setLeftWheel(left);
        setRightWheel(right);
    }
    
    /**
     * Modifica el atributo deployed
     * 
     * @param  state, nuevo valor para deployed, tipo booleano
     * 
     */
    private void setDeployed(boolean state)
    {
        deployed = state;
    }
    
    /**
     * Modifica el atributo leftWheel
     * 
     * @param  wheel, nuevo valor para rueda izquierda, tipo Wheel
     * 
     */
    private void setLeftWheel(Wheel wheel)
    {
        if (checkParam(wheel != null)) {
            leftWheel = wheel;
        }
    }
    
    /**
     * Control de parámetro
     * @param true si se cumple la condición
     */
    private boolean checkParam(boolean condition) {
        return condition;
    }
    
     /**
     * Modifica el atributo rightWheel
     * 
     * @param  wheel, nuevo valor para rueda derecha, tipo Wheel
     * 
     */
    private void setRightWheel(Wheel wheel)
    {
        if (checkParam(wheel != null)) {
            rightWheel = wheel;
        }
    }
    
    /**
     * Devuelve el valor
     * @param valor de deployed, de tipo boolean
     */
    public boolean isDeployed() {
        return deployed;
    }
    
    /**
     * Devuelve el valor
     * @param valor de leftWheel, de tipo Wheel
     */
    public Wheel getLeftWheel() {
        return leftWheel;
    }
    
    /**
     * Devuelve el valor
     * @param valor de rightWheel, de tipo Wheel
     */
    public Wheel getRightWheel() {
        return rightWheel;
    }
    
    /**
     * Comprueba que ambas ruedas estén operativas (tienen suficiente presión)
     * @return true si ambas están operativas
     */
    public boolean test() {
        if(leftWheel.test() == true  && rightWheel.test() == true) {
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Devuelve datos del puntal con el formato:
     *    Deployed: true – Test: true [L: true] [R: true]
     * @return datos del puntal
     */
    public String toString() {       
        String result = String.format("Deployed: %b – Test: %b [L: %b] [R: %b]",
                                       isDeployed(),
                                       test(),
                                       leftWheel.test(),
                                       rightWheel.test() );
        return result;
    }
    
    /**
     * Imprime por pantalla:
     * 
     * RETRACTED (o DEPLOYED)
     * Test............... FALSE.
     * 
     * LEFT Wheel
     * Max Pressure....... 34500 Mb.
     * Current Pressure... 32000 Mb (92,75%)
     * Test ... OK (Fail si falló)
     * 
     * RIGHT Wheel
     * Max Pressure....... 34500 Mb.
     * Current Pressure... 5205 Mb (15,08%)
     * Test ... OK (Fail si falló)
     * 
     */
    public void print() {
        System.out.printf("%s%n", deployedToString()); 
        System.out.printf("Test.................. %b%n", test());
        System.out.println();
        System.out.printf("LEFT Wheel%n");
        leftWheel.print();
        System.out.println();
        System.out.printf("RIGHT Wheel%n");
        rightWheel.print();
    }
        
    /**
     * Devuelve cadena con el valor de deployed
     * @return DEPLOYED o RETRACTED en función de lo que sea
     */
    private String deployedToString() {
        if (isDeployed()) {
            return "DEPLOYED";
        } else {
            return "RETRACTED";
        }
    }
        
}
