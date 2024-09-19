
/**
 * Clase Wheel
 * Sesi�n 6:
 * Modela la rueda de un avi�n, con presi�n y presi�n m�xima
 * Operaciones toString y test para ver si la rueda est� operativa
 * 
 * Tarea Sesi�n 6:
 * M�todo print()
 * 
 * @author  Omar Teixeira Gonz�lez
 * @version 28-10-20
 */
public class Wheel
{
    // Constantes
    public static final double THRESHOLD = 85;      //porcentaje umbral
    public static final double PERCENTAGE = 100;        //porcentaje
    public static final double DEFAULT_MAX_PRESSURE=1000;        //presi�n m�xima
    public static final double DEFAULT_PRESSURE=900;        //presi�n actual
    
    // Atributos variables
    private double maxPressure;     //presi�n m�xima de la rueda
    private double pressure;        //presi�n actual de la rueda
        
    /**
     * Constructor sin par�metros que indica los siguientes valores por defecto:
     * Presi�n M�xima: DEFAULT_MAXPRESSURE
     * Presi�n Actual: DEFAULT_PRESSURE
     */
    public Wheel()
    {
        setMaxPressure(DEFAULT_MAX_PRESSURE);
        setPressure(DEFAULT_PRESSURE);
    }
        
    /**
     * Constructor con dos pa�metros, maxPressure  pressure.
     * Si el par�metro no es correcto quedar� el valor est�ndar
     */
    public Wheel(double maxPressure, double pressure)
    {
        this();     //llama al constructor sin par�metros
        if(checkParam(maxPressure >= pressure)){
            setMaxPressure(maxPressure);
            setPressure(pressure);
        }
    }
    
    /**
     * M�todo para modificar el valor del atributo maxPressure
     * 
     * @param       maxPressure, nueva presi�n m�xima para el atributo maxPressure, de tipo double
     */
    private void setMaxPressure(double maxPressure){
         if(checkParam(maxPressure>=0)){
            this.maxPressure = maxPressure;
        }
    }
    
    /**
     * Controla el par�metro
     * @param   boolean condition
     */
    private boolean checkParam (boolean condition){
        return condition;
    }
    
    /**
     * M�todo para modificar el valor del atributo pressure
     * 
     * @param       pressure, nueva presi�n actual para el atributo pressure, de tipo double
     */
    private void setPressure(double pressure){
         if(checkParam(pressure>=0 && pressure <= getMaxPressure())){
            this.pressure = pressure;
        }
    }
      
    /**
     * M�todo que devuelve el valor del atributo maxPressure
     *
     * @return     el valor de la nueva presi�n m�xima
     */
     public double getMaxPressure(){
        return maxPressure;
    }
    
    /**
     * M�todo que devuelve el valor del atributo Pressure
     *
     * @return     el valor de la nueva presi�n actual
     */
    public double getPressure(){
        return pressure;
    }
    
    /**
     * M�todo que comprueba si la rueda est� operativa (tiene suficiente presi�n, por encima o igual al THRESHOLD de 
     * la presi�n m�xima)
     * 
     * @return true si la rueda est� operativa, de tipo boolean
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
     * M�todo que calcula el valor del porcentaje de la presi�n actual de la rueda
     */
    private double calculatePercentage(){
        return getPressure()/getMaxPressure() * PERCENTAGE;
    }
    
    /**
     * M�todo que utiliza el resultado de del m�todo test para devolver OK (si true) o FAIL (si false)
     */
    private String testResult(){
        if(test()==true){
           return "OK";
        }else{
           return"FAIL"; 
        }
    }
    
    /**
     * M�todo que imprime los valores de las propiedades del objeto, el % de aire dentro de la rueda y el resultado de la 
     * ejecuci�n del m�todo test, con el siguiente formato:
     * Max Pressure....... 34500 Mb
     * CurrentPressure... 32000 Mb (92,75%)
     * Test............... OK (FAIL, si fall� el test).
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