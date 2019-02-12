package image;

import color.Color;
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
    ImagePGM(String fichier) throws FileNotFoundException {        super(fichier);    }
    
    /** Cree un pixel a partir du string de type (Factory)
    @return bon type de pixel
    */
    public static Pixel createPixel(){        return new Monochrome();    }
    
    /**
     Lit un fichier pour collecter les donnees de l'image dans un tableau
     */
    public void lire(File f) {
        try {
            br = new BufferedReader(new FileReader(f));
            String sCurrentLine;

            // Lire l'entete
            type = br.readLine().trim();
            setNbrCol(br.read());
            setNbrRow(br.read());
            maxValue = br.read();
            
            // Lire la matrice
            for (int r = 0; r < getNbrRow(); r++) {
                for (int c = 0; c < getNbrCol(); c++) {
                    
                    Pixel p = createPixel();
                    p.read(br); // Demande au pixel de s'occupper de lire ses valeurs avec le reader
                    setPixel(r, c, p);
                }
            }
            
        } catch (IOException e) { e.printStackTrace(); }
    }
    
    /** Retourne le code du format de fichier pour la sauvegarde dans un fichier */
    public static String getTypeString(){ return "P2";}
}
