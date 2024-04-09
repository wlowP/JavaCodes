package wlow02_java_advance._5_SocketNetwork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// UDP协议模拟网络聊天室
// 发送方
// 📌📌可以运行多个发送方实例, 然后接收方就是聊天室了, 不需双向发送
public class _1_3_ChatRoomUDP {
    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket();
        String msg;
        byte[] msgBytes;
        InetAddress addr = InetAddress.getByName("localhost");
        int port = 9090; // 发到对方9090端口上

        Scanner sc = new Scanner(System.in);
        System.out.println("===开启聊天频道...");

        while (sc.hasNextLine()){
            msg = sc.nextLine(); // a
            msgBytes = msg.getBytes();
            // System.out.println(Arrays.toString(msgBytes)); // [97]
            ds.send(new DatagramPacket(msgBytes, msgBytes.length, addr, port));
            // 发送886的话就结束聊天了
            if ("886".equals(msg)){
                System.out.println("===结束聊天...");
                break;
            }
        }
        ds.close();
    }
}

// 接收方(聊天室)
class Receiver{
    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket(9090);
        byte[] rec = new byte[1024], data;
        DatagramPacket dp = new DatagramPacket(rec, rec.length);

        String msg;

        // 接收方不知道发送方什么时候停下来, 所以用死循环
        while (true){
            ds.receive(dp);
            data = dp.getData();
            // System.out.println(Arrays.toString(data)); // [97, 0, 0, 0, 0], 数组长度同rec
            // 📌📌getData()方法获得的数组长度取决于交给dp的数组(rec)的长度, 很可能跟发送的字节数组长度不一样
            // 所以不能直接new String(data), 不然数据会有误
            msg = new String(data, 0, dp.getLength());
            if ("886".equals(msg)){
                System.out.println("===结束聊天...");
                break;
            }
            System.out.println(dp.getAddress().getHostAddress() + ":" + dp.getPort() + " > " + msg);
        }

        ds.close();
    }
}