
/**
 * Clase Switch:
 * Tarea No Presencial Sesión 6:
 * Métodos set y get para el atributo state
 * Constantes SWITCH_ON y SWITCH_OFF
 * Método press() que alterna entre los dos estados posibles (ON, OFF) del switch
 * Método toString
 * 
 * @author Omar Teixeira González
 * @version 23-10-20
 */
public class Switch
{
    //constantes
    public static final boolean SWITCH_ON = true;
    public static final boolean SWITCH_OFF = false;
    
    public static final boolean DEFAULT_STATE = true;
    
    //variables de instancia (atributos variables):
    public boolean state;      //estado del switch, true (encendido) y false (apagado)
    
    /**
     * Constructor sin parámetros para la clase Switch
     */
    public Switch(){
        setState(DEFAULT_STATE);
    }
    
    /**
     * Constructor con parámetro state para la clase Switch
     */
    public Switch(boolean state){
        this();
        setState(state);
    }
    
    /**
     * Método que devuelve el true o false en función de si el switch está encendido o apagado
     * 
     * @return  state, el estado, de tipo boolean 
     */
    public boolean getState(){
        return state;
    }
    
    /**
     * Método que modifica el estado del switch
     * 
     * @param   state, nuevo estado del switch para el atributo state
     */
    public void setState(boolean state){
        this.state = state;
    }    
        
    /**
     * Método que alterna el estado del swtich
     */
    public void press(){
        if(getState() == SWITCH_OFF){
            this.state = SWITCH_ON;
        }else{
            this.state = SWITCH_OFF;
        }
    }
       
    /**
     * Método que devuelve "ON" si el estado es igual a true y "OFF" si el estado es igual a falsa
     * 
     * @return      "ON" o "OFF", de tipo String
     */
    public String toString(){
        if(this.state == SWITCH_ON){
            return "ON";
        }else{
            return "OFF";
        }
    }
            
}
