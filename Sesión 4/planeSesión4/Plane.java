
/**
 * Clase Plane correspondiente a la sesión 4
 * Atributos pilot, identifier, fuel
 * Métodos set/get
 * Método toString
 * Método fly
 * 
 * @author Omar Teixeira González 
 * @version 07/10/2020
 */
public class Plane
{
    // Constantes
    public static final int MIN_FUEL = 0;
    public static final int MAX_FUEL = 5000;
    
    public static final char MIN_IDENTIFIER = 'A';
    public static final char MAX_IDENTIFIER = 'Z';
    
    public static final char DEFAULT_IDENTIFIER = 'A';
    public static final int DEFAULT_FUEL = 0;
    public static final Person DEFAULT_PILOT = null;
    
    // atributos variables
    private Person pilot;
    private char identifier;        //caracter entre 'A' y 'Z'
    private int fuel;               //entero entre [0,5000]

    /**
     * Constructor for objects of class Plane
     * Datos por defecto
     * Identificador 'A'
     * fuel 0
     * pilot no existe
     */
    public Plane()
    {
        setIdentifier (DEFAULT_IDENTIFIER);
        setFuel(DEFAULT_FUEL);
        setPilot(DEFAULT_PILOT);
    }
    
    /**
     * Constructor 2 for objects of class Plane
     * 
     */
    public Plane(Person pilot, char identifier, int fuel)
    {
        this();
        setPilot(pilot);
        setIdentifier (identifier);
        setFuel(fuel);
    }

    /**
     * Modifica el valor del atributo pilot
     * 
     * @param  pilot, nuevo piloto para el avión, de tipo Person
     * 
     */
    private void setPilot(Person pilot)
    {
        this.pilot=pilot;
    }
    
    /**
     * Modifica el valor del atributo indentifier
     * 
     * @param  identifier, nuevo piloto para el avión, de tipo char
     * 
     */
    private void setIdentifier(char identifier)
    {
        if(checkParam(identifier >= MIN_IDENTIFIER && identifier <= MAX_IDENTIFIER)){
            this.identifier=identifier;      //atributo toma el valor de parámetro
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
     * An example of a method - replace this comment with your own
     *
     * @param  fuel, nuevo combustible para el avión, de tipo int
     *
     */
    private void setFuel(int fuel)
    {
        if (checkParam(fuel >= MIN_FUEL && fuel <= MAX_FUEL)){
            this.fuel=fuel;     //atributo toma el valor de parámetro
        }
    }
    
    /**
     * Devuelve el valor del piloto
     * @ return pilot, piloto del avión, de tipo Person
     */
    public Person getPilot(){
         return pilot;      
    }
    
    /**
     * Devuelve el valor del identificador
     * @ return identificador del avión [MIN_IDENTIFIER,MAX_IDENTIFIER]
     */
    public char getIdentifier(){
         return identifier;      
    }
    
    /**
     * Devuelve el valor del combustible
     * @ return fuel, combustible del avión, de tipo int
     */
    public int getFuel(){
         return fuel;      
    }
    
    /**
     * Devuelve cadena con todos los campos del avión con el siguiente formato: 
     * "Identifier-Fuel-NO PILOT (o bien el HasCode del piloto si hay piloto)"
     *
     * @return     propiedades del avión con el formato descrito anteriormente
     */
    public String toString()
    {
        String result = this.getIdentifier() + "-" +
                        this.getFuel() + "-" +
                        getPilotCode();
        return result;
    }
    
    /**
     * Método que devuelve 
     */
    private String getPilotCode(){
        if(this.getPilot()==null){      //equivalente pilot o getPilot()
            return "NO PILOT";
        }else{
            return pilot.getHashCode();
        }
    }
    
    /**
     * Método que permite volart al avión
     * Si tiene combustible devuelve true y reduce en 1 el combustible
     * Si no tiene combustible, devuelve false
     */
    public boolean fly(){
        if (getFuel() >=1) {
            setFuel(getFuel()-1);
            return true;
        }else{
            return false;
        }
    }   
}