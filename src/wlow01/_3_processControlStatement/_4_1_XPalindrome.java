package wlow01._3_processControlStatement;

import java.util.Scanner;
            //***判断一个数是否为回文数.
public class _4_1_XPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("输入数字>");
        int x = sc.nextInt();
        //x的值后面会被改变, 所以要为其备份:
        int tempx = x;
        int num = 0;

        while(x != 0){
            //从右往左获取每一位数字(个位).
            int ge = x % 10;
            //**获取个位后原来的个位可以整数/10的方式去掉.
            x /= 10;
            //把获取到的个位拼接到新数字上, 从左往右.
            num = num * 10 + ge;
        }
        System.out.println(num);
        System.out.println(num == tempx);

    }
}
