import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Write a description of class SeatManager here.
 * 
 * @author Omar Teixeira González
 * @version 25-10-20
 */
public class SeatManager
{
    // constantes
    public static final int COLUMNS=6;
    
    public static final int MIN_FIRST_ROWS =  4;
    public static final int MAX_FIRST_ROWS =  40;
    
    public static final int MIN_STANDARD_ROWS =  4;
    public static final int MAX_STANDARD_ROWS =  40;
    
    public static final byte FIRST_CLASS = 1;
    public static final byte STANDARD_CLASS = 2;
    public static final byte ALL_CLASS = 3;
        
    // atributos variables
    private int firstRows;
    private int standardRows;
    private Person[][] seats;
    
    /**
     * Constructor for objects of class SeatManager
     */
    public SeatManager(int first, int standard)
    {
        setFirstRows(first);
        setStandardRows(standard);
        //setSeats(new Person[firs+standard][COLUMNS];
        seats =  new Person[first+standard][COLUMNS];
    }  

    /**
     * Método que modifica el valor del atributo FirstRows
     * 
     * @param  rows, numero de filas para el avión, de tipo int
     */
    private void setFirstRows(int rows)
    {
        checkParam(rows >= MIN_STANDARD_ROWS && rows <= MAX_STANDARD_ROWS, "Filas en primera fuera de limites");
        firstRows = rows;
    }
    
    /**
     * Método que modifica el valor del atributo StandardRows
     * 
     * @param  rows, numero de filas para el avión, de tipo int
     */
    public void setStandardRows(int rows)
    {
        checkParam(rows >= MIN_STANDARD_ROWS && rows <= MAX_STANDARD_ROWS, "Filas en primera fuera de limites");
        standardRows = rows;
    }
    
    /**
     * Método que reserva el asiento dado una columna
     */
    public boolean bookSeat(Person passenger, int row, int column){
        checkParam(passenger != null, "Esperaba pasajero y fue null");
        checkParam(row >= 0 && row <  seats.length, "Fila fuera de limites");
        checkParam(column>=0 && column < seats[row].length, "Columna fuera de limites");
        if (seats[row][column] == null){
            seats[row][column] =  passenger;
            return true;
        }
        return false;
    }
    
    /**
     * Método que libera el asiento
     * 
     * @param row, fila, de tipo int
     * @param column, columna, de tipo int
     * @return person, persona que libera el asiento
     */
    public Person release(int row, int column){
        checkParam(row >= 0 && row <  seats.length, "Fila fuera de limites");
        checkParam(column>=0 && column < seats[row].length, "Columna fuera de limites");
        if(seats[row][column]!=null){
            seats[row][column] = null;
            return seats[row][column];                        
        }
        return null;
    }
    
    /**
     * Método que devuelve el asiento dada la fila y la columna
     * 
     * @param   row, fila, de tipo int
     * @param   column, columna, de tipo int
     * @return  seats, los asientos
     */
    public Person getSeat(int row, int column){
        checkParam(row >= 0 && row <  seats.length, "Fila fuera de limites");
        checkParam(column>=0 && column < seats[row].length, "Columna fuera de limites");
        return seats[row][column];
    }
    
    /**
     * Método que devuelve el pasajero de más edad o en caso de que el avión esté vacío devuelve null
     * 
     * @return  passenger o null
     */
    public Person oldestPassenger(){
        Person person = null;
        int aux = -1;
        for (int i=0; i<seats.length; i++){
            for(int j = 0; j< seats[i].length; j++){
                if (seats[i][j]!=null){
                    if(seats[i][j].getAge() > aux){
                        person = seats[i][j];
                        aux++;
                    }
                }
            }            
        }
        return person;
    }
    
    /**
     * Método que devuelve el número de asientos libres en una fila del avión
     * 
     * @param   row, fila del avión, de tipo int
     * @return  numberOfFreeSeats, numero de asientos, de tipo int
     */
    public int numberOfFreeSeats(int row){
       checkParam(row >= 0 && row <= seats.length,"Valor de filas no válido");
       int count = 0;
       for(int i = 0; i < seats[row].length;i++){    
           if(seats[row][i] == null){
               count = count + 1;
            }
        }
        return count;
    }
    
    /**
     * Método que devuelve el numero de asientos ocupados del avión
     * 
     * @return  count, cuenta de los asientos ocupados, de tipo int
     */
    public int numberOfOccupiedSeats(){
        int count=0;
        for (int i=0; i<seats.length;i++){
            for (int j=0; j<seats[i].length;j++){
                if(seats[i][j]!=null){
                    count++;
                }               
            }
        }
        return count;    
    }
    
    /**
     * Método print que muestra el estado de los asientos del avión. Con el siguiente formato:
     * X -> adulto
     * C -> niño
     * ? -> asiento libre
     */
     public void print(){
        System.out.println("");
         for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j] != null){
                    if(seats[i][j].getAge() < Person.ADULTHOOD_AGE){
                        System.out.print("C");
                    }else if(seats[i][j].getAge() > Person.ADULTHOOD_AGE){
                        System.out.print("X");
                    }
                }else{
                    System.out.print("?");
                }
            }
            System.out.println(" ");
        }
        System.out.println("");
    }
    
    /**
     * Método que elimina los hombres de la lista recibida y devuelve el número eliminado de estos
     * 
     * @param   lista con parámetros
     * @return número de hombres eliminados
     */
    public int removeMales(ArrayList<Person> list){
        checkParam(list!=null,"Esperaba lista y fue null");
        checkParam(list.size()!=0,"Esperaba lista con elementos y no tiene");
        checkNullElements(list, "Existen elementos a null");        
        int numberOfMalesRemoved = 0;
        Iterator<Person> it = list.iterator();
        while (it.hasNext()){
            if(it.next().getGender()==Person.GENDER_MALE){
                it.remove();
                numberOfMalesRemoved++;
            }
        }
        // for(int i=0; i<list.size(); i++){
            // if(list.get(i).getGender() == Person.GENDER_MALE){
                // list.remove(i);
                // numberOfMalesRemoved++;
                // i--;
            // }            
        // }
        return numberOfMalesRemoved;
    }
    
    /**
     * Método que devuelve las personas más jovenes del avión
     * 
     * @return  arrayList con las personas de menor edad que estén en el avión
     */
    public ArrayList<Person> getYoungestPeople(){ 
        checkParam(seats!=null, "No hay nadie en el avión");        
        int youngestAge=120;
        for (int i=0; i<seats.length; i++){
            for (int j=0; j< seats[i].length; j++){
                if (seats[i][j]!=null && seats[i][j].getAge() < youngestAge){
                    youngestAge = seats[i][j].getAge();
                }
            }            
        }
        ArrayList<Person> youngestList = new ArrayList<Person>();
        for (int i=0; i<seats.length; i++){
            for (int j=0; j< seats[i].length; j++){
                if (seats[i][j]!=null && seats[i][j].getAge() == youngestAge){
                    youngestList.add(seats[i][j]);
                }
            }            
        }
        return youngestList;
    }
    
    /**
     * Método que devuelve una lista que contiene a todos los pasajeros que son niños
     * 
     * @return  arrayList con las personas menores de 18 años
     */
    public ArrayList<Person> childrenPassengers(){
        checkParam(seats!=null, "No hay nadie en el avión");
        ArrayList<Person> childrenPassengers = new ArrayList<Person>();
        for (int i=0; i<seats.length; i++){
            for (int j=0; j< seats[i].length; j++){
                if (seats[i][j]!=null && seats[i][j].getAge() < Person.ADULTHOOD_AGE){
                    childrenPassengers.add(seats[i][j]);
                }
            }            
        }
        return childrenPassengers;
    }
    
    /**
     * Método que devuelve el número de pasajeros sentados en un área del avión
     * 
     * @return  número de pasajerso sentados en un área del avión
     */
    public int getNumPax(byte area){
        int count=0;
        if (area == FIRST_CLASS){
            for (int i=0; i<MAX_FIRST_ROWS; i++){
                for (int j=0; j<seats[i].length; j++){
                    if (seats[i][j] != null){
                        count++;
                    }
                }
            }
        }else if (area == STANDARD_CLASS){
            for (int i=0; i<MAX_STANDARD_ROWS; i++){
                for (int j=0; j<seats[i].length; j++){
                    if (seats[i][j] != null){
                        count++;
                    }
                }
            }
        }else if (area == ALL_CLASS){
            for (int i=0; i<seats.length; i++){
                for (int j=0; j<seats[i].length; j++){
                    if (seats[i][j] != null){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    /**
     *  Método que devuelve el número de pasajeros sentados en una sección del avión
     *  
     *  @param  row1,
     *          column1,
     *          row2,
     *          column2,
     *          filas y columnas que determinan la sección, de tipo int
     */
    public int getNumPaxBySection(int row1, int column1, int row2, int column2){
        int count=0;
        for (int i=row1; i<row2; i++){
            for (int j=column1; j<column2; j++){
                if (seats[i][j] != null){
                    count++;
                }
            }
        }
        return count;
    }
    
    /**
     * Método que sienta en el avión a un número de pasajeros introducido por parámetro
     * 
     * @param   paxNumber, numero de pasajeros a sentar en el avión, de tipo int
     */
    public void loadPax (int paxNumber){
        checkParam(paxNumber>0,"El parámetro es incorrecto");
        for (int i=0; i<seats.length;i++){
            for (int j=0; j<seats[i].length; j++){
                if(seats[i][j]!=null){
                    seats[i][j] = new Person();
                    paxNumber--;
                }
            }
        }
    }
    
    /**
     * Método que asigna asientos a un número de pasajeros recibido como parametro
     * 
     * @param   passengersToSeat, numero de pasajeros para sentar, de tipo int
     */
    public void loadPassengers (int passengersToSeat){
        checkParam(passengersToSeat > 0, "El numero de pasajeros no supera el mínimo");
        checkParam(passengersToSeat <= seats.length * seats[0].length, "El numero de pasajeros supera a la capacidad del avión");
        
        Random random = new Random();
        passengersToSeat = new Random().nextInt(passengersToSeat+1);
        
        int freeSeats = seats.length * seats[0].length - numberOfOccupiedSeats();
        if (passengersToSeat > freeSeats){
            passengersToSeat = passengersToSeat - (passengersToSeat - freeSeats);
        }
        loadPassengersInPlane(passengersToSeat);
    }
    
    /**
     * Método que asigna asientos a un número de pasajeros recibido como parámetro
     * 
     * @param   passengersToSeat, numero de pasajeros para introducir en el avión, de tipo int
     */
    private void loadPassengersInPlane(int passengersToSeat){
        Random random = new Random();
        int row=0;
        int column=0;
        
        for (int i=1;1<passengersToSeat;i++){
            do{
                row = random.nextInt(seats.length);
                column = random.nextInt(seats[0].length);
            }while(seats[row][column]!=null);
            this.bookSeat(new Person(), row, column);
        }
    }
       
    // Controladores
    /**
     * Controla el parámetro y devuelve un mensaje en caso de ser falso
     */
    private void checkParam(boolean condition, String msg){
        if(!condition){
            throw new RuntimeException(msg);
        }
    }
    
    /**
     * Método que comprueba el número de elementos nulos en la lista
     */
    private void checkNullElements(ArrayList<Person> list, String msg){
        for (Person person : list){
            checkParam(person!=null, msg);
            // if (person == null){
                // throw new RuntimeException(msg);
            // }
        }
    }
}   
