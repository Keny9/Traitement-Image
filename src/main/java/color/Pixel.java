package color;

import java.util.Objects;

/**
 The type Pixel. */
public interface Pixel {
    

    

    /**
     Gets color.
     @return the color
     */
    public Color getColor();
    /**
     Sets color.
     @param color the color
     */
    public void setColor(Color color) ;
    
    @Override
    public boolean equals(Object o);
    @Override
    public int hashCode() ;
    
    @Override
    public String toString();
}
