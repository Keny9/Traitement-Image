package color;

import java.io.BufferedReader;

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
    
    boolean validatePigmentIndex(int index);
    
    /**
    Equals boolean.
    @param p the p
    @return the boolean
    */
    boolean equals(Pixel p);
    
    void read(BufferedReader br);
    
    boolean validatePigmentTone(int tone)throws InstantiationException;
 
}
