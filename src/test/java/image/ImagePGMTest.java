package image;

import color.Monochrome;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ImagePGMTest {
    
    @BeforeEach
    void setUp() {
    
    }
    @AfterEach
    void tearDown() {
    
    }
    @Test
    void createPixel() { assertSame(ImagePGM.createPixel().getClass(), Monochrome.class); }
    
    @Test
    void lire() {
        File     f = new File("square.pgm");
        assertTrue(f.exists());
        
        String expected =
                "P2" + "\r\n" +
                "3 3" + "\r\n" +
                "1" + "\r\n" +
                "0 1 0" + "\r\n" +
                "0 1 1" + "\r\n" +
                "0 1 0" + "\r\n" ;
        
        ImagePGM i;
        try {
            i = new ImagePGM("square.pgm");
            i.lire(f);

            assertEquals(expected, i.toStringFile(), "lire");
        }catch (Exception e) {fail();}
    }
    
    @Test
    void getTypeString() { assertSame("P2", ImagePGM.getTypeString()); }
}