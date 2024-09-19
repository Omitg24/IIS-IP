
/**
 * Clase Weapon para el proyecto Nunchuk
 * 
 * @author Omar Teixeira 
 * @version 31-10-20
 */
public class Weapon
{
    //variables de instancia
    private String weaponName;
    private int ammunition;

    /**
     * Constructor sin parámetros para la clase Weapon
     */
    public Weapon()
    {
        setWeaponName("M416");
        setAmmunition(30);
    }
    
    /**
     * Constructor con parámetros weaponName y ammunition para la clase Weapon
     */
    public Weapon(String weaponName, int ammunition)
    {
        this();
        setWeaponName(weaponName);
        setAmmunition(ammunition);
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
     * Método que modifica el valor del nombre del arma de la clase Weapon
     * 
     * @param  ammunition, nueva munición para el arma, de tipo int
     */
    private void setWeaponName(String weaponName)
    {
        if(checkParam(weaponName!=null)){
            this.weaponName=weaponName;
        }
    }
    
    /**
     * Método que devuelve el valor del nombre del arma de la clase Weapon
     * 
     * @return weaponName, nombre para el arma, de tipo String
     */
    public String getWeaponName(){
        return weaponName;
    }
    
    /**
     * Método que modifica el valor de la munición del arma de la clase Weapon
     * 
     * @param  ammunition, nueva munición para el arma, de tipo int
     */
    private void setAmmunition(int ammunition)
    {
        if(checkParam(ammunition>=0)){
            this.ammunition=ammunition;
        }
    }
    
    /**
     * Método que devuelve el valor de la munición del arma de la clase Weapon
     * 
     * @return ammunition, munición para el arma, de tipo int
     */
    public int getAmmunition(){
        return ammunition;
    }
    
    /**
     * Método que modifica el valor de la munición si tiene munición, y, a su vez, imprime por pantalla "BANG"
     */
    public void shoot(){
        if(getAmmunition()>0){
            System.out.println("BANG");
            setAmmunition(getAmmunition()-1);
        }
    }
    
    /**
     * Método que devuelve la cadena con el nombre del arma y la munición total que tiene.
     * 
     * @return la cadena con el nombre del arma y la munición
     */
    public String toString(){
        String result=getWeaponName() + "-(" +
                      getAmmunition() + ")";
        return result;
    }
    
}
