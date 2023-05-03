package wlow02._5_SocketNet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

// 表示IP地址的类
public class _1_0_InetAddress {
    public static void main(String[] args) throws UnknownHostException {
        // Java中表示IP地址的类InetAddress, 也就是表示了一台网络设备, 通常是计算机
        // 没有public的构造方法, 通过静态方法获取对象

        // getByName方法传递字符串形式的IP地址或主机名(网络设备的名称)
        InetAddress ipAddr = InetAddress.getByName("localhost");
        System.out.println(ipAddr);

        // 获取到主机名字符串
        String hostName = ipAddr.getHostName();
        System.out.println(hostName); // REISEN

        // 获取到IP地址字符串
        String hostAddress = ipAddr.getHostAddress();
        System.out.println(hostAddress); // 10.27.217.214

        // 获取到二进制IP地址对应的字节数组, 但是数值范围会变成byte的-128~127, 所以可能出现负数
        byte[] address = ipAddr.getAddress();
        // 10.27.217.214的二进制原始形式是00001010 00011011 11011001 11010110
        // 然后根据Java中byte类型的取值范围(-128~127)转成 [10, 27, -39, -42]
        System.out.println(Arrays.toString(address)); // [10, 27, -39, -42]
    }
}
