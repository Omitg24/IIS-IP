
/**
 * Modela el puntal del aviÛn
 * Tendr· rueda izquierda y derecha y estado para indicar si est√° o no desplegada
 * 
 * SesiÛn 7:
 *      CreaciÛn de atributos (boolean deployed, Wheel leftWheel, Wheel rightWheel)
 *      MÈtodo test
 *      MÈtodo toString
 *      MÈtodo print
 *      MÈtodos deploy y retract
 * Tarea No Presencial SesiÛn 7:
 *      MÈtodo print
 * @author  Omar Teixeira Gonz·lez
 * @version 28-10-20
 */
public class WheelStrut
{
    public static final double BOEING_737_PRESSURE = 1739; //Mb presi√≥n
    public static final boolean IS_DEPLOYED = true;
       
    private boolean deployed;   // indica si el puntal est√° desplegado
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
     * Control de par√°metro
     * @param true si se cumple la condici√≥n
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
     * Comprueba que ambas ruedas est√©n operativas (tienen suficiente presi√≥n)
     * @return true si ambas est√°n operativas
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
     *    Deployed: true ‚Äì Test: true [L: true] [R: true]
     * @return datos del puntal
     */
    public String toString() {       
        String result = String.format("Deployed: %b ‚Äì Test: %b [L: %b] [R: %b]",
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
     * Test ... OK (Fail si fall√≥)
     * 
     * RIGHT Wheel
     * Max Pressure....... 34500 Mb.
     * Current Pressure... 5205 Mb (15,08%)
     * Test ... OK (Fail si fall√≥)
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
     * @return DEPLOYED o RETRACTED en funci√≥n de lo que sea
     */
    private String deployedToString() {
        if (isDeployed()) {
            return "DEPLOYED";
        } else {
            return "RETRACTED";
        }
    }
    
    /**
     * MÈtodo que despliega el puntal
     */
    public void deploy(){
        setDeployed(IS_DEPLOYED);
    }
    
    /**
     * MÈtodo que repliega el puntal
     */
    public void retract(){
        setDeployed(! IS_DEPLOYED);
    }
}
