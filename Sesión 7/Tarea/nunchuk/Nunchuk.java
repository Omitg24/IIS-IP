
/**
 * Clase Nunchuk para el proyecto Nunchunk
 * 
 * @author Omar Teixeira González
 * @version 31-10-20
 */
public class Nunchuk
{
    // instance variables - replace the example below with your own
    private Figure figure1;
    private Weapon weapon1;

    /**
     * Constructor sin parámetros para la clase Nunchuk
     */
    public Nunchuk()
    {
        setFigure(figure1);
        setWeapon(weapon1);
    }
    
    /**
     * Constructor con parámetros figure y weapon para la clase Nunchuk
     */
    public Nunchuk(Figure figure1, Weapon weapon1)
    {
        setFigure(figure1);
        setWeapon(weapon1);
    }
    
    /**
     * Método que devuelve el valor del atributo figure en la clase nunchuk
     * 
     * @return     figure1, figura de la clase figure para la clase nunchuk, de tipo Figure
     */
    public Figure getFigure()
    {
        return figure1;
    }
    
    /**
     * Método que modifica el valor del atributo figure en la clase nunchuk
     * 
     * @param   figure1, nueva figura de la clase figure para la clase nunchuk, de tipo Figure
     */
    private void setFigure(Figure figure1){
        this.figure1 = figure1;
    }
    
    /**
     * Método que devuelve el valor del atributo weapon en la clase nunchuk
     * 
     * @return     weapon1, arma de la clase weapon para la clase nunchuk, de tipo Weapon
     */
    public Weapon getWeapon()
    {
        return weapon1;
    }
    
    /**
     * Método que modifica el valor del atributo weapon en la clase nunchuk
     * 
     * @param   weapon1, nueva arma de la clase weapon para la clase nunchuk, de tipo Weapon
     */
    private void setWeapon(Weapon weapon1){
        this.weapon1 = weapon1;
    }
    
    /**
     * Método que modifica el valor de la posición x o y de la clase Figure en función del parámetro direction
     * 
     * @param   direction, direccion que tomara figure1. 
     */
    public void Advance(char direction){
        figure1.move(direction);
    }
    
    /**
     * Método que modifica el valor de la posición x o y de la clase Figure en función del parámetro direction
     * 
     * @param   direction, direccion que tomara figure1. 
     */
    public void middleAdvance(char direction){
        for (int i=0;i<2;i++){
            figure1.move(direction);
        }
    }
    
    /**
     * Método que modifica el valor de la posición x o y de la clase Figure en función del parámetro direction
     * 
     * @param   direction, direccion que tomara figure1. 
     */
    public void muchAdvance(char direction){
        for (int i=0;i<5;i++){
            figure1.move(direction);
        }
    }
    
    /**
     * Método que dispara 1 vez si el parámetro dado es true, y dispara una rafaga de 5 veces si el parámetro es false
     * 
     * @param   shoot, tipo de disparo del arma, de tipo boolean
     */
    public void shootWeapon(boolean shoot){
        if(shoot==true){
            weapon1.shoot();
        }else{
            for (int i=0;i<5;i++){
                weapon1.shoot();
            }
        }
    }
    
    /**
     * Método que  tiene como parámetro la dirección que tomará el personaje y después disparará el arma una vez
     * 
     * @param   direction, dirección que tomará el personaje, de tipo char
     */
    public void shootForward(char direction){
        figure1.move(direction);
        weapon1.shoot();
    }
    
    /**
     * Método que imprime el estado de los atributos
     */
    public void print(){
        System.out.println(figure1.toString());
        System.out.println(weapon1.toString());
    }
}