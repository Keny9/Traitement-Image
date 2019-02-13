package image;

import java.io.File;
import java.io.FileNotFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 * 
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 * Classe qui nous permet de manipuler une image poour la modifier
 * Telle que changer la luminosite de l'image, copier le contenu d'une image
 * dans une autre image ou meme changer la rotation de l'image.
 * 
 */
public class ImageManipulator {    
    
/**
     The entry point of application.
     @param args the input arguments
     */
    public static void main(String[] args) {

        Traitement traitement = new Traitement();
        
        Image img1 = new ImagePGM();
        Image img2 = new ImagePPM();
        File file = new File("Sherbrooke_Frontenac_nuit.pgm"); //Pour lire une image pgm
        File file2 = new File("Sherbrooke_Frontenac_nuit.ppm"); //Pour lire une image ppm
        
        File file3 = new File("copie_sherbrooke.pgm"); //Pur ecrire dans un fichier pgm
        File file4 = new File("copie_sherbrooke.ppm"); //Pour ecrire dans un fichier ppm
        
        traitement.lire(img1,file);
        traitement.lire(img2, file2);

        System.out.println(img1.getTypeString());
        System.out.println(img2.getTypeString());
        System.out.println(img1.getNbrRow());
        System.out.println(img2.getNbrRow());
        System.out.println("");
        
//        System.out.println("Contenue de l'image pgm");
//        img1.affiche();
//        System.out.println("");
//        System.out.println("Contenue de l'image ppm");     
//        img2.affiche();

        traitement.ecrire(file3, img1);
        traitement.ecrire(file4, img2);
     
    }
    
}
