;
/**
 * Clase Person 1.2. Sesión 2 surname y gender, método primt, toString, 
 * constructor
 * 
 * @author Omar Teixeira González 
 * @version 23-9-2020
 */
public class Person
{
    // atributos constantes
    public static final int MIN_AGE = 0;       //edad mínima
    public static final int MAX_AGE = 120;     //edad máxima
    
    public static final boolean MALE = true;
    public static final boolean FEMALE = false;
    
    // variables de instancia (atributos variables)
    private String name;      // nombre para la persona 
    private int age;       // edad para la persona
    private String surname;     // apellido para la persona
    private boolean gender;     // gÃ©nero para la persona
    
    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
       //name = "Fernando";
       //surname = "Alonso";
       setName("Fernando");
       setSurname("Alonso");
       setAge(39);
       setGender(MALE);
       //age=39
    }

    /**
     * MÃ©todo que devuelve el valor del atributo name
     * 
     * 
     * @return     name, nombre de la persona, de tipo String 
     */
    public String getName()
    {
       return name;
    }
    
    /**
     * MÃ©todo que modifica el valor del atributo name
     *
     * @param  newName  nuevo nombre para el atributo name
     * 
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * MÃ©todo que devuelve el valor del atributo age
     *
     * 
     * @return     age, edad de la persona, de tipo int
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * MÃ©todo que modifica el valor del atributo age
     *
     * @param  newAge   nueva edad para el atributo age
     * 
     */
    public void setAge(int newAge)
    {
        if(checkParam(newAge>=MIN_AGE && newAge < MAX_AGE))   {
            age = newAge;
        }
    }
    
    /**
     * Comprueba que el parametro es o no correcto
     *
     * @param  condition, condición a evaluar, de tipo boolean
     * @return     true o fdalse en función del parámetro
     */
    public boolean checkParam(boolean condition)
    {
        // if (condition = true){
            //return true;
        // }else {
            //return false;
        //}
        return condition;
    }

    /**
     * MÃ©todo que devuelve el valor del atributo surname
     *
     * 
     * @return     surname, apellido de la persona, de tipo String
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * MÃ©todo que modifica el valor del atributo surname
     *
     * @param  newSurname   nuevo apellido para el atributo surname
     * 
     */
    public void setSurname(String NewSurname)
    {
        surname = NewSurname;
    }
    
    /**
     * MÃ©todo que devuelve el valor del atributo gender
     *
     * 
     * @return     gender, gÃ©nero de la persona, de tipo Boolean
     */
    public boolean getGender()
    {
        return gender;
    }
    
    /**
     * MÃ©todo que modifica el valor del atributo gender
     *
     * @param  newGender    nuevo gÃ©nero para el atributo gender
     * 
     */
    public void setGender(boolean NewGender)
    {
        gender = NewGender;
    }

   /**
    * Método que imprime por pantalla un mensaje con información de la edad
    * de la persona y la que tendrá el proximo año. En el siguiente formato ejemplo:
    * "Tengo 26 años y el año que viene tendré 26"
    * Además muestra por pantalla todos los valores de los atributos en el formato
    *"Nombre: Fernando; Apellido: Alonso; Edad: 39; Género: Masculino"
    * 
    */
   public void print(){
       System.out.println("Tengo "+ age +" años y el año que viene tendré " + (age + 1));
       System.out.println(ageNowAndNextYear());
       System.out.println(toString());
       System.out.println(toString());
   }    
   
   /**
    * 
    */
   private String ageNowAndNextYear(){
        return "Tengo "+ age +" años y el año que viene tendré " + (age + 1);
   }
   /**
    * Método que devuelve la cadena con todos los valores de sus atributos
    * Con el siguiente formato con ejemplo;
    * "Nombre: Fernando; Apellido: Alonso; Edad: 39; Género: Masculino"
    * 
    * 
    * @return cadena con todos los valores de los atributos
    */
   public String toString() {
       String result = "Nombre: " + getName().toUpperCase() + 
                       "; Apellido: " + getSurname() + 
                       "; Edad: " + getAge() + 
                       "; Género: " + getGender();
       return result;
   }
   
   /**
    * Devuelve Masculino o Femenino en función del valor del atributo gender
    * 
    * @return Masculino o Femenino, de tipo String
    * 
    */
   private String genderToString(){
        if (gender == MALE) {
            return "Masculino";
        } else {
            return "Femenino";
        }
    }
}