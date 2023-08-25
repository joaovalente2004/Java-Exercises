import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Arrays;

public class WebServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 8090;
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Listening on port " + portNumber + "...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedOutputStream out = new BufferedOutputStream(clientSocket.getOutputStream());

            String requestLine = in.readLine();
            if (requestLine == null) {
                clientSocket.close();
                continue;
            }

            String[] requestParts = requestLine.split(" ");
            String method = requestParts[0];
            String path = requestParts[1];

            if (method.equals("GET") && path.equals("/logo.png")) {
                File file = new File("logo.png");
                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    byte[] fileData = new byte[(int) file.length()];
                    fis.read(fileData);

                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                    out.write("Content-Type: image/png\r\n".getBytes());
                    out.write(("Content-Length: " + file.length() + "\r\n").getBytes());
                    out.write("\r\n".getBytes());
                    out.write(fileData);
                    out.flush();

                    fis.close();
                } else {
                    String notFoundResponse = "HTTP/1.1 404 Not Found\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n" +
                            "Content-Length: 0\r\n" +
                            "\r\n";
                    out.write(notFoundResponse.getBytes());
                    out.flush();
                }
            } else {
                String htmlResponse = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "\r\n" +
                        "<!DOCTYPE html>\n" +
                        "\n" +
                        "<!DOCTYPE html>\n" +
                        "\n" +
                        "\n" +
                        "<html>\n" +
                        "\n" +
                        "\n" +
                        "<head>\n" +
                        "    <title>WEB SERVER</title>\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "<style>\n" +
                        "    h1 {\n" +
                        "        text-align: center;\n" +
                        "        font-size: 81px;\n" +
                        "        font-family: \"Arial Black\", Gadget, sans-serif;\n" +
                        "        color: #2f23c4;\n" +
                        "        text-shadow: 2px 2px 4px #00ddf8;\n" +
                        "        background-color: #FFFFFF;\n" +
                        "        padding: 8px;\n" +
                        "    }\n" +
                        "</style>\n" +
                        "\n" +
                        "<body>\n" +
                        "\n" +
                        "<img src=\"logo.png\" alt=\"Logo\" style=\"width: 377px;height: 351px;margin-left: 738px;margin-top: 165px;POSITION: absolute;\">\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "<h1>WEB SERVER</h1>\n" +
                        "</body>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "</html>";

                out.write(htmlResponse.getBytes());
                out.flush();
            }

            clientSocket.close();
        }
    }
}
