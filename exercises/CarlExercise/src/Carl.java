import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import  java.net.URL;



public class Carl {

    public static void main(String[] args) throws IOException {



        try {
            URL url = new URL("https://www.google.com");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Código de resposta: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Resposta:");
            System.out.println(response.toString());

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
