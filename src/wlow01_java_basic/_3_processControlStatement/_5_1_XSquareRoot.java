package wlow01_java_basic._3_processControlStatement;

import java.util.Scanner;

public class _5_1_XSquareRoot {
             //***计算一个数的平方根的整数部分.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要计算的数字>");
        double a = sc.nextInt();
        //从1开始循环计算每个数的平方,与目标比较大小得出结果.

        //运用while.
        int i = 0;
        while (i * i <= a) {
            if (i * i == a) {
                break;
            }
            i++;
        }
        if (i * i > a) {
            i -= 1;
        }
        System.out.println(i);

        //运用for. **别忘了break!!
        for (int p = 1; p <= a; p++) {
            if (p * p == a) {
                System.out.println(p);
                break;
            } else if (p * p > a) {
                System.out.println((p - 1));
                break;   //一旦找到了结果, 就可停止循环了, 不用再计算后面数字.
            }

        }

    }
}
