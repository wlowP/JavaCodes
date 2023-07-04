package test;

import java.io.File;

public class test_2 {
    public static void main(String[] args) {
        // 相对路径从项目根目录开始
        System.out.println(new File("").getAbsolutePath()); // F:\codes\practice\JavaCodes
        method();
    }

    @SuppressWarnings("all")
    static void method(){
        System.out.println("过时方法adadsaads");
    }
}
