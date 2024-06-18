import java.net.ServerSocket;
import java.net.Socket;

public class FileServers {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Initialize ServerSocket
            serverSocket = new ServerSocket(5000);
            System.out.println("Server waiting for connection...");

            // Accept client connection
            socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Simulating file sending progress
            for (int i = 10; i <= 100; i += 10) {
                System.out.println("Sending file ... " + i + "% complete!");
                Thread.sleep(500); // Simulate time delay for file transfer
            }

            // Simulate file transfer completion
            System.out.println("File sent successfully!");

            // Close connections
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println("Exception in FileServer: " + e.getMessage());
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (Exception e) {
                System.out.println("Exception while closing server socket: " + e.getMessage());
            }
        }
    }
}
