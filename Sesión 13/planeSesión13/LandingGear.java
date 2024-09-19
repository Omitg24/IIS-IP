
/**
 * Tren de aterrizaje para el avión
 * Formado por 3 puntales (nose, left y right) 
 * y una palanca que sube o baja los puntales
 * 
 * Sesión 8:
 *      Creación de atributos (boolean lever, WheelStrut nose, WheelStrut left, WheelStrut right)
 *      Creación de constructores
 *      Método moveLever
 *      Método test
 *      Método print
 *      Método toString
 *      Prueba del depurador en el método moveLever
 * Tarea No Presencial Sesión 8:
 *      Prueba del depurador en la clase PlaneTest
 * Tarea No Presencial Sesión 10:
 *      Modificar el constructor por defecto
 *      
 * @author  Omar Teixeira González
 * @version 14-12-20
 */
public class LandingGear
{
    //constantes
    public static final boolean LEVER_UP = true;
    public static final boolean LEVER_DOWN = false;
    
    //atributos variables
    private boolean lever;
    private WheelStrut nose;    // puntal del morro del aviÃ³n
    private WheelStrut left;
    private WheelStrut right;
    
    /**
     * Constructor for objects of class LandingGear
     */
    public LandingGear()
    {
        setNose(new WheelStrut(2));
        setLeft(new WheelStrut(4));
        setRight(new WheelStrut(4));
        setLever(LEVER_DOWN);
    }
     
    /**
     * Constructor for objects of class LandingGear
     */
    public LandingGear(WheelStrut nose, WheelStrut left, WheelStrut right)
    {
        setNose(nose);
        setLeft(left);
        setRight(right);
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
     * Método que devuelve el valor del atributo lever
     * 
     * @return el valor del atributo lever, de tipo boolean
     */
    public boolean getLever(){
        return lever;
    }
        
    /**
     * Modifica el valor de la puntal del avión
     * 
     * @param  nose, puntal delantero del avión, de tipo WheelStrut
     *  
     */
    private void setNose(WheelStrut nose)
    {
        if(checkParam(nose!=null)){
            this.nose = nose;
        }
    }
    
    /**
     * Método que devuelve el valor del puntal del avión
     * 
     * @return  nose, puntal delantero del avión
     */
    public WheelStrut getNose(){
        return nose;
    }
    
    /**
      * Modifica el valor de la puntal del avión
     * 
     * @param  left, puntal izquierdo del avión, de tipo WheelStrut
     *  
     */
    private void setLeft(WheelStrut left)
    {
        if(checkParam(left!=null)){
            this.left = left;
        }
    }
    
    /**
     * Método que devuelve el valor del puntal del avión
     * 
     * @return  left, puntal izquierdo del avión
     */
    public WheelStrut getLeft(){
        return left;
    }
    
    /**
      * Modifica el valor de la puntal del avión
     * 
     * @param  right, puntal derecho del avión, de tipo WheelStrut
     *  
     */
    private void setRight(WheelStrut right)
    {
        if(checkParam(right!=null)){
            this.right = right;
        }
    }
    
    /**
     * Método que devuelve el valor del puntal del avión
     * 
     * @return  right, puntal derecho del avión
     */
    public WheelStrut getRight(){
        return right;
    }
        
    /**
     * Mueve la palanca segÃºn la acciÃ³n recibida
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
     * @param  condition, condición a evaluar, de tipo boolean
     * @return     true o false en función del parámetro
     */
    private boolean checkParam(boolean condition) {
        return condition;
    }
    
    /**
     * Prueba si el tren de aterrizaje estÃ¡ operativo (si todos sus puntales lo estÃ¡n)
     * 
     * @return true si estÃ¡ operativo
     */
    public boolean test() {
        return this.getNose().test() && this.getRight().test() && this.getLeft().test();
    }
    
    /**
     * Método que comprueba el resultado del test y devuelve OK o FAIL si ha sido true o false, respectivamente
     * 
     * @return OK o FAIL, en función de la condición que cumpla
     */
    public String testResult(){
        if(test()==true){
            return "OK";
        }else{
            return "FAILURE";
        }
    }
    
    /**
     * Método que devuelve el estado en el que se encuentra un puntal, devuelve "ON" si está desplegado y todas sus presiones 
     * son válidas. Devuelve OFF si sus presiones son correctas pero está replegado y PRESS si necesita cambios en las presiones.
     * 
     * @param   wheelStrut, el puntal de la rueda sobre el que queremos obtener su estado, de tipo WheelStrut
     * @return ON, OFF o PRESS en función de la condición que haya cumplido
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
     *  FAIL   ON
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
     * @return DOWN o UP en funciÃ³n de la palanca
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
                       " Nose: " + strutState(getNose()) + 
                       " Right: " + strutState(getRight()) + 
                       " Left: " + strutState(getLeft());        
        return result;
    }   
    
}
