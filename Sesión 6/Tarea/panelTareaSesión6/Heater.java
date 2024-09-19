
/**
 * Write a description of class Heater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heater
{
    //constantes
    public static final double MIN_TEMPERATURE = 10.0;
    public static final double MAX_TEMPERATURE = 27.0;
    
    public static final double DEFAULT_TEMPERATURE = 27.0;
    
    //atributos variables
    private double temperature;

    /**
     * Constructor sin parámetros para la clase Heater
     */
    public Heater()
    {
        changeTemperature(DEFAULT_TEMPERATURE);
    }
    
    /**
     * Constructor con parámetro Temperature para la case Heater
     */
    public Heater(double temperature)
    {
        this();
        changeTemperature(temperature);
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
     * Método que devuelve el valor de la temperatura
     * 
     * @return temperature, el valor de la temperatura, de tipo double
     */
    public double getTemperature(){
        return temperature;
    }
    
    /**
     * Método que modifica el valor de la temperatura
     * 
     * @param temperature, nuevo valor para la temparatura, de tipo double
     */
    public void changeTemperature(double temperature){
        if(checkParam(temperature >= MIN_TEMPERATURE && temperature <= MAX_TEMPERATURE)){
            this.temperature = temperature;
        }
    }
    
    /**
     * Método que devuelve la cadena con el valor de la temperatura correspondiente
     * 
     * @return toString, cadena con el valor correspondiente, de tipo String
     */
    public String toString(){
        return getTemperature()+ " ºC";
    }
    
}
