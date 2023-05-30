package wlow02._5_SocketNetwork.practice;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// TCP传输之多发多收
// 接收消息的服务端(聊天室)
public class _1_0_TCPKeepOnline {
    private static final ExecutorService threadPoolUnlimited = Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket link;
        System.out.println("开启聊天室...");
        // 利用多线程, 线程池来监听多个客户端的连接
        // 每当accept拿到一个Socket连接时, 就将其分配给一个线程执行
        while (true) {
            link = serverSocket.accept();
            threadPoolUnlimited.submit(new Receiver(link));
            // new Thread(new Receiver(link)).start();
        }
    }
    // 监听客户端的Runnable实现类. 一个客户端用户对应一条线程
    static class Receiver implements Runnable{
        private final Socket link;
        // 构造方法传递客户端的Socket连接对象
        public Receiver(Socket link){
            this.link = link;
        }
        @Override
        public void run() {
            BufferedReader br;
            String msgLine;
            InetAddress addr;
            PrintStream ps;
            try {
                br = new BufferedReader(new InputStreamReader(link.getInputStream()));
                addr = link.getInetAddress();
                ps = new PrintStream(link.getOutputStream());
                System.out.println("<system> " + addr.getHostAddress() + ":" + link.getPort() + " 进入了聊天室");
                while ((msgLine = br.readLine()) != null){
                    System.out.print(addr.getHostAddress() + ":" + link.getPort() + " > ");
                    System.out.println(msgLine);
                    // 服务端做出响应
                    ps.println("您发送的内容: " + msgLine);
                }
                // 跳出循环, 说明客户端结束聊天了
                System.out.println("<system> " + addr.getHostAddress() + ":" + link.getPort() + " 退出了聊天室");
                ps.close();
                link.close();
            }catch (IOException e){
                System.err.println("exception");
            }
        }
    }
}

// 客户端, 发送信息, 可开多个实例
class ClientOnline{
    public static void main(String[] args) throws IOException {
        Socket client;
        try {
            client = new Socket("localhost", 9090);
        } catch (IOException e) {
            System.err.println("服务端未响应!");
            return;
        }
        OutputStream out = client.getOutputStream();
        PrintStream ps = new PrintStream(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        Scanner sc = new Scanner(System.in);
        String msg;
        while (true){
            msg = sc.nextLine();
            // 输入/exit结束聊天
            if ("/exit".equals(msg)) {
                System.out.println("结束聊天...");
                break;
            }
            // 这里一定得用println, 不然服务端那边的readLine就不知道什么时候读取完一行了
            ps.println(msg);
            // 📌📌服务端只用反馈一次消息, 不用while(true)跟服务端聊天了, 不然会卡住
            System.out.println("server > " + br.readLine());
        }
        client.close();
    }
}