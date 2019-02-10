package image;

import color.Pixel;
import other.Helper;

import java.io.*;
import java.util.ArrayList;



/**
 Classe qui g�re une image et ses pixels
 @author Karl Boutin, Maxime Lussier et Anthony C�t� */
public class Image {
    
    private FileReader                    fileImage;
    private BufferedReader                br;
    private String                        filename;
    
    private String                        type;
    private ArrayList <ArrayList <Pixel>> matrice;  //Le tableau de pixel
    private int                           maxValue;
    
    /**
     Constructeur
     */
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
    public void lire(File f) {
        try {
            br = new BufferedReader(new FileReader(filename));
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
            
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** Cree un pixel a partir du string de type (Factory)
     @return bon type de pixel
     */
    public Pixel createPixel(){ return getPixel(0,0).clone(); }
    

    
    /**
     Modifie les donnees d'une image
     */
    public void ecrire(String filename) {
        
        StringBuilder strBld = new StringBuilder();
        
        // Ajoute l'entete
        strBld.append(type)
                .append("\r\n")
                .append(getNbrRow())
                .append(" ")
                .append(getNbrCol())
                .append("\r\n");
        
        // Ajoute la matrice
        for (int r = 0; r < getNbrRow(); r++) {
            for (int c = 0; c < getNbrCol(); c++) {
                strBld.append(getPixel(r,c).toString());
            }
        }

        Helper.writeToFile(strBld.toString(), filename);
    }


    
    
    /** Get pixel a partir de l'index de row et colonne
     @param r row
     @param c colonne
     @return
     */
    public Pixel getPixel(int r, int c) { return matrice.get(r).get(c);    }
    
    /** Change le pixel a la position specifiee
     @param r row
     @param c colonne
     @param p pixel
     */
    public void setPixel(int r, int c, Pixel p) { matrice.get(r).set(c, p);    }
    
    /** Retourne le nombre de ligne dans la matrice
     @return nombre de ligne dans la matrice     */
    public int getNbrRow() { return matrice.size(); }
    
    /** Retourne le nombre de colonne dans la matrice
     @return nombre de colonne      */
    public int getNbrCol() { return matrice.get(0).size(); }
    
    
    /** Change le nombre de ligne  dans la matrice
     @param nbrRow nombre de lignes     */
    public void setNbrRow(int nbrRow) {
        
        // Enleve les ligne de trop
        while (nbrRow > getNbrRow())
            matrice.remove( matrice.size()-1);
        
        // Ajoute les lignes qui manque
        while (nbrRow < getNbrRow()) {
            matrice.add(new ArrayList <>(getNbrCol()));
        }
    }

    /** Change le nombre de colonne dans la matrice
     @param nbrCol nombre de colonne      */
    public void setNbrCol(int nbrCol) {
    
        for ( ArrayList<Pixel> eachRow : matrice ) {
            
            // Enleve les colonnes de trop
            while (nbrCol > getNbrCol())
                eachRow.remove( eachRow.size()-1);
            
            //Ajoute les colonnes qui manque
            while (nbrCol < getNbrCol())
                eachRow.add(createPixel());
            
            
        }
        
    }
    
    /** Redimensionne la matrice
     @param nbrRow nombre de ligne dans la matrice
     @param nbrCol nombre de colonne dans la matrice
     */
    public void resizeMatrice(int nbrRow, int nbrCol){
        
        setNbrRow(nbrRow);
        setNbrCol(nbrCol);
        
    }
    
    /**
     
     @return
     */
    public int getNbrPigment(){ return getPixel(0,0).getNbrPigment();    }
    
    
    /**
     Prend l�objet i1 et fait une copie dans l�objet i2
     @param i1 the 1 L'image qu'on copie
     @param i2 the 2 L'image dans lequel on colle les donnees
     */
    public void copier(Image i1, Image i2) {
    
    }
    
    /** Retournera la couleur preponderante de l'image i */
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
                    total_pigment[i] += getPixel(r,c).getPigment(i);
                }
            }
        }
        
        Pixel p = createPixel();
        
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
     Retourne le nombre total de pixel dans l'image
     @return nombre de pixel
     */
    public int getNbrPixel(){        return getNbrRow() * getNbrCol();    }
    
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
                    Pixel cl = getPixel(r, c).clone();
                    for (int p = 0; p < cl.getNbrPigment(); p++) {
                        cl.setPigment(p, cl.getPigment(p) - v);
                    }
                    setPixel(r, c, cl);
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
                
                i.setPixel(r, c, getPixel(r,c).clone()); // Copie le pixel
                
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
        
        // Gere tous les pixel de l'image reduite
        for (int c = 0; c < cl.getNbrCol(); c++) {
            for (int r = 0; r < cl.getNbrRow(); r++) {
                
                Pixel p = createPixel();
    
                
                for (int i = 0; i < getNbrPigment(); i++) {
                    
                    // Retrouve un pigment des 4 cases
                    int nbrPigments =1;
                    
                    int totalValue = getPixel(r*2,c*2).getPigment(i);
                    
                    if (r*2 < getNbrRow() - 1) {
                        totalValue += getPixel(r * 2 + 1, c * 2).getPigment(i);
                        nbrPigments++;
                    }
                    if (c*2 < getNbrCol() - 1){
                        totalValue += getPixel(r*2,c*2+1).getPigment(i);
                        nbrPigments++;
                    }
                        
                    if ((r*2 < getNbrRow() - 1) && (c*2 < getNbrCol() - 1)){
                        totalValue += getPixel(r*2+1,c*2+1).getPigment(i);
                        nbrPigments++;
                    }
                    
                    try {
                        p.setPigment(i, totalValue / nbrPigments);
                    }catch(Exception e){
                        System.err.println(e.toString());
                    }
                }
                
                cl.setPixel(r, c, p); // Copie le pixel
                
            }
        }
        
        return cl;
    }
    
    /**
     Verfifie si 2 images sont identiques
     @param i1 1 image qu'on veut comparer
     @param i2 la deuxieme image qu'on veut comparer
     */
    public static boolean sont_identique(Image i1, Image i2) {
        
        // Verify les dimension
        if (i1.getNbrRow() != i2.getNbrRow() || i1.getNbrCol() != i2.getNbrCol() )
            return false;
        
        // Verify les pixels
        for (int r = 0; r < i1.getNbrRow(); r++) {
            for (int c = 0; c < i1.getNbrCol(); c++) {
                if (i1.getPixel(r,c).equals(i2.getPixel(r, c)))
                    return false;
            }
        }
        return true;
    }
    
    /**
     Pivoter l'image d'une rotation de 90
     */
    public void pivoter90() {
    
        Image cl = clone();
        
        // Pivote
        for (int r = 0; r < getNbrRow(); r++) {
            for (int c = 0; c < getNbrCol(); c++) {
                
                Pixel p = getPixel(c, getNbrRow() - r);
                cl.setPixel(r, c, p);
            }
        }

        matrice = cl.matrice;
    }
    
    /**
     Rempli l'image avec un pixel
     @param p pixel
     */
    public void fill(Pixel p) {
    
        for (int r = 0; r < getNbrRow(); r++) {
            for (int c = 0; c < getNbrCol(); c++) {
                setPixel(r,c, p.clone());
            }
        }
    }
    
    
    @Override
    public Image clone() {
        
        // Cree une nouvelle image de meme taille
        Image cl = new Image();
        cl.resizeMatrice(getNbrRow(), getNbrCol());
        
        // Clone les pixels
        for (int r = 0; r < getNbrRow(); r++) {
            for (int c = 0; c < getNbrCol(); c++) {
                cl.setPixel(r,c, getPixel(r,c).clone());
            }
        }
        return cl;
    }
    
    @Override
    public String toString() {
        
        return "Image{" + "fileImage=" + fileImage + ", br=" + br + ", filename='" + filename + '\'' + ", type='" + type + '\'' + ", matrice=" + matrice + ", maxValue=" + maxValue + '}';
    }
}
