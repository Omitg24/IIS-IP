
/**
 * Clase Tree       Para la Tarea de la Sesión 2
 * 
 * @author Omar Teixeira González
 * @version 30/09/2020
 */
public class Tree
{
    // atributos constantes
    public static final String DEFAULT_TYPE_OF_TREE = "Manzano";
    public static final int DEFAULT_NUMBER_OF_FLOWERS = 7;
    public static final int DEFAULT_NUMBER_OF_FRUITS = 3;
    
    // variables de instancia (atributos variables)
    private String typeOfTree;      //Tipo de arbol
    private int maxNumberOfFlowers;     //Número máximo de flores
    private int NumberOfFlowers;        //Número de flores
    private int NumberOfFruits;     //Número de frutas
    
    /**
     * Constructor for objects of class Tree
     */
    public Tree()
    {
        settypeOfTree(DEFAULT_TYPE_OF_TREE);
        setmaxNumberOfFlowers(12);
        setNumberOfFlowers(DEFAULT_NUMBER_OF_FLOWERS);
        setNumberOfFruits(DEFAULT_NUMBER_OF_FRUITS);
    }

    /**
     * Método que devuelve el valor del atributo typeOfTree
     * 
     * 
     * @return     typeOfTree, tipo de arbol, de tipo String 
     */
    public String gettypeOfTree()
    {
        return typeOfTree;
    }
    
    /**
     * Método que modifica el valor del atributo typeOfTree
     *
     * @param  newtypeOfTree    nuevo tipo de arbol para el atributo typeOfTree
     * 
     */
    public void settypeOfTree(String newtypeOfTree)
    {
        if (newtypeOfTree != "null"){
            typeOfTree = newtypeOfTree;
        }
    }
    
    /**
     * Método que devuelve el valor del atributo maxNumberOfFlowers
     * 
     * 
     * @return     maxNumberOfFlowers, máximo número de flores, de tipo int 
     */
    public int getmaxNumberOfFlowers()
    {
        return maxNumberOfFlowers;
    }

    /**
     * Método que modifica el valor del atributo maxNumberOfFlowers
     *
     * @param  newmaxNumberOfFlowers    nuevo número máximo de Flores para el atributo 
     * maxNumberOfFlowers
     * 
     */
    public void setmaxNumberOfFlowers(int maxNumberOfFlowers)
    {
        if (maxNumberOfFlowers>=0 && maxNumberOfFlowers >= NumberOfFlowers){
        this.maxNumberOfFlowers = maxNumberOfFlowers;
        }
        
    }

    /**
     * Método que devuelve el valor del atributo NumberOfFlowers
     *
     * 
     * @return      NumberOfFlowers, número de flores, de tipo int
     * 
     */
    public int getNumberOfFlowers()
    {
        return NumberOfFlowers;
    }
    
    /**
     * Método que modifica el valor del atributo numberOfFlowers
     *
     * @param  NumberOfFlowers    nuevo número de flores para el atributo 
     * NumberOfFlowers
     * 
     */
    public void setNumberOfFlowers(int NumberOfFlowers)
    {
        if(NumberOfFlowers >= 0 && NumberOfFlowers <= maxNumberOfFlowers){
            this.NumberOfFlowers = NumberOfFlowers;
        }
    }
    
    /**
     * Método que devuelve el valor del atributo NumberOfFruits
     *
     * 
     * @return      NumberOfFruits, número de frutas, de tipo int
     */
    public int getNumberOfFruits()
    {
        return NumberOfFruits;
    }
    
    /**
     * Método que modifica el valor del atributo NumberOfFruits
     *
     * @param  NumberOfFruits    nuevo número de frutas para el atributo 
     * NumberOfFruits
     * 
     */
    public void setNumberOfFruits(int NumberOfFruits)
    {
        if (NumberOfFruits >= 0){
            this.NumberOfFruits = NumberOfFruits;
        }        
    }
    
    /**
     * Método que devuelve la cadena con todos los valores de sus atributos
     * Con el siguiente formato con ejemplo;
     * “Manzano-12-7-3".
     * 
     * 
     * @return cadena con todos los valores de los atributos
     */
    public String toString() {
        String result = gettypeOfTree()+ "-" + getmaxNumberOfFlowers() + "-" 
        + getNumberOfFlowers() + "-" + getNumberOfFruits();
        return result;
    }
    
    /**
     * Método que imprime por pantalla un mensaje con el valor de las propiedades del 
     * objeto árbol con el siguiente formato ejemplo:
     * "Valores de las propiedades del árbol: Manzano-12-7-3"
     * 
     */
    public void print(){
        System.out.print("Valores de las propiedades del árbol: ");
        System.out.print(toString());
    }  
    
    /**
     * Método para regar, que en caso de que el número de flores sea menor que el maximo 
     * número de flores, dicho número de flores aumentará en 1; en el caso de que el 
     * número de frutas sea menor que el máximo número de flores se restará en 1 el 
     * número de flores y se aumentará en 1 el número de frutas.
     * 
     */
    public void Water()
    {
        if (getNumberOfFlowers() >=0 && getNumberOfFlowers() < getmaxNumberOfFlowers()){
            setNumberOfFlowers(getNumberOfFlowers() + 1);
        }else if (getNumberOfFlowers() >=0 && getNumberOfFruits() < getmaxNumberOfFlowers()){
            setNumberOfFlowers(getNumberOfFlowers() - 1);
            setNumberOfFruits(getNumberOfFruits() + 1);
        }
    }
    
    /**
     * Método de recoger fruta, que disminuye el número de frutas en 1 y da el número de 
     * frutas restantes
     * 
     */
    public int gatherFruit()
    {
        if (getNumberOfFruits() >= 0){      //condicional Nº de frutas mayor o igual a 0
            setNumberOfFruits(getNumberOfFruits() - 1);
        }
        return NumberOfFruits;
    }
    
    /**
     * Método de recogida de la cosecha completa, que devuelve el número de frutas 
     * recogidas y convierte a 0 el valor de NumberOfFruits
     * 
     */
    public int harvest()
    {
        if(NumberOfFruits >=0){         //condicional Nº de frutas mayor o igual a 0
            NumberOfFruits = (getNumberOfFruits() - getNumberOfFruits());
        }
        return NumberOfFruits;
    }

}
