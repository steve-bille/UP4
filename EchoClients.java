import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoClients {
    public static void main(String arg[]) {
        Socket socket = null;
        BufferedReader inputReader = null;
        PrintWriter outputWriter = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Connect to server on localhost port 9000
            socket = new Socket("localhost", 9000);
            System.out.println("Client connected to server...");

            // Initialize input and output streams
            inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputWriter = new PrintWriter(socket.getOutputStream(), true);

            String userInput;
            String serverResponse;
            while (true) {
                System.out.print("Client: ");
                userInput = scanner.nextLine();
                outputWriter.println(userInput);

                // Receive and display server response
                serverResponse = inputReader.readLine();
                if (serverResponse == null) {
                    System.out.println("Server closed the connection.");
                    break;
                }
                System.out.println(serverResponse);

                // Check for termination condition
                if (userInput.equalsIgnoreCase("end")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                // Close all resources
                if (inputReader != null) inputReader.close();
                if (outputWriter != null) outputWriter.close();
                if (socket != null) socket.close();
                scanner.close();
                System.out.println("Socket Closed!");
            } catch (IOException e) {
                System.out.println("Exception while closing resources: " + e.getMessage());
            }
        }
    }
}
