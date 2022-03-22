package academy.mindswap;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    ServerSocket serverSocket;
    ExecutorService service;


    public Server() throws IOException {
        this.serverSocket = new ServerSocket(8080);
        this.service = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        while (true) {
            ClientHandler ch = new ClientHandler(serverSocket.accept());
            service.submit(ch);
        }
    }


    private class ClientHandler implements Runnable{

        Socket socket;
        BufferedReader in;
        DataOutputStream out;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String line = null;

                    line = in.readLine();

                    System.out.println(line);
                    String[] parts = line.split(" ");
                    String method = parts[0];
                    String path = parts[1];
                    String header;


          /*  File file = new File("www" + path);

            if (!file.isFile()){
                String response = """
                        <!DOCTYPE html>
                        <body>
                        <h1>Not Found</h1>
                        </body>
                        """;
                header = "HTTP/1.1 23423434 Stupid call\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: " + response.length()+ "\r\n" +
                        "Connection: close\r\n" +
                        "\r\n";


                out.writeBytes(header);
                out.write(response.getBytes());
                socket.close();
                continue;
            }*/
                    if (path.equals("/")) {
                        String response = """
                                <!DOCTYPE html>
                                <body>
                                <h1 style="color:DodgerBlue; background-color:Yellow;">Welcome to our repository.</#3333cc></h1>
                                <img src="/zoo.png" alt="png">
                                </body>
                                """;

                        byte[] responseBytes = response.getBytes();

                        header = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: text/html\r\n" +
                                "Content-Length: " + responseBytes.length + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n";

                        out.writeBytes(header);
                        out.write(responseBytes);

                    }

                    if (path.equals("/ASimplePDF.pdf")) {
                        File image = new File("www/ASimplePDF.pdf");
                        byte[] imageData = Files.readAllBytes(Path.of(image.getPath()));

                        header = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: application/pdf\r\n" +
                                "Content-Length: " + imageData.length + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n";
                        out.writeBytes(header);
                        out.write(imageData);
                        socket.close();
                        continue;

                    }

                    if (path.equals("/animals")) {
                        String response = """
                                <!DOCTYPE html>
                                <body style="background-color: black;">
                                <h1  style="text-align:center; font-size:1000%; color:red;"><b>These are our animals:</b></h1>
                                <p style="color:red; font-size:300%;">This is just something I wrote to make a paragraph. This is just something I wrote to make a paragraph. \n
                                This is just something I wrote to make a paragraph.This is just something I wrote to make a paragraph.\n
                                This is just something I wrote to make a paragraph.This is just something I wrote to make a paragraph.</p>
                                <h1 style="color:DodgerBlue; text-align:center; background-color:Yellow;">orangotango</h1>
                                <img src="/orangotango.jpeg" alt="orangotango">
                                <h1 style="color:DodgerBlue; text-align:center; background-color:Yellow;">tigre</h1>
                                <img src="/tiger.jpg" alt="tiger">
                                <h1 style="color:DodgerBlue; text-align:center; background-color:Yellow;">elefante</h1>
                                <img src="/elephant.jpeg" alt="elephant">
                                </body>
                                """;
                        byte[] responseBytes = response.getBytes();
                        header = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: text/html\r\n" +
                                "Content-Length: " + responseBytes.length + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n";
                        out.writeBytes(header);
                        out.write(responseBytes);
                        socket.close();
                        continue;

                    }
                    if (path.equals("/orangotango.jpeg")) {
                        File image = new File("www/orangotango.jpeg");
                        byte[] imageData = Files.readAllBytes(Path.of(image.getPath()));

                        header = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: image/jpeg\r\n" +
                                "Content-Length: " + imageData.length + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n";
                        out.writeBytes(header);
                        out.write(imageData);
                        socket.close();
                        continue;
                    }
                    if (path.equals("/favicon.ico")) {
                        File image = new File("www/favicon.ico");
                        byte[] imageData = Files.readAllBytes(Path.of(image.getPath()));

                        header = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: image/jpeg\r\n" +
                                "Content-Length: " + imageData.length + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n";
                        out.writeBytes(header);
                        out.write(imageData);
                        socket.close();
                        continue;
                    }

                    if (path.equals("/elephant.jpeg")) {
                        File image = new File("www/elephant.jpeg");
                        byte[] imageData = Files.readAllBytes(Path.of(image.getPath()));

                        header = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: image/jpeg\r\n" +
                                "Content-Length: " + imageData.length + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n";
                        out.writeBytes(header);
                        out.write(imageData);
                        socket.close();
                        continue;
                    }

                    if (path.equals("/tiger.jpg")) {
                        File image = new File("www/tiger.jpg");
                        byte[] imageData = Files.readAllBytes(Path.of(image.getPath()));

                        header = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: image/jpeg\r\n" +
                                "Content-Length: " + imageData.length + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n";
                        out.writeBytes(header);
                        out.write(imageData);
                        socket.close();
                        continue;
                    }
                    if (path.equals("/zoo.png")) {
                        File image = new File("www/zoo.png");
                        byte[] imageData = Files.readAllBytes(Path.of(image.getPath()));

                        String header2 = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: image/jpeg\r\n" +
                                "Content-Length: " + imageData.length + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n";
                        out.writeBytes(header2);
                        out.write(imageData);
                        socket.close();
                        continue;
                    }

           /* String response = """
                        <!DOCTYPE html>
                        <body>
                        <h1>Not Found</h1>
                        </body>
                        """;
            header = "HTTP/1.1 23423434 Stupid call\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + response.length()+ "\r\n" +
                    "Connection: close\r\n" +
                    "\r\n";


            out.writeBytes(header);
            out.write(response.getBytes());
            socket.close();*/
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
