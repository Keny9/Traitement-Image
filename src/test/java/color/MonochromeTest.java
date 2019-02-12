package color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonochromeTest {
    
    private Monochrome m;
    
    @BeforeEach
    void setUp() {
        m = new Monochrome(128);
    }
    @AfterEach
    void tearDown() {
    
    }
    
    
    @Test
    void clone_test() {
        fail();
    }
    @Test
    void getAverage() {
        assertEquals(128 , m.getAverage());
    }
    @Test
    void equals()throws Exception {
        
        assertEquals(128 , m.getGrey());
    }
    @Test
    void toString_test() {
        String expected = "Monochrome{grey=128}";
        assertEquals(expected, m.toString());
    }
}