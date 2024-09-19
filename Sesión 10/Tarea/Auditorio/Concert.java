
/**
 * Write a description of class Concert here.
 * 
 * @author Omar Teixeira González
 * @version 20-11-20
 */
public class Concert
{
    // constantes
    public static final double MIN_PRICE = 1;
    
    public static final String DEFAULT_NAME = "Linkin Park live at Oviedo";
    public static final double DEFAULT_PRICE = 10.0;
    
    // atributos variables
    private String name;
    private double price;
    private Date date;

    /**
     * Constructor for objects of class Concert
     */
    public Concert()
    {
        setName(DEFAULT_NAME);
        setPrice(DEFAULT_PRICE);
        setDate(new Date(18,6,2021));
    }
    
    /**
     * Constructor con parámetros de la clase Concert
     */
    public Concert(String name, double price, Date date)
    {
        setName(name);
        setPrice(price);
        setDate(date);
    }
    
    /**
     * Método que controla el parámetro
     * 
     * @param   condition, la condición, de tipo boolean
     * @return condition, la condición, de tipo boolean
     */
    private boolean checkParam(boolean condition){
        return condition;
    }

    /**
     * Método que modifica el valor del atributo name
     * 
     * @param  name, nombre del concierto, de tipo String
     */
    private void setName(String name)
    {
        if(checkParam(name != null)){
            this.name=name;
        }
    }
    
    /**
     * Método que modifica el valor del atributo price
     * 
     * @param  price, precio de la butaca del concierto, de tipo double
     */
    private void setPrice(double price)
    {
        if(checkParam(price >= MIN_PRICE)){
            this.price=price;
        }
    }
    
    /**
     * Método que modifica el valor del atributo date
     * 
     * @param  date, fecha del concierto, de tipo Date
     */
    private void setDate(Date date)
    {
        if(checkParam(date != null)){
            this.date=date;
        }
    }
    
    /**
     * Método que devuelve el nombre del atributo name
     * 
     * @return  name, el nombre del concierto, de tipo String
     */
    public String getName(){
        return name;
    }
    
    /**
     * Método que devuelve el nombre del atributo price
     * 
     * @return  price, el precio de la butaca del concierto, de tipo double
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * Método que devuelve el nombre del atributo date
     * 
     * @return  date, la fecha del concierto, de tipo Date
     */
    public Date getDate(){
        return date;
    }
    
}
