import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AuditoriumTest.
 *
 * @author  Omar Teixeira González
 * @version 20-11-20
 */
public class AuditoriumTest
{
    /**
     * Default constructor for test class AuditoriumTest
    */
    public AuditoriumTest()
    {
    }

    /*
     * Pruebas del método seekConcert:
     * 1- El concierto existe
     * 2- El concierto no existe
     */
    /**
     * 1- El concierto existe
     */
    @Test
    public void testSeekConcertExists(){
        try{
            Auditorium auditorium1 = new Auditorium();
            assertEquals("Linkin Park live at Oviedo",auditorium1.seekConcert("Linkin Park live at Oviedo").getName());
        }catch (RuntimeException rte){
            assertEquals("El nombre del concierto es null o la cadena está vacía", rte.getMessage());
        }
    }
    
    /**
     * 2- El concierto no existe
     */
    @Test
    public void testSeekConcertDontExists(){
        Auditorium auditorium1 = new Auditorium();
        assertEquals(null,auditorium1.seekConcert("Armin Van Buuren live at Oviedo"));
    }
    
    
}

