package wlow02_java_advance._3_IOstream._0_0_File;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

// files类的练习
public class _2_0_Practice {
    public static void main(String[] args) {

        File fToBeDELETED = new File("nothing");
        // =====📌📌警告📌📌=====
        // 🔖📌📌📌慎用该方法!!!删除不走回收站!!!
        //long start = System.currentTimeMillis();
        rmdir(fToBeDELETED);
        //System.out.println("删除耗时: " + (System.currentTimeMillis() - start));
        // =====📌📌警告📌📌=====

        // 统计不同类型文件数量
        File f = new File("F:/codes");
        System.out.println(typeCount(f));

        // 查找某一类型的文件.
        File f1 = new File("F:/codes/practice/Web");
        //System.out.println(Arrays.toString(findByType(f1, "txt")));

        // 统计大小
        File f2 = new File("F:/notes/钉钉");
        //System.out.println("大小: " + sizeOf(f2) / 1024.0 + " KB");
    }


    // 递归删除文件夹
    // 🔖📌📌📌慎用该方法!!!不走回收站!!!
    // 该方法无论对于文件or文件夹都会调用一次, 调用次数较多
    public static void rmdir(File src){
        if (!src.exists()) return;
        if (!src.delete()){
            for (File file : src.listFiles()) {
                rmdir(file);
            }
            src.delete();
        }
    }
    // 📌📌📌只针对文件夹递归调用删除方法, 减少方法调用次数, 但是第一次调用必须传递文件夹.
    // 但效率貌似不一定比第一种删除方法高
    // 第一种方法也能直接应用在文件上, 但这一种不能, listFiles会返回null.
    public static void rmdir_1(File src){
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()){
                file.delete();
            }else {
                rmdir_1(file);
            }
        }
        src.delete();
    }


    // 统计文件夹大小
    private static long sizeOf(File src){
        if (src.isFile()){
            return src.length();
        }else {
            long session = 0;
            for (File file : src.listFiles()) {
                session += sizeOf(file);
            }
            return session;
        }
    }
    // 只针对文件夹递归调用该方法:
    // 📌📌第一次调用不能传递文件, 否则报错
    public static long sizeOf_1(File src){
        long size = 0;
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()){
                size += file.length();
            }else {
                size += sizeOf_1(file);
            }
        }
        return size;
    }


    // 查找特定类型的文件
    // 传入文件后缀名, 不带点的  查找.txt文件 -> 第二个参数传入txt
    public static File[] findByType(File src, String target){
        ArrayList<File> list = new ArrayList<>();
        collect(src, list, target);
        return list.toArray(new File[0]);
    }
    private static void collect(File f, ArrayList<File> list, String tar){
        if (f.isFile()){
            if (f.getName().endsWith(tar)){
                list.add(f.getAbsoluteFile());
            }
        }else {
            for (File file : f.listFiles()) {
                collect(file, list, tar);
            }
        }
    }


    // 统计文件夹中不同类型文件的个数, 只依据后缀名
    public static HashMap<String, Integer> typeCount(File src){
        HashMap<String, Integer> res = new HashMap<>();
        count(src, res);
        return res;
    }
    private static void count(File f, HashMap<String, Integer> map){
        if (f.isFile()){
            String[] info = f.getName().split("\\.");
            String type = info.length == 1 ? "无后缀名" : info[info.length - 1];
            if (map.containsKey(type)){
                map.put(type, map.get(type) + 1);
            }else {
                map.put(type, 1);
            }
        }else {
            for (File file : f.listFiles()) {
                count(file, map);
            }
        }
    }
}
