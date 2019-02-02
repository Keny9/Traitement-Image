package color;

import java.util.Objects;

/**
 The type Pigmentation. */
public class Pigmentation {
    
    private int pigment;
    
    /**
     Instantiates a new Pigmentation.
     @param pigment the pigment
     */
    public Pigmentation(int pigment) {
        
        this.pigment = pigment;
    }
    
    /**
     Gets pigment.
     @return the pigment
     */
    public int getPigment() {
        
        return pigment;
    }
    /**
     Sets pigment.
     @param pigment the pigment
     */
    public void setPigment(int pigment) {
        
        this.pigment = pigment;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pigmentation that = (Pigmentation) o;
        return pigment == that.pigment;
    }
    @Override
    public int hashCode() {
        
        return Objects.hash(pigment);
    }
    @Override
    public String toString() {
        
        return "Pigmentation{" + "pigment=" + pigment + '}';
    }
}
