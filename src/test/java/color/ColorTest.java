package color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    
    @BeforeEach
    void setUp() {
    
    }
    @AfterEach
    void tearDown() {
    
    }
    
    
    @Test
    void toString_test() {
        Color c = new Color(1,2,3);
        String expected = "Color{red=1, green=2, blue=3}";
        Assertions.assertEquals(expected, c.toString());
    }
    @Test
    void clone_test() {

    }
    @Test
    void getAverage() throws Exception{
        Color c = new Color(30,20,10);
        Assertions.assertEquals(20, c.getAverage(), "Average");
    }
    @Test
    void equals() throws Exception {
        Color c = new Color(255,128,0);
    
        Assertions.assertEquals(255 , c.getRed(), "Red");
        Assertions.assertEquals(128 , c.getGreen(), "Green");
        Assertions.assertEquals(0 , c.getBlue(), "Blue");
    }
}