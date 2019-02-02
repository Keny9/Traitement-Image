package file;

import java.io.File;
import java.net.URI;

/**
 The type Ppm file. */
public class PPMFile extends File {
    
    /**
     Instantiates a new Ppm file.
     @param pathname the pathname
     */
    public PPMFile(String pathname) {
        
        super(pathname);
    }
    /**
     Instantiates a new Ppm file.
     @param parent the parent
     @param child  the child
     */
    public PPMFile(String parent, String child) {
        
        super(parent, child);
    }
    /**
     Instantiates a new Ppm file.
     @param parent the parent
     @param child  the child
     */
    public PPMFile(File parent, String child) {
        
        super(parent, child);
    }
    /**
     Instantiates a new Ppm file.
     @param uri the uri
     */
    public PPMFile(URI uri) {
        
        super(uri);
    }
}
