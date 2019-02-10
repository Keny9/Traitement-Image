package color;

import java.io.BufferedReader;
import java.io.IOException;

/**
 Interface qui permet de getPixel et de setPixel les donnees d'un pixel
 @author Karl Boutin, Maxime Lussier et Anthony C�t� */
public interface Pixel {
    
    Pixel clone();
    
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
    
    /**
     Gets average.
     @return the average
     */
    int getAverage();
    
    /**
     Lance une exception si l'index de pigment est invalide
     @param index the index
     @return toujours vrai tant qu'il n'y a pas d'exception
     @throws ArrayIndexOutOfBoundsException the array index out of bounds exception
     */
    default boolean validatePigmentIndex(int index) throws ArrayIndexOutOfBoundsException{
        if(0 > index || index >= getNbrPigment())
            throw new ArrayIndexOutOfBoundsException("L'index de pigment est invalide");
        
        return true;
    }
    
    /**
     Lance une exception si la force du pigmet est invalide
     @param tone the tone
     @return toujours vrai tant qu'il n'y a pas d'exception
     @throws InstantiationException the instantiation exception
     */
    default boolean validatePigmentTone(int tone) throws InstantiationException{
        if(0 > tone || 255 <= tone)
            throw new InstantiationException("La valeur de pigment est invalide");
        
        return true;
    }
    
    /**
     Equals boolean.
     @param p the p
     @return the boolean
     */
    boolean equals(Pixel p);
    
    /**
     Lit le pixel dans le buffer
     @param br BufferedReader
     */
    default void read(BufferedReader br){
        try {
            
            for (int i = 0; i < getNbrPigment(); i++) {
                setPigment(i, br.read());
            }
    
        }catch (IOException e){
            System.err.println(e.toString());
        }catch (Exception e){
            System.err.println(e.toString());
        }
    }
    
    /**
     Remet a zero les pigments du pixel
     */
    default void clear() {
        try {
            
            for (int i = 0; i < getNbrPigment(); i++) {
                setPigment(i, 0);
            }
    
        }catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
    
}
