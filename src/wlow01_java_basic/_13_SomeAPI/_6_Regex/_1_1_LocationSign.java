package wlow01_java_basic._13_SomeAPI._6_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 正则表达式的定位符 ^ $ \b \B
public class _1_1_LocationSign {
    public static void main(String[] args) {
        // 开头和结尾定位符 ^ $
        // regex要求: 开头至少一个数字, 一定以小写字母结尾.
        Pattern pat = Pattern.compile("^\\d+[a-z]+");
        Pattern pat1 = Pattern.compile("^\\d+[a-z]+$");
        String str = "123abc123";
        Matcher m = pat.matcher(str);
        while (m.find()){
            System.out.println(m.group(0)); // 123abc
        }
        Matcher m1 = pat1.matcher(str);
        while (m1.find()){
            System.out.println(m1.group(0)); // 不会匹配
        }

        // 边界定位符 \\b \\B
        // 📌📌字符串的开头/结尾也可以被\\b匹配📌📌
        String str1 = "1xx23 xx123 xx 123xx xx";
        String res = str1.replaceAll("xx\\b", "__");
        String res1 = str1.replaceAll("xx\\B", "__");
        String res2 = str1.replaceAll("\\bxx", "__");
        String res3 = str1.replaceAll("\\Bxx", "__");
        String res4 = str1.replaceAll("\\bxx\\b", "__");
        String res5 = str1.replaceAll("\\Bxx\\B", "__");
        System.out.println(res);  // 1xx23 xx123 __ 123__ __
        System.out.println(res1); // 1__23 __123 xx 123xx xx
        System.out.println(res2); // 1xx23 __123 __ 123xx __
        System.out.println(res3); // 1__23 xx123 xx 123__ xx
        System.out.println(res4); // 1xx23 xx123 __ 123xx __
        System.out.println(res5); // 1__23 xx123 xx 123xx xx
    }
}
