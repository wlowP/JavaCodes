package wlow01_java_basic._8_string;

import java.util.Scanner;

public class _5_4_CalculateByStr {
            //把字符串类型的数字转为int类型的数字再进行乘法运算.(题目真是闲得蛋疼)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入乘数1>");
        String num1 = sc.next();
        while (checkInt(num1)) {
            num1 = sc.next();
        }
        System.out.println("输入乘数2>");
        String num2 = sc.next();
        while (checkInt(num2)) {
            num2 = sc.next();
        }

        System.out.println("计算结果: " + strToInt(num1)*strToInt(num2));

    }


    //判断不合理数据的方法.
    public static boolean checkInt(String num) {
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c < 48 || c > 57) {
                System.out.println("输入不合理!请重新输入>");
                return true;
            }
        }
        return false;
    }


    //字符串数字转换为整数数字的方法.
    public static int strToInt(String num) {
        int theNum = 0;
        //逆序输出, 免去了使用幂次方的语句.
        for (int i = 0; i < num.length(); i++) {
            theNum += num.charAt(i)-48;
            if (i != num.length()-1){
                theNum *= 10;
            }
        }
        return theNum;
    }

}
