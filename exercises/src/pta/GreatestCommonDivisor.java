package pta;

import java.util.Scanner;

// 寻找最大公约数.
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
        //}
    }

    // 获得最大公约数的方法. (欧几里得算法)
    static int gcd(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return b;
    }
}
