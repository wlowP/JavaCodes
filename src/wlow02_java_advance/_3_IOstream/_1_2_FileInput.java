package wlow02_java_advance._3_IOstream;

import java.io.FileInputStream;

import java.io.IOException;

public class _1_2_FileInput {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("IOPractice/content.txt");
        // 一次读取一个字符, 结果是ASCII值
        int b1 = fis.read();
        System.out.println(b1); // 87
        System.out.print((char)b1); // W
        // 📌如果读完了再调用read()会返回-1

        // 采用循环的方式读取文件.
        int b;
        while ((b = fis.read()) != -1){
            System.out.print((char)b);
        }

        fis.close();
    }
}
