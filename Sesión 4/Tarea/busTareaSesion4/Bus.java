
/**
 * Clase Bus para la Tarea de la Sesión 4
 * 
 * @author Omar Teixeira González 
 * @version 08/10/20
 */
public class Bus
{
    //Atributos constantes
    public static final int MAX_NUMBER_OF_SEATS=60;     //máximo número de asientos
    
    //Atributos variables (variables de instancia)
    private boolean driverPresent;      //si está el conductor true, sino false
    private int availableSeats;     //número de asientos disponibles del autobús
    private int newPassengers;      //número de personas que van a montar
    private String driverState;     //estado del conductor (ON DUTY O 
    
    /**
     * Constructor 1 de la clase Bus
     */
    public Bus()
    {
        setDriverPresent(false);
        setAvailableSeats(MAX_NUMBER_OF_SEATS);
    }
    
    /**
     * Constructor con parámetros de la clase Bus
     */
    public Bus(boolean driverPresent, int availableSeats)
    {
        setDriverPresent(driverPresent);
        setAvailableSeats(availableSeats);
    }

    /**
     * MÃ©todo que devuelve el valor del atributo driverPresent
     *
     * 
     * @return     driverPresent, si el confuctor está, de tipo Boolean
     */
    public boolean getDriverPresent()
    {
        return driverPresent;
    }

    /**
     * MÃ©todo que modifica el valor del atributo driverPresent
     *
     * @param  driverPresent    true o false si el conductor está
     * 
     */
    private void setDriverPresent(boolean driverPresent)
    {
        this.driverPresent = driverPresent;
    }
    
    /**
     * MÃ©todo que devuelve el valor del atributo age
     *
     * 
     * @return     age, edad de la persona, de tipo int
     */
    public int getAvailableSeats()
    {
        return availableSeats;
    }

    /**
     * MÃ©todo que modifica el valor del atributo age
     *
     * @param  availableSeats   nueva número de asientos disponibles 
     * para el atributo availableSeats
     * 
     */
    private void setAvailableSeats(int availableSeats)
    {
        if(checkParam(availableSeats <= MAX_NUMBER_OF_SEATS))   {
            this.availableSeats = availableSeats;
        }
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
     * Método que modifica el valor del atributo driverPresent 
     * convirtiendolo a true
     * 
     */
    public void sitDrive()
    {
        if(driverPresent==true){
            getDriverPresent();
        }else{    
            driverPresent=true;
        }
    }
    
    /**
     * Método que devuelve el número de asientos libres restantes y el estado
     * del conductor (true), en caso de que se incorporen nuevos
     * pasajeros o mantiene el número de asientos libres y devuelve un valor
     * false del conductor.
     *
     * @param       el número de pasajeros que podrían entrar al autobus
     * @return     la respuesta a la condición correspondiente
     */
    public boolean getOn(int newPassengers)
    {
        if(driverPresent && getAvailableSeats()>=newPassengers){
            availableSeats = (getAvailableSeats()- newPassengers);
            return true;
        }else{
            availableSeats = getAvailableSeats();
            return false;
        }
    }
    
    /**
     * Método que devuelve una cadena en la que hay presente una condición 
     * respecto al estado del conductor y el número de asientos disponibles,
     * esta cadena presenta el siguiente formato:"ON DUTY/OUT OF SERVICE-60".
     *
     * 
     * @return      La cadena que contiene la información con el estado del 
     * conductor y el número de asientos disponibles
     */
    public String toString()
    {
        if(getDriverPresent()==true){
            driverState= "ON DUTY";
        }else{
            driverState= "OUT OF SERVICE";
        }
        return driverState +
               "-" + availableSeats;
    }
}
