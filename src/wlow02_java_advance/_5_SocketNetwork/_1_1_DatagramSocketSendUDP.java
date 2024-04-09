package wlow02_java_advance._5_SocketNetwork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// 以UDP协议发送数据
public class _1_1_DatagramSocketSendUDP {
    public static void main(String[] args) throws IOException {
        /*
        * 1.创建DatagramSocket对象, 用来发送数据的
        *   构造方法可以传递int表示发送时所用的端口号
        *   空参构造的话就从当前可用端口中随机选一个
        * */
        DatagramSocket ds = new DatagramSocket();

        // 2.打包数据, 用DatagramPacket类
        String msg = "你好";
          // 要发送的数据得转成byte数组
        byte[] msgBytes = msg.getBytes();
          // 指定发送给哪台网络设备
        InetAddress addr = InetAddress.getByName("localhost");
          // 发送给对应网络设备的哪个端口
        int port = 8080;
          // 构造方法从第二个参数开始也可以传递int的offset和length, 表示从数组中第几个元素开始发送多长的数据
          // 下面只传递数组长度的话表示把整个数组都发送出去
        DatagramPacket dp = new DatagramPacket(msgBytes, msgBytes.length, addr, port);

        // 3.发送数据
        ds.send(dp);

        // 4.释放资源
        ds.close();
    }
}