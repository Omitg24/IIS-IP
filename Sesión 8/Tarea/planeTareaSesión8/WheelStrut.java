
/**
 * Modela el puntal del avi�n
 * Tendr� rueda izquierda y derecha y estado para indicar si está o no desplegada
 * 
 * Sesi�n 7:
 *      Creaci�n de atributos (boolean deployed, Wheel leftWheel, Wheel rightWheel)
 *      M�todo test
 *      M�todo toString
 *      M�todo print
 *      M�todos deploy y retract
 * Tarea No Presencial Sesi�n 7:
 *      M�todo print
 * @author  Omar Teixeira Gonz�lez
 * @version 28-10-20
 */
public class WheelStrut
{
    public static final double BOEING_737_PRESSURE = 1739; //Mb presión
    public static final boolean IS_DEPLOYED = true;
       
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
     * Constructor que recibe valores para las ruedas
     */
    public WheelStrut (boolean deployed) {
        this();
        setDeployed(deployed);
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
    
    /**
     * M�todo que despliega el puntal
     */
    public void deploy(){
        setDeployed(IS_DEPLOYED);
    }
    
    /**
     * M�todo que repliega el puntal
     */
    public void retract(){
        setDeployed(! IS_DEPLOYED);
    }
}
