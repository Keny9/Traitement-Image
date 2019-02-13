package image;

import color.Monochrome;
import color.Pixel;

import java.io.*;
import java.util.ArrayList;

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
    
    /**
     Lit un fichier pour collecter les donnees de l'image dans un tableau
     */
//    public void read(File f) {
//        try {
//            br = new BufferedReader(new FileReader(f));
//            String sCurrentLine;
//            
//            // Lire l'entete
//            type = br.readLine().trim();
//            sCurrentLine = br.readLine();
//            String arr[] = sCurrentLine.split(" ");
//            setNbrCol(Integer.parseInt(arr[0]));
//            setNbrRow(Integer.parseInt(arr[1]));
//            maxValue = Integer.parseInt(br.readLine());
//            
//            int nbLineFile = 0; //Le nombre de ligne dans le fichier
//            
//            // Lire la matrice
//            while((sCurrentLine = br.readLine()) != null){
//                  
//                String temp[] = sCurrentLine.split(" ");
//                matrice.add(new ArrayList<Pixel>());
//                  
//                for (int c = 0; c < temp.length; c++) {
//                    
//                    Monochrome m = new Monochrome();
//                    try {
//                        m.setPigment(0, Integer.parseInt(temp[c]));
//                    } catch (Exception ex) {
//                        System.err.println(ex);
//                    }
//                    addPixel(nbLineFile, c, m);
//                }
//                nbLineFile++;
//            }
//        } catch (IOException e) { e.printStackTrace(); }
//    }
    
    /** Retourne le code du format de fichier pour la sauvegarde dans un fichier */
    public String getTypeString(){ return "P2";}
}
