package file;

import color.Pixel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 Classe qui g�re une image et ses pixels
 @author Karl Boutin, Maxime Lussier et Anthony C�t� */
public class Image {
    
    private FileReader                    fileImage;
    private BufferedReader                br;
    private String                        line;
    private ArrayList <ArrayList <Pixel>> matrice;  //Le tableau de pixel
    private int                           nbrRow;
    private int                           nbrCol;
    
    /**
     Constructeur d'une image
     */
    Image(String nomFichier) {
        
    }
    
    /**
     Constructeur d'une image
     */
    Image(File file) {
    
    }
    
    /**
     Lit un fichier pour collecter les donnees de l'image dans un tableau
     */
    public void lire() {
        
        // Lire l'entete
        
        
        
        // Lire la matrice
        for (int r = 0; r < getNbrRow(); r++) {
            for (int c = 0; c < getNbrCol(); c++) {
                // Read Pixel
            }
        }
        
    }
    
    /**
     Modifie les donnees d'une image
     */
    public void ecrire() {
        
        // Ecrit entete
        
        
        // Ecrit la matrice
        for (int r = 0; r < getNbrRow(); r++) {
            for (int c = 0; c < getNbrCol(); c++) {
            
            }
        }

    }


    
    
    /**
     Get
     @param r ligne
     @param c colonne
     @return
     */
    public Pixel get(int r, int c) {
        
        return matrice.get(r).get(c);
    }
    
    /**
     Set
     @param l ligne
     @param c colonne
     @param p pixel
     */
    public void set(int l, int c, Pixel p) {
        
        matrice.get(l).set(c, p);
    }
    
    /**
     @return nombre de ligne dans la matrice     */
    public int getNbrRow() { return nbrRow; }
    /**
     @return nombre de colonne dans la matrice     */
    public int getNbrCol() { return nbrCol; }
    /**
     @param nbrRow nombre de lignes dans la matrice     */
    public void setNbrRow(int nbrRow) { this.nbrRow = nbrRow; }

    /**
     @param nbrCol nombre de colonne dans la matrice     */
    public void setNbrCol(int nbrCol) { this.nbrCol = nbrCol; }
    
    /**
     
     @param nbrRow nombre de ligne dans la matrice
     @param nbrCol nombre de colonne dans la matrice
     */
    public void resizeMatrice(int nbrRow, int nbrCol){
        
        ArrayList <ArrayList <Pixel>> temp;
        
    }
    
    
    
    
    /**
     Prend l�objet i1 et fait une copie dans l�objet i2
     @param i1 the 1 L'image qu'on copie
     @param i2 the 2 L'image dans lequel on colle les donnees
     */
    public void copier(Image i1, Image i2) {
    
    }
    /**
     Retournera la couleur pr�pond�rante de l�image i
     @param i L'image dans laquelle on veut recuperer la couleur dominante de l'image
     */
    public void couleur_preponderante(Image i) {
    
    }
    /**
     Modifie la valeur de chaque pixel de l�image d�une valeur sp�cifi�e,
     * si v est positif, l�image devient plus noire, si v est n�gatif, l�image devient plus claire
     @param i L'image dans laquelle on veut changer la luminosite
     @param v the v L'intensite qu'on veut appliquer a l'image
     */
    public void eclaircir_noircir(Image i, int v) {
        
        try {
            for (int r = 0; r < getNbrRow(); r++) {
                for (int c = 0; c < getNbrCol(); c++) {
    
                    Pixel cl = i.get(r, c).clone();
                    for (int p = 0; p < cl.getNbrPigment(); p++) {
                        cl.setPigment(p, cl.getPigment(p) - v);
                    }
                    i.set(r, c, cl);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     Extraire un sous ensemble de l�image partir de du point p1,c1 jusqu�� p2,c2
     @param i  L'image dans laquelle on veut extraire les donnees
     @param x1  Position x debut dans fichier
     @param y1  Position y debut dans fichier
     @param x2  Position x fin dans fichier
     @param y2  Position y fin dans fichier
     * Ce qui nous donnera une zone dans laquelle on veut recuperer les donnees
     */
    public void extraire(Image i, int x1, int y1, int x2, int y2) {
    
    }
    /**
     Reduire une image i1 a une image i2
     * Reduit la taille de l'image
     @param i L'image qu'on veut reduire
     */
    public void reduire(Image i) {
    
    }
    /**
     Verfifie si 2 images sont identiques
     @param i1 1 image qu'on veut comparer
     @param i2 la deuxieme image qu'on veut comparer
     */
    public boolean sont_identique(Image i1, Image i2) {
        
        // Verify les dimension
        if (i1.getNbrRow() != i2.getNbrRow() || i1.getNbrCol() != i2.getNbrCol() )
            return false;
        
        // Verify les pixels
        for (int r = 0; r < getNbrRow(); r++) {
            for (int c = 0; c < getNbrCol(); c++) {
                if (i1.get(r,c).equals(i2.get(r, c)))
                    return false;
            }
        }
        return true;
    }
    /**
     Pivoter l'image d'une rotation de 90
     @param i L'image dans laquelle on fait une rotation
     */
    public void pivoter90(Image i) {
    
    }
}
