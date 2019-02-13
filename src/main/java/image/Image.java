package image;

import color.Color;
import color.Monochrome;
import color.Pixel;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import other.Helper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 Classe qui gere une image et ses pixels
 @author Karl Boutin, Maxime Lussier et Anthony Cote */
public class Image {
    
    private File           file;        // Le fichier de l'image
    private BufferedReader br;          // Buffer pour lire dans le fichier
    private String         nomFichier;  // Le nom du fichier
    private int            nbCol;       // Nb colonne inscrit dans le fichier
    private int            nbLine;      // Nb ligne inscrit dans le fichier
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
            type = br.readLine().trim();
            sCurrentLine = br.readLine();
            String arr[] = sCurrentLine.split(" ");
            setNbrCol(Integer.parseInt(arr[0]));
            setNbrRow(Integer.parseInt(arr[1]));
            maxValue = Integer.parseInt(br.readLine());
            
            int nbLineFile = 0; //Le nombre de ligne dans le fichier
            
            if(this instanceof ImagePGM){

                // Lire la matrice
                while((sCurrentLine = br.readLine()) != null){

                    String temp[] = sCurrentLine.split(" ");
                    matrice.add(new ArrayList<Pixel>());

                        for (int c = 0; c < temp.length; c++) {
                            
                            Monochrome m = new Monochrome();
                            try {
                                m.setPigment(0, Integer.parseInt(temp[c]));
                            } catch (Exception ex) {
                                System.err.println(ex);
                            }
                            addPixel(nbLineFile, c, m); //Ajoute le pixel a la matrice
                    }
                        nbLineFile++;   
                }
            } 
            else if(this instanceof ImagePPM){
                
                // Lire la matrice
                 while((sCurrentLine = br.readLine()) != null){

                    String temp[] = sCurrentLine.split(" ");
                    matrice.add(new ArrayList<Pixel>());

                    for (int c = 0; c < temp.length; c+=3) {
                        int rouge,vert,bleu;

                        rouge = Integer.parseInt(temp[c]);
                        vert = Integer.parseInt(temp[c + 1]);
                        bleu = Integer.parseInt(temp[c + 2]);

                        Color m = new Color(rouge, vert, bleu);

                        addPixel(nbLineFile, c, m); //Ajoute le pixel a la matrice
                    }
                    nbLineFile++;
                }
            }  
        } catch (IOException e) { e.printStackTrace(); }
        
    } 
    
    //Affiche le contenue de la matrice selon sont type de fichier
    public void affiche(){
        
        if(this instanceof ImagePGM){
           for(int i = 0;i< matrice.size();i++){
                for(int j = 0; j < matrice.get(i).size();j++){
                    System.out.print(matrice.get(i).get(j).getPigment(j) + " ");
                } 
                System.out.println("");
            } 
        }
        else{
            for(int i = 0; i < matrice.size();i++){
                for(int j = 0;j < matrice.get(i).size();j++){
                    for(int k = 0; k < 3;k++){
                        System.out.print(matrice.get(i).get(j).getPigment(k) + " ");
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
               
                for(int i = 0;i< matrice.size();i++){
                    for(int j = 0; j < matrice.get(i).size();j++){
                        writer.write(matrice.get(i).get(j).getPigment(j) + " ");
                    } 
                    writer.write(String.format("%n"));
                } 
            }
            else{
                for(int i = 0; i < matrice.size();i++){
                    for(int j = 0;j < matrice.get(i).size();j++){
                        for(int k = 0; k < 3;k++){
                            writer.write(matrice.get(i).get(j).getPigment(k) + " ");
                        }
                    }
                    writer.write(String.format("%n"));
                }   
            }
        } catch (IOException ex) {
            System.err.println("Le fichier est protege en mode ecriture. Pour le modifier vous avez besoins des permissions necessaires sur le fichier.");
        }
    }
    
//    /** Cree un pixel a partir du string de type (Factory)
//     @return bon type de pixel
//     */
//    private static Pixel createPixel(){
//        throw new NotImplementedException();// pas besoin puiquon herite
//        //return getPixel(0,0).clone();
//    }

    /**
     Ecrire une image dans un fichier
     */
//    public void ecrire(String filename) {
//        
//        Helper.writeToFile(toStringFile(), filename);
//    }
//    
//    public String toStringFile(){
//        
//        StringBuilder strBld = new StringBuilder();
//        
//        // Ajoute l'entete
//        strBld.append(type)
//                .append("\r\n")
//                .append(getNbrRow())
//                .append(" ")
//                .append(getNbrCol())
//                .append("\r\n")
//                .append(getTypeString())
//                .append("\r\n");
//        
//        // Ajoute la matrice
//        for (int r = 0; r < getNbrRow(); r++) {
//            for (int c = 0; c < getNbrCol(); c++) {
//                strBld.append(getPixel(r,c).toString())
//                        .append(" ");
//            }
//            strBld.append("\r\n");
//        }
//        
//        return strBld.toString();
//    }
    
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
        return matrice.get(r).get(c);
    }
    
    /** Change le pixel a la position specifiee dans la matrice
     @param r row
     @param c colonne
     @param p pixel
     */
    public void setPixel(int r, int c, Pixel p) { 
        matrice.get(r).set(c, p);    
    }
    
    /**
     * Ajoute un nouveau pixel dans la matrice de l'image qui les contient
     * @param r Position de la ligne
     * @param c Position de la colonne
     * @param p Le pixel
     */
    public void addPixel(int r,int c, Pixel p){
        matrice.get(r).add(p);
    }
    
    /** Retourne le nombre de ligne dans la matrice
     @return nombre de ligne dans la matrice     */
    public int getNbrRow() {
        return nbLine;
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
        return maxValue;
    }
    
    
    /** Change le nombre de ligne  dans la matrice
     @param nbrRow nombre de lignes     */
    public void setNbrRow(int nbrRow) {
        nbLine = nbrRow;
    }

    /** Change le nombre de colonne dans la matrice
     @param nbrCol nombre de colonne      */
    public void setNbrCol(int nbrCol) {
        nbCol = nbrCol;
    }
    
    /** Redimensionne la matrice
     @param nbrRow nombre de ligne dans la matrice
     @param nbrCol nombre de colonne dans la matrice
     */
//    public void resizeMatrice(int nbrRow, int nbrCol){
//        
//        setNbrRow(nbrRow);
//        setNbrCol(nbrCol);
//    }
    
    /**
     
     @return
     */
//    public static int getNbrPigment(){ return createPixel().getNbrPigment();    }
    
    
    /**
     Prend l�objet i1 et fait une copie dans l�objet i2
     @param i1 the 1 L'image qu'on copie
     @param i2 the 2 L'image dans lequel on colle les donnees
     */
    public void copier(Image i1, Image i2) {
        i1.lire(file);
        
        i1.ecrire(i2.nomFichier);
    }
    
//    /** Retournera la couleur preponderante de l'image i */
//    public void couleur_preponderante() {
//    
//        int[] total_pigment = {0,0,0};
//    
//        for (int i = 0; i < getNbrPigment(); i++) {
//            total_pigment[i] = 0;
//        }
//        
//        // Cumule les valeurs dans chaque pixel
//        for (int c = 0; c < getNbrCol(); c++) {
//            for (int r = 0; r < getNbrRow(); r++) {
//    
//                // Lit les valeurs du pixel
//                for (int i = 0; i < getNbrPigment(); i++) {
//                    total_pigment[i] += getPixel(r,c).getPigment(i);
//                }
//            }
//        }
//        
//        Pixel p = createPixel();
//        
//        //Calcule les valeurs
//        try{
//            for (int i = 0; i < getNbrPigment(); i++) {
//                p.setPigment(i, total_pigment[i] / getNbrPixel());
//            }
//        
//        }catch(Exception e){
//            System.err.println(e.toString());
//        }
//    }
    
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
     Extraire un sous ensemble de l�image partir de du point p1,c1 jusqu�� p2,c2
     @param c1  Position x debut dans fichier
     @param r1  Position y debut dans fichier
     @param c2  Position x fin dans fichier
     @param r2  Position y fin dans fichier
     * Ce qui nous donnera une zone dans laquelle on veut recuperer les donnees
     */
//    public void extraire(int c1, int r1, int c2, int r2) {
//        
//        Image i = new Image();
//        
//        // S'assure que les valeur sont dans le bon ordre
//        if (c1 > c2) {
//            int temp = c1;
//            c1 = c2;
//            c2 = temp;
//        }
//        
//        if (r1 > r2) {
//            int temp = r1;
//            r1 = r2;
//            r2 = temp;
//        }
//        
//        // Redimensionne la matrice
//        int newRow = r2 - r1;
//        int newCol = c2 - c1;
//        i.resizeMatrice( newRow, newCol);
//    
//        // Transfert les pixel
//        for (int c = 0; c < newCol; c++) {
//            for (int r = 0; r < newRow; r++) {
//                
//                i.setPixel(r, c, getPixel(r,c).clone()); // Copie le pixel
//            }
//        }
//    }
    
    /**
     Reduire une image i1 a une image i2
     * Reduit la taille de l'image
     */
//    public Image reduire() {
//    
//        Image cl = new Image();
//        cl.resizeMatrice(getNbrRow()/2, getNbrCol()/2);
//        int[] pigments = {0,0,0};
//        
//        // Gere tous les pixel de l'image reduite
//        for (int c = 0; c < cl.getNbrCol(); c++) {
//            for (int r = 0; r < cl.getNbrRow(); r++) {
//                
//                Pixel p = createPixel();
//                
//                for (int i = 0; i < getNbrPigment(); i++) {
//                    
//                    // Retrouve un pigment des 4 cases
//                    int nbrPigments =1;
//                    
//                    int totalValue = getPixel(r*2,c*2).getPigment(i);
//                    
//                    if (r*2 < getNbrRow() - 1) {
//                        totalValue += getPixel(r * 2 + 1, c * 2).getPigment(i);
//                        nbrPigments++;
//                    }
//                    if (c*2 < getNbrCol() - 1){
//                        totalValue += getPixel(r*2,c*2+1).getPigment(i);
//                        nbrPigments++;
//                    }
//                        
//                    if ((r*2 < getNbrRow() - 1) && (c*2 < getNbrCol() - 1)){
//                        totalValue += getPixel(r*2+1,c*2+1).getPigment(i);
//                        nbrPigments++;
//                    }
//                    
//                    try {
//                        p.setPigment(i, totalValue / nbrPigments);
//                    }catch(Exception e){
//                        System.err.println(e.toString());
//                    }
//                }
//                cl.setPixel(r, c, p); // Copie le pixel
//            }
//        }
//        return cl;
//    }
    
    /**
     Verfifie si 2 images sont identiques
     @param i1 1 image qu'on veut comparer
     @param i2 la deuxieme image qu'on veut comparer
     */
    public static boolean sont_identique(Image i1, Image i2) {
        
        // Verifier les dimension
        if (i1.getNbrRow() != i2.getNbrRow() || i1.getNbrCol() != i2.getNbrCol() )
            return false;
        
        // Verifier les pixels
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
//    public void pivoter90() {
//    
//        Image cl = clone();
//        
//        // Pivote
//        for (int r = 0; r < getNbrRow(); r++) {
//            for (int c = 0; c < getNbrCol(); c++) {
//                
//                Pixel p = getPixel(c, getNbrRow() - r);
//                cl.setPixel(r, c, p);
//            }
//        }
//
//        matrice = cl.matrice;
//    }
    
    /**
     Rempli l'image avec un pixel
     @param p pixel
     */
//    public void fill(Pixel p) {
//    
//        for (int r = 0; r < getNbrRow(); r++) {
//            for (int c = 0; c < getNbrCol(); c++) {
//                setPixel(r,c, p.clone());
//            }
//        }
//    }
    
    
//    @Override
//    public Image clone() {
//        
//        // Cree une nouvelle image de meme taille
//        Image cl = new Image();
//        cl.resizeMatrice(getNbrRow(), getNbrCol());
//        
//        // Clone les pixels
//        for (int r = 0; r < getNbrRow(); r++) {
//            for (int c = 0; c < getNbrCol(); c++) {
//                cl.setPixel(r,c, getPixel(r,c).clone());
//            }
//        }
//        return cl;
//    }

}
