package wlow01._2_calculation;

import java.util.Scanner;

public class _6_0_CompareOperator {
    public static void main(String[] args) {
        //int a = 10;
        //int b = 10;
        //int c = 100;
        //System.out.println(a==b); -->true
        //System.out.println(a==c); -->false

        //键盘录入 + 比较大小.
        Scanner sc = new Scanner(System.in);
        System.out.print("输入a:");
        int a = sc.nextInt();
        System.out.print("输入b:");
        int b = sc.nextInt();
        boolean V = a > b;
        System.out.println(V);

    }
}
