package wlow02._3_IOstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class _3_0_Charset {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("IOPractice/chinese.txt");
        int b;
        // 字节流读取中文出现乱码.
        while ((b = fis.read()) != -1){
            System.out.print((char)b);
        }
        System.out.println();
        fis.close();

        String str = "ab啊啵";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        // IDEA默认用Unicode的UTF-8编码解码, 一个汉字三个字节.
        // [97, 98, -27, -107, -118, -27, -107, -75]

        byte[] bytes1 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));
        // GBK中, 一个汉字两个字节
        // [97, 98, -80, -95, -32, -93]

        // 解码时默认UTF-8
        System.out.println(new String(bytes)); // ab啊啵
        System.out.println(new String(bytes1, "GBK")); // ab啊啵

        // 解码方式跟编码不统一, 就出现乱码.
        System.out.println(new String(bytes1)); // ab���
    }
}
