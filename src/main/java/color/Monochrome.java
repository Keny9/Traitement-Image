package color;

/**
 * 
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 */
public class Monochrome implements Pixel{
    
    int grey;
    public static final int NBR_PIGMENTS = 1;
    
    /** Instantiates a new Monochrome. */
    public Monochrome() {
    
    }
    
    public Monochrome(int grey) throws InstantiationException{
        validatePigmentTone(grey);
        this.grey = grey;
    }


    @Override
    public Pixel clone() {
        
        try {
            super.clone();
            return new Monochrome(grey);
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new Monochrome();
    }
    
    public int getNbrPigment() { return NBR_PIGMENTS; }
    
    
    public int getPigment(int index) throws ArrayIndexOutOfBoundsException {
        
        validatePigmentIndex(index);
        
        return grey;
    }
    
    
    
    
    public void setPigment(int index, int value) throws Exception {
    
        validatePigmentIndex(index);
        validatePigmentTone(value);
        
        grey = value;
    }
    
    public int getAverage() {
        
        return grey;
    }
    
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
