import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TeamTest.
 *
 * @author  Omar Teixeira González
 * @version 16-11-20
 */
public class TeamTest
{
    /**
     * Default constructor for test class TeamTest
     */
    public TeamTest()
    {
    }

    /**
     * Prueba para el método addplayer:
     */
    @Test
    public void testAddPlayer(){
        Team team1 = new Team();
        Player player1 = new Player("Omar",7);
        team1.addPlayer(player1);
        assertEquals(1,team1.getPlayers().size());
        assertEquals("Omar - 7", team1.getPlayerIndex(0).toString());
    }
    
    /*
     * Pruebas para el método AddPlayerIndex:
     * 1- Dentro de los límites -> Añade
     * 2- Fuera de los límites -> No añade
     */
    /**
     * 1- Dentro de los límites -> Añade
     */
    @Test
    public void testAddPlayerIndexInsideLimits(){
        Team team1 = new Team();
        Player player1 = new Player("Omar", 7);
        Player player2 = new Player("Israel", 8);
        Player player3 = new Player("Álvaro", 9);
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        assertEquals("Álvaro - 9", team1.getPlayerIndex(2).toString());
    }
    
    /**
     * 2- Fuera de los límites -> No añade
     */
    @Test
    public void testAddPlayerIndexOutsideLimits(){
        try{
            Team team1 = new Team();
            Player player1 = new Player("Omar", 7);
            Player player2 = new Player("Israel", 8);
            Player player3 = new Player("Álvaro", 9);
            team1.addPlayer(player1);
            team1.addPlayer(player2);
            team1.addPlayerIndex(player3, -1);
            assertNull(team1.getPlayerIndex(2).toString());
            fail("Se esperaba un error de rango");
        }catch(RuntimeException rte){
            assertEquals("valor fuera de rango", rte.getMessage());
        }
    }
    
    /**
     * Prueba del método seekPlayerAny
     */
    @Test
    public void testSeekPlayerAny(){
        Team team1 = new Team();
        Player player1 = new Player("Omar", 7);
        Player player2 = new Player("Israel", 8);
        Player player3 = new Player("Álvaro", 9);
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        assertEquals(player3, team1.seekPlayer(9));
        assertEquals(player2, team1.seekPlayer(8));
        assertEquals(player1, team1.seekPlayer(7));
    }
    
    /*
     * Pruebas para el método removePlayer de la clase Team:
     * 1- Elimina el 7
     * 2- Elimina el 8
     * 3- Elimina el 9
     */
    
    /**
     * 1- Elimina el 7
     */
    @Test
    public void testRemovePlayer7(){
        Team team1 = new Team();
        Player player1 = new Player("Omar", 7);
        Player player2 = new Player("Israel", 8);
        Player player3 = new Player("Álvaro", 9);
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.removePlayer(7);
        assertEquals("Israel - 8", team1.getPlayerIndex(0).toString());
        assertEquals("Álvaro - 9", team1.getPlayerIndex(1).toString());
    }
    
    /**
     * 2- Elimina el 8
     */
    @Test
    public void testRemovePlayer8(){
        Team team1 = new Team();
        Player player1 = new Player("Omar", 7);
        Player player2 = new Player("Israel", 8);
        Player player3 = new Player("Álvaro", 9);
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.removePlayer(8);
        assertEquals("Omar - 7", team1.getPlayerIndex(0).toString());
        assertEquals("Álvaro - 9", team1.getPlayerIndex(1).toString());
    }
    
    /**
     * 3- Elimina el 9
     */
    @Test
    public void testRemovePlayer9(){
        Team team1 = new Team();
        Player player1 = new Player("Omar", 7);
        Player player2 = new Player("Israel", 8);
        Player player3 = new Player("Álvaro", 9);
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        team1.removePlayer(9);
        assertEquals("Omar - 7", team1.getPlayerIndex(0).toString());
        assertEquals("Israel - 8", team1.getPlayerIndex(1).toString());
    }
}
