import java.util.ArrayList;
/**
 * Modela el puntal del avión
 * Tendrá rueda izquierda y derecha y estado para indicar si estÃ¡ o no desplegada
 * 
 * Sesión 7:
 *      Creación de atributos (boolean deployed, Wheel leftWheel, Wheel rightWheel)
 *      Método test
 *      Método toString
 *      Método print
 *      Métodos deploy y retract
 * Tarea No Presencial Sesión 7:
 *      Método print
 * Tarea No Presencial Sesión 10:
 *      Modificar el constructor para tener un arrayList de ruedas     
 *      
 * @author  Omar Teixeira González
 * @version 14-12-20
 */
public class WheelStrut
{
    //constantes
    public static final double BOEING_737_PRESSURE = 1739; //Mb presiÃ³n
    public static final boolean IS_DEPLOYED = true;
    public static final int DEFAULT_NUMBER_OF_WHEELS = 4;
    
    //atributos varibales
    private boolean deployed;   // indica si el puntal estÃ¡ desplegado
    //private Wheel leftWheel;
    //private Wheel rightWheel;
    
    private ArrayList<Wheel> wheels;

    /**
     * Constructor que cree un puntal con una lista de 4 ruedas
     */
    public WheelStrut()
    {
        setDeployed(IS_DEPLOYED);
        wheels = new ArrayList<Wheel>();
        setWheels(DEFAULT_NUMBER_OF_WHEELS);
        //setLeftWheel(new Wheel(BOEING_737_PRESSURE,BOEING_737_PRESSURE));
        //setRightWheel(new Wheel(BOEING_737_PRESSURE,BOEING_737_PRESSURE));
    }
    
    /**
     * Constructor con parámetr NumberOfWheels
     */
    public WheelStrut(int numberOfWheels){
        this();
        setDeployed(IS_DEPLOYED);
        wheels = new ArrayList<Wheel>();
        setWheels(numberOfWheels);
    }
    
    /**
     * Método que crea una lista con el número de ruedas que reciba como parámetro y la asigna al atributo Wheels
     * 
     * @param   numero de ruedas
     */
    private void setWheels(int numberOfWheels){
        checkParam(numberOfWheels > 0, "El número de ruedas debe ser mayor que 0");
        wheels = new ArrayList<Wheel>();
        for(int i=1; i<=numberOfWheels; i++){
            wheels.add(new Wheel(BOEING_737_PRESSURE,BOEING_737_PRESSURE));
        }
    }

    /**
     * Constructor que recibe valores para las ruedas
     */
    public WheelStrut (boolean deployed, ArrayList<Wheel> wheels) {
        this();
        setDeployed(deployed);
        setWheels(wheels);
    }
    
    /**
     * Constructor que recibe valores para las ruedas
     */
    public WheelStrut (boolean deployed) {
        this();
        setDeployed(deployed);
    }
    
    /**
     * Método que asigna valor a wheels
     * 
     * @param nueva lista de ruedas
     */
    private void setWheels(ArrayList<Wheel> list){
        checkParam(list!=null);
        checkParam(list.size() > 0, "La lista recibida esta vacía");
        this.wheels=list;
    }
    
    /**
     * Método que controla el parámetro, si no se cumple lanza un RuntimeException
     * 
     * @param   condition, la condición, de tipo boolean
     */
    private void checkParam(boolean condition){
        if(condition==false){
            throw new RuntimeException();
        }
    }
    
    /**
     * Método que controla el parámetro, si no se cumple lanza un RuntimeException
     * 
     * @param   condition, la condición, de tipo boolean
     *          msg, un mensaje, de tipo String
     */
    private void checkParam(boolean condition, String msg){
        if(condition==false){
            throw new RuntimeException(msg);
        }
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
     * Devuelve el valor
     * @param valor de deployed, de tipo boolean
     */
    public boolean isDeployed() {
        return deployed;
    }
        
    /**
     * Comprueba que todas las ruedas estÃ©n operativas (tienen suficiente presiÃ³n)
     * @return true si ambas estÃ¡n operativas
     */
    public boolean test() {
        for (Wheel wheelToTest : wheels){
            if(wheelToTest.test() == false){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Devuelve datos del puntal con el formato:
     *    Deployed: true â€“ Test: true [1: true] [2: true] [3: true] [4: true] ...
     * @return datos del puntal
     */
    public String toString() {       
        String result = String.format("Deployed: %b - Test: %b ",
                                       isDeployed(),
                                       test());
        int position = 1;                               
        for (Wheel wheelToString: wheels){
            result = result + String.format("[%d: %b]", position, wheelToString.test());                               
            position++;
        }        
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
     * Test ... OK (Fail si fallÃ³)
     * 
     * RIGHT Wheel
     * Max Pressure....... 34500 Mb.
     * Current Pressure... 5205 Mb (15,08%)
     * Test ... OK (Fail si fallÃ³)
     * 
     */
    public void print() {
        System.out.printf("%s%n", deployedToString()); 
        System.out.printf("Test.................. %b%n", test());
        for(int i=0; i<wheels.size(); i++){
            System.out.printf("Wheel %d%n", i+1);
            wheels.get(i).print();
        }
        System.out.println();        
    }
        
    /**
     * Devuelve cadena con el valor de deployed
     * @return DEPLOYED o RETRACTED en funciÃ³n de lo que sea
     */
    private String deployedToString() {
        if (isDeployed()) {
            return "DEPLOYED";
        } else {
            return "RETRACTED";
        }
    }
    
    /**
     * Método que despliega el puntal
     */
    public void deploy(){
        setDeployed(IS_DEPLOYED);
    }
    
    /**
     * Método que repliega el puntal
     */
    public void retract(){
        setDeployed(! IS_DEPLOYED);
    }
       
    /**
     * Método que devuelve el numero de ruedas que hay en la colección
     */
    public int size(){
        return wheels.size();
    }
    
    /**
     * Método que devuelve la rueda situada en la posición recibida como parámetro
     * 
     * @param posición en la lista
     * @return  la rueda situada en la posicion
     */
    public Wheel getWheel(int index){
        checkParam(index>=0 && index<size(), "valor fuera de rango");
        return wheels.get(index); 
    }
}

