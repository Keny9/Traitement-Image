package image;

import color.Color;
import color.Monochrome;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImagePPMTest {
    
    @BeforeEach
    void setUp() {
    
    }
    @AfterEach
    void tearDown() {
    
    }
    @Test
    void createPixel() { assertSame(ImagePGM.createPixel().getClass(), Color.class); }
    
    @Test
    void lire() {
        fail();
    }
    
    @Test
    void getTypeString() {        assertSame("P3", ImagePGM.getTypeString());    }
}