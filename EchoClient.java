import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        Socket clientSocket = null;
        String line;
        DataInputStream consoleInput = null;
        DataInputStream serverInput = null;
        PrintStream outputStream = null;

        try {
            InetAddress ia = InetAddress.getLocalHost();
            clientSocket = new Socket(ia, 9000);
            System.out.println("Connected to server on port 9000");

            consoleInput = new DataInputStream(System.in);
            outputStream = new PrintStream(clientSocket.getOutputStream());
            serverInput = new DataInputStream(clientSocket.getInputStream());

            while (true) {
                System.out.print("Client: ");
                line = consoleInput.readLine();
                outputStream.println(line);
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Server: " + serverInput.readLine());
            }

            consoleInput.close();
            outputStream.close();
            serverInput.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Socket Closed!");
        }
    }
}

