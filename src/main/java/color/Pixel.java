package color;

/**
 * Interface qui permet de get et de set les donnees d'un pixel
 * @author Karl Boutin, Maxime Lussier et Anthony C�t�
 */
public interface Pixel {
    
    Pixel clone();
    
    /**
     
     @return
     */
    int getNbrPigment();
    
    /**
     
     @param index
     @return
     @throws ArrayIndexOutOfBoundsException
     */
    int getPigment(int index) throws ArrayIndexOutOfBoundsException;
    
    void setPigment(int index, int value) throws Exception;
    
    int getAverage();
    
    /**
     
     @param index
     @return toujours vrai tant qu'il n'y a pas d'exception
     @throws ArrayIndexOutOfBoundsException
     */
    default boolean validatePigmentIndex(int index) throws ArrayIndexOutOfBoundsException{
        if(0 > index || index >= getNbrPigment())
            throw new ArrayIndexOutOfBoundsException("L'index de pigment est invalide");
        
        return true;
    }
    
    /**
     
     @param tone
     @return toujours vrai tant qu'il n'y a pas d'exception
     @throws InstantiationException
     */
    default boolean validatePigmentTone(int tone) throws InstantiationException{
        if(0 > tone || 255 <= tone)
            throw new InstantiationException("L'index de pigment est invalide");
        
        return true;
    }
    
    boolean equals(Pixel p);
}
