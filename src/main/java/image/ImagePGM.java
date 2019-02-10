package image;

import color.Color;
import color.Monochrome;
import color.Pixel;
//import jdk.jshell.spi.ExecutionControl;

/**
 * Classe qui instancie une image PGM
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 */
public class ImagePGM extends Image {

    /**
     * Constructeur d'image PGM
     * @param fichier 
     */
    ImagePGM(String fichier){
        super(fichier);
    }
    
    
        /** Cree un pixel a partir du string de type (Factory)
     @return bon type de pixel
     */
    @Override
    public Pixel createPixel(){

        return new Monochrome();
    }
    
}
