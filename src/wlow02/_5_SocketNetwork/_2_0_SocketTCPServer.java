package wlow02._5_SocketNetwork;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 以TCP协议收发数据
// 接收端(服务端) 先运行服务端再运行客户端
public class _2_0_SocketTCPServer {
    public static void main(String[] args) throws IOException {
        // 1.创建服务端的ServerSocket对象
        //   构造函数传递监听的端口, 要跟客户端连接的端口保持一致
        ServerSocket serverSocket = new ServerSocket(9090);

        // 2.监听客户端的连接, 返回客户端的连接对象(Socket对象)
        //   📌📌方法具有阻塞性, 连接不到就一直等着
        Socket socket = serverSocket.accept();

        // 3.获取基本字节输入流读取数据, 最好转换成高级流, 因为字节流不能读取中文
        InputStream in = socket.getInputStream(); // 可见流是内置于Socket连接通道里面的
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

          // 获取IP, 端口等信息
        InetAddress ip = socket.getInetAddress();
        System.out.print(ip.getHostAddress() + ":" + socket.getPort() + " > ");

        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        } // 127.0.0.1:58663 > 你好不好

        // 4.释放资源
        socket.close(); // 断开了跟客户端的连接 (Socket关了, 里面的流也自动关了)
        serverSocket.close(); // 关闭了服务端
    }
}

// 发送端(客户端)
class SocketClient{
    public static void main(String[] args) throws IOException {
        /*
        *   1.先创建Socket对象
        *     创建对象时就会跟指定的服务端连接
        *     连接不上就会抛异常ConnectException
        *     📌实际场景下, 应该再多重试连接几遍, 不行再提示错误
        * */
        Socket socket = new Socket("localhost", 9090);

        // 2. 对象获取一个基本字节输出流, 推荐转换成高级流
        OutputStream out = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        bw.write("你好不好");

        // 3.释放资源
        bw.close(); // 📌📌bw不关流的话没法写出数据, 也就没法发送信息
        socket.close();
    }
}
