;
/**
 * Clase Person 1.2. Sesi�n 2 surname y gender, m�todo primt, toString, 
 * constructor
 * 
 * @author Omar Teixeira Gonz�lez 
 * @version 23-9-2020
 */
public class Person
{
    // atributos constantes
    public static final int MIN_AGE = 0;       //edad m�nima
    public static final int MAX_AGE = 120;     //edad m�xima
    
    public static final boolean MALE = true;
    public static final boolean FEMALE = false;
    
    // variables de instancia (atributos variables)
    private String name;      // nombre para la persona 
    private int age;       // edad para la persona
    private String surname;     // apellido para la persona
    private boolean gender;     // género para la persona
    
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
        if(checkParam(newAge>=MIN_AGE && newAge < MAX_AGE))   {
            age = newAge;
        }
    }
    
    /**
     * Comprueba que el parametro es o no correcto
     *
     * @param  condition, condici�n a evaluar, de tipo boolean
     * @return     true o fdalse en funci�n del par�metro
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
     * Método que devuelve el valor del atributo surname
     *
     * 
     * @return     surname, apellido de la persona, de tipo String
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * Método que modifica el valor del atributo surname
     *
     * @param  newSurname   nuevo apellido para el atributo surname
     * 
     */
    public void setSurname(String NewSurname)
    {
        surname = NewSurname;
    }
    
    /**
     * Método que devuelve el valor del atributo gender
     *
     * 
     * @return     gender, género de la persona, de tipo Boolean
     */
    public boolean getGender()
    {
        return gender;
    }
    
    /**
     * Método que modifica el valor del atributo gender
     *
     * @param  newGender    nuevo género para el atributo gender
     * 
     */
    public void setGender(boolean NewGender)
    {
        gender = NewGender;
    }

   /**
    * M�todo que imprime por pantalla un mensaje con informaci�n de la edad
    * de la persona y la que tendr� el proximo a�o. En el siguiente formato ejemplo:
    * "Tengo 26 a�os y el a�o que viene tendr� 26"
    * Adem�s muestra por pantalla todos los valores de los atributos en el formato
    *"Nombre: Fernando; Apellido: Alonso; Edad: 39; G�nero: Masculino"
    * 
    */
   public void print(){
       System.out.println("Tengo "+ age +" a�os y el a�o que viene tendr� " + (age + 1));
       System.out.println(ageNowAndNextYear());
       System.out.println(toString());
       System.out.println(toString());
   }    
   
   /**
    * 
    */
   private String ageNowAndNextYear(){
        return "Tengo "+ age +" a�os y el a�o que viene tendr� " + (age + 1);
   }
   /**
    * M�todo que devuelve la cadena con todos los valores de sus atributos
    * Con el siguiente formato con ejemplo;
    * "Nombre: Fernando; Apellido: Alonso; Edad: 39; G�nero: Masculino"
    * 
    * 
    * @return cadena con todos los valores de los atributos
    */
   public String toString() {
       String result = "Nombre: " + getName().toUpperCase() + 
                       "; Apellido: " + getSurname() + 
                       "; Edad: " + getAge() + 
                       "; G�nero: " + getGender();
       return result;
   }
   
   /**
    * Devuelve Masculino o Femenino en funci�n del valor del atributo gender
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