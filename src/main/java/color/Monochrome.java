package color;

/**
 * Classe qui gere un pixel qui n est pas en couleur
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 */
public class Monochrome implements Pixel{
    
    int grey;                   //Valeur du pixel
    public static final int NBR_PIGMENTS = 1; // 1 int equivaut a un pixel
    
    /** Constructeur sans parametre. */
    public Monochrome() {
    
    }
    
    /**
     * Constructeur avec parametre
     * @param grey 
     */
    public Monochrome(int grey){
        this.grey = grey;
    }
    
    /**
     * Retourne le nombre de pigment par pixel
     * @return 1 (image en gris tout le temps un pigment de couleur par pixel qui est le gris)
     */
    public int getNbrPigment() { return NBR_PIGMENTS; }
    
    /**
     * Obtenir le pigment du pixel
     * @param index 
     * @return
     * @throws ArrayIndexOutOfBoundsException 
     */
    public int getPigment(int index) throws ArrayIndexOutOfBoundsException {
        return grey;
    }
    
    /**
     * Retourne la valeur du pigment
     * @return 
     */
    public int getGrey(){return grey;}
    
    /**
     * Set une valeur au pigment de gris
     * @param value 
     */
    public void setGrey(int value){grey = value;}
    
    /**
     * Change la valeur dans le pigment
     * @param index pas d'index dans le gris
     * @param value a appliquer
     * @throws Exception 
     */
    public void setPigment(int index, int value) throws Exception {
        grey = value;
    }
}
