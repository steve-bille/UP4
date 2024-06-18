import java.io.*;
import java.net.*;

class ClientRARP {
    public static void main(String args[]) {
        try {
            DatagramSocket client = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("127.0.0.1");

            byte[] sendbyte = new byte[1024];
            byte[] receivebyte = new byte[1024];

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the Physical address (MAC):");
            String str = in.readLine();
            sendbyte = str.getBytes();

            DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, addr, 1309);
            client.send(sender);

            DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
            client.receive(receiver);

            String s = new String(receiver.getData());
            System.out.println("The Logical Address is(IP): " + s.trim());

            client.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

//Enter the Physical address (MAC):6A:08:AA:C2