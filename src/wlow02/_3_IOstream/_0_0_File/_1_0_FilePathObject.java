package wlow02._3_IOstream._0_0_File;

import java.io.File;

public class _1_0_FilePathObject {
    public static void main(String[] args) {
        // 创建File对象的三种方法:
        String pathStr = "D:\\Users\\ROG-STRITX\\Desktop\\something.txt";
        File f1 = new File(pathStr);
        System.out.println(f1); // D:\Users\ROG-STRITX\Desktop\something.txt

        // pathStr, 父级路径: 除去最后一级路径的其他部分 D:\Users\ROG-STRITX\Desktop
        // 子级路径: 路径最后一级的部分 something.txt
        String parent = "D:\\Users\\ROG-STRITX\\Desktop",
               child = "something.txt";
        File f2 = new File(parent, child);
        System.out.println(f2); // D:\Users\ROG-STRITX\Desktop\something.txt

        File f3 = new File(new File(parent), child);
        System.out.println(f3); // D:\Users\ROG-STRITX\Desktop\something.txt

    }
}
