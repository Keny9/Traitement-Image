/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

import color.Monochrome;
import color.Pixel;

import java.io.File;

/**
 *
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 * Classe qui nous permet de manipuler une image poour la modifier
 * Telle que changer la luminosite de l'image, copier le contenu d'une image
 * dans une autre image ou meme changer la rotation de l'image.
 */
public class Traitement {
    
    /**
     Ouvre en lecture le fichier en format PGM ou PPM specifie et charge les donnees dans l image
     @param i l'image
     @param f le fichier dans lequel on lit les donnees
     */
    public static void  lire(Image i, File f) {
        i.lire(f);
    }
    
    /**
     Ouvre le fichier specifiee et y sauvegarde en format PGM ou PPM l image
     @param f le fichier dans lequel on veut ecrire les donnees
     @param i l'image qui va nous permettre d'ecrire dans le fichier
     */
    public static void ecrire(File f, Image i) {
        i.ecrire(f.getPath());
    }
    
    /**
     Prend l objet i1 et fait une copie dans l objet i2
     @param i1 the 1 L'image qu'on copie
     @param i2 the 2 L'image dans lequel on colle les donnees
     */
    public static void copier(Image i1, Image i2) {
       
    }
    /**
     Retournera la couleur preponderante de l image i
     @param i L'image dans laquelle on veut recuperer la couleur dominante de l'image
     */
    public static Pixel couleur_preponderante(Image i) {
       // i.couleur_preponderante();
        return new Monochrome(); // TODO : retourner la vrai valeur
    }
    /**
     Modifie la valeur de chaque pixel de l�image d�une valeur specifiee, 
     * si v est positif, l image devient plus noire, si v est negatif, l image devient plus claire
     @param i L'image dans laquelle on veut changer la luminosite
     @param v the v L'intensite qu'on veut appliquer a l'image
     */
    public static void eclaircir_noircir(Image i, int v) {
        i.eclaircir_noircir(v);
    }
    
    /**
     Extraire un sous ensemble de l image partir de du point p1,c1 jusqu'a p2,c2
     @param i  L'image dans laquelle on veut extraire les donnees
     @param x1  Position x debut dans fichier
     @param y1  Position y debut dans fichier
     @param x2  Position x fin dans fichier 
     @param y2  Position y fin dans fichier
     * Ce qui nous donnera une zone dans laquelle on veut recuperer les donnees
     */
    public static void extraire(Image i, int x1, int y1, int x2, int y2) {
       // i.extraire( x1, y1,x2, y2);
    }
    
    /**
     Reduire une image i1 a une image i2
     * Reduit la taille de l'image
     @param i L'image qu'on veut reduire
     */
    public static void reduire(Image i) {
        //i.reduire();
    }
    
    /**
     Verfifie si 2 images sont identiques
     @param i1 1 image qu'on veut comparer
     @param i2 la deuxieme image qu'on veut comparer
     */
    public static boolean sont_identique(Image i1, Image i2) {
        return Image.sont_identique(i1, i2);
    }
    
    /**
     Pivoter l'image d'une rotation de 90 
     @param i L'image dans laquelle on fait une rotation
     */
    public static void pivoter90(Image i) {
        //i.pivoter90();
    }
}
