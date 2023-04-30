package wlow02._3_IOstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class _1_3_ReadMore {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("IOPractice/content.txt");

        // 📌要传递一个byte数组当做read读取的缓冲区. 长度自定, 最好位1024的整数倍.
        byte[] bytes = new byte[10];
        /* 返回的int表示本次读取到了多少个字节数据, 读完了返回-1
         * read指针的移动跟byte数组的长度无关.
         * 实际读取到几个字节, 指针就移动几个单位.
         *
         * 📌📌如果一直复用同一个byte数组, read方法读取到字节的话会对其中的元素
         * 📌📌进行替换, 读取到了几个(read方法返回值)就替换几个.
         * 所以可能出现数组中同时存在两轮读取数据的情况:
         * 比如byte数组长度为10, 最后只读取到3个字节(abc), 而上一次读取到0-9
         * 📌📌那么new String(数组)的结果就是abc3456789
         * 所以String构造方法最好配合read方法返回值使用: new String(数组, 0, read返回值)
         * */

        int read = fis.read(bytes);
        System.out.println(read); // 10
        System.out.println(new String(bytes, 0, read)); // When I was
        System.out.println(Arrays.toString(bytes)); // [87, 104, 101, 110, 32, 73, 32, 119, 97, 115]
        fis.close();
    }
}
