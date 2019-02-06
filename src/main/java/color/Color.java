package color;

/**
 * 
 * @author Karl Boutin, Maxime Lussier et Anthony Côté
 */
public class Color implements Pixel{
    
    /** The R. */
    int R;
    /** The G. */
    int G;
    /** The B. */
    int B;
    
    /**
     Instantiates a new Color.
     @param r the r
     @param g the g
     @param b the b
     */
    public Color(int r, int g, int b) {
        
        R = r;
        G = g;
        B = b;
    }
    
    /**
     Gets r.
     @return the r
     */
    public int getR() {
        
        return R;
    }
    /**
     Gets g.
     @return the g
     */
    public int getG() {
        
        return G;
    }
    /**
     Gets b.
     @return the b
     */
    public int getB() {
        
        return B;
    }
    
    /**
     Sets r.
     @param r the r
     */
    public void setR(int r) {
        
        R = r;
    }
    /**
     Sets g.
     @param g the g
     */
    public void setG(int g) {
        
        G = g;
    }
    /**
     Sets b.
     @param b the b
     */
    public void setB(int b) {
        
        B = b;
    }
    /**
     
     @return
     */
    public Color getColor() {
        
        return null;
    }
    public void setColor(Color color) {
    
    }
    
    @Override
    public String toString() {
        
        return "Color{" + "R=" + R + ", G=" + G + ", B=" + B + '}';
    }

    public Pixel getPixel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPixel(Pixel pixel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
