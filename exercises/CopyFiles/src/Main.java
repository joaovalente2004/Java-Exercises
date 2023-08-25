import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void  main(String[] args) throws Exception {


        /*

        Capable capable = new Capable();
        try {
            capable.copyImage();
        } catch (IOException e) {
            System.out.println("Ja copiou pahhhhh: " + e.getMessage());
        }


         */


        WordReader wordReader = new WordReader();

        try {
            wordReader.copyText();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ja copiou pahhhhh: " + e.getMessage());
        }




    }
}
