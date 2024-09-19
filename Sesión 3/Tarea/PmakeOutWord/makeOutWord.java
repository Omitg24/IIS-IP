
/**
 * Clase makeOutWord        para la tarea de la Sesión 3
 * 
 * @author Omar Teixeira González
 * @version 30/09/2020
 */
public class makeOutWord
{
    /**
     * Constructor for objects of class makeOutWord
     */
    public makeOutWord()
    {
        
    }

    /**
     * Método para mover una palabra entre dos signos, por ejemplo: 
     * "<<>>, Hola" a "<<Hola>>"
     * 
     * @param  situar a la palabra entre las expresiones
     * @return     makeOutWord, la palabra entre las expresiones dadas
     */
    public String makeOutWord(String out, String word) {
        return (out.substring(0, 2) + word + out.substring(2, 4));	
    }
}
