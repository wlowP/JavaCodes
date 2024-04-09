package wlow02_java_advance._3_IOstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class _1_0_FileOutput {
    public static void main(String[] args) throws IOException {
        File f = new File("IOPractice/target.txt");
        // 创建字节输出流对象
        // 构造方法要传递文件路径, 字符串或者File对象都行
        FileOutputStream fos = new FileOutputStream(f);
        // 写出数据(类型是byte, 会按照ASCII码表映射)
        fos.write(65); // A
        fos.write(66); // B
        // 释放资源: close()
        fos.close();
    }
}
