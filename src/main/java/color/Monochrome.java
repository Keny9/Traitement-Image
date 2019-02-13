package color;

/**
 * Classe qui gere un pixel qui n est pas en couleur
 * @author Karl Boutin, Maxime Lussier et Anthony Cote
 */
public class Monochrome implements Pixel{
    
    int grey;                   //Valeur du pixel
    public static final int NBR_PIGMENTS = 1; // 1 int equivaut a un pixel
    
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
    
    public int getGrey(){return grey;}
    
    public void setGrey(int value){grey = value;}
    
    public void setPigment(int index, int value) throws Exception {
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
    
    /**
     Lance une exception si l'index de pigment est invalide
     @param index the index
     @return toujours vrai tant qu'il n'y a pas d'exception
     @throws ArrayIndexOutOfBoundsException the array index out of bounds exception
     */
    public boolean validatePigmentIndex(int index) throws ArrayIndexOutOfBoundsException{
        if(0 > index || index >= getNbrPigment())
            throw new ArrayIndexOutOfBoundsException("L'index de pigment est invalide");

        return true;
    }
    
     /**
     Lance une exception si la force du pigmet est invalide
     @param tone the tone
     @return toujours vrai tant qu'il n'y a pas d'exception
     @throws InstantiationException the instantiation exception
     */
    public boolean validatePigmentTone(int tone) throws InstantiationException{
        if(0 > tone || 255 <= tone)
            throw new InstantiationException("La valeur de pigment est invalide");

        return true;
    }
     
     /**
     Remet a zero les pigments du pixel
     */
    public void clear() {
        try {

            for (int i = 0; i < getNbrPigment(); i++) {
                setPigment(i, 0);
            }

        }catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
