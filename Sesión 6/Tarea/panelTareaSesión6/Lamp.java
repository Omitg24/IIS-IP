
/**
 * Clase Lamp:
 * Tarea No Presencial Sesión 6:
 * Métodos set y get del atributo state
 * Constantes LAMP_ON y LAMP_OFF
 * Métodos turnOn y turnOff para modificar el estado de la bombilla
 * Método toSring que devuelve "ENCENDIDA" o "APAGADA" en función del estado de la bombilla.
 * 
 * @author Omar Teixeira González
 * @version 23-10-20
 */
public class Lamp
{
    //constantes
    public static final boolean LAMP_ON = true;
    public static final boolean LAMP_OFF = false;
    
    public static final boolean DEFAULT_STATE = true;
    
    //variables de instancia (atributos variables):
    private boolean state;      //estado de la bombilla, true (encendida) y false (apagada)
    
    /**
     * Constructor sin parámetros para la clase Lamp
     */
    public Lamp(){
        setState(DEFAULT_STATE);
    }
    
    /**
     * Constructor con parámetro state para la clase Lamp
     */
    public Lamp(boolean state){
        this();
        setState(state);
    }
    
    /**
     * Método que devuelve el true o false en función de si la bombilla está encendida o apagada
     * 
     * @return  state, el estado, de tipo boolean 
     */
    public boolean getState(){
        return state;
    }
    
    /**
     * Método que modifica el estado de la bombilla
     * 
     * @param   state, nuevo estado de la bombilla para el atributo state
     */
    private void setState(boolean state){
        this.state = state;
    }    
    
    /**
     * Método que modifica (enciende) el estado de la bombilla
     */
    public void turnOn(){
        this.state = LAMP_ON;
    }
    
    /**
     * Método que modifica (apaga) el estado de la bombilla
     */
    public void turnOff(){
        this.state = LAMP_OFF;
    }
    
    /**
     * Método que devuelve "ENCENDIDA" si el estado es igual a true y "APAGADA" si el estado es igual a falsa
     * 
     * @return      "ENCENDIDA" o "APAGADA", de tipo String
     */
    public String toString(){
        String result;
            if(this.state == LAMP_ON){
                result = "ENCENDIDA";
            }else{
                result = "APAGADA";
            }
        return result;
    }
            
}
