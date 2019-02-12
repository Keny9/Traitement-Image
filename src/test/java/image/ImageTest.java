package image;

import color.Monochrome;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {
    
    ImagePGM i;
    
    @BeforeEach
    void setUp() {
        i = new ImagePGM();
    }
    @AfterEach
    void tearDown() {
    
    }
    
    
    @Test
    void lire() {
        fail();
    }
    @Test
    void createPixel() {
        fail();
    }
    @Test
    void ecrire() {
        fail();
    }
    @Test
    void getPixel() {
        
        
        fail();
    }
    @Test
    void setPixel() {
        fail();
    }
    @Test
    void getNbrRow() {
        
        assertEquals(1, i.getNbrRow());
        fail();
    }
    @Test
    void getNbrCol() {
        
        assertEquals(1, i.getNbrCol());
        fail();
    }
    @Test
    void setNbrRow() {
        
        i.setNbrRow(3);
        assertEquals(3, i.getNbrRow());
    }
    @Test
    void setNbrCol() {
        
        i.setNbrCol(3);
        assertEquals(3, i.getNbrCol());
    }
    @Test
    void resizeMatrice() {
        i.resizeMatrice(3,4);
        
        assertEquals(3, i.getNbrRow());
        assertEquals(4, i.getNbrCol());
    }
    @Test
    void getNbrPigment() {
        
        assertEquals(1,  ImagePGM.getNbrPigment());
        assertEquals(3,  ImagePPM.getNbrPigment());
        
    }
    @Test
    void copier() {
        fail();
    }
    @Test
    void couleur_preponderante() {
        fail();
    }
    @Test
    void getNbrPixel() {
        
        i.resizeMatrice(3,7);
        assertEquals(21, i.getNbrPixel());
    }
    @Test
    void eclaircir_noircir() {
        fail();
    }
    @Test
    void extraire() {
        fail();
    }
    @Test
    void reduire() {
        
        i.resizeMatrice( 4,8);
        i.reduire();
        
        assertEquals(2, i.getNbrRow());
        assertEquals(4, i.getNbrCol());
    }
    @Test
    void sont_identique() {
        
        ImagePGM i2 = new ImagePGM();
        
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 5; c++) {
                assertSame (i2.getPixel(r,c), i.getPixel(r,c));
            }
        }
    }
    @Test
    void pivoter90() {
        fail();
    }
    @Test
    void fill() {
        i.resizeMatrice( 4,5);
        Monochrome p = new Monochrome(128);
        i.fill(p);
    
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 5; c++) {
                assertSame (p, i.getPixel(r,c));
            }
        }
    }
    @Test
    void clone_test() {
        fail();
    }
    @Test
    void toString_test() {
        fail();
    }
}