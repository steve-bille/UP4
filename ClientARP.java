import java.io.*;
import java.net.*;

class ClientARP {
    public static void main(String[] args) {
        final int PORT = 9876; // Use the same port number as the server
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            Socket clsct = new Socket("127.0.0.1", PORT);
            BufferedReader din = new BufferedReader(new InputStreamReader(clsct.getInputStream()));
            PrintWriter dout = new PrintWriter(clsct.getOutputStream(), true);

            System.out.println("Enter the Logical address(IP):");
            String str1 = in.readLine();
            dout.println(str1);

            String str = din.readLine();
            System.out.println("The Physical Address is: " + str);

            clsct.close();
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

//Enter the Logical address(IP):165.165.80.80
