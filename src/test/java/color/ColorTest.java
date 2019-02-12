package color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    
    Color c;
    
    @BeforeEach
    void setUp() {
        c = new Color(10,20,30);
    }
    @AfterEach
    void tearDown() {
    
    }
    
    
    @Test
    void toString_test() {
        
        String expected = "Color{red=10, green=20, blue=30}";
        assertEquals(expected, c.toString());
    }
    @Test
    void clone_test() {
        fail();
    }
    @Test
    void getAverage() throws Exception{
        
        assertEquals(20, c.getAverage(), "Average");
    }
    @Test
    void equals() throws Exception {
        
        assertEquals(10 , c.getRed(), "Red");
        assertEquals(20 , c.getGreen(), "Green");
        assertEquals(30 , c.getBlue(), "Blue");
    }
}