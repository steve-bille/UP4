import java.io.*;
import java.net.*;

class UDPServer {
    public static DatagramSocket ds;
    public static byte[] buffer = new byte[1024];
    public static int clientPort = 789, serverPort = 790;

    public static void main(String[] args) throws Exception {
        ds = new DatagramSocket(clientPort);
        System.out.println("Press Ctrl+C to quit the program");
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ia = InetAddress.getLocalHost();

        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            String psx = new String(p.getData(), 0, p.getLength());
            System.out.println("Client: " + psx);
            System.out.print("Server: ");
            String str = dis.readLine();
            if (str.equals("end"))
                break;
            buffer = str.getBytes();
            ds.send(new DatagramPacket(buffer, str.length(), ia, serverPort));
        }
        ds.close();
    }
}
