package wlow02._3_IOstream;

import java.io.FileReader;
import java.io.IOException;

public class _3_1_FileReader {
    public static void main(String[] args) throws IOException {
        // 对于纯文本文件用字符流读取会更好. 一次读取一个字符.
        // 📌📌默认的解码方式是UTF-8, 所以对应的文本文件应该是UTF-8编码的.
        FileReader fr = new FileReader("IOPractice/济南的冬天.txt");

        // 一个一个字节地读取
        // 读取的时候遇到英文, 读一个字节; 遇到中文读三个字节(UTF-8)
        // 📌📌此时read方法返回整数, 表示字符对应的字节(二进制)转成的整数(十进制), 也就是在码表中的序号.
        // a -> 97 ; '我' -> 25105. 所以要强转成char字符.
        int ch;
        while ((ch = fr.read()) != -1){
            System.out.print((char)ch);
        }
        System.out.println();
        fr.close();

        // 利用缓冲数组读取
        char[] buffer = new char[10];
        int count; // count接收read方法返回值表示实际读到了几个字符
        FileReader fr1 = new FileReader("IOPractice/济南的冬天.txt");
        while ((count = fr1.read(buffer)) != -1){
            System.out.print(new String(buffer, 0, count));
        }
        fr1.close();
    }
}
