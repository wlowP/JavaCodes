package wlow02._3_IOstream;

import java.io.*;

// 字节缓冲流
public class _5_0_BufferedIOStream {
    public static void main(String[] args) throws IOException {
        // 用字节缓冲流拷贝文件
        // 缓冲流构造方法要传递基本流对象
        FileInputStream fis = new FileInputStream("IOPractice/content.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("IOPractice/content_copy.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int count;
        byte[] buffer = new byte[1024];
        while ((count = bis.read(buffer)) != -1){
            bos.write(buffer, 0, count);
        }

        // 释放资源时就不需要close基本流了, 缓冲流底层会帮忙关基本流
        bos.close();
        bis.close();
    }
}
