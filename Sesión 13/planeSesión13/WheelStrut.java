import java.util.ArrayList;
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
 * Tarea No Presencial Sesi�n 10:
 *      Modificar el constructor para tener un arrayList de ruedas     
 *      
 * @author  Omar Teixeira Gonz�lez
 * @version 14-12-20
 */
public class WheelStrut
{
    //constantes
    public static final double BOEING_737_PRESSURE = 1739; //Mb presión
    public static final boolean IS_DEPLOYED = true;
    public static final int DEFAULT_NUMBER_OF_WHEELS = 4;
    
    //atributos varibales
    private boolean deployed;   // indica si el puntal está desplegado
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
     * Constructor con par�metr NumberOfWheels
     */
    public WheelStrut(int numberOfWheels){
        this();
        setDeployed(IS_DEPLOYED);
        wheels = new ArrayList<Wheel>();
        setWheels(numberOfWheels);
    }
    
    /**
     * M�todo que crea una lista con el n�mero de ruedas que reciba como par�metro y la asigna al atributo Wheels
     * 
     * @param   numero de ruedas
     */
    private void setWheels(int numberOfWheels){
        checkParam(numberOfWheels > 0, "El n�mero de ruedas debe ser mayor que 0");
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
     * M�todo que asigna valor a wheels
     * 
     * @param nueva lista de ruedas
     */
    private void setWheels(ArrayList<Wheel> list){
        checkParam(list!=null);
        checkParam(list.size() > 0, "La lista recibida esta vac�a");
        this.wheels=list;
    }
    
    /**
     * M�todo que controla el par�metro, si no se cumple lanza un RuntimeException
     * 
     * @param   condition, la condici�n, de tipo boolean
     */
    private void checkParam(boolean condition){
        if(condition==false){
            throw new RuntimeException();
        }
    }
    
    /**
     * M�todo que controla el par�metro, si no se cumple lanza un RuntimeException
     * 
     * @param   condition, la condici�n, de tipo boolean
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
     * Comprueba que todas las ruedas estén operativas (tienen suficiente presión)
     * @return true si ambas están operativas
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
     *    Deployed: true – Test: true [1: true] [2: true] [3: true] [4: true] ...
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
        for(int i=0; i<wheels.size(); i++){
            System.out.printf("Wheel %d%n", i+1);
            wheels.get(i).print();
        }
        System.out.println();        
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
       
    /**
     * M�todo que devuelve el numero de ruedas que hay en la colecci�n
     */
    public int size(){
        return wheels.size();
    }
    
    /**
     * M�todo que devuelve la rueda situada en la posici�n recibida como par�metro
     * 
     * @param posici�n en la lista
     * @return  la rueda situada en la posicion
     */
    public Wheel getWheel(int index){
        checkParam(index>=0 && index<size(), "valor fuera de rango");
        return wheels.get(index); 
    }
}

