package image;

import color.Color;
import color.Pixel;
import java.io.*;

/**
 * Classe qui instancie une image PPM
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 */
public class ImagePPM extends Image {

    /**      Contructeur    */
    ImagePPM(){}
    
    /**
     * Constructeur d'une image PPM
     * @param fichier 
     */
    ImagePPM(String fichier) throws FileNotFoundException {super(fichier);}
    
    /** Cree un pixel a partir du string de type (Factory)
     @return bon type de pixel
     */
    public static Pixel createPixel(){return new Color();}
    
    public String getTypeString(){return "P3";}
   
}
