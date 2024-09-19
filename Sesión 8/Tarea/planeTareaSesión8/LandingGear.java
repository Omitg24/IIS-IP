
/**
 * Tren de aterrizaje para el avi�n
 * Formado por 3 puntales (nose, left y right) 
 * y una palanca que sube o baja los puntales
 * 
 * Sesi�n 8:
 *      Creaci�n de atributos (boolean lever, WheelStrut nose, WheelStrut left, WheelStrut right)
 *      Creaci�n de constructores
 *      M�todo moveLever
 *      M�todo test
 *      M�todo print
 *      M�todo toString
 *      Prueba del depurador en el m�todo moveLever
 * Tarea No Presencial Sesi�n 8:
 *      Prueba del depurador en la clase PlaneTest
 *      
 * @author  Omar Teixeira Gonz�lez
 * @version     4-10-20
 */
public class LandingGear
{
    //constantes
    public static final boolean LEVER_UP = true;
    public static final boolean LEVER_DOWN = false;
    
    //atributos variables
    private boolean lever;
    private WheelStrut nose;    // puntal del morro del avión
    private WheelStrut left;
    private WheelStrut right;
    
    /**
     * Constructor for objects of class LandingGear
     */
    public LandingGear()
    {
        setWheelStrutNose(nose);
        setWheelStrutLeft(left);
        setWheelStrutRight(right);
        setLever(LEVER_DOWN);
    }
     
    /**
     * Constructor for objects of class LandingGear
     */
    public LandingGear(WheelStrut nose, WheelStrut left, WheelStrut right, boolean lever)
    {
        setWheelStrutNose(nose);
        setWheelStrutLeft(left);
        setWheelStrutRight(right);
        setLever(lever);
    }        
    
    /**
     * Modifica el valor de la palanca
     * 
     * @param  lever nuevo valor para la palanca, de tipo boolean
     *  
     */
    private void setLever(boolean lever)
    {
        this.lever=lever;
    }
    
    /**
     * M�todo que devuelve el valor del atributo lever
     * 
     * @return el valor del atributo lever, de tipo boolean
     */
    public boolean getLever(){
        return lever;
    }
        
    /**
     * Modifica el valor de la puntal del avi�n
     * 
     * @param  nose, puntal delantero del avi�n, de tipo WheelStrut
     *  
     */
    private void setWheelStrutNose(WheelStrut nose)
    {
        if(checkParam(nose!=null)){
            this.nose = nose;
        }
    }
    
    /**
     * M�todo que devuelve el valor del puntal del avi�n
     * 
     * @return  nose, puntal delantero del avi�n
     */
    public WheelStrut getWheelStrutNose(){
            return nose;
    }
    
    /**
      * Modifica el valor de la puntal del avi�n
     * 
     * @param  nose, puntal delantero del avi�n, de tipo WheelStrut
     *  
     */
    private void setWheelStrutLeft(WheelStrut left)
    {
        if(checkParam(left!=null)){
            this.left = left;
        }
    }
    
    /**
     * M�todo que devuelve el valor del puntal del avi�n
     * 
     * @return  nose, puntal delantero del avi�n
     */
    public WheelStrut getWheelStrutLeft(){
            return left;
    }
    
    /**
      * Modifica el valor de la puntal del avi�n
     * 
     * @param  nose, puntal delantero del avi�n, de tipo WheelStrut
     *  
     */
    private void setWheelStrutRight(WheelStrut right)
    {
        if(checkParam(right!=null)){
            this.right = right;
        }
    }
    
    /**
     * M�todo que devuelve el valor del puntal del avi�n
     * 
     * @return  nose, puntal delantero del avi�n
     */
    public WheelStrut getWheelStrutRight(){
            return right;
    }
        
    /**
     * Mueve la palanca según la acción recibida
     * 
     * @param action, LEVER_UP o LEVER_DOWN
     */
    public void moveLever(boolean action) {
        if (action == LEVER_UP){
            setLever(LEVER_UP);
            nose.retract();
            left.retract();
            right.retract();
        }else if (action == LEVER_DOWN){
            setLever(LEVER_DOWN);
            nose.deploy();
            left.deploy();
            right.deploy();
        }
    }
    
    /**
     * Comprueba que el parametro es o no correcto
     *
     * @param  condition, condici�n a evaluar, de tipo boolean
     * @return     true o false en funci�n del par�metro
     */
    private boolean checkParam(boolean condition) {
        return condition;
    }
    
    /**
     * Prueba si el tren de aterrizaje está operativo (si todos sus puntales lo están)
     * 
     * @return true si está operativo
     */
    public boolean test() {
        return nose.test() && right.test() && left.test();
    }
    
    /**
     * M�todo que comprueba el resultado del test y devuelve OK o FAIL si ha sido true o false, respectivamente
     * 
     * @return OK o FAIL, en funci�n de la condici�n que cumpla
     */
    public String testResult(){
        if(test()==true){
            return "OK";
        }else{
            return "FAILURE";
        }
    }
    
    /**
     * M�todo que devuelve el estado en el que se encuentra un puntal, devuelve "ON" si est� desplegado y todas sus presiones 
     * son v�lidas. Devuelve OFF si sus presiones son correctas pero est� replegado y PRESS si necesita cambios en las presiones.
     * 
     * @param   wheelStrut, el puntal de la rueda sobre el que queremos obtener su estado, de tipo WheelStrut
     * @return ON, OFF o PRESS en funci�n de la condici�n que haya cumplido
     */
    public String strutState(WheelStrut wheelStrut){
        if(wheelStrut.test()){
            if (wheelStrut.isDeployed()){
                return "ON";
            }else{
                return "OFF";
            }
        }else{
            return "PRESS";
        }
    }
        
    /**
     * Imprime los datos del tren de aterrizaje con el siguiente formato:
     *  Lever.............. DOWN (o UP)
     * Test............... FALSE.
     *  
     *      ON
     *  FAIL�  ON
     *  
     */ 
    public void print() {
        System.out.printf("Lever.............. %s", leverToString());        
        System.out.println(" ");
        System.out.printf("Test............... %b", testResult());
        System.out.println(" ");
        System.out.printf("      %s      ", strutState(nose));
        System.out.println(" ");
        System.out.printf("%s         %s", strutState(left), strutState(right));
        System.out.println(" ");
    }
    
    /**
     * Valor de la planca en formato String
     * 
     * @return DOWN o UP en función de la palanca
     */
    public String leverToString() {
        if (getLever()==LEVER_UP){
            return "UP";
        }else{
            return "DOWN";
        }
    }
    
    /**
     * Valores de los datos en el formato
     * Lever: UP    Status:OK   Nose: ON    Right: ON   Left: ON
     * Lever: DOWN Status: FAILURE Nose: OFF Left: OFF Right: OFF
     *
     * @return valor de los datos del tren de aterrizaje con el formato anterior
     */
    public String toString() {
        String result= "Lever: " + leverToString() + 
                       " Status: " + testResult() + 
                       " Nose: " + strutState(nose) + 
                       " Right: " + strutState(right) + 
                       " Left: " + strutState(left);        
        return result;
    }   
    
}
