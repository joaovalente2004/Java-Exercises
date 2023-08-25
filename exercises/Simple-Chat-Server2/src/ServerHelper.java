import java.io.*;
import java.net.Socket;

public class ServerHelper implements Runnable{


    Socket clientSocket;

    public ServerHelper(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }

    @Override
    public void run() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            while (true) {
                String input = in.readLine();
                System.out.println(input);
                out.write("OLA");
                out.newLine();
                out.flush();


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
