package file;

import java.io.File;

/**
 The type Image manipulator. */
public class ImageManipulator {
    
    private Image img;
    
    /**
     The entry point of application.
     @param args the input arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hi");
    }
    
    /**
     Gets img.
     @return the img
     */
    public Image getImg() {
        
        return img;
    }
    /**
     Sets img.
     @param img the img
     */
    public void setImg(Image img) {
        
        this.img = img;
    }
    
    
    /**
     Lire.
     @param i the
     @param f the f
     */
    public void lire(Image i, File f) {
    
    }
    /**
     Ecrire.
     @param f the f
     @param i the
     */
    public void ecrire(File f, Image i) {
    
    }
    /**
     Copier.
     @param i1 the 1
     @param i2 the 2
     */
    public void copier(Image i1, Image i2) {
    
    }
    /**
     Couleur preponderante.
     @param i the
     */
    public void couleur_preponderante(Image i) {
    
    }
    /**
     Eclaircir noircir.
     @param i the
     @param v the v
     */
    public void eclaircir_noircir(Image i, int v) {
    
    }
    /**
     Extraire.
     @param i  the
     @param p1 the p 1
     @param c1 the c 1
     @param p2 the p 2
     @param c2 the c 2
     */
    public void extraire(Image i, int p1, int c1, int p2, int c2) {
    
    }
    /**
     Reduire.
     @param i the
     */
    public void reduire(Image i) {
    
    }
    /**
     Sont identique.
     @param i1 the 1
     @param i2 the 2
     */
    public void sont_identique(Image i1, Image i2) {
    
    }
    /**
     Pivoter 90.
     @param i the
     */
    public void pivoter90(Image i) {
    
    }
    @Override
    public String toString() {
        
        return "ImageManipulator{" + "img=" + img + '}';
    }
}
