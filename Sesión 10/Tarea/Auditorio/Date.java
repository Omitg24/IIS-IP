
/**
 * Write a description of class Date here.
 * 
 * @author Omar Teixeira González
 * @version 20-11-20
 */
public class Date
{
    // constantes
    public static final int MIN_DAY = 1;
    public static final int MAX_DAY = 31;
    
    public static final int MIN_MONTH = 1;
    public static final int MAX_MONTH = 12;
    
    public static final int MIN_YEAR = 2000;
    
    // atributos variables
    private int day;
    private int month;
    private int year;

    /**
     * Constructor con parámetros para la clase Date
     */
    public Date(int day, int month, int year)
    {
        setDay(day);
        setMonth(month);
        setYear(year);
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
     * Método que modifica el valor del atributo day
     * 
     * @param  day, dia de la fecha, de tipo int 
     */
    private void setDay(int day)
    {
        if(checkParam(day >= MIN_DAY && day <= MAX_DAY)){
            this.day=day;
        }
    }
    
    /**
     * Método que modifica el valor del atributo month
     * 
     * @param  month, mes de la fecha, de tipo int 
     */
    private void setMonth(int month)
    {
        if(checkParam(month >= MIN_MONTH && month <= MAX_MONTH)){
            this.month=month;
        }
    }
    
    /**
     * Método que modifica el valor del atributo year
     * 
     * @param  year, año de la fecha, de tipo int 
     */
    private void setYear(int year)
    {
        if(checkParam(year >= MIN_YEAR)){
            this.year=year;
        }
    }      
    
    /**
     * Método que devuelve el día del concierto
     * 
     * @return  day, día de la fecha, de tipo int
     */
    public int getDay(){
        return day;
    }
    
    /**
     * Método que devuelve el mes del concierto
     * 
     * @return  month, mes de la fecha, de tipo int
     */
    public int getMonth(){
        return month;
    }
    
    /**
     * Método que devuelve el año del concierto
     * 
     * @return  year, año de la fecha, de tipo int
     */
    public int getYear(){
        return year;
    }
}
