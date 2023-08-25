import java.io.*;
import java.net.Socket;

public class ClientWorker implements Runnable{

    Socket clientSocket;


    public ClientWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run() {
        //listen to socket.input
        //write to System.out
        //ussing a thread

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {
                String input = in.readLine();
                System.out.println(input);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
