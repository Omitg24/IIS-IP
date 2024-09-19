
/**
 * Clase Person para primera sesión de IP
 * 
 * @author Omar Teixeira González 
 * @version 16-9-2020
 */
public class Person
{
    // Atributos de la persona
    private String name;      // nombre para la persona 
    private int age;       // edad para la persona
    
    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
       
    }

    /**
     * Método que devuelve el valor del atributo name
     * 
     * 
     * @return     name, nombre de la persona, de tipo String 
     */
    public String getName()
    {
       return name;
    }
    
    /**
     * Método que modifica el valor del atributo name
     *
     * @param  newName  nuevo nombre para el atributo name
     * 
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Método que devuelve el valor del atributo age
     *
     * 
     * @return     age, edad de la persona, de tipo int
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * Método que modifica el valor del atributo age
     *
     * @param  newAge   nueva edad para el atributo age
     * 
     */
    public void setAge(int newAge)
    {
        age = newAge;
    }

}
