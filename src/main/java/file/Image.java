package file;

import color.Pixel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Classe qui gère une image et ses pixels
 * @author Karl Boutin, Maxime Lussier et Anthony Côté
 */
public class Image {
    
    private FileReader fileImage;
    private BufferedReader br;
    private String line;
    private ArrayList<ArrayList<Pixel>> m;  //Le tableau de pixel
    
    /**
     * Constructeur d'une image
     */
    Image(String nomFichier){
        
    }
    
    /**
     * Lit un fichier pour collecter les donnees de l'image dans un tableau
     */
    public void lire(){
        
    }
    
    /**
     * Modifie les donnees d'une image
     */
    public void ecrire(){
        
    }
            
}
