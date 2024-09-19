import java.util.Random;
/**
 * Clase Persona, con
 * Sesión 1:
 *      Atributos nombre y edad con métodos de modificación y acceso
 * Tarea No Presencial Sesión 1:
 *      Se añade apellido y género
 * Sesión 2:
 *      Control de rango en la edad
 *      Uso de métodos de modificación en el constructor en lugar de asignación directa
 *      Método print que imprima mensaje con la edad y todos los datos de la persona
 *      Método toString. Método tuUpperCase de String
 *      Constantes para rangos de edad y género
 * Tarea No Presencial Sesión 2:
 *      Método getCriticalAge()
 *      Constantes  ADULTHOOD_AGE y RETIREMENT_AGE
 * Sesión 3:
 *      Creación de clases de Pruebas y su ejecución
 * Tarea No Presencial Sesión 3:
 *      Creación de métodos de Pruebas
 *      Método getHashCode()
 * Sesión 4:
 *      Añadimos control de parámetro en set de los String (si es !=null)
 * Tarea No Presencial Sesión 4:
 *      Modificación getHashCode()
 * Sesión 5 (Examen):
 *      Introducción de los métodos set y get del atributo DNI.
 *      Método changeAge()
 * Sesión 6:
 *      Uso del depurador
 *      Implementación de la clase java.util.Random
 * Tarea No Presencial Sesión 11:
 *      Modificación del constructor sin parámetros de la clase
 * 
 * @author  Omar Teixeira González
 * @version 28-10-20
 */
public class Person
{
    // atributos constantes
    public static final int MIN_AGE = 0;       //edad mínima
    public static final int MAX_AGE = 120;     //edad máxima

    public static final int ADULTHOOD_AGE = 18;     //edad mayoría de edad
    public static final int RETIREMENT_AGE = 65;     //edad jubilación

    public static final boolean GENDER_MALE = true;     //género masculino es true
    public static final boolean GENDER_FEMALE = false;      //género femenino es false
    
    public static final int NAME_LETTERS = 2;       //letras del nombre para el nuevo getHashCode
    public static final int SURNAME_LETTERS= 4;     //letras del apel para el nuevo getHashCode
    
    public static final String STANDARD_NAME = "Fernando";      //nombre estándar para la persona
    public static final String STANDARD_SURNAME = "Alonso";       //apellido estándar para la persona
    public static final int STANDARD_AGE = 39;      //edad estándar para la persona
    public static final boolean STANDARD_GENDER = GENDER_MALE;      //género estándar para la persona
    public static final String STANDARD_DNI = "00000000A";      //dni estándar para la persona
    
    public static final int MIN_YEARS_FOR_WOMEN = 20;    //número minimo de años para mujeres (método changeAge())
    public static final int MAX_YEARS_FOR_MEN = 100;        //número máximo de años para hombres (método changeAge())
    
    public static final String femaleNames[] = {"Ana", "Laura", "María", "Bea"};        //array de nombres de mujeres
    public static final String maleNames[] = {"Omar", "Israel", "Víctor", "Álvaro"};        //array de nombres de hombres
    public static final String surnames[] = {"González", "Iglesias", "Martín", "Fernández"};       //array de apellidos
    
    // variables de instancia (atributos variables)
    private String name;      // nombre para la persona 
    private int age;       // edad para la persona
    private String surname;     // apellido para la persona
    private boolean gender;     // gÃ©nero para la persona, true Masculino y false Femenino
    private String dni;

    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        Random random = new Random();
        setGender(random.nextBoolean());
        if (getGender()==GENDER_MALE){
            setName(maleNames[random.nextInt(maleNames.length)]);
        }else{
            setName(femaleNames[random.nextInt(femaleNames.length)]);
        }
        setSurname(surnames[random.nextInt(surnames.length)]);
        setAge(random.nextInt(120));        
        //setAge (getRandomAge());
        setDni(STANDARD_DNI);
    }
     
    /**
     * Constructor con parámetro la edad de la persona
     * el resto de los datos serán los que se asignan en el constructor sin parámetro
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
     * el resto de los datos serán los que se asignan en el constructor sin parámetro
     * En caso de erro en algún parámetro debe deja el valor por defecto
     * 
     *@param edad con que se crea el objeto
     *@param ... AÑADIR
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
     * 
     */
    public Person(boolean gender){
        this();
        setName(gender);
        setGender(gender);
    }
        
    /**
     * Método que modifica el valor del atributo name dado el género.
     * 
     * @param   gender, genero de la persona, de tipo boolean
     */
    public void setName(boolean gender){
        Random random = new Random();
        if (gender==GENDER_MALE){
            setName(maleNames[random.nextInt(maleNames.length)]);
        }else{
            setName(femaleNames[random.nextInt(femaleNames.length)]);
        }
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
    public void setName(String name)
    {
        if(checkParam(name!= null)){
            this.name = name;
        }
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
     * Genera un número aleatorio entre 0 y 120 [0,120)
     * @return número aleatorio generado
     */
    public int getRandomAge(){
        Random randomNumberGenerator = new Random();
        return randomNumberGenerator.nextInt(MAX_AGE);
     }
    
    /**
     * MÃ©todo que modifica el valor del atributo age
     *
     * @param  newAge   nueva edad para el atributo age
     * 
     */
    public void setAge(int newAge)
    {
        if(checkParam(newAge >= MIN_AGE && newAge < MAX_AGE)){
            age = newAge;
        }
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
    public void setSurname(String surname)
    {
        if(checkParam(surname!= null)){
            this.surname = surname;
        }
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
    public void setGender(boolean gender)
    {
        this.gender = gender;
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
        String result = "Nombre: " + this.getName().toUpperCase() + 
            "; Apellido: " + this.getSurname() + 
            "; Edad: " + this.getAge() + 
            "; Género: " + this.getGender();
        return result;
    }

    /**
     * Devuelve Masculino o Femenino en función del valor del atributo gender
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
     * Método que devuelve el valor númerico Age
     *
     * 
     * @return     el valor requerido en función de cada condicional.
     */
    public int getCriticalAge()
    {
        if (getAge() < ADULTHOOD_AGE ) {        //edad inferior a 18
            return ADULTHOOD_AGE  - getAge();        //años restantes para tener 18
        }
        else if (getAge() >= ADULTHOOD_AGE && getAge() < RETIREMENT_AGE ){  //edad entre 18 y 65
            return RETIREMENT_AGE  - getAge();       //años restantes para tener 65
        }
        else {      //en el resto de casos (edad superior a 65)
            return getAge() - RETIREMENT_AGE;       //años pasados desde los 65
        }
    }
    
    /**
     * Método que devuelve una cadena determinada de valores.
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
     * Método que devuelve la etapa en la que se encuentra la persona en
     * función de su edad, por ejemplo: 16:CHILD, 35:ADULT, 71: RETIRED
     *
     *
     * @return     CHILD, ADULT o RETIRED, en función de la edad, de tipo 
     * String
     */
    public String getAgeCategory()
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
     * Método que devuelve el nombre recortado a las 2 primeras letras,
     * en caso de tener 2 o más letras, o una única letra en caso de solo 
     * tener esa
     * 
     * @return     el nombre recortado, de tipo String
     */
    public String getNameLetters()
    {
        if(getName().length()>= NAME_LETTERS){
            this.name = getName().substring(0,NAME_LETTERS).toUpperCase();
        }else{
            this.name = name.toUpperCase();
        }
        return  this.name;
    }
    
    /**
     * Método que devuelve el apellido recortado a las 4 primeras letras, 
     * en caso de tener 4 o más, o menos que 4 en caso de que el número de 
     * letras que componen al apellido sea inferior a dicha cifra.
     *
     * @return     el apellido recortado, de tipo String
     */
    public String getSurnameLetters()
    {
        if(getSurname().length()>= SURNAME_LETTERS){
            this.surname = getSurname().substring(0,SURNAME_LETTERS).toUpperCase();
        }else{
            this.surname = surname.toUpperCase();
        }
        return  this.surname;
    }
    
    /**
     * Método que devuelve el valor del atributo dni
     *
     * 
     * @return   dni, el dni de la persona, de tipo String
     */
    public String getDni()
    {
        return dni;
    }
    
    /**
     * Método que modifica el valor del atributo dni
     *
     * @param  theDni, dni para el atributo dni
     * 
     */
    private void setDni(String theDni)
    {
        if(checkParam(theDni!=null && theDni.length()==9)){
          this.dni = theDni;
        }
    }
    
    /**
     * Cambia la edad de la persona
     * Si es hombre, aumenta tantos años como la longitud de su apellido, si al aumentar no supera los 100
     * Si es mujer y mayor de edad, reduce tantos años como la longitud de su nombre, siempre que no baje de 20 años
     * 
     */
    public void changeAge(){
        if(getGender() == GENDER_MALE){
            int newAge = getAge() + getSurname().length();
            if(newAge < MAX_YEARS_FOR_MEN){
                setAge(newAge);
            }
        }else if (getAge() >= ADULTHOOD_AGE){
            int newAge = getAge() - getName().length();
            if(newAge > MIN_YEARS_FOR_WOMEN) {
                setAge(newAge);
            }
        }   
            }
}