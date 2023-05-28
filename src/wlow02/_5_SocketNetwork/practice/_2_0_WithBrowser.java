package wlow02._5_SocketNetwork.practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// BS应用架构 - 接收浏览器的消息并打印
// 浏览器访问localhost:9090后, 服务端控制台就打印出请求体消息
public class _2_0_WithBrowser {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9090);
        Socket link = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(link.getInputStream()));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        link.close();
    }
}
