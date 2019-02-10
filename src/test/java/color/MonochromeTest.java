package color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonochromeTest {
    
    @BeforeEach
    void setUp() {
    
    }
    @AfterEach
    void tearDown() {
    
    }
    @Test
    void clone_test() {

    }
    @Test
    void getAverage() {
        Monochrome m = new Monochrome(128);
        
        Assertions.assertEquals(128 , m.getAverage());
    }
    @Test
    void equals()throws Exception {
        Monochrome m = new Monochrome(128);
        
        Assertions.assertEquals(128 , m.getGrey());
    }
    @Test
    void toString_test() {
        Monochrome m = new Monochrome(1);
        String expected = "Monochrome{grey=1}";
        Assertions.assertEquals(expected, m.toString());
    }
}