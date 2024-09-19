
/**
 * Clase ControlPanel
 * Tarea No Presencial Sesión 6:
 * 
 * @author Omar Teixeira González
 * @version 23-10-20
 */
public class ControlPanel
{
    //atributos variables
    private Switch switch1;
    private Lamp lamp1;
    private Potentiometer potentio1;
    private Heater heater1;
    
    /**
     * Constructor sin parámetros para la clase ControlPanel
     */
    public ControlPanel(){
        setSwitch(new Switch());
        setLamp(new Lamp());
        setPotentiometer(new Potentiometer());
        setHeater(new Heater());
    }
    
    /**
     * Constructor con parámetros switch1, lamp1, potentio1, heater1 para la clase ControlPanel
     */
    public ControlPanel(Switch switch1, Lamp lamp1){
        this();
        setSwitch(switch1);
        setLamp(lamp1);
    }
    
    /**
     * Constructor con parámetros switch1, lamp1, potentio1, heater1 para la clase ControlPanel
     */
    public ControlPanel(Potentiometer potentio1, Heater heater1){
        this();
        setPotentiometer(potentio1);
        setHeater(heater1);
    }
    
    /**
     * Constructor con parámetros switch1, lamp1, potentio1, heater1 para la clase ControlPanel
     */
    public ControlPanel(Switch switch1, Lamp lamp1, Potentiometer potentio1, Heater heater1){
        this();
        setSwitch(switch1);
        setLamp(lamp1);
        setPotentiometer(potentio1);
        setHeater(heater1);
    }
    
    /**
     * Modifica el valor del atributo Switch
     * 
     * @param  Switch, nuevo switch para el panel de control, de tipo Switch
     */
    private void setSwitch(Switch switch1)
    {
        this.switch1=switch1;
    }
    
    /**
     * Modifica el valor del atributo Lamp
     * 
     * @param  Lamp, nuevo lampara para el panel de control, de tipo Lamp
     */
    private void setLamp(Lamp lamp1)
    {
        this.lamp1=lamp1;
    }
    
    /**
     * Modifica el valor del atributo Potentiometer
     * 
     * @param  Potentiometer, nuevo potenciómetro para el panel de control, de tipo Potentiometer
     */
    private void setPotentiometer(Potentiometer potentiometer1)
    {
        this.potentio1=potentiometer1;
    }
    
    /**
     * Modifica el valor del atributo Heater
     * 
     * @param  Heater, nuevo radiador para el panel de control, de tipo Heater
     */
    private void setHeater(Heater heater1)
    {
        this.heater1=heater1;
    }
    
    /**
     * Método que devuelve el valor del atributo Switch
     * 
     * @return  Switch, el valor del switch
     */
    public Switch getSwitch(){
        return switch1;
    }
    
    /**
     * Método que devuelve el valor del atributo Lamp
     * 
     * @return  Lamp, el valor de la lampara
     */
    public Lamp getLamp(){
        return lamp1;
    }
    
    /**
     * Método que devuelve el valor del atributo Potentiometer
     * 
     * @return  Potentiometer, el valor del potenciometro
     */
    public Potentiometer getPotentiometer(){
        return potentio1;
    }
    
    /**
     * Método que devuelve el valor del atributo Heater
     * 
     * @return  Heater, el valor del radiador
     */
    public Heater getHeater(){
        return heater1;
    }
    
    /**
     * Método print que muestra el estado del sistema con el siguiente formato de ejemplo:
     * =========== Estado del PANEL ============
     * Interruptor: ON
     * Bombilla: ENCENDIDA
     * Potenciómetro: 10
     * Radiador: 27.0 ºC
     */
    public void print(){
        System.out.println("=========== Estado del PANEL ============");
        System.out.println("Interruptor: " + switch1.toString());
        System.out.println("Bombilla: " + lamp1.toString());
        System.out.println("Potenciómetro: " + potentio1.toString());
        System.out.println("Radiador: " + heater1.toString());
    }
    
    /**
     * Método que cambia la posición del interruptor, y si este está en ON, enciende la bombilla, si está en OFF, apaga la
     * bombilla.
     */
    public void press()
    {
        switch1.press();
        if(switch1.getState() == switch1.SWITCH_ON){
            lamp1.turnOn();
        }else{
            lamp1.turnOff();
        }
    }
    
    /**
     * Método que cambia la posición del potenciómetro, y si este tiene valor 0, cambia la temperatura del radiador a 10, 
     * si está en 10, cambia la temperatura del radiador a 27
     */
    public void movePotentiometer(int position)
    {
        potentio1.movePosition(position);
        heater1.changeTemperature((position*17)/(10)+10);
    }
}
