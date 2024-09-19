import java.util.ArrayList;
/**
 * Write a description of class Autiditorium here.
 * 
 * @author Omar Teixeira González
 * @version 20-11-20
 */
public class Auditorium
{
    // atributos variables
   
    private ArrayList<Concert> concerts;
    
    /**
     * Constructor sin parámetros para la clase Auditorium
     */
    public Auditorium()
    {
        concerts = new ArrayList<Concert>();
    }
    
    /**
     * Constructor con parámetro numberOfConcerts para la clase Auditorium
     */
    public Auditorium(int numberOfConcerts)
    {
        this();
        concerts = new ArrayList<Concert>(numberOfConcerts);
    }
    
    /**
     * Método que controla el parámetro y devuelve una sentencia en caso de ser false
     */
    private void checkParam(boolean condition, String str){
        if(!condition){
            throw new RuntimeException(str);
        }
    }
    
    /**
     * Método que modifica el valor de la colección de conciertos
     * 
     * @param numberOfConcerts, numero de conciertos, de tipo int
     */
    private void setConcerts(int numberOfConcerts){
        concerts = new ArrayList<Concert>();
        for(int i=0; i < numberOfConcerts; i++){
            concerts.add(new Concert());
        }
    }
    
    /**
     * Método que busca un concierto y si existe lo devuelve
     * 
     * @param  name, nombre del concierto, de tipo String 
     */
    public Concert seekConcert(String name){
        checkParam(name != null && name.trim().length() != 0, "El nombre del concierto es null o la cadena está vacía");
        for (Concert concert : concerts){
            if(concert.getName().equals(name)){
                return concert;
            }
        }
        return null;
    }
    
    /**
     * Método que evalúa si ya existe un concierto en esa fecha
     */
    private boolean seekConcertDate(Date date){
        for( Concert concert : concerts){
            if(concert.getDate().equals(date)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método que añade un concierto siempre que no haya otro en la misma posición
     * 
     * @param   concertName, price, date
     */
    public void addConcert(String name, double price, Date date){
        checkParam(name != null && price > 0.0 && date != null, "Parámetros incorrectos");
        checkParam(seekConcertDate(date) == false, "En esa fecha ya hay un concierto");
        concerts.add(new Concert(name, price, date));
    }
    
    /**
     * Método que devuelve todos los conciertos almacenados en la colección
     */
    public ArrayList<Concert> getConcerts(){
        return concerts;
    }
    
    /**
     * Método que elimina todos los conciertos que se hayan realizado en un año determinado
     * 
     * @param   year, año en el que se han realizado los conciertos a eliminar, de tipo int
     */
    public void removeConcert(int year){
        int i=0;
        while (i< concerts.size()){
            if(concerts.get(i).getDate().getYear() == year){
                concerts.remove(i);
            } else {
                i++;
            }
        }
    }
    
}
