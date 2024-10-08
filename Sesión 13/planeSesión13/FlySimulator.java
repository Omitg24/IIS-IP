import java.util.ArrayList;
import java.util.Iterator;
/**
 * Clase FlySimulator:
 * Sesi髇 13:
 *      Constructor sin par醡etros
 *      M閠odo fillFreeMap
 *      M閠odo addPlane
 *      M閠odo hasSameIdentifier
 *      M閠odo hasSamePilotName
 *      M閠odo isFreePosition
 *      M閠odo printMap
 *      M閠odo printHeader
 *      M閠odo animate
 *      M閠odo flyPlanes
 *      M閠odo updateMap
 *      M閠odo removePlanesCollision
 *      M閠odo removePlanesInPosition
 *      M閠odo printCollision
 *      M閠odo getPlanes
 *      M閠odo getPosition
 *      
 * @author  Omar Teixeira Gonz醠ez
 * @version 14-12-20
 */
public class FlySimulator
{
    // Constantes
    public static final char FREE = '~';  // la virgulilla indica posici贸n libre (sin avi贸n)
    public static final char COLLISION = '%';  // indica colisi贸n 
    
    // Atributos variables
    private ArrayList<Plane> planeList;
    private char[][] map;  //representa el radar. Contiene:
                                //identificador del avi贸n en las posiciones ocupadas por avi贸n
                                // '~' en las posiciones libres
                                // '%' en las posiciones en que hubo colisi贸n

    /**
     * Constructor 
     * Crea la lista y el mapa
     * Rellena el mapa con virgulillas (posiciones libres)
     */
    public FlySimulator()
    {
       planeList = new ArrayList<Plane>();
       map = new char[Plane.MAX_X + 1][Plane.MAX_Y + 1]; // filas y columnas entre 0 y 10 inclusive
       fillFreeMap();              // inicialmente el mapa est谩 vac铆o, sin aviones
    }
    
    /**
     * Rellena la matriz con valores correspondientes a posici贸n libre
     */
    private void fillFreeMap(){
        for (int i=0; i<map.length; i++) {
            for (int j=0; j < map[i].length; j++) {
                map[i] [j] =  FREE;
            }
        }
    }

    /**
     * A帽ade un avi贸n al sistema de control
     * 
     * No ser谩n v谩lidos y provocar谩n excepci贸n 
     *      aviones que est茅n localizados en posiciones del mapa ya ocupadas, 
     *      ni aviones con el un identificador que ya existe. 
     * 
     * Se a帽ade el avi贸n a la lista de a viones 
     * y se modifica el mapa para que aparezca el identificador del avi贸n
     * @param plane, avi贸n a a帽adir
     * 
     */
    public void addPlane(Plane plane)
    {
        checkParam(plane != null, "Esperaba avi髇 y fue null");
        checkParam(isFreePosition(plane),"La posici髇 ya est� ocupada");
        checkParam(!hasSameIdentifier(plane), "Ya existe un avi髇 con el mismo identificador");
       
        int row = plane.getXPos();
        int column = plane.getYPos();
        
        planeList.add(plane);
        map[row][column] = plane.getIdentifier();        
    }
    
    /**
     * @return true si hay un avi贸n en la lista con el mismo identificador que el 
     * avi贸n recibido como par谩metro
     * @param plane 
     */
    private boolean hasSameIdentifier(Plane plane){
        for (Plane pl : planeList){
            if(pl.getIdentifier()==plane.getIdentifier()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * @return true si hay un avi贸n en la lista con el mismo nombre del piloto que el 
     * avi贸n recibido como par谩metro
     * @param plane 
     */
    private boolean hasSamePilotName(Plane plane){
        for (Plane pl : planeList){
            if(pl.getPilot().getName().equals(plane.getPilot().getName())){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Comprueba si la posici贸n en la matriz correspondiente a la posici贸n del avi贸n que recibe, est谩 vac铆a
     * 
     * @param plane
     * @return true si est谩 libre
     */
    private boolean isFreePosition(Plane plane) {
       // if (map[plane.getXPos()][plane.getYPos()] == FREE){
           // return true;          
       // } else{
           // return false;
       // }  
       int row=plane.getXPos();
       int column=plane.getYPos();
       return map[row][column] == FREE;
    }
    
    /**
     * Imprime el mapa (radar) con todos los aviones
     * Se imprie el identificador o la virgulilla
     */
    public void printMap(){
        System.out.println("");
        System.out.println("-------------- Radar--------");
        printHeader();
        for (int i=0; i < map.length; i++) {
            System.out.print(i + "  ");
            for (int j=0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }
    
    /**
     * M閠odo que imprime por pantalla el cabecero del mapa
     */
    private void printHeader(){
       System.out.print("   ");
       for (int j=0; j < map[0].length; j++) {
           System.out.print(j +  " ");
        }
       System.out.println();
    }
    
    /**
     * Simula el movimiento de todos los aviones una posici贸n
     * Implica volar los aviones y actualizar el mapa
     */
    public void animate(){
        flyPlanes();        
        updateMap();
        removePlanesAndPrintCollisions();
        printMap();        
    }
    
    /**
     * Hace que todos los aviones de la lista aviones vuelen
     */
    private void flyPlanes(){
        for (Plane plane : planeList){
            plane.fly();
        }
    }
    
    /**
     * Actualiza el mapa del radar
     *      Rellena el mapa a vac铆o 
     *      Recorre lista de aviones
     *          Si est谩 vac铆a la posici贸n del avi贸n, se asignar谩 el identificador del avi贸n de la lista
     *          Si ya est谩 ocupada se asignar谩 colisi贸n 
     *          
     */
    private void updateMap(){        
        fillFreeMap();
        for (Plane pl : planeList){
            int row = pl.getXPos();
            int column = pl.getYPos();
            if (map[row][column]==FREE){
                map[row][column]=pl.getIdentifier();
            } else{
                map[row][column]=COLLISION;
            }
        }
    }
        
    /**
     * 
     * Borra e imprime los aviones que colisionan 
     * (Los que tienen igual posici贸n y en matriz se indica %)
     *  Recorre matriz y si hay un % 
     *      busca todos los aviones con esa posici贸n 
     *          Los borra y los guarda en una lista
     *      Imprime la lista de borrados para esa posici贸n
     * 
     */
    private void removePlanesAndPrintCollisions () {        
        for (int i =0; i<map.length;i++){
            for (int j=0; j< map[i].length;j++){
                if(map[i][j]==COLLISION){
                    ArrayList<Plane> removed = removePlanesInPosition(i,j);
                    printCollision(removed);
                }                    
            }            
        }
    }       
        
    /**
     * Elimina de la lista de aviones todos los que tengan posici贸n row column
     * Y los devuelve en una lista
     * @param row, fila en la matriz
     * @param column, columna en la matriz
     * @return ArrayList con aviones borrados
     */
    private ArrayList<Plane> removePlanesInPosition(int row, int column) {
        ArrayList<Plane> planeRemoved = new ArrayList<Plane>();
        Iterator<Plane> planeListIterator = planeList.iterator();
        while (planeListIterator.hasNext()){
            Plane plane = planeListIterator.next();
            if ( plane.getXPos() == row && plane.getYPos() == column){
                planeListIterator.remove();
                planeRemoved.add(plane);
            }                
        }
        return planeRemoved;
    }
    
    /**
     * Imprime los datos (toString) de todos los aviones de la lista 
     * 
     * @param ArrayList<Plane> lista de aviones a imprimir
     */
    private void printCollision(ArrayList<Plane> collisionedPlanes) {
        System.out.println("-------Colisi贸n---------");
        for (Plane plane : collisionedPlanes){
            System.out.println(plane.toString());
        }
    }           
        
    /**
     * Si no se cumple la condici贸n lanza RuntimeException con el mensaje indicado
     * @param condition
     * @param msg mensaje
     */
    private void checkParam(boolean condition, String msg){
        if (condition == false) {
            throw new RuntimeException(msg);
        }
    }
    
    /**
     * Devuelve la lista de aviones en un array
     * @return array con la lista de aviones
     */
    public Plane[] getPlanes(){
        Plane[] planes = new Plane[planeList.size()];
        for (int i=0; i<planes.length;i++){
            planes[i]=planeList.get(i);
        }
        return planes;
    }
    
    /**
     * Devuelve el contenido de una posici贸n del mapa
     * 
     * @return identificador, % o ~ 
     */
    public char getPosition(int row, int column){
        checkParam(row>=0 && column>=0, "Parametros no validos");
        return map[row][column];
    }
}
