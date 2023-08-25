import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPServer {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);


        int portNumber = 8090;

        //server receives message from client in lowercase and sends it back in uppercase

        while (true) {


            byte[] recvBuffer = new byte[1024];

            DatagramSocket socket = new DatagramSocket(portNumber);

            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);

            socket.receive(receivePacket);

            System.out.println("Received packet from " + receivePacket.getAddress().getHostName());
            System.out.println(new String(receivePacket.getData()));

            //after receiving the message, the server sends it back to the client in uppercase

            byte[] sendBuffer = new byte[1024];

            String message = new String(receivePacket.getData()).toUpperCase();

            sendBuffer = message.getBytes();

            InetAddress address = receivePacket.getAddress();

            int port = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, port);

            socket.send(sendPacket);

            socket.close();


        }
    }

}
