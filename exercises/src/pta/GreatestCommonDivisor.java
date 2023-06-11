package pta;

import java.util.Scanner;

// 寻找最大公约数. 使用更相减损法, 辗转相除法
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        // 输入两个整数, 打印出其最大公约数和最小公倍数.
        // 📌📌最小公倍数 = 两数乘积 / 最大公约数, 所以只要找到最大公约数就好了.
        Scanner sc = new Scanner(System.in);
        int a, b, div;
        //while (sc.hasNextInt()){
        a = sc.nextInt();
        b = sc.nextInt();
        div = gcd(a, b);
        System.out.printf("%d %d\n", div, a * b / div);
        System.out.println(gcd1(a, b));
        System.out.println(gcd2(a, b));
        //}
    }

    // 获得最大公约数的方法. (欧几里得算法)
    // "更相减损法"
    static int gcd(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return b;
    }

    // 辗转相除法(自己写的循环版)
    static int gcd1(int a, int b){
        int remainder = a % b; // 记录余数
        if (remainder == 0) return Math.min(a, b); // a, b刚好整除的情况
        while (remainder != 0){
            remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    // 辗转相除法(递归版)
    static int gcd2(int a, int b){
        if (b == 0) return a;
        return gcd2(b, a % b);
    }
}
