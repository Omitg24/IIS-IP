
/**
 * Write a description of class Player here.
 * 
 * @author Omar Teixeira Gonzalez
 * @version 16-11-20
 */
public class Player
{
    //constantes
    public static final String DEFAULT_NAME="Omar";
    public static final int DEFAULT_NUMBER=0;
    
    // atributos variables
    private String name;
    private int number;

    /**
     * Constructor sin parámetros para la clase Player
     */
    public Player()
    {
        setName(DEFAULT_NAME);
        setNumber(DEFAULT_NUMBER);
    }
    
    /**
     * Constructor con parámetros name y number para la clase Player
     */
    public Player(String name, int number)
    {
        this();
        setName(name);
        setNumber(number);
    }
    
    /**
     * Método que controla el parámetro
     * 
     * @param   condition, la condición, de tipo boolean
     * @return   condition, la condición, de tipo boolean
     */
    private boolean checkParam(boolean condition){
        return condition;
    }

    /**
     * Método que modifica el valor del atributo name
     * 
     * @param   name, nombre para el jugador, de tipo String
     */
    private void setName(String name){
       if(checkParam(name!=null)){
           this.name=name;
       }
    }
    
    /**
     * Método que devuelve el valor del atributo name
     * 
     * @return  name, el nombre del jugador, de tipo String
     */
    public String getName(){
        return name;
    }
    
    /**
     * Método que modifica el valor del atributo number
     * 
     * @param   number, numero para el jugador, de tipo int
     */
    private void setNumber(int number){
       this.number=number;
    }
    
    /**
     * Método que devuelve el valor del atributo number
     * 
     * @return  number, el numero del jugador, de tipo int
     */
    public int getNumber(){
        return number;
    }
    
    /**
     * Método que devuelve una cadena de caracteres.
     * 
     * @return  la cadena toString con el formato: "Nombre-Numero"
     */
    public String toString(){
        return getName() + " - " + getNumber();
    }
}
