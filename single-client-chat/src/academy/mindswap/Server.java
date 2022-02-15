package academy.mindswap;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Collectors;

public class Server {


    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept(); // blocking method!
        BufferedReader receivingReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter senderWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader senderReader = new BufferedReader(new InputStreamReader(System.in));

        while(!clientSocket.isClosed()){

            Thread.sleep(1000);

            String message="";
            while (receivingReader.ready()) {
                message = receivingReader.readLine();
                System.out.println("CLIENT: " + message);
            }


            if (message.equalsIgnoreCase("Exit")) {
                senderWriter.write("Bye Bye!");
                senderWriter.flush();
                clientSocket.close();
                break;
            }

            while(senderReader.ready()) {
                senderWriter.write(senderReader.readLine());
                senderWriter.newLine();
                senderWriter.flush();
            }
        }


    }
}
