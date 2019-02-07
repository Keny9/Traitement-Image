package color;

/**
 * 
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 */
public class Monochrome implements Pixel{
    
    int grey;
    
    /** Instantiates a new Monochrome. */
    public Monochrome() {
    
    }
    
    public Monochrome(int grey) throws InstantiationException{
        validatePigmentTone(grey);
        this.grey = grey;
    }


    public Pixel getPixel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPixel(Pixel pixel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Pixel clone() {
        try {
            return new Monochrome(grey);
        }catch (InstantiationException e){
            e.printStackTrace();
        }
        return new Monochrome();
    }
    
    public int getNbrPigment() {              return 1;    }
    
    
    public int getPigment(int index) throws ArrayIndexOutOfBoundsException {
        
        validatePigmentIndex(index);
        
        return grey;
    }
    
    
    
    @Override
    public void setPigment(int index, int value) throws Exception {
    
        validatePigmentIndex(index);
        validatePigmentTone(value);
        
        grey = value;
    }
    @Override
    public int getAverage() {
        
        return grey;
    }
    @Override
    public boolean equals(Pixel p) {
        
        if (p.getClass() != Monochrome.class)
            return false;
        
        try {
            return grey == p.getPigment(0);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return false;
    }
    
    
}
