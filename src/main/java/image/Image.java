package image;

import color.Color;
import color.Monochrome;
import color.Pixel;
import java.io.*;
import java.util.ArrayList;


/**
 Classe qui gere une image et ses pixels avec les diverses methodes qui permet de
 * la manipuler
 @author Karl Boutin, Maxime Lussier et Anthony Cote */

public class Image{
    
    private File           file;        // Le fichier de l'image
    private BufferedReader br;          // Buffer pour lire dans le fichier
    private String         nomFichier;  // Le nom du fichier
    private int            nbCol;       // Nb colonne inscrit dans le fichier
    private int            nbRow;       // Nb ligne inscrit dans le fichier
    private String         type;        // Le type de fichier
    private int            maxValue;    // La valeur maximale possible inscrite dans le fichier

    private ArrayList <ArrayList <Pixel>> matrice = new ArrayList <ArrayList <Pixel>>();  //Le tableau de pixel
    
    /**
     * Constructeur sans parametre
     */
    Image(){}

   /**
    * Constructeur avec parametre
    * @param nomFichier
    * @throws FileNotFoundException 
    */
    Image(String nomFichier) throws FileNotFoundException{
        this.nomFichier = nomFichier;
        file = new File(nomFichier);
    }
    
    /**
     Lit un fichier pour collecter les donnees de l'image dans un tableau
     * @param f Le fichier dans lequel on veut lire
     */
    public void lire(File f) { // Voir sous classes
        try {
            br = new BufferedReader(new FileReader(f));
            String sCurrentLine;
            
            // Lire l'entete
            setType(br.readLine().trim());
            sCurrentLine = br.readLine();
            String arr[] = sCurrentLine.split(" ");
            setNbrCol(Integer.parseInt(arr[0]));
            setNbrRow(Integer.parseInt(arr[1]));
            setMaxValue(Integer.parseInt(br.readLine()));
            
            if(this instanceof ImagePGM){

                // Lire la matrice                           
                sCurrentLine = br.readLine();
                String temp[] = sCurrentLine.split(" ");
                int pos = 0; //position dans l'array temp;
                for (int row = 0; row < nbRow; row++)
                {                
                    matrice.add(new ArrayList<Pixel>());

                        for (int col = 0; col < nbCol; col++) {
                            
                            Monochrome m = new Monochrome();
                            try {
                                // Si à la fin de l'array
                                if(pos == temp.length){
                                    sCurrentLine = br.readLine();                                   
                                    temp = sCurrentLine.split(" ");
                                    pos = 0;
                                }
                                m.setPigment(0, Integer.parseInt(temp[pos]));
                                pos++;
                            } catch (Exception ex) {
                                System.err.println(ex);
                            }
                            addPixel(row, col , m); //Ajoute le pixel a la matrice    
                    }   
                }
            } 
            else if(this instanceof ImagePPM){
                
                // Lire la matrice
                sCurrentLine = br.readLine();
                String temp[] = sCurrentLine.split(" ");
                int pos = 0; //position dans l'array temp;
                 for (int row = 0; row < nbRow; row++)
                 {
                    matrice.add(new ArrayList<Pixel>());

                    for (int col = 0; col < nbCol; col++) {
                        int rouge,vert,bleu;
                        
                        if(pos == temp.length){
                            sCurrentLine = br.readLine();
                            temp = sCurrentLine.split(" ");
                            pos = 0;
                        }
                        rouge = Integer.parseInt(temp[pos]);
                        pos++;
                        if(pos == temp.length){
                            sCurrentLine = br.readLine();
                            temp = sCurrentLine.split(" ");
                            pos = 0;
                        }
                        vert = Integer.parseInt(temp[pos]);
                        pos++;
                        if(pos == temp.length){
                            sCurrentLine = br.readLine();
                            temp = sCurrentLine.split(" ");
                            pos = 0;
                        }
                        bleu = Integer.parseInt(temp[pos]);
                        pos++;

                        Color m = new Color(rouge, vert, bleu);

                        addPixel(row, col, m); //Ajoute le pixel a la matrice
                    }
                }
            }  
        } catch (IOException e) { e.printStackTrace(); }
        
    } 
    
    //Affiche le contenue de la matrice selon son type de fichier
    public void affiche(){
        
        if(this instanceof ImagePGM){
           for(int i = 0;i< getMatrice().size();i++){
                for(int j = 0; j < getMatrice().get(i).size();j++){
                    System.out.print(getMatrice().get(i).get(j).getPigment(j) + " ");
                } 
                System.out.println("");
            } 
        }
        else{
            for(int i = 0; i < getMatrice().size();i++){
                for(int j = 0;j < getMatrice().get(i).size();j++){
                    for(int k = 0; k < 3;k++){
                        System.out.print(getMatrice().get(i).get(j).getPigment(k) + " ");
                    }
                }
                System.out.println("");
            }   
        }
    }
    
    /**
     * Methode qui ecrit une image dans un fichier
     * @param nomFichier 
     */
    public void ecrire(String nomFichier){
        
        try {
            FileWriter writer = new FileWriter(nomFichier);
            
            writer.write(getTypeString() + String.format("%n"));
            writer.write(getNbrCol() + " " + getNbrRow() + String.format("%n"));
            writer.write(getMaxValue() + String.format("%n"));
                
            if(this instanceof ImagePGM){
               
                for(int i = 0;i< getMatrice().size();i++){
                    for(int j = 0; j < getMatrice().get(i).size();j++){
                        writer.write(getMatrice().get(i).get(j).getPigment(j) + " ");
                    } 
                    writer.write(String.format("%n"));
                } 
            }
            else{
                for(int i = 0; i < getMatrice().size();i++){
                    for(int j = 0;j < getMatrice().get(i).size();j++){
                        for(int k = 0; k < 3;k++){
                            writer.write(getMatrice().get(i).get(j).getPigment(k) + " ");
                        }
                    }
                    writer.write(String.format("%n"));
                }   
            }
        } catch (IOException ex) {
            System.err.println("Le fichier est protege en mode ecriture. Pour le modifier vous avez besoins des permissions necessaires sur le fichier.");
        }
    }
    
    /**
     * Methode qui prend une image et qui la copie dans une autre
     * @param i1 L image qu on veut copier
     * @param i2 L image dans laquelle on veut faire une copie de Image1
     */
    public static void copier(Image i1, Image i2) {
        
        Image temp;
        
        if (i1 instanceof ImagePGM){
            i2 = new ImagePGM();
            
            i2.setType(i1.getTypeString());
            i2.setNbrCol(i1.getNbrCol());
            i2.setNbrRow(i1.getNbrRow());
            
            for(int row = 0; row < i2.getNbrRow(); row++){
                i2.getMatrice().add(new ArrayList<Pixel>());
                for (int col = 0; col < i2.getNbrCol(); col++){
                    i2.getMatrice().get(row).add(i1.getPixel(row, col));
                }
            }
        }
    }
    
    /**
     * Trouve la couleur dominante de l'image
     * @return 
     */
    public int couleur_preponderante() {
       int prep[] = new int[256];

       for (int row = 0; row < getNbrRow(); row++){
           for (int col = 0; col < getNbrCol(); col++){
               prep[getMatrice().get(row).get(col).getPigment(0)]++;
           }
       }

       int max = 0;

       for(int i = 0; i < 256; i++){
           if(prep[i] > prep[max]){
               max = i;
           }
       }
       return max;
    }
    
    /**
     * Obtenir le type de l'image
     * @return le type de l'image
     */
    public String getTypeString(){ 
        return type;
    }

    /** Get pixel a partir de l'index de ligne et colonne
     @param r row
     @param c colonne
     @return
     */
    public Pixel getPixel(int r, int c) { 
        return getMatrice().get(r).get(c);
    }
    
    /** Change le pixel a la position specifiee dans la matrice
     @param r row
     @param c colonne
     @param p pixel
     */
    public void setPixel(int r, int c, Pixel p) { 
        getMatrice().get(r).set(c, p);    
    }
    
    /**
     * Ajoute un nouveau pixel dans la matrice de l'image qui les contient
     * @param r Position de la ligne
     * @param c Position de la colonne
     * @param p Le pixel
     */
    public void addPixel(int r,int c, Pixel p){
        getMatrice().get(r).add(p);
    }
    
    /** Retourne le nombre de ligne dans la matrice
     @return nombre de ligne dans la matrice     */
    public int getNbrRow() {
        return nbRow;
    }
    
    /** Retourne le nombre de colonne dans la matrice
     @return nombre de colonne      */
    public int getNbrCol() {
        return nbCol;
    }
    
    /**
     * Retourne la valeur maximale qu'on peut avoir dans le fichier
     * @return la valeur maximale
     */
    public int getMaxValue(){
        return 255;
    }
    
    
    /** Change le nombre de ligne  dans la matrice
     @param nbrRow nombre de lignes     */
    public void setNbrRow(int nbrRow) {
        nbRow = nbrRow;
    }

    /** Change le nombre de colonne dans la matrice
     @param nbrCol nombre de colonne      */
    public void setNbrCol(int nbrCol) {
        nbCol = nbrCol;
    }
    
     /**
     * Obtiens la matrice de l'image
     * @return the matrice
     */
    public ArrayList <ArrayList <Pixel>> getMatrice() {
        return matrice;
    }

    /**
     * @param matrice La matrice a appliquer a la matrice de l'image
     */
    public void setMatrice(ArrayList <ArrayList <Pixel>> matrice) {
        this.matrice = matrice;
    }
    
    /**
     Retourne le nombre total de pixel dans l'image
     @return nombre de pixel
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

            for ( ArrayList<Pixel> alP : matrice ) {
                for ( Pixel p : alP ) {

                    // Change le pixel

                    for (int pigm = 0; pigm < p.getNbrPigment(); pigm++) {

                        int newPigment = Math.max(0, p.getPigment(pigm) - v);
                        newPigment = Math.min(maxValue, newPigment);
                        p.setPigment(pigm, newPigment);
                    }

                }
            }


        }catch (Exception e){
            System.err.println(e.toString());
        }
    }
    
    /**
     Extraire un sous ensemble de lï¿½image partir de du point p1,c1 jusqu a p2,c2
     @param c1  Position x debut dans fichier
     @param r1  Position y debut dans fichier
     @param c2  Position x fin dans fichier
     @param r2  Position y fin dans fichier
     * Ce qui nous donnera une zone dans laquelle on veut recuperer les donnees
     */
    public Image extraire(int c1, int r1, int c2, int r2) {

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
        i.setNbrCol(newCol);
        i.setNbrRow(newRow);

        if(this instanceof ImagePPM){
            // Transfert les pixel
            for (int r = 0; r < newRow; r++) {
                i.getMatrice().add(new ArrayList<Pixel>());
                for (int c = 0; c < newCol; c++) {
                    i.getMatrice().get(r).add(getPixel(r,c));
                }
            }
        }

        if(this instanceof ImagePPM){
            // Transfert les pixel
            for (int r = 0; r < newRow; r++) {
                for (int c = 0; c < newCol; c++) {
                    i.getMatrice().add(new ArrayList<Pixel>());
                    i.getMatrice().get(r).add(getPixel(r,c));
                }
            }
        }

        return i;
    }
    
   /**
    * Methode qui reduit la dimension de l image
    * @param i l image qu on veut reduire
    * @return l image qui a ete reduit
    */
   public static Image reduire(Image i){
       
       int moyenne = 0;
       
        if (i instanceof ImagePGM){
            ImagePGM cl = new ImagePGM();
            cl.setNbrRow(i.getNbrRow()/2);
            cl.setNbrCol(i.getNbrCol()/2);
            for(int row = 0; row < cl.getNbrRow(); row++)
            {
                for (int col = 0; col < cl.getNbrCol(); col++)
                {
                    cl.getMatrice().add(new ArrayList<Pixel>());
                    Monochrome p = new Monochrome();
                    if (row == cl.getNbrRow()-1 && col == cl.getNbrCol()-1){
                         moyenne =
                                + i.getMatrice().get((row*2)).get(col*2).getPigment(0);
                        
                    }
                    else if (row == cl.getNbrRow()-1){
                         moyenne =
                                + i.getMatrice().get((row*2)).get((col*2)+1).getPigment(0)
                                + i.getMatrice().get((row*2)).get(col*2).getPigment(0);
                        moyenne /= 2;
                    }
                    else if (col == cl.getNbrCol()-1){
                         moyenne =
                                + i.getMatrice().get((row*2)+1).get(col*2).getPigment(0)
                                
                                + i.getMatrice().get((row*2)).get(col*2).getPigment(0);
                        moyenne /= 2;
                    }
                    else{
                         moyenne = i.getMatrice().get((row*2)+1).get((col*2)+1).getPigment(0)
                                + i.getMatrice().get((row*2)+1).get(col*2).getPigment(0)
                                + i.getMatrice().get((row*2)).get((col*2)+1).getPigment(0)
                                + i.getMatrice().get((row*2)).get(col*2).getPigment(0);
                        moyenne /= 4;
                    }
                    
                    try {
                        p.setPigment(0,moyenne);
                    } catch (Exception ex) {
                        System.out.println("HEY CRISS");
                    }
                    try{
                        cl.addPixel(row, col, p);
                    }
                    catch(IndexOutOfBoundsException ex){
                        System.err.println("bug");
                        System.out.println("row : " + row + " col : " + col + "moyenne: " + moyenne);
                    }
                }
            }
            return cl;
        }
        else if(i instanceof ImagePPM){
            ImagePPM cl = new ImagePPM();
            cl.setNbrRow(i.getNbrRow()/2);
            cl.setNbrCol(i.getNbrCol()/2);
            for(int row = 0; row < cl.getNbrRow(); row++)
            {
                for (int col = 0; col < cl.getNbrCol(); col++)
                {
                    cl.getMatrice().add(new ArrayList<Pixel>());
                    Color p = new Color();
                    // Pour le nombre de pigment dans un pixel color
                    for (int pig = 0; pig < 3; pig++){
                        if (row == cl.getNbrRow()-1 && col == cl.getNbrCol()-1){
                            moyenne =
                                    + i.getMatrice().get((row*2)).get(col*2).getPigment(pig);
                            
                        }
                        else if (row == cl.getNbrRow()-1){
                            moyenne =
                                    + i.getMatrice().get((row*2)).get((col*2)+1).getPigment(pig)
                                    + i.getMatrice().get((row*2)).get(col*2).getPigment(pig);
                            moyenne /= 2;
                        }
                        else if (col == cl.getNbrCol()-1){
                            moyenne =
                                    + i.getMatrice().get((row*2)+1).get(col*2).getPigment(pig)
                                    
                                    + i.getMatrice().get((row*2)).get(col*2).getPigment(pig);
                            moyenne /= 2;
                        }
                        else{
                            moyenne = i.getMatrice().get((row*2)+1).get((col*2)+1).getPigment(pig)
                                    + i.getMatrice().get((row*2)+1).get(col*2).getPigment(pig)
                                    + i.getMatrice().get((row*2)).get((col*2)+1).getPigment(pig)
                                    + i.getMatrice().get((row*2)).get(col*2).getPigment(pig);
                            moyenne /= 4;
                        }
                        
                        try {
                            p.setPigment(pig,moyenne);
                        } catch (Exception ex) {
                            System.out.println("HEY CRISS");
                        }
                    }
                    
                    try{
                        cl.addPixel(row, col, p);
                    }
                    catch(IndexOutOfBoundsException ex){
                        System.err.println("bug");
                        System.out.println("row : " + row + " col : " + col + "moyenne: " + moyenne);
                    }
                }
            }
            return cl;
        }
        return new Image();
    }
    
    /**
     Verfifie si 2 images sont identiques
     @param i1 1 image qu'on veut comparer
     @param i2 la deuxieme image qu'on veut comparer
     *@return retourne vrai si les deux images sont identiques 
     */
    public static boolean sont_identique(Image i1, Image i2) {
        
        //Si c'est le meme type d image
        if(i1.getTypeString() != i2.getTypeString()){
            return false;
        }
            
        //Verfier les lignes
        if(i1.getMatrice().size() != i2.getMatrice().size()){
            return false;
        }
        
        //Verifie les colonnes
        for(int i = 0; i < i1.getMatrice().size();i++){

            if(i1.getMatrice().get(i).size() != i2.getMatrice().get(i).size()){
                return false;
            }
        }
        
       if(i1 instanceof ImagePGM){
        //Verifier les donnees
         for(int i = 0; i < i1.getMatrice().size();i++){
            for(int j = 0; j < i1.getMatrice().get(i).size();j++){
                if( i1.getMatrice().get(i).get(j).getPigment(0) != i2.getMatrice().get(i).get(j).getPigment(0)){
                    return false;
                 }
            }
        }
    }else {
        //Verifier les donneesm PPM
        for(int i = 0; i < i1.getMatrice().size();i++){
            for(int j = 0; j < i1.getMatrice().get(i).size();j++){
                for(int k = 0; k < 3;k++){
                    if(i1.getMatrice().get(i).get(j).getPigment(k) != i2.getMatrice().get(i).get(j).getPigment(k)){
                        return false;
                    }
                }
            }
        }
    }
      
        return true;
    }

    
   /**     Pivoter l'image d'une rotation de 90     */
    public Image pivoter90() {

        //first change the dimensions vertical length for horizontal length
        //and viceversa
        Image newImg;

        if (this.getClass() == ImagePGM.class) {
            newImg = new ImagePGM();
            for (int row = 0; row < newImg.getNbrRow(); row++) {
                for (int col = 0; col < newImg.getNbrCol(); col++) {
                    newImg.setPixel(row, col, new Monochrome());
                }
            }
        }else{
            newImg = new ImagePPM();
            for (int row = 0; row < newImg.getNbrRow(); row++) {
                for (int col = 0; col < newImg.getNbrCol(); col++) {
                    newImg.setPixel(row, col, new Color());
                }
            }
        }

        //invert values 90 degrees clockwise by starting from button of
        //array to top and from left to right
        newImg.setNbrCol(getNbrRow());
        newImg.setNbrRow(getNbrCol());
        int ii = 0;
        int jj = 0;
        for(int i=0; i< newImg.getNbrRow(); i++){
            newImg.getMatrice().add(new ArrayList<Pixel>());
            for(int j= 0 ; j < newImg.getNbrCol(); j++){
                newImg.getMatrice().get(i).add(getMatrice().get(getNbrRow()- j - 1).get(i));
            }
        }
        return newImg;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param maxValue the maxValue to set
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

}

