package wlow02_java_advance._3_IOstream;

import java.io.FileWriter;
import java.io.IOException;

public class _3_2_FileWriter {
    public static void main(String[] args) throws IOException {
        // 字符输出流.
        FileWriter fw = new FileWriter("IOPractice/target2.txt");

        // 按照整数对应的字符集编号写出字符.
        fw.write(25105); // 字符'我'在Unicode字符集中对应的编号

        // 直接写出字符串, 或者字符串的一部分
        fw.write("\n你就是个帅比");
        fw.write("\n你就是个帅比", 0, 5);

        // 写出字符数组, 或者字符数组的一部分
        char[] chars = new char[]{'\n', '我', '不', '知', '道'};
        fw.write(chars);
        fw.write(chars, 0, 3);
        fw.close();
    }
}
