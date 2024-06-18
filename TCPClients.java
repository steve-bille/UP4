import java.net.*;
import java.io.*;

public class TCPClients {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 4000);
            System.out.println("Client is running.");

            // Simulating reading the image from disk
            System.out.println("Reading image from disk.");
            // Assume the image is successfully read

            // Simulating sending the image
            System.out.println("Sending image to server.");
            // Simulate sending image
            System.out.println("Image sent to server.");

            // Close the socket
            socket.close();

        } catch (IOException e) {
            System.out.println("Socket connection error: " + e.getMessage());
        }
    }
}
