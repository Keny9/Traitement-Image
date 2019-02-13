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
    
        // OK
        //test_lire_ecrire();
        
        
        // BROKEN
        test_eclaircir();
        //test_couleur_preponderante();
        //test_extraire();
        //test_reduire();
        //test_sont_identiques();
        //test_pivoter90();
    }
    
    
    public static void test_pivoter90(){
        

        Image img1 = new ImagePGM();
        Image img2 = new ImagePPM();
        File file = new File("Sherbrooke_Frontenac_nuit.pgm"); //Pour lire une image pgm
        File file2 = new File("Sherbrooke_Frontenac_nuit.ppm"); //Pour lire une image ppm
        
        File file3 = new File("pivoter_sherbrooke.pgm"); // Pour ecrire dans un fichier pgm
        File file4 = new File("pivoter_sherbrooke.ppm"); // Pour ecrire dans un fichier ppm
        
        Traitement.lire(img1,file);
        Traitement.lire(img2, file2);
        
        Traitement.pivoter90(img1);
        Traitement.pivoter90(img2);
        
        Traitement.ecrire(file3, img1);
        Traitement.ecrire(file4, img2);
    }
    
    
    public static void test_sont_identiques(){
        

        Image img1 = new ImagePGM();
        Image img2 = new ImagePPM();
        File file = new File("Sherbrooke_Frontenac_nuit.pgm"); //Pour lire une image pgm
        File file2 = new File("Sherbrooke_Frontenac_nuit.ppm"); //Pour lire une image ppm
        
        Traitement.lire(img1,file);
        Traitement.lire(img2, file2);
    
        System.out.println("Devrait etre identique");
        System.out.println(Traitement.sont_identique(img1, img1));
        System.out.println("Ne devrait pas etre identique");
        System.out.println(Traitement.sont_identique(img1, img2));

    }
    
    public static void test_reduire(){
        

        Image img1 = new ImagePGM();
        Image img2 = new ImagePPM();
        File file = new File("Sherbrooke_Frontenac_nuit.pgm"); //Pour lire une image pgm
        File file2 = new File("Sherbrooke_Frontenac_nuit.ppm"); //Pour lire une image ppm
        
        File file3 = new File("reduire_sherbrooke.pgm"); // Pour ecrire dans un fichier pgm
        File file4 = new File("reduire_sherbrooke.ppm"); // Pour ecrire dans un fichier ppm
        
        Traitement.lire(img1,file);
        Traitement.lire(img2, file2);
        
        Traitement.reduire(img1);
        Traitement.reduire(img2);
        
        Traitement.ecrire(file3, img1);
        Traitement.ecrire(file4, img2);
    }
    
    public static void test_extraire(){
        

        Image img1 = new ImagePGM();
        Image img2 = new ImagePPM();
        File file = new File("Sherbrooke_Frontenac_nuit.pgm"); //Pour lire une image pgm
        File file2 = new File("Sherbrooke_Frontenac_nuit.ppm"); //Pour lire une image ppm
        
        File file3 = new File("extraire_sherbrooke.pgm"); // Pour ecrire dans un fichier pgm
        File file4 = new File("extraire_sherbrooke.ppm"); // Pour ecrire dans un fichier ppm
        
        Traitement.lire(img1,file);
        Traitement.lire(img2, file2);
        
        Traitement.extraire(img1, 10, 10, 50, 50);
        Traitement.extraire(img2, 10, 10, 50, 50);
        
        Traitement.ecrire(file3, img1);
        Traitement.ecrire(file4, img2);
    }
    
    
    public static void test_couleur_preponderante(){
        

        Image img1 = new ImagePGM();
        Image img2 = new ImagePPM();
        File file = new File("Sherbrooke_Frontenac_nuit.pgm"); //Pour lire une image pgm
        File file2 = new File("Sherbrooke_Frontenac_nuit.ppm"); //Pour lire une image ppm
        
        Traitement.lire(img1,file);
        Traitement.lire(img2, file2);
    
        System.out.println("Les couleurs preponderante sont : ");
//        System.out.println(traitement.couleur_preponderante(img1));
//        System.out.println(traitement.couleur_preponderante(img2));
    }
    
    public static void test_eclaircir(){
        
       
        Image img1 = new ImagePGM();
        Image img2 = new ImagePPM();
        File file = new File("Sherbrooke_Frontenac_nuit.pgm"); //Pour lire une image pgm
        File file2 = new File("Sherbrooke_Frontenac_nuit.ppm"); //Pour lire une image ppm
        
        File file3 = new File("eclaircir_sherbrooke.pgm"); // Pour ecrire dans un fichier pgm
        File file4 = new File("eclaircir_sherbrooke.ppm"); // Pour ecrire dans un fichier ppm
        
        Traitement.lire(img1,file);
        Traitement.lire(img2, file2);
        
        Traitement.eclaircir_noircir(img1, 100);
        Traitement.eclaircir_noircir(img2, 100);
        
        Traitement.ecrire(file3, img1);
        Traitement.ecrire(file4, img2);
    }
    
    public static void test_lire_ecrire(){

        Image img1 = new ImagePGM();
        Image img2 = new ImagePPM();
        File file = new File("Sherbrooke_Frontenac_nuit.pgm"); //Pour lire une image pgm
        File file2 = new File("Sherbrooke_Frontenac_nuit.ppm"); //Pour lire une image ppm
        
        File file3 = new File("copie_sherbrooke.pgm"); // Pour ecrire dans un fichier pgm
        File file4 = new File("copie_sherbrooke.ppm"); // Pour ecrire dans un fichier ppm
        
        Traitement.lire(img1,file);
        Traitement.lire(img2, file2);

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

        Traitement.ecrire(file3, img1);
        Traitement.ecrire(file4, img2);
     
    }
    
}
