package file;

import java.io.File;
import java.net.URI;

/**
 The type Pgm file. */
public class PGMFile extends File {
    
    /**
     Instantiates a new Pgm file.
     @param pathname the pathname
     */
    public PGMFile(String pathname) {
        
        super(pathname);
    }
    /**
     Instantiates a new Pgm file.
     @param parent the parent
     @param child  the child
     */
    public PGMFile(String parent, String child) {
        
        super(parent, child);
    }
    /**
     Instantiates a new Pgm file.
     @param parent the parent
     @param child  the child
     */
    public PGMFile(File parent, String child) {
        
        super(parent, child);
    }
    /**
     Instantiates a new Pgm file.
     @param uri the uri
     */
    public PGMFile(URI uri) {
        
        super(uri);
    }
}
