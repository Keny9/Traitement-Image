package color;

import java.util.Objects;

/**
 The type Color. */
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
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(R, color.R) && Objects.equals(G, color.G) && Objects.equals(B, color.B);
    }
    @Override
    public int hashCode() {
        
        return Objects.hash(R, G, B);
    }
    
    @Override
    public String toString() {
        
        return "Color{" + "R=" + R + ", G=" + G + ", B=" + B + '}';
    }
}
