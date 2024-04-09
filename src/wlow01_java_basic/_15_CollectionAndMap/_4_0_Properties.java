package wlow01_java_basic._15_CollectionAndMap;

import java.io.*;
import java.util.Properties;

// 常用于操作.properties配置文件的Properties映射集合
public class _4_0_Properties {
    public static void main(String[] args) throws IOException {
        // Properties集合没有泛型, 键和值可以添加任意类型数据, 但一般只加字符串.
        Properties prop = new Properties();
        prop.put("aaa", "111");
        prop.put("bbb", "222");
        prop.put("ccc", "333");
        prop.put("ddd", "444");
        System.out.println(prop);

/*        // 跟IO流相关的方法: 存储, 读取外部文件:
        BufferedWriter bw = new BufferedWriter(new FileWriter("IOPractice/configFiles/config1.properties"));
        // 存储: store方法
        // 第一个参数传递字节流或字符流, 第二个参数传递对应.properties文件中的注释
        prop.store(bw, "test");*/

        // 读取: load方法(实例方法)
        // 传递字节流或字符流读取对应.properties文件到相应对象中
        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream("IOPractice/configFiles/config1.properties"));
        Properties prop1 = new Properties();
        prop1.load(bis);
        System.out.println(prop1); // {aaa=111, ccc=333, bbb=222, ddd=444}
    }
}
