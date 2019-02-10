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
    
    public Monochrome(int grey){
        this.grey = grey;
    }


    @Override
    public Pixel clone() {
        
        try {
            super.clone();
            return new Monochrome(grey);
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new Monochrome();
    }
    
    public int getNbrPigment() { return NBR_PIGMENTS; }
    
    
    public int getPigment(int index) throws ArrayIndexOutOfBoundsException {
        
        //validatePigmentIndex(index);
        
        return grey;
    }
    
    public int getGrey(){        return grey;    }
    
    public void setGrey(int value)  {        grey = value;     }
    
    public void setPigment(int index, int value) throws Exception {
    
        //validatePigmentIndex(index);
        //validatePigmentTone(value);
        
        grey = value;
    }
    
    public int getAverage() {  return grey;    }
    
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
    
    @Override
    public String toString() {
        
        return "Monochrome{" + "grey=" + grey + '}';
    }
}
