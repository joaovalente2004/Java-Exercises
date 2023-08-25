import java.io.*;
import java.util.Iterator;


public class WordReader {



    public void copyText() throws FileNotFoundException, IOException{

        FileReader fileReader = null;
        BufferedReader bReader = null;

        try {
            fileReader = new FileReader("resources/book.txt");
            bReader = new BufferedReader(fileReader);

            String line;

            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }


        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                    System.out.println("FileReader closed successfully.");
                }
                catch (IOException e) {
                    System.out.println("Error closing FileReader: " + e.getMessage());
                }
            }
            if (bReader != null) {
                try {
                    bReader.close();
                    System.out.println("BufferedReader closed successfully.");
                }
                catch (IOException e) {
                    System.out.println("Error closing BufferedReader: " + e.getMessage());
                }
            }
        }

        private Iterator<Integer> iterator() implements Iterable<String>{

            return new Iterator<Integer>() {




                @Override
                public boolean hasNext() {
                    if (this.next() != null) {
                        return true;
                    }
                    return false;


                }

                @Override
                public String next() {
                    //use next() to get the next element

                    if (this.hasNext()) {
                        return this.next();
                    }
                    return null;

                }



            };
        };








    }


    @Override
    public Iterator<String> iterator() {
        return null;
    }





}
