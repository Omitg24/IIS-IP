
;
/**
 * Clase Persona, con
 * Sesi�n 1:
 *      Atributos nombre y edad con m�todos de modificaci�n y acceso
 * Tarea No Presencial Sesi�n 1:
 *      Se a�ade apellido y g�nero
 * Sesi�n 2:
 *      Control de rango en la edad
 *      Uso de m�todos de modificaci�n en el constructor en lugar de asignaci�n directa
 *      M�todo print que imprima mensaje con la edad y todos los datos de la persona
 *      M�todo toString. M�todo tuUpperCase de String
 *      Constantes para rangos de edad y g�nero
 * Tarea No Presencial Sesi�n 2:
 *      M�todo getCriticalAge()
 *      Constantes  ADULTHOOD_AGE y RETIREMENT_AGE
 * Sesi�n 3:
 *      Creaci�n de clases de Pruebas y su ejecuci�n
 * Tarea No Presencial Sesi�n 3:
 *      Creaci�n de m�todos de Pruebas
 *      M�todo getHashCode()
 * 
 * @author Omar Teixeira Gonz�lez 
 * @version 07/10/2020
 */
public class Person
{
    // atributos constantes
    public static final int MIN_AGE = 0;       //edad m�nima
    public static final int MAX_AGE = 120;     //edad m�xima

    public static final int ADULTHOOD_AGE = 18;     //edad mayor�a de edad
    public static final int RETIREMENT_AGE = 65;     //edad jubilaci�n

    public static final boolean GENDER_MALE = true;
    public static final boolean GENDER_FEMALE = false;
    
    public static final int NAME_LETTERS = 2;
    public static final int SURNAME_LETTERS= 4;

    // variables de instancia (atributos variables)
    private static String name;      // nombre para la persona 
    private int age;       // edad para la persona
    private String surname;     // apellido para la persona
    private boolean gender;     // género para la persona, true Masculino y false Femenino

    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        setName("Omar");
        setAge(18);
        setSurname("Teixeira");
        setGender(GENDER_MALE);
    }
    
    /**
     * Constructor con par�metro la edad de la persona
     * el resto de los datos ser�n los que se asignan en el constructor sin par�metro
     * 
     *@param edad con que se crea el objeto
     */
    public Person(int age)
    {
        this();
        setAge(age);
    }
    
    /**
     * Constructor recibe todos los datos de la persona
     * el resto de los datos ser�n los que se asignan en el constructor sin par�metro
     * En caso de erro en alg�n par�metro debe deja el valor por defecto
     * 
     *@param edad con que se crea el objeto
     *@param ... A�ADIR
     */
    public Person(String name, String surname, int age, boolean gender)
    {
        this();
        setName(name);
        setAge(age);
        setSurname(surname);
        setGender(gender);
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
    public void setName(String name)
    {
        if(checkParam(name!= null)){
            this.name = name;
        }
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
    public void setAge(int age)
    {
        if(checkParam(age >= MIN_AGE && age <= MAX_AGE))   {
            this.age = age;
        }
    }

    /**
     * Comprueba que el parametro es o no correcto
     *
     * @param  condition, condici�n a evaluar, de tipo boolean
     * @return     true o false en funci�n del par�metro
     */
    private boolean checkParam(boolean condition)
    {
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
    public void setSurname(String surname)
    {
        if(checkParam(surname!= null)){
            this.surname = surname;
        }
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
    public void setGender(boolean gender)
    {
        this.gender = gender;
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
        String result = "Nombre: " + this.getName().toUpperCase() + 
            "; Apellido: " + this.getSurname() + 
            "; Edad: " + this.getAge() + 
            "; G�nero: " + this.getGender();
        return result;
    }

    /**
     * Devuelve Masculino o Femenino en funci�n del valor del atributo gender
     * 
     * @return Masculino o Femenino, de tipo String
     * 
     */
    private String genderToString()
    {
        if (gender == GENDER_MALE) {
            return "Masculino";
        } 
        else {
            return "Femenino";
        }
    }

    /**
     * M�todo que devuelve el valor n�merico Age
     *
     * 
     * @return     el valor requerido en funci�n de cada condicional.
     */
    public int getCriticalAge()
    {
        if (getAge() < ADULTHOOD_AGE ) {        //edad inferior a 18
            return ADULTHOOD_AGE  - getAge();        //a�os restantes para tener 18
        }
        else if (getAge() >= ADULTHOOD_AGE && getAge() < RETIREMENT_AGE ){  //edad entre 18 y 65
            return RETIREMENT_AGE  - getAge();       //a�os restantes para tener 65
        }
        else {      //en el resto de casos (edad superior a 65)
            return getAge() - RETIREMENT_AGE;       //a�os pasados desde los 65
        }
    }
    
    /**
     * M�todo que devuelve una cadena determinada de valores.
     *
     * 
     * @return     la cadena de datos dados.
     */
    public String getHashCode()
    {
        return getAge()+
              "-"+getNameLetters()+
              "-"+getSurnameLetters()+
              "-"+getAgeCategory();
    }
    
    /**
     * M�todo que devuelve la etapa en la que se encuentra la persona en
     * funci�n de su edad, por ejemplo: 16:CHILD, 35:ADULT, 71: RETIRED
     *
     *
     * @return     CHILD, ADULT o RETIRED, en funci�n de la edad, de tipo 
     * String
     */
    private String getAgeCategory()
    {
        if (getAge() < ADULTHOOD_AGE ) {
            return "CHILD";
        }
        else if (getAge() >= ADULTHOOD_AGE && getAge() < RETIREMENT_AGE ){
            return "ADULT";
        }
        else {
            return "RETIRED";
        }
    }
    
    /**
     * M�todo que devuelve el nombre recortado a las 2 primeras letras,
     * en caso de tener 2 o m�s letras, o una �nica letra en caso de solo 
     * tener esa
     * 
     * @return     el nombre recortado, de tipo String
     */
    private String getNameLetters()
    {
        if(getName().length()>= NAME_LETTERS){
            this.name = getName().substring(0,NAME_LETTERS).toUpperCase();
        }else{
            this.name = name.toUpperCase();
        }
        return  this.name;
    }
    
    /**
     * M�todo que devuelve el apellido recortado a las 4 primeras letras, 
     * en caso de tener 4 o m�s, o menos que 4 en caso de que el n�mero de 
     * letras que componen al apellido sea inferior a dicha cifra.
     *
     * @return     el apellido recortado, de tipo String
     */
    private String getSurnameLetters()
    {
        if(getSurname().length()>= SURNAME_LETTERS){
            this.surname = getSurname().substring(0,SURNAME_LETTERS).toUpperCase();
        }else{
            this.surname = surname.toUpperCase();
        }
        return  this.surname;
    }
}