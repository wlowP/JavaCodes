package wlow02._7_JVM._2_ClassLoader;

import java.io.IOException;
import java.io.InputStream;

// 类加载器的一些方法
public class _1_1_GetResource {
    public static void main(String[] args) throws IOException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        // 获取外部文件资源, 并返回其对应的字节输入流
        // 📌📌📌此时文件相对路径默认从src目录下开始, 而不是项目根路径
        InputStream in = systemClassLoader.getResourceAsStream("content.txt");
        int b;
        if (in != null) {
            while ((b = in.read()) != -1){
                System.out.print((char)b);
            }
            in.close();
        }
    }
}
