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
    static ExecutorService threadPoolUnlimited = Executors.newCachedThreadPool();
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
    // 监听客户端的Runnable实现类
    static class Receiver implements Runnable{
        private Socket link;
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
                while ((msgLine = br.readLine()) != null){
                    System.out.print(addr.getHostAddress() + ":" + link.getPort() + " > ");
                    System.out.println(msgLine);
                    ps.println("您发送的内容: " + msgLine);
                    ps.flush();
                }
            }catch (IOException e){
                System.err.println("eee");
            }
        }
    }
}

// 客户端, 发送信息, 可开多个实例
class ClientOnline{
    public static void main(String[] args) throws IOException {
        Socket client = null;
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
            if ("886".equals(msg)) {
                System.out.println("结束聊天...");
                break;
            }
            ps.println(msg);
            ps.flush();
            // 📌📌服务端只用反馈一次消息, 不用while(true)跟服务端聊天了, 不然会卡住
            System.out.println("server > " + br.readLine());
        }
        ps.close();
        client.close();
    }
}