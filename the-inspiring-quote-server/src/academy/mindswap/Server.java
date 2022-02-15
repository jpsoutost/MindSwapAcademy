package academy.mindswap;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

    public static void main(String[] args) throws IOException {
	// write your code here
        // OPEN AN UDP SOCKET
        int portNumber = 8080;
        DatagramSocket socket = new DatagramSocket(portNumber);


        byte[] recvBuffer = new byte[1024];

        while (socket.isBound()) {

            //RECEIVE DATA FROM CLIENT
            DatagramPacket receivedPacket = new DatagramPacket(recvBuffer, recvBuffer.length);

            System.out.println("Waiting for packet...");
            socket.receive(receivedPacket); // blocking method!

            String receivedString = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            System.out.println("Received: " + receivedString);

            //SEND DATA TO CLIENT
            String stringToSend = "";
            if(receivedString.equals("hit me")){
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader("./resources/inspirationalQuotes.txt"));
                    for (int i = 0; i < Math.random() * 50; i++) {
                        stringToSend = reader.readLine();
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                stringToSend = "unsupported operation";
            }


            InetAddress address = receivedPacket.getAddress();
            int port = receivedPacket.getPort();
            String response = stringToSend;
            byte[] responseBytes = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, address, port);
            socket.send(responsePacket);

        }

        socket.close();

    }
}
