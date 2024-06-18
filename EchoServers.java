import java.net.*;
import java.io.*;

public class EchoServers {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader inputReader = null;
        PrintWriter outputWriter = null;

        try {
            // Create server socket on port 9000
            serverSocket = new ServerSocket(9000);
            System.out.println("Server waiting for connection...");

            // Accept client connection
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Initialize input and output streams
            inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outputWriter = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = inputReader.readLine()) != null) {
                System.out.println("Client: " + clientMessage);
                outputWriter.println("Server: " + clientMessage);

                // Check for termination condition
                if (clientMessage.equalsIgnoreCase("end")) {
                    break;
                }
            }

            // Close all resources
            inputReader.close();
            outputWriter.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
