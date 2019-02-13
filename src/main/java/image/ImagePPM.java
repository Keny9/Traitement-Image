package image;

import color.Color;
import color.Monochrome;
import color.Pixel;

import java.io.*;
import java.util.ArrayList;

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
    
    /**
     Lit un fichier pour collecter les donnees de l'image dans un tableau
     */
//    public void lire(File f) {
//        try {
//           br = new BufferedReader(new FileReader(f));
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
//            int nbLineFile = 0; //Le nombre de ligne dans le fichier reel
//            
//            // Lire la matrice
//               while((sCurrentLine = br.readLine()) != null){
//                
//                String temp[] = sCurrentLine.split(" ");
//                matrice.add(new ArrayList<Pixel>());
//                
//                for (int c = 0; c < temp.length; c+=3) {
//                    int rouge,vert,bleu;
//
//                    rouge = Integer.parseInt(temp[c]);
//                    vert = Integer.parseInt(temp[c + 1]);
//                    bleu = Integer.parseInt(temp[c + 2]);
//
//                    Color m = new Color(rouge, vert, bleu);
//
//                    addPixel(nbLineFile, c, m);
//                }
//                nbLineFile++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    
    /** Retourne le code du format de fichier pour la sauvegarde dans un fichier */
    //public String getTypeString(){ return "P3";}
}
