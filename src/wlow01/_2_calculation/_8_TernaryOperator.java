package wlow01._2_calculation;

import java.util.Scanner;

public class _8_TernaryOperator {
    public static void main(String[] args) {
        //三元运算符用来判断数据是否相同(略)
        //用来比较多个数的最大值
        Scanner sc = new Scanner(System.in);
        System.out.println("第一个数:");
        int a = sc.nextInt();
        System.out.println("第二个数:");
        int b = sc.nextInt();
        System.out.println("第三个数:");
        int c = sc.nextInt();

        int c1 = a > b ? a : b;
        int c2 = c1 > c ? c1 : c;


        System.out.println(c2);

    }
}
