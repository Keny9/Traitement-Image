package other;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Helper {
    
    /** Ecrit dans le fichier
     @param content contenu a mettre dans le fichier
     @param outputFile nom du fichier a ecrire a l'interieur
     */
    public static void writeToFile(String content, String outputFile) {
        try {
            PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
            writer.println(content);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
