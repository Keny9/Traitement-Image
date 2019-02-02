package color;

import java.util.Objects;

/**
 The type Pixel. */
public class Pixel {
    
    private Color color;
    
    /**
     Instantiates a new Pixel.
     @param color the color
     */
    public Pixel(Color color) {
        
        this.color = color;
    }
    
    /**
     Gets color.
     @return the color
     */
    public Color getColor() {
        
        return color;
    }
    /**
     Sets color.
     @param color the color
     */
    public void setColor(Color color) {
        
        this.color = color;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pixel pixel = (Pixel) o;
        return Objects.equals(color, pixel.color);
    }
    @Override
    public int hashCode() {
        
        return Objects.hash(color);
    }
    
    @Override
    public String toString() {
        
        return "Pixel{" + "color=" + color + '}';
    }
}
