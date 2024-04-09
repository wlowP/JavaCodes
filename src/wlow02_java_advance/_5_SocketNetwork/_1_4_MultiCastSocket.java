package wlow02_java_advance._5_SocketNetwork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

// 组播: 发送端
public class _1_4_MultiCastSocket {
    public static void main(String[] args) throws IOException {
        // 组播, 用的是MultiCastSocket来收发数据, 是DatagramSocket的子类
        MulticastSocket ms = new MulticastSocket();

        // 然后使用方式基本同DatagramSocket
        String msg = "发送的组播消息";
        byte[] msgBytes = msg.getBytes();
         // 📌📌发送的目标IP地址应该是组播地址:
        InetAddress addr = InetAddress.getByName("224.0.0.1");
        int port = 9090;

        ms.send(new DatagramPacket(msgBytes, msgBytes.length, addr, port));

        ms.close();
    }
}

// 组播接收端, 创建多个实例
class MultiCastRec{
    public static void main(String[] args) throws IOException{
        // 用MulticastSocket对象来接收数据, 指定要接收的端口号
        MulticastSocket ms = new MulticastSocket(9090);

        // 📌📌将当前网络设备添加到224.0.0.1这一个组中
        InetAddress groupAddr = InetAddress.getByName("224.0.0.1");
        ms.joinGroup(groupAddr);

        // 然后接收数据方法基本同单播
        byte[] rec = new byte[1024], data;
        DatagramPacket dp = new DatagramPacket(rec, rec.length);

        ms.receive(dp);
        data = dp.getData();
        InetAddress ip = dp.getAddress();

        System.out.println(ip + ": " + dp.getPort() + " > " + new String(data, 0, dp.getLength()));

        ms.close();
    }
}

