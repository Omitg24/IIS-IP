import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StoreTest.
 *
 * @author  Omar Teixeira González
 * @version 14-12-20
 */
public class StoreTest
{
    /**
     * Default constructor for test class StoreTest
     */
    public StoreTest()
    {
    }
    
    /*
     * Pruebas del constructor con parámetro Product[] listProducts:
     * Positivos:
     * 1- La lista no es null ni contiene elementos null
     * 
     * Negativos:
     * 2- La lista es null
     * 3- La lista contiene elementos null
     */
    
    /**
     * 1- La lista no es null ni contiene elementos null
     */
    @Test
    public void testConstructorWithParamsOk(){
        Product product1 = new Product("aaaaaa", 12, 4);
        Product product2 = new Product("bbbbbb", 25, 10);
        Product product3 = new Product("cccccc", 50, 5);
        Product product4 = new Product("dddddd", 41, 3);
        Product product5 = new Product("eeeeee", 36, 6);
        Product product6 = new Product("ffffff", 52, 12);
        Store store = new Store(new Product[]{product1, product2, product3, product4, product5, product6});
        ArrayList<Product> newList = store.getProducts();
        assertEquals(6,newList.size());
        for (int i=0; i<newList.size();i++){
            assertNotNull(newList.get(i));
        }
    }
    
    /**
     * 2- La lista es null
     */
    @Test
    public void testConstructorWithParamsNullList(){
        try{
            Store store = new Store(null);
        }catch(RuntimeException msg){
            assertEquals("La lista de productos es null", msg.getMessage());
        }
    }
    
    /**
     * 3- La lista contiene elementos null
     */
    @Test
    public void testConstructorWithParamsNullElements(){
        Product product1 = new Product("aaaaaa", 12, 4);
        Product product2 = new Product("bbbbbb", 25, 10);
        Product product3 = new Product("cccccc", 50, 5);
        Product product4 = new Product("dddddd", 41, 3);
        Product product5 = new Product("eeeeee", 36, 6);
        Product product6 = new Product("ffffff", 52, 12);
        try{
            Store store = new Store(new Product[]{product1, product2, product3, product4, product5, product6,null});
            fail("Esperaba excepción");
        }catch(RuntimeException msg){
            assertEquals("Hay una posición null",msg.getMessage());
        }
    }    
    
    /**
     * Pruebas del método deleteProducts:
     * Positvos:
     * 1- La cantidad es mayor que 0
     * 2- La cantidad es mayor que 0 y hay productos con esa cantidad
     * 3- La cantida es mayor que 0 y mayor que la cantidad de todos los productos
     * 
     * Negativos:
     * 4- Ningun productor tiene esa cantidad
     * 5- La cantidad es menor que 0
     */
    
   /**
    * 1- La cantidad es mayor que 0
    */
   @Test
   public void testDeleteProducts(){
        Product product1 = new Product("aaaaaa", 12, 4);
        Product product2 = new Product("bbbbbb", 25, 10);
        Product product3 = new Product("cccccc", 50, 5);
        Product product4 = new Product("dddddd", 41, 3);
        Product product5 = new Product("eeeeee", 36, 6);
        Product product6 = new Product("ffffff", 52, 12);
        Store store = new Store(new Product[]{product1, product2, product3, product4, product5, product6});

        ArrayList<Product> removed = store.deleteProducts(7);
        ArrayList<Product> newList = store.getProducts();
        assertEquals(2, newList.size());
        assertEquals(2, removed.size());
   }
    
   /**
    * 2- La cantidad es mayor que 0 y hay productos con esa cantidad
    */
   @Test
   public void testDeleteProductsSameAmount(){
        Product product1 = new Product("aaaaaa", 12, 4);
        Product product2 = new Product("bbbbbb", 25, 10);
        Product product3 = new Product("cccccc", 50, 5);
        Product product4 = new Product("dddddd", 41, 3);
        Product product5 = new Product("eeeeee", 36, 6);
        Product product6 = new Product("ffffff", 52, 12);
        Store store = new Store(new Product[]{product1, product2, product3, product4, product5, product6});

        ArrayList<Product> removed = store.deleteProducts(5);
        ArrayList<Product> newList = store.getProducts();
        assertEquals(2, newList.size());
        assertEquals(2, removed.size());
    }
    
   /**
     * 3- La cantida es mayor que 0 y mayor que la cantidad de todos los productos
     */
   @Test
   public void testDeleteProductsOverAmount(){
        Product product1 = new Product("aaaaaa", 12, 4);
        Product product2 = new Product("bbbbbb", 25, 10);
        Product product3 = new Product("cccccc", 50, 5);
        Product product4 = new Product("dddddd", 41, 3);
        Product product5 = new Product("eeeeee", 36, 6);
        Product product6 = new Product("ffffff", 52, 12);
        Store store = new Store(new Product[]{product1, product2, product3, product4, product5, product6});

        ArrayList<Product> removed = store.deleteProducts(15);
        ArrayList<Product> newList = store.getProducts();
        assertEquals(2, newList.size());
        assertEquals(2, removed.size());
   }
   
   /**
     * 4- Ningun productor tiene esa cantidad
     */
   @Test
   public void testDeleteProductsUnderAmount(){
        Product product1 = new Product("aaaaaa", 12, 4);
        Product product2 = new Product("bbbbbb", 25, 10);
        Product product3 = new Product("cccccc", 50, 5);
        Product product4 = new Product("dddddd", 41, 3);
        Product product5 = new Product("eeeeee", 36, 6);
        Product product6 = new Product("ffffff", 52, 12);
        Store store = new Store(new Product[]{product1, product2, product3, product4, product5, product6});

        ArrayList<Product> removed = store.deleteProducts(1);
        ArrayList<Product> newList = store.getProducts();
        assertEquals(6, newList.size());
        assertEquals(6, removed.size());
   }
   
   /**
     * 5- La cantidad es menor que 0
     */
   @Test
   public void testDeleteProductsAmountUnderLimits(){
        Product product1 = new Product("aaaaaa", 12, 4);
        Product product2 = new Product("bbbbbb", 25, 10);
        Product product3 = new Product("cccccc", 50, 5);
        Product product4 = new Product("dddddd", 41, 3);
        Product product5 = new Product("eeeeee", 36, 6);
        Product product6 = new Product("ffffff", 52, 12);
        Store store = new Store(new Product[]{product1, product2, product3, product4, product5, product6});

        try{
            ArrayList<Product> removed = store.deleteProducts(15);
        }catch(RuntimeException msg){
            assertEquals("La cantidad debe de ser mayor que cero",msg.getMessage());
        }
   }
}

