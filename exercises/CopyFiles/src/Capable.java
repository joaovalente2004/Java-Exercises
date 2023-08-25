import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Capable {

    public void copyImage() throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        String sourcePath = "resources/11729.jpeg";

        String destinationPath = "resources/Background8K.jpeg";

        try {
            fileInputStream = new FileInputStream(sourcePath);
            fileOutputStream = new FileOutputStream(destinationPath);

            byte[] buffer = new byte[1024];
            int bytesRead;

            System.out.println("Copying image...");

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                System.out.println(bytesRead);
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Image copied successfully.");
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
                System.out.println("FileInputStream closed successfully.");
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
                System.out.println("FileOutputStream closed successfully.");
            }
        }
    }


}
