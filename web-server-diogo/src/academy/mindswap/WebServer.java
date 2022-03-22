package academy.mindswap;

import academy.mindswap.util.HttpHeaderBuilder;
import academy.mindswap.util.Messages;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {

    public static void main(String[] args) {
        try {
            new WebServer().start(8080);
        } catch (IOException e) {
            System.err.println(Messages.SERVER_ERROR);
        }
    }

    private void start(int port) throws IOException {
        ServerSocket socket = new ServerSocket(port);
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.printf(Messages.SERVER_CONNECTED, socket.getInetAddress().getHostAddress(), port);
        serveRequests(socket, service);
    }

    private void serveRequests(ServerSocket socket, ExecutorService service) {

        while (true) {
            try {
                Socket clientSocket = socket.accept();
                service.submit(new RequestHandler(clientSocket));
            } catch (IOException e) {
                System.err.println(Messages.CLIENT_CONNECTION_ERROR);
            }
        }
    }

    private static class RequestHandler implements Runnable {

        private Socket clientSocket;

        public RequestHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            dealWithRequest(clientSocket);
        }

        private void dealWithRequest(Socket clientSocket) {

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String[] headerParts = splitHeader(in);
                System.out.printf(Messages.REQUEST, headerParts[0]);

                reply(out, headerParts[1], headerParts[2]);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        private String[] splitHeader(BufferedReader in) throws IOException {
            String header = in.readLine();
            String[] splitHeader = header.split(" ");
            String[] headerParts = new String[3];
            headerParts[0] = header;
            headerParts[1] = splitHeader[0];
            headerParts[2] = splitHeader[1];
            return headerParts;
        }

        private void reply(DataOutputStream out, String httpVerb, String resource) throws IOException {

            if (!httpVerb.equals("GET")) {
                replyWithHeader(out, HttpHeaderBuilder.notAllowed(), Messages.REQUEST_NOT_SUPPORTED);
                close(clientSocket);
                return;
            }

            if (resource.equals("/")) {
                File file = new File("www/index.html");
                replyWithHeader(out, HttpHeaderBuilder.ok(file.getName(), file.length()));
                replyWithFile(out, file);
                return;
            }

            File file = new File("www" + resource);

            if (!file.exists()) {
                file = new File("www/404.html");
                replyWithHeader(out, HttpHeaderBuilder.notFound(file.getName(), file.length()), Messages.RESOURCE_NOT_FOUND);
                replyWithFile(out, file);
                return;
            }

            replyWithHeader(out, HttpHeaderBuilder.ok(file.getName(), file.length()));
            replyWithFile(out, file);
        }

        private void replyWithHeader(DataOutputStream out, String header) throws IOException {
            out.writeBytes(header);
        }

        private void replyWithHeader(DataOutputStream out, String header, String message) throws IOException {
            System.err.println(message);
            out.writeBytes(header);
        }

        private void replyWithFile(DataOutputStream out, File file) throws IOException {
            byte[] bytes = Files.readAllBytes(Path.of(file.getPath()));
            out.write(bytes, 0, bytes.length);
            close(clientSocket);
        }

        private void close(Socket clientSocket) throws IOException {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }
}
