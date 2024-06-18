import java.net.InetAddress;
import java.net.Socket;

public class FileClients {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            // Initialize socket
            socket = new Socket(InetAddress.getByName("localhost"), 5000);
            System.out.println("Client connected to server...");

            // Simulate file saving
            Thread.sleep(1000); // Simulate time delay for file reception
            System.out.println("File saved successfully!");

            // Close the socket
            socket.close();

        } catch (Exception e) {
            System.out.println("Exception in FileClient: " + e.getMessage());
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                System.out.println("Exception while closing client socket: " + e.getMessage());
            }
        }
    }
}
