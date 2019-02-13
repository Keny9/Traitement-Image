package color;


/**
 Interface qui permet de getPixel et de setPixel les donnees d'un pixel
 @author Karl Boutin, Maxime Lussier et Anthony Cote */
public interface Pixel {
    
    /**
     Gets nbr pigment.
     @return nbr pigment
     */
    int getNbrPigment();
    
    /**
     Gets pigment.
     @param index the index
     @return pigment
     @throws ArrayIndexOutOfBoundsException the array index out of bounds exception
     */
    int getPigment(int index) throws ArrayIndexOutOfBoundsException;
    
    /**
     Sets pigment.
     @param index the index
     @param value the value
     @throws Exception the exception
     */
    void setPigment(int index, int value) throws Exception;
 
}
