import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Clase SeatManager:
 * Sesión 10:
 *      Constructor con parámetros
 *      Métodos get y set de FirstRows y StandardRows
 *      Método setSeats
 *      Método bookSeat
 *      Método release
 *      Método getSeat
 *      Método oldestPassenger
 *      Método numberOfFreeSeats
 * Tarea No Presencial Sesión 11:
 *      Método print
 *      Método numberOfOcuppied
 * Sesión 12:
 *      Método removeMales
 *      Método getYoungestPeople 
 *      Método youngestAge
 * Tarea No Presencial Sesión 12:
 *      Método getNumPax
 *      Método getNumPaxBySection
 *      Método validArea
 *      Método loadPassengers
 *      Método loadPax
 *      Método loadPassengersInPlane
 *  Ejercicios de complemento:
 *      Método getPosition
 *      Método getFirstFreeSeatsInWindow
 *      Método getColumn
 *      Método getColumnArray
 *      Método getRow
 *      Método getRowArray
 *      Método subArray
 *      Modificación método print
 * 
 * @author Omar Teixeira González
 * @version 14-12-20
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
     * Constructor con parámetros de la calse SeatManager
     */
    public SeatManager(int first, int standard)
    {
        setFirstRows(first);
        setStandardRows(standard);
        //setSeats(new Person[firs+standard][COLUMNS];
        seats =  new Person[first+standard][COLUMNS];
    }
    
    /**
     * Método que devuelve el valor del atributo firstRows
     * 
     * @return firstRows, numero de filas en primera
     */
    public int getFirstRows(){
        return firstRows;
    }
    
    /**
     * Método que devuelve el valor del atributo standardRows
     * 
     * @return firstRows, numero de filas en turista
     */
    public int getStandardRows(){
        return standardRows;
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
    private void setStandardRows(int rows)
    {
        checkParam(rows >= MIN_STANDARD_ROWS && rows <= MAX_STANDARD_ROWS, "Filas en primera fuera de limites");
        standardRows = rows;
    }
    
    /**
     * Método que asigna un nuevo valor a seats
     * 
     * @param   seats, nuevo valor para seats, de tipo Person[][]
     */
    private void setSeats(Person[][] seats){
        checkParam(seats!=null,"Esperaba matriz de asientos pero fue null");
        this.seats=seats;
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
     * Método que recibe una persona como párametro y devuelve un objeto con el asiento en el que esta sentada
     * 
     * @param   person, pasajero del avión, de tipo Person
     * @return  position, objeto con la posición del pasajero, de tipo Position
     */
    public Position getPosition(Person person){
        checkParam(person!=null, "La persona es null");
        Position position = null;
        for (int i=0; i<seats.length;i++){
            for (int j=0; j<seats[i].length;j++){
                if(seats[i][j]==person){
                    position= new Position(i,j);
                }
            }
        }
        return position;
    }
    
    /**
     * Método que devuelve la primera fila en la que hay mas de dos asientos libres consecutivos
     */
    public int getFirstFreeSeatsInWindow(){
        for (int i=0; i<seats.length;i++){
            if (seats[i][0]==null && seats[i][1]==null){
                return i;
            }else if(seats[i][4]==null  && seats[i][5]==null){
                return i;
            }
        }
        return 50;
    }
    
    /**
     * Método que devuelve todas las personas que hay en una columna
     * 
     * @param   column, columna para recopilar a todas las personas que estan en ella, de tipo int
     * @return  personas de la columna seleccionada
     */
    public Person[] getColumn(int column){
        checkParam(column>=0 && column < seats[0].length, "La columna no cumple los limites");
        Person[] list = new Person[seats.length];
        for (int i=0;i<seats.length;i++){
                 list[i]=seats[i][column];
        }
        return list;
    }
    
    /**
     * Método que devuelve un arrayList de las personas que hay en una columna
     * 
     * @param   column, columna para recopilar a todas las personas que estan en ella, de tipo int
     * @return  personas de la columna seleccionada
     */
    public ArrayList<Person> getColumnArray(int column){
        checkParam(column>=0 && column < seats[0].length, "La columna no cumple los limites");
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i=0; i<seats.length;i++){
            list.add(seats[i][column]);
        }
        return list;
    }
    
    /**
     * Método que devuelve todas las personas que hay en una fila
     * 
     * @param   row, fila para recopilar a todas las personas que estan en ella, de tipo int
     * @return  personas de la fila seleccionada
     */
    public Person[] getRow(int row){
        checkParam(row>=0 && row < seats.length, "La fila no cumple los limites");
        Person[] list = new Person[seats[0].length];
        for (int j=0;j<seats[0].length;j++){
            list[j]=seats[row][j];
        }
        return list;
    }
    
    /**
     * Método que devuelve un arrayList de las personas que hay en una fila
     * 
     * @param   row, fila para recopilar a todas las personas que estan en ella, de tipo int
     * @return  personas de la fila seleccionada
     */
    public ArrayList<Person> getRowArray(int row){
        checkParam(row>=0 && row < seats.length, "La fila no cumple los limites");
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i=0; i<seats[0].length;i++){
            list.add(seats[row][i]);
        }
        return list;
    }
    
    /**
     * Método que devuelva un array Bidimensionl comprendido entre las columnas y filas indicadas
     * 
     * @param   row1
     *          column1
     *          row2
     *          column2, filas y columnas del area seleccionada
     * @return  list, array bidimensional con las personas
     */
    public Person[][] subArray(int row1, int column1, int row2, int column2){
        checkParam(row1>=0 && row1 < seats.length, "La fila no cumple los limites");
        checkParam(column1>=0 && column1 < seats.length, "La columna no cumple los limites");
        checkParam(row2>=0 && row2 < seats.length, "La fila no cumple los limites");
        checkParam(column2>=0 && column2 < seats.length, "La columna no cumple los limites");
        Person[][] list = new Person[(row2-row1)][(column2-column1)];
        for (int i=row1;i<row2;i++){
            for (int j=column1;j<column2;j++){
                list[i-row1][j-column1]=seats[i][j];
            }
        }
        return list;
    }
    
    /**
     * Método que elimina las personas de una fila seleccionada
     * 
     * @param   row, fila seleccionada, de tipo int
     */
    public void removeRow(int row){
        for(int i=0; i<seats.length;i++){
            for(int j=0; j<seats[i].length;j++){
                seats[row][j]=null;
            }
        }
    }
    
    /**
     * Método que elimina las personas de una columna seleccionada
     * 
     * @param   column, column seleccionada, de tipo int
     */
    public void removeColumn(int column){
        for(int i=0; i<seats.length;i++){
            for(int j=0; j<seats[i].length;j++){
                seats[i][column]=null;
            }
        }
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
        System.out.println("  A B C  D E F");
        printForAreas(0, firstRows-1);
        System.out.println("---------------");
        printForAreas(firstRows, firstRows+standardRows-1);
        System.out.println("");
    }
    
    /**
     * Método que imprime las filas y columnas de un avión por partes, separadas entre first y standard
     */
    private void printForAreas(int area1, int area2){
        for (int i=area1; i<=area2;i++){
            System.out.print(i+" ");
            for (int j=0; j<seats[i].length; j++){
                if (j==3){
                    System.out.print(" ");
                }
                if(seats[i][j]==null){
                    System.out.print("? ");
                }else if(seats[i][j].getAge()>=Person.ADULTHOOD_AGE){
                    System.out.print("X ");
                }else{
                    System.out.print("C ");
                }                
            }
            System.out.println();
        }
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
        checkParam(numberOfOccupiedSeats()==0, "No hay nadie en el avión");                
        ArrayList<Person> youngestList = new ArrayList<Person>();
        for (int i=0; i<seats.length; i++){
            for (int j=0; j< seats[i].length; j++){
                if (seats[i][j]!=null && seats[i][j].getAge() == youngestAge()){
                    youngestList.add(seats[i][j]);
                }
            }            
        }
        return youngestList;
    }
    
    /**
     * Método que devuelve la edad del pasajero más joven del avión
     * 
     * @return  age, edad del pasajero más joven
     */
    private int youngestAge(){
        int youngestAge=120;
        for (int i=0; i<seats.length; i++){
            for (int j=0; j< seats[i].length; j++){
                if (seats[i][j]!=null && seats[i][j].getAge() < youngestAge){
                    youngestAge = seats[i][j].getAge();
                }
            }            
        }
        return youngestAge;
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
        checkParam(validArea(area), "El area es incorrecta");
        int count=0;
        switch (area){
            case FIRST_CLASS:
                count = getNumPaxBySection(0,0,getFirstRows(),COLUMNS);
                break;
            case STANDARD_CLASS:
                count = getNumPaxBySection(getFirstRows(),0,seats.length,COLUMNS);
                break;
            case ALL_CLASS:
                count = getNumPaxBySection(0,0,seats.length,COLUMNS);
        }
        return count;
    }
    
    /**
     * Método que controla si el area es valida
     * 
     * @param   area, area del avión, de tipo byte
     */
    private boolean validArea(byte area){
        return area>= FIRST_CLASS && area <= ALL_CLASS;
    }
    
    /**
     * Método que rellena los asientos con personas aleatorias
     * 
     * @param   sm1, de tipo SeatManager
     */
    public void fillSeats(SeatManager sm1){
        for (int i=0; i<seats.length;i++){
            for (int j=0; j<seats[i].length;j++){
                if(seats[i][j]==null){
                    bookSeat(new Person(),i,j);
                }
            }
        }
    }
    
    /**
     *  Método que devuelve el número de pasajeros sentados en una sección del avión
     *  
     *  @param  row1,
     *          column1,
     *          row2,
     *          column2,
     *          filas y columnas que determinan la sección, de tipo int
     * @return  cuenta del numero de personas que hay en esa zona
     */
    public int getNumPaxBySection(int row1, int column1, int row2, int column2){
        checkParam(row1>=0 && row2<=seats.length,"Las filas no corresponden a los limites del avión");
        checkParam(column1>=0 && column2<=seats[0].length,"Las columnas no corresponden a los limites del avión");
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
        checkParam(paxNumber<=numberOfFreeSeats(),"Más pasajeros que asientos libres");
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
     * Método que devuelve el número de asientos libres
     * 
     * @return  freeSeats, numero de asientos libres
     */
    private int numberOfFreeSeats(){
        int freeSeats=0;
        for(int i=0; i<seats.length;i++){
            freeSeats=freeSeats+numberOfFreeSeats(i);
        }
        return freeSeats;
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
    
    /**
     * Método que devuelve el número de asientos en las columnas del avión
     * 
     * @return  count, cuenta del numero de asientos en las columnas
     */
    public int columnLength(){
        int count=0;
        for (int i=0; i<seats.length;i++){
            count++;
        }
        return count;
    }
    
    /**
     * Método que devuelve el número de asientos en las filas del avión
     * 
     * @return  row, cuenta del numero de asientos en la fila
     */
    public int rowLength(){
        int count=0;
        for (int i=0; i<seats[0].length;i++){
            count++;
        }
        return count;
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
