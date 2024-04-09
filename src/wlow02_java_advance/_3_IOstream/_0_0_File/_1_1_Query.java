package wlow02_java_advance._3_IOstream._0_0_File;

import java.io.File;
import java.util.Date;

public class _1_1_Query {
    public static void main(String[] args) {
        File f1 = new File("F:/codes/practice/myIOPractice/济南的冬天.txt"),
             f2 = new File("F:/codes/practice/myIOPractice"),
             f3 = new File("F:/codes/practice/myIOPractice/none.abc");

        // 是否为文件夹/文件
        System.out.println(f1.isDirectory()); // false
        System.out.println(f1.isFile()); // true
        // 文件/路径是否存在
        System.out.println(f3.exists()); // false
        // 是否为绝对路径
        System.out.println(f2.isAbsolute()); // true

        // 获得文件大小(如果文件存在的话)(单位是byte, 等于1kB/1024)
        // 📌📌无法获取文件夹的大小.
        System.out.println("文件大小: " + f1.length() / 1024.0 + " KB"); // 文件大小: 1.78515625 KB

        // 获得文件的绝对路径, 可以发现非绝对路径在不同计算机中的绝对路径.
        // 一个相对路径:
        String path = "src/wlow02/_3_IOstream/_0_0_FilePath/_1_1_Methods.java";
        File f4 = new File(path);
        System.out.println(f4.getAbsolutePath()); // F:\codes\... (绝对路径)
        System.out.println(f4.getAbsoluteFile()); // 绝对路径, 但是是File对象

        // 获得定义对象时指定的路径(构造函数传递了什么就获得什么)
        System.out.println(f1.getPath()); // F:\codes\practice\济南的冬天.txt
        // 获得子路径和父路径
            // getName如果是文件夹就没有后缀名
        System.out.println(f1.getName()); // 济南的冬天.txt
        System.out.println(f1.getParent()); // F:\codes\practice

        // 获得最后的修改时间, 是时间戳毫秒数
        System.out.println(new Date(f1.lastModified())); //Tue Feb 07 21:14:51 CST 2023
    }
}
