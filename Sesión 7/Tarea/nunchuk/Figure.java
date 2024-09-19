
/**
 * Clase Figure del proyecto Nunchuk:
 * 
 * @author Omar Teixeira González 
 * @version 30-10-20
 */
public class Figure
{
    // constantes:
    public static final int X_LOWER_EDGE = 0;
    public static final int Y_LOWER_EDGE = 0;
    public static final int X_UPPER_EDGE = 640;
    public static final int Y_UPPER_EDGE = 320;
    
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';
    public static final char UP = 'U';
    public static final char DOWN = 'D';
    
    public static final int STEP = 10;
    
    // variables de instancia:
    private String name;
    private int xPos;
    private int yPos;

    /**
     * Constructor sin parámetros para la clase figure
     */
    public Figure()
    {
        setName("Omar");
        setXPos(10);
        setYPos(10);
    }
    
    /**
     * Constructor con parámetros name, xPos e yPos de la clase Figure
     */
    public Figure(String name, int xPos, int yPos)
    {
        this();
        setName(name);
        setXPos(xPos);
        setYPos(yPos);
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
     * Método que modifica el valor del atributo name 
     * 
     * @param  name, el nuevo nombre para la figura, de tipo String
     */
    private void setName(String name){
        if(checkParam(name!=null)){        
            this.name=name;
        }
    }
    
    /**
     * Método que devuelve el valor del atributo name
     * 
     * @return name, el nombre de la figura, de tipo String
     */
    public String getName(){
        return name;
    }
    
    /**
     * Método que modifica el valor del atributo xPos 
     * 
     * @param  xPos, la nueva posición x para la figura, de tipo int
     */
    private void setXPos(int xPos){
        if(checkParam(xPos>=X_LOWER_EDGE && xPos <=X_UPPER_EDGE)){        
            this.xPos=xPos;
        }
    }
    
    /**
     * Método que devuelve el valor del atributo xPos
     * 
     * @return xPos, la posición x de la figura, de tipo int
     */
    public int getXPos(){
        return xPos;
    }
    
    /**
     * Método que modifica el valor del atributo yPos 
     * 
     * @param  yPos, la nueva posición y para la figura, de tipo int
     */
    private void setYPos(int yPos){
        if(checkParam(yPos>=Y_LOWER_EDGE && yPos <=Y_UPPER_EDGE)){        
            this.yPos=yPos;
        }
    }
    
    /**
     * Método que devuelve el valor del atributo yPos
     * 
     * @return yPos, la posición y de la figura, de tipo int
     */
    public int getYPos(){
        return yPos;
    }
    
    /**
     * Método que modifica la posición x o la posición y en función del parámetro char que reciba, es decir, si 'L', la posición
     * retrocede en uno, si es 'U' aumenta la posición y en uno, y viceversa:
     * 'L' => -1
     * 'R' => +1
     * 'D' => -1
     * 'U' => +1
     * 
     * @param direction, dirección que realizará el objeto, de tipo char
     */
    public void move(char direction){
        if(direction==LEFT){
            setXPos(getXPos()-1);
        }else if(direction==RIGHT){
            setXPos(getXPos()+1);
        }else if(direction==DOWN){
            setYPos(getYPos()-1);
        }else if(direction==UP){
            setYPos(getYPos()+1);
        }
    }
    
    /**
     * Método que devulve una cadena con el nombre, la posición x y la posición y con el siguiente formato:
     * Omar-(18,14)
     * 
     * @return  la cadena con el nombre, la posición x y la posición y, de tipo String
     */
    public String toString(){
        String result = getName() + "-(" +
                        getXPos() + "," +
                        getYPos() + ")";
        return result;
    }
}
