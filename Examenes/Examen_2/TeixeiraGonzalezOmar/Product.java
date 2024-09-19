
/**
 * Clase para modelar los productos del almacén
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 14-12-20
 */
public class Product
{
    // constantes
    public static final int CODE_LENGTH = 6;   
    public static final double MIN_PRICE = 0.0;
    public static final int MIN_AMOUNT = 0;
    
    // atributos variables
    private String code;    // c�digo de 6 caracteres
    private double price;    // >=0
    private int amount;     // >=0

    /**
     * Constructor con par�metros que crea objetos producto
     * @param code string de 6 caracteres
     * @param price, float >=0
     * @param amount, int >= 0
     */
    public Product(String code, double price, int amount)
    {
        setCode(code);
        setPrice(price);
        setAmount(amount);
    }

    /**
     * Modifica el valor del código
     * 
     * @param code debe ser una cadena de 6 caracteres
     */
    public void setCode(String code)
    {
        checkParam(code != null, "Esperaba c�digo y fue null");
        checkParam(code.length() == 6, "Tama�o de c�digo inv�lido");
        this.code = code;
    }
    
    /**
     * Modifica el valor del pecio
     * 
     * @param  price el precio debe ser >=0
     * 
     */
    public void setPrice(double price)
    {
        checkParam(price >= MIN_PRICE, "Precio debe ser 0 o mayor");
        this.price = price;
    }
    
    /**
     * Modifica el valor de la contidad del producto
     * 
     * @param amount la cantidad debe ser >=0
     */
    public void setAmount(int amount)
    {
        checkParam(amount >= MIN_AMOUNT, "Cantidad debe ser 0 o mayor");
        this.amount = amount;
    }
    
    /**
     * Devuelve el n�mero de unidades del producto
     * 
     * @return amount, cantidad de art�culos del producto
     */
    public int getAmount(){
        return amount;
    }
       
    /**
     * Devuelve el c�digo del producto
     * 
     * @return el c�digo del art�culo
     */
    public String getCode(){
        return code;
    }
    
    /**
     * Asigna nueva cantidad de unidades al producto
     * 
     * @param amount n�mero de unidades 
     */
    public void changeStock(int amount){
        setAmount(amount);
    }
      
    // Controladores
    
    /**
     * Si no se cumple la condici�n salta excepci�n RuntimeException
     * 
     * @param condition expresi�n booleana a evaluar
     * @param mensaje cadena de texto a mostrar si se produce el error
     */
    public void checkParam(boolean condition, String msg) {
        if (condition == false) {
            throw new RuntimeException(msg);
        }        
    }
    
    /**
     * Comprueba que el c�digo tenga 6 caracteres, si no, lanza excepci�n
     * 
     * @param code la cadena del c�digo del producto
     */
    public void checkString(String code) {
        if (code == null) {
            throw new RuntimeException("Esperaba c�digo y fue null");
        }
        if (code.length() != CODE_LENGTH) {
            throw new RuntimeException("Longitud del c�digo incorrecta");
        }
    } 
}
