import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        String line;
        DataInputStream inputStream;
        PrintStream printStream;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Server started and listening on port 9000");
        } catch (IOException e) {
            System.out.println("Error creating server socket: " + e);
            return;
        }

        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            inputStream = new DataInputStream(clientSocket.getInputStream());
            printStream = new PrintStream(clientSocket.getOutputStream());

            while (true) {
                line = inputStream.readLine();
                if (line == null || line.equalsIgnoreCase("exit")) {
                    break;
                }
                printStream.println(line);
            }

            inputStream.close();
            printStream.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error handling client connection: " + e);
        }
    }
}
