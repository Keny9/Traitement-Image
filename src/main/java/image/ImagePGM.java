package image;

import color.Monochrome;
import color.Pixel;
import java.io.*;

/**
 * Classe qui instancie une image PGM
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 */
public class ImagePGM extends Image {

    ImagePGM(){}
    
    /**
     * Constructeur d'image PGM
     * @param fichier 
     */
    ImagePGM(String fichier) throws FileNotFoundException {super(fichier);}
    
    /** Cree un pixel a partir du string de type (Factory)
    @return bon type de pixel
    */
    public static Pixel createPixel(){return new Monochrome();}
    
    public String getTypeString(){return "P2";}
    
}
