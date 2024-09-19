import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SeatManagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
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
        Person person = new Person("Pepe","Viyuela",43,true);
        Person person2 = new Person("Marcos","Viyuela",82,true);
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
}


