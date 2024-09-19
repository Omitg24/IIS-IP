
/**
 * Clase Tree       Para la Tarea de la Sesión 2
 * 
 * @author Omar Teixeira González
 * @version 24/09/2020
 */
public class Tree
{
    // variables de instancia (atributos variables)
    private String typeOfTree;      //Tipo de arbol
    private int maxNumberOfFlowers = 25;     //Número máximo de flores
    private int numberOfFlowers;        //Número de flores
    private int numberOfFruits;     //Número de frutas
    
    /**
     * Constructor for objects of class Tree
     */
    public Tree()
    {
        settypeOfTree("Manzano");
        setmaxNumberOfFlowers(25);
        setnumberOfFlowers(7);
        setnumberOfFruits(3);
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
    public void setmaxNumberOfFlowers(int newmaxNumberOfFlowers)
    {
        if (newmaxNumberOfFlowers>=0 && newmaxNumberOfFlowers >= numberOfFlowers){
        maxNumberOfFlowers = newmaxNumberOfFlowers;
        }
        
    }

    /**
     * Método que devuelve el valor del atributo numberOfFlowers
     *
     * 
     * @return      numberOfFlowers, número de flores, de tipo int
     * 
     */
    public int getnumberOfFlowers()
    {
        return numberOfFlowers;
    }
    
    /**
     * Método que modifica el valor del atributo numberOfFlowers
     *
     * @param  newnumberOfFlowers    nuevo número de flores para el atributo 
     * numberOfFlowers
     * 
     */
    public void setnumberOfFlowers(int newnumberOfFlowers)
    {
        if(newnumberOfFlowers >= 0 && newnumberOfFlowers <= maxNumberOfFlowers){
            numberOfFlowers = newnumberOfFlowers;
        }
    }
    
    /**
     * Método que devuelve el valor del atributo numberOfFruits
     *
     * 
     * @return      numberOfFruits, número de frutas, de tipo int
     */
    public int getnumberOfFruits()
    {
        return numberOfFruits;
    }
    
    /**
     * Método que modifica el valor del atributo numberOfFruits
     *
     * @param  newnumberOfFruits    nuevo número de frutas para el atributo 
     * numberOfFruits
     * 
     */
    public void setnumberOfFruits(int newnumberOfFruits)
    {
        if (newnumberOfFruits >= 0){
            numberOfFruits = newnumberOfFruits;
        }        
    }
    
    /**
     * Método que devuelve la cadena con todos los valores de sus atributos
     * Con el siguiente formato con ejemplo;
     * “Manzano-25-7-3".
     * 
     * 
     * @return cadena con todos los valores de los atributos
     */
    public String toString() {
        String result = gettypeOfTree()+ "-" + getmaxNumberOfFlowers() + "-" 
        + getnumberOfFlowers() + "-" + getnumberOfFruits();
        return result;
    }
    
    /**
     * Método que imprime por pantalla un mensaje con el valor de las propiedades del 
     * objeto árbol con el siguiente formato ejemplo:
     * "Valores de las propiedades del árbol: Manzano-25-7-3"
     * 
     */
    public void print(){
        System.out.print("Valores de las propiedades del árbol: ");
        System.out.print(toString());
    }  
}
