package wlow02._3_IOstream._0_0_File;

import java.io.File;
import java.util.Arrays;

public class _1_3_Traverse {
    public static void main(String[] args) {
        File f1 = new File("F:/codes/practice/myIOPractice");
        File[] files = f1.listFiles();
        for (File file : files) {
            // 数组中的元素file依次表示f1文件夹里面所有的文件/文件夹
            System.out.println(file.getName());
        }

        // 获取所有系统盘符, 注意是静态方法
        File[] disks = File.listRoots();
        System.out.println(Arrays.toString(disks)); // [C:\, D:\, E:\, F:\], 因计算机而异


        // 获取file的子级文件/文件夹的名字(子级路径, 包括后缀名), 📌但是返回字符串数组而不是File[]
        String[] files1 = f1.list();
        System.out.println(Arrays.toString(files1)); // 结果较长, 略

        // 过滤并获取符合要求的子级文件/文件夹.
        // 传递函数接口FileFilter的对象, 回调函数只有一个形参, 类型是File, 表示当前遍历到的File对象
        // (获取所有txt文件)  (📌判断细节: 首先得是个文件而不是文件夹)
        File[] files2 = f1.listFiles(pathname -> pathname.isFile() && pathname.getPath().endsWith(".txt"));
        System.out.println(Arrays.toString(files2));
        // [F:\codes\practice\newFile.txt, F:\codes\practice\content.txt]

        // 也可传递函数接口FilenameFilter的对象, 回调函数有两个形参, 分别是父级和子级路径
        // 📌📌形参中的父级路径是File对象, 子级路径是字符串.
        File[] files3 = f1.listFiles((parent, child) -> child.endsWith(".txt"));
        System.out.println(Arrays.toString(files3)); // 结果同上files2
    }
}
