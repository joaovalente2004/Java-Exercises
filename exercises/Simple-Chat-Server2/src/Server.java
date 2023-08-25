import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static List<ServerHelper> serverHelpers = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        int portNumber = 8090;

        ServerSocket serverSocket = new ServerSocket(portNumber);

        ExecutorService cachedPool = Executors.newCachedThreadPool();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSocket.setKeepAlive(true);

            ServerHelper serverHelper = new ServerHelper(clientSocket);

            serverHelpers.add(serverHelper);

            cachedPool.submit(serverHelper);
        }
    }

    static class ServerHelper implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;

        public ServerHelper(Socket clientSocket) throws IOException {
            this.clientSocket = clientSocket;
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String receivedMessage;
                while ((receivedMessage = in.readLine()) != null) {
                    System.out.println("Received: " + receivedMessage);
                    sendMessageToAllClients(receivedMessage);
                }

                in.close();
                out.close();
                clientSocket.close();

                serverHelpers.remove(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendMessageToAllClients(String message) {
            for (ServerHelper serverHelper : serverHelpers) {
                if (serverHelper != this)
                    serverHelper.sendMessage(message);

            }
        }

        private void sendMessage(String message) {
            out.println(message);
        }
    }
}
