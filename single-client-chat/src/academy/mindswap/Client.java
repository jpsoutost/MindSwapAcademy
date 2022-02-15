package academy.mindswap;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket clientSocket = new Socket("localhost", 8080);

        BufferedWriter senderWritter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader senderReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader receivingReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (!clientSocket.isClosed()){
            Thread.sleep(1000);

            String message = "";

            while(senderReader.ready()){
                message = senderReader.readLine();
                senderWritter.write(message);
                senderWritter.newLine();
                senderWritter.flush();
            }

            while(receivingReader.ready()) {
                System.out.println("SERVER: " + receivingReader.readLine());
            }

            if (message.equalsIgnoreCase("exit")) {
                System.out.println("SERVER: " + receivingReader.readLine());
                break;
            }
        }

        clientSocket.close();
    }
}
