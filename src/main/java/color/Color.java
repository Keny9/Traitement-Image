package color;

/**
 * Classe qui gere un pixel de couleur
 @author Karl Boutin, Maxime Lussier et Anthony Cote */
public class Color implements Pixel {
    
    int[] pigment = { 0, 0, 0 }; //Tableau de couleur
    
    // Index de pigment
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;
    
    
    public Color(){
        
        pigment[RED] = 0;
        pigment[GREEN] = 0;
        pigment[BLUE] = 0;
    }
    
    /**
     Instantiates a new Color.
     @param r the r
     @param g the g
     @param b the b
     */
    public Color(int r, int g, int b) {
        
        setRed(r);
        setGreen(g);
        setBlue(b);
    }
    
    /**
     Gets r.
     @return the r
     */
    public int getRed() { return pigment[RED]; }
    /**
     Gets g.
     @return the g
     */
    public int getGreen() { return pigment[GREEN]; }
    /**
     Gets b.
     @return the b
     */
    public int getBlue() { return pigment[BLUE]; }
    
    /**
     Sets r.
     @param r the r
     */
    public void setRed(int r)   { pigment[RED]= r; }
    /**
     Sets g.
     @param g the g
     */
    public void setGreen(int g)   { pigment[GREEN]= g; }
    /**
     Sets b.
     @param b the b
     */
    public void setBlue(int b)   { pigment[BLUE]= b; }
    
    public int getNbrPigment() { return 3; }
    
    public int getPigment(int index) throws ArrayIndexOutOfBoundsException {
        return pigment[index];
        
    }
    
    public void setPigment(int index, int value) throws Exception {
        pigment[index] = value;
    }
    
    public int getAverage() { return (pigment[RED] + pigment[GREEN] + pigment[BLUE]) / 3; }

}
