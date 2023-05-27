package wlow02._5_SocketNetwork.practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// TCP文件上传
// 服务端
public class _1_5_FileUpload {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9090);

    }
}

// 上传文件的客户端
class Uploader{
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9090);

    }
}