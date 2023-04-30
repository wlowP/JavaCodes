package wlow02._3_IOstream;

import java.io.*;
import java.nio.charset.Charset;

public class _6_1_Exercises1 {
    public static void main(String[] args) throws IOException {
        // 将UTF-8编码的文本转为GBK编码

        FileReader fr = new FileReader("IOPractice/济南的冬天.txt");
        // 输出时指定GBK字符集
        FileWriter fw = new FileWriter("IOPractice/济南的冬天_toGBK.txt", Charset.forName("GBK"));
        int count;
        char[] buffer = new char[1024];
        while ((count = fr.read(buffer)) != -1)
            fw.write(buffer, 0, count);

        // 字符流底层有缓冲区, 输出时要flush或关流才能写出数据.
        fw.close();
        fr.close();


        // 用字节流读取一整行中文, 配合转换流和缓冲流
        // 转换过程:   fis字节流 --ISR包装--> 字符流 --> BR缓冲流
        FileInputStream fis = new FileInputStream("IOPractice/济南的冬天_GBK.txt");
        InputStreamReader isr = new InputStreamReader(fis, "GBK");
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        System.out.println(line); // 济南的冬天
        br.close();
    }
}
