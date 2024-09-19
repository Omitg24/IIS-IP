import java.util.ArrayList;
/**
 * Write a description of class Team here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Team
{
    private ArrayList<Player> players;
    /**
     * Constructor for objects of class Team
     */
    public Team()
    {
        players = new ArrayList<Player>();
    }
    
    /**
     * Método que analiza la condición
     * 
     * @param   condition, la condición, de tipo boolean
     * @return condition, la condición, de tipo boolean
     */
    private boolean checkParam(boolean condition, String str){
        if (condition){
            return true;
        }else{
            throw new RuntimeException(str);
        }
    }

    /**
     * Método que añade un jugador a la colección equipo
     * 
     * @param  player, el nuevo jugador que queremos añadir a la colección, de tipo Player
     */
    public void addPlayer(Player player){
        if(checkParam(player!=null, "valor no valido")){
            players.add(player);
        }        
    }
    
    /**
     * Método que añade un jugador a la colección equipo indicando la posición
     * 
     * @param  player, el nuevo jugador que queremos añadir a la colección, de tipo Player
     *         index, nuevo indice que queramos añadir a la colección, de tipo int
     */
    public void addPlayerIndex(Player player, int index){
        if(checkParam(index>0 && index<=players.size(), "valor fuera de rango")){
            players.add(index, player);
        }        
    }
    
    /**
     * Método que busca un jugador con un número en concreto, si aparecere, lo devuelve, sino,
     * devuelve null.
     * 
     * @param  number, numero del jugador que queremos buscar, de tipo int
     */
    public Player seekPlayer(int number){
        for(Player player : players){
            if(player.getNumber()==number){
                return player;
            }
        }
        return null;
    }
    
    /**
     * Método que elimina un jugador de la colección, dado el número de su posición
     * 
     * @param  number, numero del jugador que queremos eliminar, de tipo int
     */
    public void removePlayer(int number){
        Player playerToRemove = seekPlayer(number);
        if(playerToRemove != null){
            players.remove(playerToRemove);
        }
    }
    
    /**
     * Método que muestra a los jugadores por consola
     */
    public void showPlayers(){
        for(Player player : players){
            System.out.println(player.toString());
        }
    }
    
    /**
     * Método que devuelve el indice del jugador
     * 
     * return index o null, en funcion del valor
     */
    public Player getPlayerIndex(int number){
        if(number>=0 && number < players.size()){
            return (players.get(number));
        }else{
            return null;
        }
    }
    
    /**
     * Método que devuelve los jugadores de la colección
     * 
     * @return  players, jugadores de la colección, de tipo Player
     */
    public ArrayList getPlayers(){
        return players;
    }
}
