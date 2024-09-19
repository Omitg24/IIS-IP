
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
    
    public static final int MIN_X=0;
    public static final int MAX_X=10;
    public static final int MIN_Y=0;
    public static final int MAX_Y=10;
    
    public static final int MIN_SPEED_X=-1;
    public static final int MAX_SPEED_X=1;
    public static final int MIN_SPEED_Y=-1;
    public static final int MAX_SPEED_Y=1;
        
    // atributos variables
    private Person pilot;
    private char identifier;        //caracter entre 'A' y 'Z'
    private int fuel;               //entero entre [0,5000]
    private int xPos;               //entero entre [MIN_X,MAX_X]
    private int yPos;               //entero entre [MIN_Y,MAX_Y]
    private int xSpeed;               //entero entre [MIN_SPEED_X,MAX_SPEED_X]
    private int ySpeed;               //entero entre [MIN_SPEED_Y,MAX_SPEED_Y]

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
     * Constructor 3 for objects of class Plane
     * 
     */
    public Plane(Person pilot)
    {
        this();
        setPilot(pilot);
        setIdentifier (DEFAULT_IDENTIFIER);
        setFuel(DEFAULT_FUEL);
    }
    
    /**
     * Constructor 4 for objects of class Plane
     * 
     */
    public Plane(char identifier)
    {
        this();
        setPilot(DEFAULT_PILOT);
        setIdentifier (identifier);
        setFuel(DEFAULT_FUEL);
    }
    
    /**
     * Constructor 5 for objects of class Plane
     * 
     */
    public Plane(int fuel)
    {
        this();
        setPilot(DEFAULT_PILOT);
        setIdentifier (DEFAULT_IDENTIFIER);
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
     * Método que modifica el valor del atributo fuel
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
     * Método que modifica el valor de la posición x del avión
     *
     * @param  xPos, nueva posición x para el avión, de tipo int
     * 
     */
    private void setXPos(int xPos)
    {
        if(xPos >=MIN_X && xPos <=MAX_X){
            this.xPos=xPos;
        }
    }
    
    /**
     * Método que modifica el valor de la posición y del avión
     *
     * @param  yPos, nueva posición y para el avión, de tipo int
     * 
     */
    private void setYPos(int yPos)
    {
        if(yPos >=MIN_Y && yPos <=MAX_Y){
            this.yPos=yPos;
        }
    }
    
    /**
     * Método que modifica el valor de la velocidad x del avión
     *
     * @param  xSpeed, nueva veloccidad x para el avión, de tipo int
     * 
     */
    private void setXSpeed(int xSpeed)
    {
        if(xSpeed >=MIN_SPEED_X && xSpeed <=MAX_SPEED_X){
            this.xSpeed=xSpeed;
        }
    }
    
    /**
     * Método que modifica el valor de la velocidad y del avión
     *
     * @param  ySpeed, nueva velocidad y para el avión, de tipo int
     * 
     */
    private void setYSpeed(int ySpeed)
    {
        if(ySpeed >=MIN_SPEED_Y && ySpeed <=MAX_SPEED_Y){
            this.ySpeed=ySpeed;
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
     * Devuelve la posición x del avión
     * @ return xPos, posición x del avión, de tipo int
     */
    public int getXPos(){
         return xPos;      
    }
    
    /**
     * Devuelve la posición y del avión
     * @ return yPos, posición y del avión, de tipo int
     */
    public int getYPos(){
         return yPos;      
    }
    
    /**
     * Devuelve la velocidad x del avión
     * @ return xSpeed, velocidad x del avión, de tipo int
     */
    public int getXSpeed(){
         return xSpeed;      
    }
    
    /**
     * Devuelve la velocidad y del avión
     * @ return ySpeed, velocidad y del avión, de tipo int
     */
    public int getYSpeed(){
         return ySpeed;      
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
     * Método que devuelve el estado del piloto en función de unas
     * condiciones.
     * 
     * @return   NO PILOT o el Piloto, de tipo String
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
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void accelerate(int xSpeed, int ySpeed)
    {
        if(xSpeed>=MIN_SPEED_X && xSpeed<=MAX_SPEED_X && ySpeed>=MIN_SPEED_Y && ySpeed<=MAX_SPEED_Y){
            this.xSpeed=xSpeed;
            this.ySpeed=ySpeed;                  
        }
    }

}