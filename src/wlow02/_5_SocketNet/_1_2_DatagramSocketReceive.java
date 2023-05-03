package wlow02._5_SocketNet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// UDP协议接收数据
public class _1_2_DatagramSocketReceive {
    public static void main(String[] args) throws IOException {
        /*
        * 1.创建DatagramSocket对象, 用来接收数据
        *   接收数据的时候一定在构造方法指明监听的端口, 要跟
        *   DatagramPacket中指定的端口号一样
        * */
        DatagramSocket ds = new DatagramSocket(8080);

        // 2.创建接收数据的DatagramPacket并让ds接收
        byte[] rec = new byte[1024];
        DatagramPacket dp = new DatagramPacket(rec, rec.length);
        ds.receive(dp);

        // 3.解析数据包
        byte[] data = dp.getData(); // 获取到发来的字节数组
        int len = dp.getLength(); // 发来的字节数组的长度
        InetAddress address = dp.getAddress(); // 获取到发送方的IP信息
        int port = dp.getPort(); // 📌📌获取到发送方发送时的端口号, 不是接收到数据的端口号

        System.out.println("接收到数据: " + new String(data));
        System.out.println("数据长度: " + len);
        System.out.println("是从 " + address + " 这台电脑的 " + port + " 端口发过来的");

        // 4.释放资源
        ds.close();
    }
}
