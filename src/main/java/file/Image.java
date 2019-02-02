package file;

import java.io.File;
import java.util.Objects;

/**
 The type Image. */
public class Image {
    
    private File file;
    
    /**
     Instantiates a new Image.
     @param file the file
     */
    public Image(File file) {
        
        this.file = file;
    }
    /**
     Gets file.
     @return the file
     */
    public File getFile() {
        
        return file;
    }
    /**
     Sets file.
     @param file the file
     */
    public void setFile(File file) {
        
        this.file = file;
    }
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(file, image.file);
    }
    @Override
    public int hashCode() {
        
        return Objects.hash(file);
    }
    @Override
    public String toString() {
        
        return "Image{" + "file=" + file + '}';
    }
}
