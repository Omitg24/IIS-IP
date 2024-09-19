import java.util.ArrayList;
import java.util.Iterator;

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
     * Elimina los hombres de la lista recibida como parámetro
     * 
     * @param   lista con personas. No debe haber elementos null
     * @return número de hombres eliminados
     */
    public int removeMales(ArrayList<Person> list){
        checkParam(list!=null, "Esperaba lista y fue null");
        checkParam(list.size()!=0, "La lista no debe estar vacía");    
        checkNullElements(list, "Existen elementos a null");
        
        int numberOfMalesRemoved=0;
        Iterator<Person> it = list.iterator();
        while(it.hasNext()){
            if(it.next().getGender() == Person.GENDER_MALE){
                numberOfMalesRemoved++;
                it.remove();                
            }
        }
        return numberOfMalesRemoved;
        // for(int i=0; i< list.size();i++){
            // if(list.get(i).getGender() == Person.GENDER_MALE){
                // list.remove(i);
                // numberOfMalesRemoved++;
            // }
        // }
        // return numberOfMalesRemoved;
    }
    
    /**
     * @return  arrayList con las personas de menor edad que estén en el avión
     */
    public ArrayList<Person> getYoungestPersons(){
        int youngestAge = 120;
        for (int i=0; i < seats.length; i++){
            for (int j=0; j < seats[i].length; j++){
                if (seats[i][j]!=null && seats[i][j].getAge() < youngestAge){
                    youngestAge = seats[i][j].getAge();
                }
            }
        }
        ArrayList <Person> youngestList = new ArrayList<Person>();
        for (int i=0; i < seats.length; i++){
            for (int j=0; j < seats[i].length; j++){
                if (seats[i][j]!=null && seats[i][j].getAge() < youngestAge){
                    youngestList.add(seats[i][j]);
                }
            }
        }
        return youngestList;
    }
    
    /**
     * Método print que muestra el estado de los asientos del avión. Con el siguiente formato:
     * X -> adulto
     * C -> niño
     * ? -> asiento libre
     */
     public void print(){
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[0].length; j++){
                if(seats[i][j] != null){
                    if(seats[i][j].getAge() < Person.ADULTHOOD_AGE){
                        System.out.print("C");
                    }
                    else if(seats[i][j].getAge() > Person.ADULTHOOD_AGE){
                        System.out.print("X");
                    }
                }
                else{
                    System.out.print("?");
                }
            }
            System.out.println(" ");
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
     * 
     */
    private void checkNullElements(ArrayList<Person> list, String msg){
        for (Person person : list){
            checkParam(person!=null, msg);
        }
    }
}   
