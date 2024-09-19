import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de prueba de la clase SeatManager
 *
 * @author  Omar Teixeira González
 * @version 14-12-20
 */
public class SeatManagerTest
{
    private SeatManager sm1;
    @Before
    public void setUp(){
        sm1= new SeatManager(SeatManager.MIN_FIRST_ROWS, SeatManager.MIN_STANDARD_ROWS);
    }
    
    /*
     * Pruebas del constructor con dos parámetros:
     * Positivos:
     * 1- Parámetros entre limties -> Se crea el seatManager
     * 2- Parámetros en limite inferior -> Se crea el seatManager
     * 3- Parámetros en límite superior -> Se crea el seatManager
     * 
     * Negativos
     * 4- Filas de first menor al límite inferior -> No se crea el seatManager
     * 5- Filas de first mayor al límite superior -> No se crea el seatManager
     * 6- Filas de standard menor al límite inferior -> No se crea el seatManager
     * 7- Filas de standard mayor al límite superior -> No se crea el seatManager
     */
    /**
     * 1- Parámetros entre limties -> Se crea el seatManager
     */
    @Test
    public void testConstructorBothInsideLimits(){
        SeatManager sm1 = new SeatManager(10,10);
        assertNull(sm1.getSeat(10, 5));
    }
    
    /**
     * 2- Parámetros en limite inferior -> Se crea el seatManager
     */
    @Test
    public void testConstructorBothInLowerLimits(){
        SeatManager sm1 = new SeatManager(4,4);
        assertNull(sm1.getSeat(4, 4));
    }
    
    /**
     * 3- Parámetros en límite superior -> Se crea el seatManager
     */
    @Test
    public void testConstructorBothInUpperLimits(){
        SeatManager sm1 = new SeatManager(40,40);        
        assertNull(sm1.getSeat(40, 5));
    }
    
    /**
     * 4- Filas de first menor al límite inferior -> No se crea el seatManager
     */
    @Test 
    public void testConstructorFRowUnderLowerLimit(){
        try{
            SeatManager sm1 = new SeatManager(SeatManager.MIN_FIRST_ROWS-1, SeatManager.MIN_STANDARD_ROWS);
            fail("Esperaba fallo en el constructor");
        }catch(RuntimeException msg){
            assertEquals("Filas en primera fuera de limites", msg.getMessage());
        }
    }
    
    /**
     * 5- Filas de first mayor al límite superior -> No se crea el seatManager
     */
    @Test 
    public void testConstructorFRowOverUpperLimit(){
        try{
            SeatManager sm1 = new SeatManager(SeatManager.MAX_FIRST_ROWS+1, SeatManager.MIN_STANDARD_ROWS);
            fail("Esperaba fallo en el constructor");
        }catch(RuntimeException msg){
            assertEquals("Filas en primera fuera de limites", msg.getMessage());
        }
    }
    
    /**
     * 6- Filas de standard menor al límite inferior -> No se crea el seatManager
     */
    @Test 
    public void testConstructorSRowUnderLowerLimit(){
        try{
            SeatManager sm1 = new SeatManager(SeatManager.MIN_FIRST_ROWS, SeatManager.MIN_STANDARD_ROWS-1);
            fail("Esperaba fallo en el constructor");
        }catch(RuntimeException msg){
            assertEquals("Filas en primera fuera de limites", msg.getMessage());
        }
    }
    
    /**
     * 7- Filas de standard mayor al límite superior -> No se crea el seatManager
     */
    @Test 
    public void testConstructorSRowOverUpperLimit(){
        try{
            SeatManager sm1 = new SeatManager(SeatManager.MIN_FIRST_ROWS, SeatManager.MAX_STANDARD_ROWS+1);
            fail("Esperaba fallo en el constructor");
        }catch(RuntimeException msg){
            assertEquals("Filas en primera fuera de limites", msg.getMessage());
        }
    }
    
    /*
     * Pruebas del bookSeat
     * Positivos:
     * 1- Parámetros correctos y posición de la matriz está vacía -> asigna posición y devuelve true
     * 2- Parámetros correctos y posición de la matriz está ocupada -> no asigna y devuelve false
     * 
     * Negativos:
     * 3- Parámetros es null, el resto está bien
     * 4- Row por debajo del límite inferior, el resto está bien
     * 5- Row por encima del límite superior. el resto está bien
     * 6- Column por debajo del límite inferior. el resto está bien
     * 7- Column por encima del límite superior. el resto está bien
     */
    
    /**
     * 1- Parámetros correctos y posición de la matriz está vacía -> asigna posición y devuelve true
     */
    @Test
    public void testBookSeatFreePosition(){
        Person passenger  = new Person();
        assertTrue(sm1.bookSeat(passenger,0,0));
        assertEquals(passenger, sm1.getSeat(0,0));
    }
    
    /**
     * 2- Parámetros correctos y posición de la matriz está ocupada -> no asigna y devuelve false
     */
    @Test
    public void testBookSeatOccupedPosition(){
        Person passenger  = new Person();
        assertTrue(sm1.bookSeat(passenger,0,0));
        assertEquals(passenger, sm1.getSeat(0,0));
    }
    
    /**
     * 3- Parámetros es null, el resto está bien
     */
    @Test
    public void testBookSeatNullPassenger(){
        try{
            sm1.bookSeat(null,0,0);
            fail("Esperaba excepción, pasajero null");
        }catch (RuntimeException msg){
            assertEquals("Esperaba pasajero y fue null", msg.getMessage());
        }
    }
    
    /**
     * 4- Row por debajo del límite inferior, el resto está bien
     */
    @Test
    public void testBookSeatRowUnderLimit(){
        try{
            Person passenger = new Person();
            sm1.bookSeat(passenger,-1,0);
            assertTrue(sm1.bookSeat(passenger,0,0));
            assertEquals(passenger, sm1.getSeat(0,0));
        }catch (RuntimeException msg){
            assertEquals("Fila fuera de limites", msg.getMessage());
        }
    }
    
    /**
     * 5- Row por encima del límite superior. el resto está bien
     */
    @Test
    public void testBookSeatRowOverLimit(){
        try{
            Person passenger = new Person();
            sm1.bookSeat(passenger,7,0);
            assertTrue(sm1.bookSeat(passenger,0,0));
            assertEquals(passenger, sm1.getSeat(0,0));
        }catch (RuntimeException msg){
            assertEquals("Fila fuera de limites", msg.getMessage());
        }
    }
    
    /**
     * 6- Column por debajo del límite inferior. el resto está bien
     */
    @Test
    public void testBookSeatColumnUnderLimit(){
        try{
            Person passenger = new Person();
            sm1.bookSeat(passenger,0,-1);
            assertTrue(sm1.bookSeat(passenger,0,0));
            assertEquals(passenger, sm1.getSeat(0,0));
        }catch (RuntimeException msg){
            assertEquals("Columna fuera de limites", msg.getMessage());
        }
    }
    
    /**
     * 7- Column por encima del límite superior. el resto está bien
     */
    @Test
    public void testBookSeatColumnOverLimit(){
        try{
            Person passenger = new Person();
            sm1.bookSeat(passenger,0,7);
            assertTrue(sm1.bookSeat(passenger,0,0));
            assertEquals(passenger, sm1.getSeat(0,0));
        }catch (RuntimeException msg){
            assertEquals("Columna fuera de limites", msg.getMessage());
        }
    }
    
    /*
     * Pruebas para el método release:
     * Positivos:
     * 1- Row y Column en los límites inferiores
     * 2- Row y Column en los límites superiores
     * 3- Row y Column dentro de los límites
     * 
     * Negativos:
     * 4- Row y Column por debajo de los límites inferiores
     * 5- Row y Column por encima de los límites superiores
     */    
        
    /**
     * 1- Row y Column en los límites inferiores
     */
    @Test
    public void testReleaseInLowerLimits()
    {
        assertNull(sm1.release(4, 4));
    }
    
    /**
     * 2- Row y Column en los límites superiores
     */
    @Test
    public void testReleaseInUpperLimits()
    {
        SeatManager seatManager1 = new SeatManager(40,40);
        assertNull(seatManager1.release(40, 5));
    }
    
    /**
     * 3- Row y Column dentro de los límites
     */
    @Test
    public void testReleaseInsideLimits()
    {
        SeatManager seatManager1 = new SeatManager(20,20);
        assertNull(seatManager1.release(20, 4));
    }
    
    /**
     * 4- Row y Column por debajo de los límites inferiores
     */
    @Test
    public void testReleaseUnderLowerLimits1()
    {
        try{
            assertNull(sm1.release(4, -2));
        }catch (RuntimeException msg){
            assertEquals("Columna fuera de limites", msg.getMessage());            
        }
    }
    
    /**
     * 4- Row y Column por debajo de los límites inferiores
     */
    @Test
    public void testReleaseUnderLowerLimits2()
    {
        try{
            assertNull(sm1.release(-2, 4));
        }catch (RuntimeException msg){
            assertEquals("Fila fuera de limites", msg.getMessage());            
        }
    }
    
    /**
     * 5- Row y Column por encima de los límites superiores
     */
    @Test
    public void testReleaseOverUpperLimits1()
    {
        try{
            assertNull(sm1.release(4, 8));
        }catch (RuntimeException msg){
            assertEquals("Columna fuera de limites", msg.getMessage());            
        }
    }
    
    /**
     * 5- Row y Column por encima de los límites superiores
     */
    @Test
    public void testReleaseOverUpperLimits2()
    {
        try{
            assertNull(sm1.release(8, 4));
        }catch (RuntimeException msg){
            assertEquals("Fila fuera de limites", msg.getMessage());            
        }
    }
    
    /*
     * Pruebas del método oldestPassenger() 
     * 1- Si el avión está vacío -> devuelve null
     * 2- Si hay una persona -> devuelve a la persona
     * 3- Si hay más de una persona -> devuelve a la más mayor
     */
    
    /**
     * 1- Si el avión está vacío -> devuelve null
     */
    @Test
    public void testOldestPassenger1(){
        sm1.getSeat(0, 0);
        assertEquals(null, sm1.oldestPassenger());
    }
    
    /**
     * 2- Si hay una persona -> devuelve a la persona
     */
    @Test
    public void testOldestPassenger2(){
        Person person = new Person();
        sm1.bookSeat(person, 1, 1);
        assertEquals(person, sm1.oldestPassenger());
    }
    
    /**
     * 3- Si hay más de una persona -> devuelve a la más mayor
     */
    @Test
    public void testOldestPassenger3(){
        Person person = new Person();
        Person person2 = new Person();
        sm1.bookSeat(person, 1, 1);
        sm1.bookSeat(person2, 1, 2);
        assertEquals(person2, sm1.oldestPassenger());
    }
    
    /*
     * Pruebas del método numberOfFreeSeats()
     * Positivos:
     * 1- Row correcto, todos los asientos ocupados -> Devuelve 0
     * 2- Row correcto, con asientos libres -> Devuelve el número de los asientos libres
     * 
     * Negativos:
     * 3- Row por debajo del límite inferior -> Salta la excepción
     * 4- Row por encima del límite superior -> Salta la excepción
     */
        
    
    /**
     * 1- Row correcto, todos los asientos ocupados -> Devuelve 0
     */
     @Test
     public void testNumberOfFreeSeats3(){
         Person person = new Person();
         SeatManager sm2 = new SeatManager(6,6);
         for(int i = 0; i < SeatManager.COLUMNS; i++){
               sm1.bookSeat(person, 2, i);
         }
         assertEquals(0,sm1.numberOfFreeSeats(2));         
    }
    
    /**
     * 2- Row correcto, con asientos libres -> Devuelve el número de los asientos libres
     */
     @Test
     public void testNumberOfFreeSeats4(){
         Person person = new Person();
         for(int i = 0; i < SeatManager.COLUMNS-1; i++){
             sm1.bookSeat(person, 1, i);
         }
         assertEquals(1,sm1.numberOfFreeSeats(1));  
    }
    
    /**
     * 3- Row por debajo del límite inferior -> Salta la excepción
     */
    @Test
    public void testNumberOfFreeSeats1(){
        try{
            sm1.numberOfFreeSeats(-200);
            fail("Esperaba fallo en el método");
        }catch(RuntimeException msg){
            assertEquals("Valor de filas no válido", msg.getMessage());
        }
    }
    
    /**
     * 4- Row por encima del límite superior -> Salta la excepción
     */
    @Test
    public void testNumberOfFreeSeats2(){
        try{
            sm1.numberOfFreeSeats(200);
            fail("Esperaba fallo en el método");
        }
        catch(RuntimeException e){
            assertEquals("Valor de filas no válido", e.getMessage());
        }
    }
    
    /*
     * Pruebas del método removeMales:
     * Positivos:
     * 1- Lista que no contiene hombres -> Devuelve 0
     * 2- Lista con hombres y mujeres -> Devuelve el número de hombres eliminados y los borra
     * 
     * Negativos:
     * 3- Lista vacía -> Devuelve la excepción o 0
     * 4- Null en lugar de lista vacía -> Devuelve la excepción
     * 5- Lista con elementos null -> Devuelve la excepción
     */
    
    /**
     * 1- Lista que no contiene hombres -> Devuelve 0
     */
    @Test
    public void testRemoveMalesWhenOnlyWomen(){
        SeatManager manager = new SeatManager(4,5);
        ArrayList<Person> list = new ArrayList<Person>();
        Person woman1 = new Person(Person.GENDER_FEMALE);
        Person woman2 = new Person(Person.GENDER_FEMALE);
        Person woman3 = new Person(Person.GENDER_FEMALE);
        Person woman4 = new Person(Person.GENDER_FEMALE);
        list.add(woman1);
        list.add(woman2);
        list.add(woman3);
        list.add(woman4);
        
        for (int i=1; i<=2; i++){
            list.add(new Person(Person.GENDER_FEMALE));
        }
        int men = manager.removeMales(list);
        assertEquals(0,men);       
    }    
    
    /**
     * 2- Lista con hombres y mujeres -> Devuelve el número de hombres eliminados y los borra
     */
    @Test
    public void testRemoveMalesMenAndWomen(){
        SeatManager manager = new SeatManager(4,5);
        ArrayList<Person> list = new ArrayList<Person>();
        Person woman1 = new Person(Person.GENDER_FEMALE);
        Person woman2 = new Person(Person.GENDER_FEMALE);
        Person man1 = new Person(Person.GENDER_MALE);
        Person man2 = new Person(Person.GENDER_MALE);
        list.add(woman1);
        list.add(woman2);
        list.add(man1);
        list.add(man2);
        
        for (int i=1; i<=2; i++){
            list.add(new Person(Person.GENDER_FEMALE));
            list.add(new Person(Person.GENDER_MALE));
        }
        int men = manager.removeMales(list);
        assertEquals(4,men);
        for (Person person : list){
            assertEquals(Person.GENDER_FEMALE, person.getGender());
        }
        assertEquals(4,list.size());        
    }
    
    /**
     * 3- Lista vacía -> Devuelve la excepción o 0
     */
    @Test
    public void testRemoveMalesEmptyList(){
        SeatManager manager = new SeatManager(4,5);
        ArrayList<Person> list = new ArrayList<Person>();
        try{
            int men = manager.removeMales(list);
            fail("Esperaba excepción porque lista vacía");
        }catch(RuntimeException msg){
            assertEquals("Esperaba lista con elementos y no tiene", msg.getMessage());
        }
    }
    
    /**
     *         
     */
    @Test
    public void testRemoveMalesNull(){
        SeatManager manager = new SeatManager(4,5);
        ArrayList<Person> list = null;
        try{
            int men = manager.removeMales(list);
            fail("Esperaba excepción porque lista vacía");
        }catch(RuntimeException msg){
            assertEquals("Esperaba lista y fue null", msg.getMessage());
        }
    }
    
    /**
     * 2- Lista con hombres y mujeres -> Devuelve el número de hombres eliminados y los borra
     */
    @Test
    public void testRemoveMalesMenWomenNull(){
        try{
            SeatManager manager = new SeatManager(4,5);
            ArrayList<Person> list = new ArrayList<Person>();
            Person woman1 = new Person(Person.GENDER_FEMALE);
            Person woman2 = new Person(Person.GENDER_FEMALE);
            Person man1 = new Person(Person.GENDER_MALE);            
            list.add(woman1);
            list.add(woman2);
            list.add(man1);
            list.add(null);
            
            for (int i=1; i<=2; i++){
                list.add(new Person(Person.GENDER_FEMALE));
                list.add(new Person(Person.GENDER_MALE));
            }
            int men = manager.removeMales(list);
            fail("Hay elementos null");
        }catch (RuntimeException msg){
            assertEquals("Existen elementos a null", msg.getMessage());
        }           
    }
    
    /*
     * Pruebas del método getYoungestPeople
     * Positivos:
     * 1- Existe una sola persona -> Devuelve a esa persona
     * 2- Existen varias personas -> Devuelve los 3 más pequeños
     * 
     * Negativos:
     * 3- Existen 0 personas en el avión -> Devuelve la excepción
     */
    
    /**
     * 1- Existe una sola persona -> Devuelve a esa persona
     */
    @Test
    public void testGetYoungestPeopleWhenOnlyOnePerson(){
        SeatManager manager = new SeatManager(10,5);
        ArrayList<Person> list = manager.getYoungestPeople();
        Person person1 = new Person();
        list.add(person1);
        assertTrue(manager.bookSeat(person1,2,3));
        assertEquals(1,list.size());
        for (int i=0; i < list.size()  ; i++){
            list.get(i);
        }
    }
    
    /**
     * 2- Existen varias personas -> Devuelve los 3 más pequeños
     */
    @Test
    public void testGetYoungestPeopleWhenMorePeople(){
        SeatManager manager = new SeatManager(10,5);
        ArrayList<Person> list = manager.getYoungestPeople();
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        assertTrue(manager.bookSeat(person1,2,3));
        assertTrue(manager.bookSeat(person2,8,2));
        assertTrue(manager.bookSeat(person3,1,5));
        assertTrue(manager.bookSeat(person4,5,4));
        assertEquals(4,list.size());
        for (int i=0; i < list.size()  ; i++){
            list.get(i);
        }
    }
    
    /**
     * 3- Existen 0 personas en el avión -> Devuelve la excepción
     */
    @Test
    public void testGetYoungestPeopleWhenEmpty(){
        SeatManager manager = new SeatManager(10,5);
        ArrayList<Person> list = manager.getYoungestPeople();
        try{            
            for (int i=0; i < list.size()  ; i++){
                list.get(i);
            }            
        }catch (RuntimeException msg){
            assertEquals("No hay nadie en el avión", msg.getMessage());
        }
    }
    
    /*
     * Pruebas del método childrenPassenger:
     * 1- Hay varios niños
     * 2- No hay ningun niño
     * 3- No hay pasajeros
     */
    
    /**
     * 1- Hay varios niños
     */
    @Test
    public void testChildrenPassengersSome(){
        SeatManager sm1 = new SeatManager(4,5);
        sm1.bookSeat(new Person(8), 0, 0);
        sm1.bookSeat(new Person(8), 1, 1);
        sm1.bookSeat(new Person(8), 2, 2);
        
        sm1.bookSeat(new Person(30), 0, 1);
        sm1.bookSeat(new Person(40), 1, 1);
        sm1.bookSeat(new Person(50), 2, 1);
        
        ArrayList<Person> list = sm1.childrenPassengers();
        assertEquals(3,list.size());
        for (Person person : list){
            assertEquals(8,person.getAge());
        }
    }
    
    /**
     * 2- No hay ningun niño
     */
    @Test
    public void testChildrenPassengersNoChidren(){
        SeatManager sm1 = new SeatManager(4,5);
        
        sm1.bookSeat(new Person(30), 0, 1);
        sm1.bookSeat(new Person(40), 1, 1);
        sm1.bookSeat(new Person(50), 2, 1);
        
        ArrayList<Person> list = sm1.childrenPassengers();
        assertEquals(0,list.size());
        for (Person person : list){
            assertEquals(0,person.getAge());
        }
    }
    
    /**
     * 3- No hay pasajeros
     */
    @Test
    public void testChildrenPassengersEmpty(){
        SeatManager sm1 = new SeatManager(4,5);        
        
        ArrayList<Person> list = sm1.childrenPassengers();
        assertEquals(0,list.size());
        for (Person person : list){
            assertEquals(0,person.getAge());
        }
    }
    
    /*
     * Pruebas del método getNumPax:
     * Positivos:
     * 1- Ningún pasajero y llamada a primera clase
     * 2- Ningún pasajero y llamada a standard
     * 3- Ningún pasajero y llamada a todos
     * 4- Pasajeros en las 3 areas y llamada a primera clase
     * 5- Pasajeros en las 3 areas y llamada a primera clase
     * 6- Pasajeros en las 3 areas y llamada a primera clase
     * 
     * Negativos:
     * 7- Area incorrecta
     */
    
    /**
     * 1,2 y 3
     */
    @Test
    public void testGetNumPaxNoPassengers(){
       SeatManager sm1 = new SeatManager(4,5);
       assertEquals(0,sm1.getNumPax((byte) SeatManager.FIRST_CLASS));       
       assertEquals(0,sm1.getNumPax((byte) SeatManager.STANDARD_CLASS));       
       assertEquals(0,sm1.getNumPax((byte) SeatManager.ALL_CLASS));       
    }
       
    /**
     * 4, 5 y 6
     */
    @Test
    public void testGetNumPaxPassengers(){
       SeatManager sm1 = new SeatManager(4,5);
       sm1.fillSeats(sm1);
       assertEquals(24,sm1.getNumPax((byte) SeatManager.FIRST_CLASS));       
       assertEquals(30,sm1.getNumPax((byte) SeatManager.STANDARD_CLASS));       
       assertEquals(54,sm1.getNumPax((byte) SeatManager.ALL_CLASS));              
    }
    
    /**
     * 7- Area incorrecta
     */
    @Test
    public void testGetNumPaxInvalidArea(){
        SeatManager sm1 = new SeatManager(4,5);
        try {
            byte area = 4;
            sm1.getNumPax(area);
            fail("Esperaba excepción, área desconocida");
        } catch (RuntimeException msg){
            assertEquals("El area es incorrecta", msg.getMessage());
        }
    }
    
    /*
     * Pruebas del método getPosition:
     * Positivos:
     * 1- La persona esta en el avión
     * 
     * Negativos:
     * 2- La persona es null
     */
    
    /**
     * 1- La persona esta en el avión
     */
    @Test
    public void testGetPositionPerson(){
        Person person1 = new Person();
        assertEquals(true, sm1.bookSeat(person1, 2, 2));
        Position position = sm1.getPosition(person1);
        assertEquals(2, position.getRow());
        assertEquals(2, position.getColumn());
    }
    
    /**
     * 2- La persona es null
     */
    @Test
    public void testGetPositionNull(){
        Person person1 = null;
        try{
            Position position = sm1.getPosition(person1);
            fail("Esperaba excepción");
        }catch(RuntimeException msg){
            assertEquals("La persona es null",msg.getMessage());
        }
    }
    
    
    /*
     * Pruebas del método getFirstFreeSeatsInWindows:
     * Positivos:
     * 1- Hay dos sitios libres consecutivos
     * 2- No hay dos sitios libres consecutivos
     */
    
    /**
     * 1- Hay dos sitios libres consecutivos
     */
    @Test
    public void testGetFirstFreeSeatsInWindowsOk(){
        sm1.fillSeats(sm1);
        sm1.release(2,0);
        sm1.release(2,1);
        assertEquals(2,sm1.getFirstFreeSeatsInWindow());
    }
    
    /**
     * 2- No hay dos sitios libres consecutivos
     */
    @Test
    public void testGetFirstFreeSeatsInWindowsFail(){
        sm1.fillSeats(sm1);
        assertEquals(50,sm1.getFirstFreeSeatsInWindow());
    }
    
    /*
     * Pruebas del método getColumn:
     * Positivos:
     * 1- Hay personas en la columna
     * 2- No hay personas en la columna
     * 
     * Negativos:
     * 3- La columna no cumple los límites
     */
    
    /**
     * 1- Hay personas en la columna
     */
    @Test
    public void testGetColumnPerson(){
        sm1.fillSeats(sm1);
        Person[] list = sm1.getColumn(2);
        assertEquals(list.length,sm1.columnLength());
        for (int i=0; i<sm1.columnLength();i++){
            assertNotNull(list[i]);
        }
    }
    
    /**
     * 2- No hay personas en la columna
     */
    @Test
    public void testGetColumnNoPerson(){
        Person[] list = sm1.getColumn(2);
        assertEquals(list.length,sm1.columnLength());
        for (int i=0; i<sm1.columnLength();i++){
            assertNull(list[i]);
        }
    }
    
    /**
     * 3- La columna no cumple los límites
     */
    @Test
    public void testGetColumnOutOfLimits(){
        try{
            Person[] list = sm1.getColumn(7);
            fail("Esperaba excepción");
        }catch(RuntimeException msg){
            assertEquals("La columna no cumple los limites",msg.getMessage());
        }
    }
    
    /*
     * Pruebas del método getColumnArray:
     * Positivos:
     * 1- Hay personas en la columna
     * 2- No hay personas en la columna
     * 
     * Negativos:
     * 3- La columna no cumple los límites
     */
    
    /**
     * 1- Hay personas en la columna
     */
    @Test
    public void testGetColumnArrayPerson(){
        sm1.fillSeats(sm1);
        ArrayList<Person> list = new ArrayList<Person>(sm1.columnLength());
        list = sm1.getColumnArray(2);
        assertEquals(list.size(),sm1.columnLength());
        for (int i=0; i<sm1.columnLength();i++){
            assertNotNull(list.get(i));
        }
    }
    
    /**
     * 2- No hay personas en la columna
     */
    @Test
    public void testGetColumnArrayNoPerson(){
        ArrayList<Person> list = new ArrayList<Person>(sm1.columnLength());
        list = sm1.getColumnArray(2);
        assertEquals(list.size(),sm1.columnLength());
        for (int i=0; i<sm1.columnLength();i++){
            assertNull(list.get(i));
        }
    }
    
    /**
     * 3- La columna no cumple los límites
     */
    @Test
    public void testGetColumnArrayNull(){
        try{
            ArrayList<Person> list = new ArrayList<Person>(sm1.columnLength());
            list = sm1.getColumnArray(7);
            fail("Esperaba excepción");
        }catch(RuntimeException msg){
            assertEquals("La columna no cumple los limites", msg.getMessage());
        }
    }
    
    /*
     * Pruebas del método getRow:
     * Positivos:
     * 1- Hay personas en la fila
     * 2- No hay personas en la fila
     * 
     * Negativos:
     * 3- La fila no cumple los límites
     */
    
    /**
     * 1- Hay personas en la fila
     */
    @Test
    public void testGetRowPerson(){
        sm1.fillSeats(sm1);
        Person[] list = sm1.getRow(5);
        assertEquals(list.length,sm1.rowLength());
        for (int i=0; i<sm1.rowLength();i++){
            assertNotNull(list[i]);
        }
    }
    
    /**
     * 2- No hay personas en la fila
     */
    @Test
    public void testGetRowNoPerson(){
        Person[] list = sm1.getRow(5);
        assertEquals(list.length,sm1.rowLength());
        for (int i=0; i<sm1.rowLength();i++){
            assertNull(list[i]);
        }
    }
    
    /**
     * 3- La fila no cumple los límites
     */
    @Test
    public void testGetRowOutOfLimits(){
        try{
            Person[] list = sm1.getRow(15);
            fail("Esperaba excepción");
        }catch(RuntimeException msg){
            assertEquals("La fila no cumple los limites",msg.getMessage());
        }
    }    
}




