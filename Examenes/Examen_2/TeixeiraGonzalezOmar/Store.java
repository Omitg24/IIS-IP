import java.util.ArrayList;
/**
 * Clase Store
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 14-12-20
 */
public class Store
{
    // atributos variables
    private ArrayList<Product> products;

    /**
     * Constructor for objects of class Store
     */
    public Store(Product[] listProducts){
        checkParam(listProducts!=null, "La lista de productos es null");
        for (int i=0; i<listProducts.length;i++){
            checkParam(listProducts[i]!=null, "Hay una posici�n null");
        }
        products = new ArrayList<Product>();
        for (int i=0; i<listProducts.length;i++){
            products.add(listProducts[i]);
        }        
    }
    
    /**
     * M�todo que devuelve una copia de la lista de productos
     * 
     * @return  productsCopy, copia de la lista de productos
     */
    public ArrayList<Product> getProducts(){
        ArrayList<Product> productsCopy = new ArrayList<Product>(products.size());
        for (int i=0; i<products.size();i++){
            productsCopy.add(products.get(i));
        }
        return productsCopy;
    }
    
    // /**
     // * M�todo que almacena los productos de la lista en una matriz
     // * 
     // * @param   columns, columnas que debe tener la nueva matriz que almacene los elementos
     // */
    // public Product[][] generateMatrix(int columns){
        // checkParam(products!=null, "La lista de productos es null");
        // checkParam(columns>=0, "La columna no esta dentro de los l�mites");        
        // for (int i=0; i<products.size();i++){
             // Product[][] matrix = new Product[i][columns];
             
        // }
        // return matrix;
    // }
    
    /**
     * M�todo que elimina todos los productos que tienen una cantidad menor o igual a la introducida por par�metro y devuelve un array con los 
     * eliminados
     * 
     * @param   amount, cantidad de los productos, de tipo int
     * @return  removed, arrayList<Product> con los objetos eliminados
     */
    public ArrayList<Product> deleteProducts(int amount){
        checkParam(amount>0,"La cantidad debe de ser mayor que cero");
        ArrayList<Product> removed = new ArrayList<Product>();
        Product removedP=null;
        for (int i=0; i<products.size();i++){
            if (products.get(i).getAmount()<=amount){
                removedP=products.remove(i);     
                products.remove(i);                           
            }
            removed.add(removedP);
        }
        return removed;
    }
    
    // Controladores
    
    /**
     * Si no se cumple la condici�n salta excepci�n RuntimeException
     * 
     * @param condition expresi�n booleana a evaluar
     * @param mensaje cadena de texto a mostrar si se produce el error
     */
    private void checkParam(boolean condition, String msg) {
        if (condition == false) {
            throw new RuntimeException(msg);
        }        
    }
}
