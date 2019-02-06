package color;

/**
 * Interface qui permet de get et de set les donnees d'un pixel
 * @author Karl Boutin, Maxime Lussier et Anthony Côté
 */
public interface Pixel {
    
    /**
     
     @return les donnees du pixel
     */
    public Pixel getPixel();
    
    /**
     Applique les donnes du pixel 
     @param pixel la valeur
     */
    public void setPixel(Pixel pixel) ;
    
}
