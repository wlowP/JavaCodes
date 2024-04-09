package wlow02_java_advance._3_IOstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 复制小文件
public class _2_0_FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:/Music/幻想记事簿 ～ Story of Fantasies/大空魔术　~ Magical Astronomy - 上海アリス幻樂団.mp3");
        FileOutputStream fos = new FileOutputStream("IOPractice/music_copy.mp3");


        // 因为是字节流, 所以只要有访问权限就可以拷贝任意类型的文件.
        // 缓存一次读取5MB再复制.
        int read;
        byte[] buffer = new byte[1024 * 1024 * 5];
        while ((read = fis.read(buffer)) != -1){
            fos.write(buffer, 0, read);
        }
        // 📌📌先开的流后关闭.
        fos.close();
        fis.close();
    }
}
