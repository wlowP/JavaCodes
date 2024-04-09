package wlow01_java_basic._8_string;

import java.util.Scanner;
import java.util.StringJoiner;

public class _5_0_RomanNum {
            //将键盘录入的数字字符串转化为罗马数字字符串.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要转换的数字>");
        String num = sc.next();
        //检测不合理数据.
        while (!checkStr(num)){
            System.out.println("输入不合法!请重新输入>");
            num = sc.next();
        }
        //利用StringJoiner拼接结果.
        StringJoiner sj = new StringJoiner(", " , "[" , "]");
        System.out.println("转换结果:");
        for (int i = 0; i < num.length(); i++) {
            String v = Ara2Rome(num.charAt(i));
            sj.add(v);
        }
        System.out.println(sj.toString());
    }



    //检查不合理数据的方法.
    public static boolean checkStr(String str){
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > '9' || c < '0'){  //*****不要再写 c >= 57 || c <= 48 了!!!!!
                return false;
            }
        }
        return true;
    }
    //数字转换的方法.利用ASCII值加减进行转化.
    public static String Ara2Rome(char m){
        String[] rome = {" " , "I" , "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        int n = m - 48;
        return rome[n];
    }
}
