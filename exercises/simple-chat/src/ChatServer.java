import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public  static void main(String[] args) throws IOException {

        int portNumber = 8090;

        ServerSocket serverSocket = new ServerSocket(portNumber);

        Socket clientSocket = serverSocket.accept();

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {

            System.out.println("Laurinda: " + in.readLine());

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String userInput = stdIn.readLine();

            out.println(userInput);

        }
    }
}
