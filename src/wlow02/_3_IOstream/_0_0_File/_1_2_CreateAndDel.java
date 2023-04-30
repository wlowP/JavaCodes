package wlow02._3_IOstream._0_0_File;

import java.io.File;
import java.io.IOException;

public class _1_2_CreateAndDel {
    public static void main(String[] args) throws IOException {
        File f1 = new File("F:/codes/practice/myIOPractice/newFile.txt");

        // 创建文件, 会有编译时异常IOException, 返回布尔值表示是否创建成功
        System.out.println(f1.createNewFile()); // true, 📌📌如果文件已经存在的话返回false
            // 如果父级路径不存在或有误, 方法会抛出IOException->报错

        // 创建单级文件夹, 返回布尔值表示是否创建成功. 如果重名则返回false.
        File f2 = new File("f:/codes/practice/myIOPractice/new-dir");
        System.out.println(f2.mkdir());
        // 如果是创建多级文件夹, 要用mkdirs
        // 一般用mkdirs
        File f3 = new File("f:/codes/practice/myIOPractice/new-dir/aaa/bbb");
        System.out.println(f3.mkdirs());

        // delete方法栗子略. 注意只能删除某个文件或空的文件夹
    }
}
