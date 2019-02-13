package color;

/**
 * Classe qui gere un pixel de couleur
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
    public Color(int r, int g, int b) {
        
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
    public void setRed(int r)   { pigment[RED]= r; }
    /**
     Sets g.
     @param g the g
     */
    public void setGreen(int g)   { pigment[GREEN]= g; }
    /**
     Sets b.
     @param b the b
     */
    public void setBlue(int b)   { pigment[BLUE]= b; }

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
    
    @Override
    public String toString() {
        
        return "Color{" + "red=" + pigment[RED] + ", green=" + pigment[GREEN] + ", blue=" + pigment[BLUE] + '}';
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
        
        //validatePigmentIndex(index);
        return pigment[index];
        
    }
    
    
    public void setPigment(int index, int value) throws Exception {
        pigment[index] = value;
    }
    
    
    public int getAverage() { return (pigment[RED] + pigment[GREEN] + pigment[BLUE]) / 3; }
    
    
    public boolean equals(Pixel p) {
        
        if (p.getClass() != Color.class) return false;
        
        try {
    
            for (int i = 0; i < getNbrPigment(); i++) {
                if (pigment[i] != p.getPigment(i))
                    return false;
            }
            
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.err.println("Exception theoriquement impossible car on demande un indice de 0 sur un tableau de 1");
        }
        return false;
    }

    
}
