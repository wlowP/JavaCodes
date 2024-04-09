package wlow02_java_advance._3_IOstream;

import java.io.*;
import java.util.Date;

// 打印流
public class _8_0_PrintStream {
    public static void main(String[] args) throws IOException {
        // 打印流只输出不输入, 所以只有输出流

        // 字节打印流: 包装字节输出流
        // 对于字节打印流, 📌因为字节流底层没有缓冲区, 开不开自动刷新都一样; UTF-8是默认编码方式, 传不传都一样
        // @NotNull String csn 就是CharSetName, 也是以字符串表示字符集名字
        PrintStream ps = new PrintStream(new FileOutputStream("IOPractice/print_stream_out.txt"), true, "UTF-8");
        ps.println("字节打印流");
        ps.close();

        // 字符打印流: 包装字符输出流
        // 因为字符流有缓冲区, 不自动flush可能写不出数据, 最好开启自动flush
        PrintWriter pw = new PrintWriter(new FileWriter("IOPractice/print_stream_out.txt", true), true);
        pw.println("字符打印流, 最好开启自动flush");
        pw.printf("%1$tH : %1$tM : %1$tS \n", new Date());
        pw.close();

        // System.out 实际也是调用了System类里面的一个静态的PrintStream类型的常量out, 调用out的打印方法
        // 此打印流在虚拟机创建的时候就自动被创建, 默认指向控制台
        // 📌📌System.out 又叫标准输出流, 是唯一的, 如果关闭的话除非重启虚拟机, 否则都用不了了
        PrintStream ps1 = System.out;
        ps1.println("这样子也能sout");
        ps1.close();
        System.out.println("关流了, 打印不出来了");
    }
}
