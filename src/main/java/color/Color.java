package color;

import java.util.Objects;

/**
 The type Color. */
public class Color {
    
    /** The R. */
    Pigmentation R;
    /** The G. */
    Pigmentation G;
    /** The B. */
    Pigmentation B;
    
    /**
     Instantiates a new Color.
     @param r the r
     @param g the g
     @param b the b
     */
    public Color(Pigmentation r, Pigmentation g, Pigmentation b) {
        
        R = r;
        G = g;
        B = b;
    }
    
    /**
     Gets r.
     @return the r
     */
    public Pigmentation getR() {
        
        return R;
    }
    /**
     Gets g.
     @return the g
     */
    public Pigmentation getG() {
        
        return G;
    }
    /**
     Gets b.
     @return the b
     */
    public Pigmentation getB() {
        
        return B;
    }
    
    /**
     Sets r.
     @param r the r
     */
    public void setR(Pigmentation r) {
        
        R = r;
    }
    /**
     Sets g.
     @param g the g
     */
    public void setG(Pigmentation g) {
        
        G = g;
    }
    /**
     Sets b.
     @param b the b
     */
    public void setB(Pigmentation b) {
        
        B = b;
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
