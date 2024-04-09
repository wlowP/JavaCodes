package wlow02_java_advance._5_SocketNetwork.practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// TCP文件上传
// 服务端
public class _1_5_FileUpload {
    private static final ExecutorService threadPoolUnlimited = Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9090);
        Socket link;
        while (true){
            link = server.accept();
            threadPoolUnlimited.submit(new Receiver(link));
        }
    }

    static class Receiver implements Runnable{
        private final Socket link;
        public Receiver(Socket link){
            this.link = link;
        }
        @Override
        public void run() {
            byte[] buffer = new byte[1024 * 1024 * 5];
            int length;
            BufferedInputStream bis;
            BufferedOutputStream bos;
            BufferedWriter bw;
            try {
                bis = new BufferedInputStream(link.getInputStream());
                // 📌📌用UUID类防止本地文件名重复
                bos = new BufferedOutputStream(new FileOutputStream("IOPractice/upload/" + UUID.randomUUID().toString().replace("-", "") + ".mp3"));
                System.out.println(Thread.currentThread().getName() + " > 准备接收文件...");
                // 📌📌📌read方法会从连接通道中读取数据, 但是只有读到一个结束标记的时候才会返回-1, 不然就卡在这了
                // 于是客户端那边需要确保发送结束标记, 可以用socket.shutdownOutput()
                while ((length = bis.read(buffer)) != -1){
                    bos.write(buffer, 0, length);
                }
                System.out.println(Thread.currentThread().getName() + " > 接收文件成功");
                bw = new BufferedWriter(new OutputStreamWriter(link.getOutputStream()));
                bw.write("上传文件成功!");
                bw.close(); // 这一步必要(flush也行), 否则流不能释放资源, 写不出数据, 客户端也就接不到响应消息
                bos.close();
                link.close();
            }catch (IOException e){
                System.err.println(Thread.currentThread().getName() + " > 上传文件出现异常!");
            }finally {
                try {
                    link.close();
                } catch (IOException ignored) {}
            }
        }
    }
}

// 上传文件的客户端
class Uploader{
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9090);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("IOPractice/妖怪モダンコロニー - 上海アリス幻樂団.mp3"));
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        byte[] buffer = new byte[1024 * 1024 * 5];
        int length;
        System.out.println("开始上传文件...");
        while ((length = bis.read(buffer)) != -1){
            bos.write(buffer, 0, length);
        }

        // 利用字节数组发送数据, 也就是write(buffer, 0, length)时
        // 📌📌要调用shutdown方法结束输出, 否则服务端会认为客户端还没输出完, 一直等着客户端输出, 卡在读取文件的while循环中
        // 而客户端也一直等着服务端响应, 卡在read方法上, 就造成了两边阻塞
        // 相当于上传完文件后又发送了一个文件结束标记, 告诉服务端文件已经传完了
        client.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(br.readLine());
        bis.close();
        client.close();
        br.close();
    }
}