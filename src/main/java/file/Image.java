package file;

import color.Pixel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static java.util.Collections.swap;


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
    
    Image(){
    
    }
    
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
     @param r ligne
     @param c colonne
     @param p pixel
     */
    public void set(int r, int c, Pixel p) {
        
        matrice.get(r).set(c, p);
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
     
     @return
     */
    public int getNbrPigment(){
        return get(0,0).getNbrPigment();
    }
    
    
    /**
     Prend l�objet i1 et fait une copie dans l�objet i2
     @param i1 the 1 L'image qu'on copie
     @param i2 the 2 L'image dans lequel on colle les donnees
     */
    public void copier(Image i1, Image i2) {
    
    }
    
    /**     Retournera la couleur preponderante de l'image i
     */
    public void couleur_preponderante() {
    
        int[] total_pigment = {0,0,0};
    
        for (int i = 0; i < getNbrPigment(); i++) {
            total_pigment[i] = 0;
        }
        
        // Cumule les valeurs dans chaque pixel
        for (int c = 0; c < getNbrCol(); c++) {
            for (int r = 0; r < getNbrRow(); r++) {
    
                // Lit les valeurs du pixel
                for (int i = 0; i < getNbrPigment(); i++) {
                    total_pigment[i] += get(r,c).getPigment(i);
                }
            }
        }
        
        Pixel p = get(0,0).clone();
        
        //Calcule les valeurs
        try{
            for (int i = 0; i < getNbrPigment(); i++) {
                p.setPigment(i, total_pigment[i] / getNbrPixel());
            }
        
        }catch(Exception e){
            System.err.println(e.toString());
        }


    }
    
    /**
     
     @return
     */
    public int getNbrPixel(){
        return getNbrRow() * getNbrCol();
    }
    
    /**
     Modifie la valeur de chaque pixel de l'image d'une valeur specifiee,
     * si v est positif, l'image devient plus noire, si v est negatif, l'image devient plus claire
     @param v the v L'intensite qu'on veut appliquer a l'image
     */
    public void eclaircir_noircir(int v) {
        
        try {
            for (int r = 0; r < getNbrRow(); r++) {
                for (int c = 0; c < getNbrCol(); c++) {
    
                    //
                    Pixel cl = get(r, c).clone();
                    for (int p = 0; p < cl.getNbrPigment(); p++) {
                        cl.setPigment(p, cl.getPigment(p) - v);
                    }
                    set(r, c, cl);
                }
            }
        }catch (Exception e){
            System.err.println(e.toString());
        }
    }
    
    /**
     Extraire un sous ensemble de l�image partir de du point p1,c1 jusqu�� p2,c2
     @param c1  Position x debut dans fichier
     @param r1  Position y debut dans fichier
     @param c2  Position x fin dans fichier
     @param r2  Position y fin dans fichier
     * Ce qui nous donnera une zone dans laquelle on veut recuperer les donnees
     */
    public void extraire(int c1, int r1, int c2, int r2) {
        
        Image i = new Image();
        
        // S'assure que les valeur sont dans le bon ordre
        if (c1 > c2) {
            int temp = c1;
            c1 = c2;
            c2 = temp;
        }
        
        if (r1 > r2) {
            int temp = r1;
            r1 = r2;
            r2 = temp;
        }
        
        // Redimensionne la matrice
        int newRow = r2 - r1;
        int newCol = c2 - c1;
        i.resizeMatrice( newRow, newCol);
    
        // Transfert les pixel
        for (int c = 0; c < newCol; c++) {
            for (int r = 0; r < newRow; r++) {
                
                i.set(r, c, get(r,c).clone()); // Copie le pixel
                
            }
        }
    }
    /**
     Reduire une image i1 a une image i2
     * Reduit la taille de l'image
     */
    public Image reduire() {
    
        Image cl = new Image();
        cl.resizeMatrice(getNbrRow()/2, getNbrCol()/2);
        int[] pigments = {0,0,0};
        
        for (int c = 0; c < cl.getNbrCol(); c++) {
            for (int r = 0; r < cl.getNbrRow(); r++) {
                
                Pixel p = get(0,0).clone();
    
                
                for (int i = 0; i < getNbrPigment(); i++) {
                    
                    // Retrouve un pigment des 4 cases
                    int v = get(r*2,c*2).getPigment(i);
                    
                    if (r*2 < getNbrRow() - 1)
                        v = get(r*2+1,c*2).getPigment(i);
                    
                    if (c*2 < getNbrCol() - 1)
                        v = get(r*2,c*2+1).getPigment(i);
                        
                    if ((r*2 < getNbrRow() - 1) && (c*2 < getNbrCol() - 1))
                        v = get(r*2+1,c*2+1).getPigment(i);
                    
                    try {
                        p.setPigment(i, v);
                    }catch(Exception e){
                        System.err.println(e.toString());
                    }
                }
                
                cl.set(r, c, p); // Copie le pixel
                
            }
        }
        
        return cl;
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
     */
    public void pivoter90() {
    
        Image i;
        
        // Clone
        try {
            i = clone();
            
            // Pivote
            for (int r = 0; r < getNbrRow(); r++) {
                for (int c = 0; c < getNbrCol(); c++) {
                    
                    Pixel p = get(c, getNbrRow() - r);
                    i.set(r, c, p);
                    
                }
            }
        }catch (CloneNotSupportedException e){
            System.err.println(e.toString());
        }
    }
    
    public Image clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
