import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.out;

public class Client {

    public static void main(String[] args) throws IOException {



        String hostName = "localhost";
        int portNumber = 6969;

        Socket clientSocket = new Socket(hostName, portNumber);


        ClientWorker clientWorker = new                                                                                                                                                                                                                                                                                                                           ClientWorker(clientSocket);

        Thread thread = new Thread(clientWorker);

        thread.start();


        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;

        while ((userInput = stdIn.readLine()) != null) {

            out.println(userInput);

        }

        out.close();

        stdIn.close();

        clientSocket.close();











    }



}