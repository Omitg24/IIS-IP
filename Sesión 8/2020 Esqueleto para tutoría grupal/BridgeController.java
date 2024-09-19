/**
 * Tarea no presencial correspondiente a la Sesión 8
 * Controlador del puente levadizo.
 * 
 * @author Omar Teixeira González
 * @version 6-10-20
 */
public class BridgeController
{
    //constantes
    public static final boolean PRESSED = true;
    public static final int ANGLE_INCREASE = 30;        // incremento de ángulo producido al mover una posición la palanca
    
    public static final int MIN_LEVER = 0;      // valor mínimo que puede tomar la palanca
    public static final int MAX_LEVER = 5;      // valor máximo que puede tomar la palanca
    
        // valores por defecto al construir
        public static final int DEFAULT_ANGLE = 0;
        public static final int DEFAULT_LEVER = 0;
        public static final boolean DEFAULT_CLUTCH = ! PRESSED; 
    
    //atributos variables
    private int lever;               // Palanca de cambio  (3 posiciones: 0 puente con inclinación 0; 1 puente con inglinación 30º; 2 puente con inlcinación 60º)   
    private boolean clutch;             // embrague         (2 posiciones presionado o no presionado)
    private BasculeBridge bridge;     // puente levadizo a controlar      
    
    /**
     * Constructor para objetos de la clase BridgeController
     * Inicializa: 
     *      embrague sin presión
     *      palanca en posición 0
     *      por tanto puente con 0º de inclinación
     */
    public BridgeController()
    {
        setLever(DEFAULT_LEVER);
        setClutch(DEFAULT_CLUTCH);
        setBridge(new BasculeBridge(DEFAULT_ANGLE));
    }

     /**
     * Constructor para objetos de la clase con un parámetro 
     * @param position entero que indica la posición de la palanca que controla el puente (entre 0 y 2)
     */
    public BridgeController(int position)
    {
        this();
        setLever(position);
        setBridge(new BasculeBridge(position*12));
    }
    
    /**
     * Método que devuelve true si la condición se cumple y false si la condición no se cumple
     * 
     * @param   la condición que se debe cumplir, de tipo boolean
     */
    private boolean checkParam(boolean condition){
        return condition;
    }
    
    /** 
     * Asigna valor al atributo bridge
     * @param newBridge valor de tipo BasculeBridge para el atributo
     */
    private void setBridge(BasculeBridge newBridge)
    {
        if (newBridge != null){
            bridge = newBridge;
        }
    }
    
    /**
     * Devuelve el atributo puente 
     * @return objeto de tipo BasculeBridge correspondiente al puente controlado por BridgeController
     */
    public BasculeBridge getBridge()
    {
        return bridge;
    }
    
    /**
     * Devuelve el valor del embrague
     * @return boolean  true si el embrague está presionado
     */
    public boolean getClutch()
    {
        return clutch;
    }
    
    /**
     *  Devuelve el valor de la palanca
     *  @return int 0, 1 o 2 según sea el valor de la palanca
     */
    public int getLever()
    {
        return lever;
    }
    
    /**
     * Coloca un nuevo valor en el embrague. 
     * @param cluth . Valor de tipo boolean para atributo clutch
     */
    private void setClutch(boolean  clutch)
     {
        this.clutch = clutch;
     }
     
    /**
     * Coloca un nuevo valor para atributo lever
     * @para lever valor de tipo int para la palanca
     */      
    private void setLever(int lever)
    {
         if (lever >= MIN_LEVER && lever <= MAX_LEVER){
            this.lever = lever;
        }
    }
        
    /**
     * Cambia la posición del embrague.Estando presionado deja de estarlo y viceversa
     * 
     */
    public void changeClutch()
    {
       if(clutch==PRESSED){
           setClutch(!PRESSED);
       }else{
           setClutch(PRESSED);
       }
    }    
    
    /**
     * Cambia la posición de la palanca si el embrague está presionado, y hace que el puente cambie su inclinación, 
     * imprimiendo los grados de inclinación del nuevo puente o "error" si no se ha podido hacer la operación
     * @param int nueva posición (1, 2, 3, 4 o 5)
     */
    public void changeLever(int lever)
    {
        int aux=this.lever;
        if(clutch==PRESSED){
            setLever(lever);
            if(aux>lever){
                bridge.dropBridge((aux-lever)*12);
            }else{
                bridge.raiseBridge((lever-aux)*12);
            }
        }
    }
    
    /**
     * Cambia la posición de la palanca si el embrague está presionado, y hace que el puente cambie su inclinación, 
     * imprimiendo los grados de inclinación del nuevo puente o "error" si no se ha podido hacer la operación
     * @param int nueva posición (1, 2, 3, 4 o 5)
     */
    public void moveLever(int newLever)
    {
        if (checkParam(newLever >= MIN_LEVER && newLever <= MAX_LEVER)){
            if (getClutch()==PRESSED) {
                float newSlope = slopeForLever(newLever);
                if(newSlope > bridge.getSlope()){
                    bridge.raiseBridge(newSlope - bridge.getSlope());
                } else {
                    bridge.dropBridge(bridge.getSlope() - newSlope);
                }
                setLever(newLever);
            }
        }
    }
    
    /**
     * Dada una posición de la palanca calcula el ángulo de inclinación del puente
     */
    private float slopeForLever(int lever){
        float newSlope = (lever - MIN_LEVER) * 
                        (BasculeBridge.MAX_SLOPE - BasculeBridge.MIN_SLOPE)/ (MAX_LEVER - MIN_LEVER)
                         + BasculeBridge.MIN_SLOPE;
        return newSlope;
    }
}
