package wlow02._3_IOstream;

import java.io.*;

import java.util.Arrays;

public class _4_0_Exercises {
    public static void main(String[] args) throws IOException {

        // 复制文件或文件夹.
        File src = new File("F:/codes/practice/myIOPractice/copy_src"),
             dest = new File("F:/codes/practice/myIOPractice/copy_dest");
        //copy(src, dest);

        // 加密文件.
        File src1 = new File("F:/codes/practice/myIOPractice/copy_src/img.enc.png"),
             dest1 = new File("F:/codes/practice/myIOPractice/copy_src/img.png");
        //encrypt(src1, dest1);

        File src2 = new File("IOPractice/array.txt"),
             dest2 = new File("IOPractice/array_sorted.txt");
        //sortFromArrayFile(src2, dest2);

    }


    // 复制文件夹, src传递文件或文件夹都可
    public static void copy(File src, File dest) throws IOException {
        byte[] buffer = new byte[1024 * 1024 * 5]; // 5MB缓存
        // 当一开始传递的src是文件时:
        if (src.isFile()){
            File probe = new File(dest, src.getName());
            probe.createNewFile();
            copyDir(src, probe, buffer);
        }else
            copyDir(src, dest, buffer);
    }
    private static void copyDir(File src, File dest, byte[] buffer) throws IOException{
        if (src.isFile()){
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            int count;
            while ((count = fis.read(buffer)) != -1)
                fos.write(buffer, 0, count);
            fos.close(); // 📌别忘了关流.
            fis.close();
        }else {
            // 📌📌别忘了先创建一个空文件夹, 免得FileOutputStream找不到父级文件夹而报错.
            dest.mkdirs();
            for (File nextSrc : src.listFiles()) {
                // 📌📌文件名和文件夹的层级关系可以通过递归传递.
                copyDir(nextSrc, new File(dest, nextSrc.getName()), buffer);
            }
        }
    }


    // model: src只能传递文件夹, 方法内一开始就把文件夹展开.
    public static void copy_model(File src, File dest) throws IOException{
        dest.mkdirs(); // 先创建文件夹防止报错
        for (File file : src.listFiles()) {
            if (file.isFile()){
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                byte[] buffer = new byte[1024];
                int count;
                while ((count = fis.read(buffer)) != -1)
                    fos.write(buffer, 0, count);
                fos.close();
                fis.close();
            }else{
                copy_model(file, new File(dest, file.getName()));
            }
        }
    }


    // 加密文件
    // 采用异或( ^ )的计算方式, 因为异或的运算可逆. 100 ^ 10 = 110; 110 ^ 10 = 100
    // 加密和解密时使用的第二个异或运算数(密钥)要一样, 比如下面是678, 解密时也要678
    // 在指定目录dest下输出加密后文件
    public static void encrypt(File src, File dest) throws IOException{
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        int enc;
        while ((enc = fis.read()) != -1)
            fos.write(enc ^ 678);
        fos.close();
        fis.close();
    }


    // 修改文件. 文件内容: 数字-数字-数字-..., 用IO流对其中数字排序.
    public static void sortFromArrayFile(File src, File dest) throws IOException{
        // 先获取字符串形式的数组
        // 纯文本文件用字符流更好.
        FileReader fr = new FileReader(src);
        FileWriter fw = new FileWriter(dest);
        char[] buffer = new char[1024];
        int count;
        StringBuilder sb = new StringBuilder();
        while ((count = fr.read(buffer)) != -1)
            sb.append(new String(buffer, 0, count));
        // 转换为Integer数组, 再进行排序
        String[] arr = sb.substring(1, sb.length() - 1).split(",");
        Integer[] arr1 = Arrays.stream(arr)
                .map(String::strip)
                .map(Integer::parseInt)
                .sorted((a, b)->a - b)
                .toArray(Integer[]::new);
        fw.write(Arrays.toString(arr1).replace(", ", " - "));
        fw.close();
        fr.close();
    }
}
