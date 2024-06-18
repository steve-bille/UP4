import java.io.*;
import java.net.*;

class UDPClient {
    public static DatagramSocket ds;
    public static int clientPort = 789, serverPort = 790;

    public static void main(String[] args) throws Exception {
        byte[] buffer = new byte[1024];
        ds = new DatagramSocket(serverPort);
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Server waiting");
        InetAddress ia = InetAddress.getLocalHost();

        while (true) {
            System.out.print("Client: ");
            String str = dis.readLine();
            if (str.equals("end"))
                break;
            buffer = str.getBytes();
            ds.send(new DatagramPacket(buffer, str.length(), ia, clientPort));
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            String psx = new String(p.getData(), 0, p.getLength());
            System.out.println("Server: " + psx);
        }
        ds.close();
    }
}
