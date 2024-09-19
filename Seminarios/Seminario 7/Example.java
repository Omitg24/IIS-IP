import java.util.*;

public class Example
{
    // instance variables - replace the example below with your own
    private ArrayList<String> prizes;
    private HashSet<String> numbers;
    private HashMap<String,String> results;

    /**
     * Constructor for objects of class Example
     */
    public Example()
    {
        prizes=new ArrayList<String>();
        numbers=new HashSet<String>();
        results=new HashMap<String,String>();
    }

    public void fillCollections()
    {
        prizes.add("4.000.000€");
        prizes.add("1.250.000€");
        prizes.add("500.000€");        
        prizes.add("1.000€");
        prizes.add("1.000€");
        System.out.println("ArrayList: añadidos 5 elementos; tamaño de la colección: "+prizes.size());

        numbers.add("101010");
        numbers.add("534562");
        numbers.add("987654");        
        numbers.add("112376");
        numbers.add("009218");
        System.out.println("HashSet: añadidos 5 elementos; tamaño de la colección: "+numbers.size());       
    }

    public void showCollections()
    {
        System.out.println("Prizes:");
        for (String element:prizes){
            System.out.print(element+"   ");
        }

        System.out.println("\n\nNumbers:");
        for (String element:numbers){
            System.out.print(element+"   ");
        }

        System.out.println("\n\nResults:");
        for (String key:results.keySet()){
            System.out.print("["+key+","+results.get(key)+"]   ");
        }

    }

    public String choosePrize()
    {
        Random random = new Random();
        int position = random.nextInt(prizes.size());
        String aux = prizes.get(position);
        prizes.remove(position);
        return aux;
    }

    public String chooseNumber()
    {
        Random random =  new Random();
        int position = random.nextInt(numbers.size());
        int numberOfIterations = 0;
        String aux = null;
        for (String number : numbers){
            if (position==numberOfIterations){
                aux = number;    
                break;
            }
            numberOfIterations++;
        }
        numbers.remove(aux);
        return aux;
    }

    public void rafflePrizes(int howMany)
    {
       checkParam(numbers.size() == prizes.size() && howMany  > 0 && howMany <= numbers.size(), "Demasiados números");
       for (int i=0; i<howMany;i++){
           results.put(this.chooseNumber(), this.choosePrize());
       }
    }
    
    // Controladores
    
    public void checkParam(boolean condition, String msg){
        if (!condition){
            throw new RuntimeException(msg);        
        }
    }
}
