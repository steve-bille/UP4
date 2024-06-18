import java.io.*;
import java.net.*;

class ServerARP {
    public static void main(String[] args) {
        final int PORT = 9876; // Use a different port number
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is waiting for connection on port " + PORT + "...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter dout = new PrintWriter(socket.getOutputStream(), true);

            String str = din.readLine();
            String[] ip = {"165.165.80.80", "165.165.79.1"};
            String[] mac = {"6A:08:AA:C2", "8A:BC:E3:FA"};
            boolean found = false;

            for (int i = 0; i < ip.length; i++) {
                if (str.equals(ip[i])) {
                    dout.println(mac[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                dout.println("MAC Address Not Found");
            }

            // Close the connection after handling one request.
            din.close();
            dout.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
