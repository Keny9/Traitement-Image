package image;

import color.Color;
import color.Monochrome;
import color.Pixel;
import jdk.jshell.spi.ExecutionControl;

/**
 * Classe qui instancie une image PPM
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 */
public class ImagePPM extends Image {

    /**
     * Constructeur d'une image PPM
     * @param fichier 
     */
    ImagePPM(String fichier){
        super(fichier);
    }
    
    /** Cree un pixel a partir du string de type (Factory)
     @return bon type de pixel
     */
    @Override
    public Pixel createPixel(){

        return new Color();
    }
    
}
