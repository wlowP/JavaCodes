package wlow02_java_advance._3_IOstream;


import java.io.FileOutputStream;
import java.io.IOException;

public class _1_1_Write {
    public static void main(String[] args) throws IOException {
        // 续写开关, 📌📌构造方法第二个参数传递true. ->追加写入
        // 这样在创建对象写入内容时就不会把目标文件清空了
        FileOutputStream fos = new FileOutputStream("IOPractice/target1.txt", true);
        String str = "abcde12345";
        byte[] bytes = str.getBytes();
        fos.write(bytes, 1, 8);

        // 换行, 写入换行符\r\n
        byte[] wrap = "\r\n".getBytes();
        fos.write(wrap);
        fos.write(bytes, 5, 5);
        fos.write(wrap);

        fos.close();
    }
}
