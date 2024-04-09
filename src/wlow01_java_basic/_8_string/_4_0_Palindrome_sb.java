package wlow01_java_basic._8_string;

import java.util.Scanner;

public class _4_0_Palindrome_sb {
            //判断输入的字符串是否为回文.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要判断的内容>");

        StringBuilder sb = new StringBuilder();
        sb.append(sc.next());
        //链式编程.
        boolean v = sb.toString().equals(sb.reverse().toString());
        System.out.println(v);
    }
}
