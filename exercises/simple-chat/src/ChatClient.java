import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public  static void main(String[] args) throws IOException {

        String hostName = "localhost";
        int portNumber = 6969;

        Socket clientSocket = new Socket(hostName, portNumber);


        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String userInput = stdIn.readLine();

            out.println(userInput);

            System.out.println("Joao: " + in.readLine());



        }

    }
}
