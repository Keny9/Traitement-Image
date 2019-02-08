package color;

/**
 @author Karl Boutin, Maxime Lussier et Anthony Cote */
public class Color implements Pixel {
    
    int[] pigment = { 0, 0, 0 };
    
    // Index de pigment
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;
    
    
    public Color(){
        
        pigment[RED] = 0;
        pigment[GREEN] = 0;
        pigment[BLUE] = 0;
    }
    
    /**
     Instantiates a new Color.
     @param r the r
     @param g the g
     @param b the b
     */
    public Color(int r, int g, int b) throws Exception{
        
        setRed(r);
        setGreen(g);
        setBlue(b);
    }
    
    /**
     Gets r.
     @return the r
     */
    public int getRed() { return pigment[RED]; }
    /**
     Gets g.
     @return the g
     */
    public int getGreen() { return pigment[GREEN]; }
    /**
     Gets b.
     @return the b
     */
    public int getBlue() { return pigment[BLUE]; }
    
    
    /**
     Sets r.
     @param r the r
     */
    public void setRed(int r) throws Exception { setPigment(RED, r); }
    /**
     Sets g.
     @param g the g
     */
    public void setGreen(int g) throws Exception { setPigment(GREEN, g); }
    /**
     Sets b.
     @param b the b
     */
    public void setBlue(int b) throws Exception { setPigment(BLUE, b); }
    /**
     @return
     */
    
    
    @Override
    public String toString() {
        
        return "Color{" + "RED=" + pigment[RED] + ", GREEN=" + pigment[GREEN] + ", BLUE=" + pigment[BLUE] + '}';
    }
    
    public Pixel getPixel() {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void setPixel(Pixel pixel) {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Pixel clone() {
        try {
            return new Color(getRed(), getGreen(), getBlue());
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Color();
    }
    public int getNbrPigment() { return 3; }
    
    public int getPigment(int index) throws ArrayIndexOutOfBoundsException {
        
        validatePigmentIndex(index);
        return pigment[index];
        
    }
    
    
    public void setPigment(int index, int value) throws Exception {
        
        validatePigmentIndex(index);
        validatePigmentTone(value);
        pigment[index] = value;
    }
    
    
    public int getAverage() { return (pigment[RED] + pigment[GREEN] + pigment[BLUE]) / 3; }
    
    
    public boolean equals(Pixel p) {
        
        if (p.getClass() != Color.class) return false;
        
        try {
            return (pigment[RED] == p.getPigment(RED) && pigment[GREEN] == p.getPigment(GREEN) && pigment[BLUE] == p.getPigment(BLUE));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Exception theoriquement impossible car on demande un indice de 0 sur un tableau de 1");
        }
        return false;
    }
    
}
