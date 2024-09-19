
/**
 * Clase Wheel
 * Sesión 6:
 * Modela la rueda de un avión, con presión y presión máxima
 * Operaciones toString y test para ver si la rueda está operativa
 * 
 * Tarea Sesión 6:
 * Método print()
 * 
 * @author  Omar Teixeira González
 * @version 28-10-20
 */
public class Wheel
{
    // Constantes
    public static final double THRESHOLD = 85;      //porcentaje umbral
    public static final double PERCENTAGE = 100;        //porcentaje
    public static final double DEFAULT_MAX_PRESSURE=1000;        //presión máxima
    public static final double DEFAULT_PRESSURE=900;        //presión actual
    
    // Atributos variables
    private double maxPressure;     //presión máxima de la rueda
    private double pressure;        //presión actual de la rueda
        
    /**
     * Constructor sin parámetros que indica los siguientes valores por defecto:
     * Presión Máxima: DEFAULT_MAXPRESSURE
     * Presión Actual: DEFAULT_PRESSURE
     */
    public Wheel()
    {
        setMaxPressure(DEFAULT_MAX_PRESSURE);
        setPressure(DEFAULT_PRESSURE);
    }
        
    /**
     * Constructor con dos paámetros, maxPressure  pressure.
     * Si el parámetro no es correcto quedará el valor estándar
     */
    public Wheel(double maxPressure, double pressure)
    {
        this();     //llama al constructor sin parámetros
        if(checkParam(maxPressure >= pressure)){
            setMaxPressure(maxPressure);
            setPressure(pressure);
        }
    }
    
    /**
     * Método para modificar el valor del atributo maxPressure
     * 
     * @param       maxPressure, nueva presión máxima para el atributo maxPressure, de tipo double
     */
    private void setMaxPressure(double maxPressure){
         if(checkParam(maxPressure>=0)){
            this.maxPressure = maxPressure;
        }
    }
    
    /**
     * Controla el parámetro
     * @param   boolean condition
     */
    private boolean checkParam (boolean condition){
        return condition;
    }
    
    /**
     * Método para modificar el valor del atributo pressure
     * 
     * @param       pressure, nueva presión actual para el atributo pressure, de tipo double
     */
    private void setPressure(double pressure){
         if(checkParam(pressure>=0 && pressure <= getMaxPressure())){
            this.pressure = pressure;
        }
    }
      
    /**
     * Método que devuelve el valor del atributo maxPressure
     *
     * @return     el valor de la nueva presión máxima
     */
     public double getMaxPressure(){
        return maxPressure;
    }
    
    /**
     * Método que devuelve el valor del atributo Pressure
     *
     * @return     el valor de la nueva presión actual
     */
    public double getPressure(){
        return pressure;
    }
    
    /**
     * Método que comprueba si la rueda está operativa (tiene suficiente presión, por encima o igual al THRESHOLD de 
     * la presión máxima)
     * 
     * @return true si la rueda está operativa, de tipo boolean
     */
    public boolean test(){
        // if(getPressure() >= THRESHOLD/100*getMaxPressure()){
             // return true;
        // }else{
             // return false;
        // }
        return getPressure() >= THRESHOLD/PERCENTAGE*getMaxPressure();
    }
    
    /**
     * Devuelve los datos de la rueda con el siguiente formato:
     * MaxP: 20700,0 Mb - Pressure: 19300,0 Mb - Percentage: 93,4 - Test: true 
     */
    public String toString(){
        String result = String.format("MaxP: %.1f Mb - Pressure: %.1f Mb - Percentage: %.2f - Test: %b",
                                        maxPressure,
                                        pressure,
                                        calculatePercentage(),
                                        test());
        return result;
    }
    
    /**
     * Método que calcula el valor del porcentaje de la presión actual de la rueda
     */
    private double calculatePercentage(){
        return getPressure()/getMaxPressure() * PERCENTAGE;
    }
    
    /**
     * Método que utiliza el resultado de del método test para devolver OK (si true) o FAIL (si false)
     */
    private String testResult(){
        if(test()==true){
           return "OK";
        }else{
           return"FAIL"; 
        }
    }
    
    /**
     * Método que imprime los valores de las propiedades del objeto, el % de aire dentro de la rueda y el resultado de la 
     * ejecución del método test, con el siguiente formato:
     * Max Pressure....... 34500 Mb
     * CurrentPressure... 32000 Mb (92,75%)
     * Test............... OK (FAIL, si falló el test).
     */
    public void print(){
        System.out.println(String.format(("Max Pressure....... %.0f Mb"),
                            maxPressure));
        System.out.print(String.format("Current Pressure... %.0f Mb (%.2f",
                            pressure,
                            calculatePercentage()));
        System.out.println("%)");
        System.out.println("Test............... " +testResult());
    }
}