import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String hostName = "localhost";
        int portNumber = 8090;

        //client sends message to server in lowercase and server sends it back in uppercase

        byte[] sendBuffer = new byte[1024];

        DatagramSocket socket = new DatagramSocket();

        while (true) {

            InetAddress address = InetAddress.getByName(hostName);


            System.out.println("Send message to server: ");
            String message = scanner.nextLine();

            sendBuffer = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, portNumber);

            socket.send(sendPacket);

            byte[] recvBuffer = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);

            socket.receive(receivePacket);

            System.out.println("Received packet from " + receivePacket.getAddress().getHostName());
            System.out.println(new String(receivePacket.getData()));

            socket.close();


        }
    }
}
