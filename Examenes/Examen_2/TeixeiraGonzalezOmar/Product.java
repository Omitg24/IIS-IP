
/**
 * Clase para modelar los productos del almacÃ©n
 * 
 * @author Omar Teixeira González
 * @version 14-12-20
 */
public class Product
{
    // constantes
    public static final int CODE_LENGTH = 6;   
    public static final double MIN_PRICE = 0.0;
    public static final int MIN_AMOUNT = 0;
    
    // atributos variables
    private String code;    // código de 6 caracteres
    private double price;    // >=0
    private int amount;     // >=0

    /**
     * Constructor con parómetros que crea objetos producto
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
     * Modifica el valor del cÃ³digo
     * 
     * @param code debe ser una cadena de 6 caracteres
     */
    public void setCode(String code)
    {
        checkParam(code != null, "Esperaba código y fue null");
        checkParam(code.length() == 6, "Tamaño de código inválido");
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
     * Devuelve el número de unidades del producto
     * 
     * @return amount, cantidad de artículos del producto
     */
    public int getAmount(){
        return amount;
    }
       
    /**
     * Devuelve el cídigo del producto
     * 
     * @return el cídigo del artículo
     */
    public String getCode(){
        return code;
    }
    
    /**
     * Asigna nueva cantidad de unidades al producto
     * 
     * @param amount número de unidades 
     */
    public void changeStock(int amount){
        setAmount(amount);
    }
      
    // Controladores
    
    /**
     * Si no se cumple la condición salta excepción RuntimeException
     * 
     * @param condition expresión booleana a evaluar
     * @param mensaje cadena de texto a mostrar si se produce el error
     */
    public void checkParam(boolean condition, String msg) {
        if (condition == false) {
            throw new RuntimeException(msg);
        }        
    }
    
    /**
     * Comprueba que el código tenga 6 caracteres, si no, lanza excepción
     * 
     * @param code la cadena del código del producto
     */
    public void checkString(String code) {
        if (code == null) {
            throw new RuntimeException("Esperaba código y fue null");
        }
        if (code.length() != CODE_LENGTH) {
            throw new RuntimeException("Longitud del código incorrecta");
        }
    } 
}
