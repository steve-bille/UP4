import java.net.*;
import java.io.*;

public class TCPServers {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(4000);
            System.out.println("Server Waiting for image");

            socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Simulating reading the image size
            int len = 512 * 1024; // Assume a 512KB image for demonstration
            System.out.println("Image Size: " + len / 1024 + "KB");

            // Close connections
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.out.println("IOException on close: " + e.getMessage());
            }
        }
    }
}
