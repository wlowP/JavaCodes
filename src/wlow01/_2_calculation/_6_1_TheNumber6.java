package wlow01._2_calculation;

import java.util.Scanner;

public class _6_1_TheNumber6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你认为正确的两个数:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        //三个条件满足其一即可,则用两个"||"
        boolean V = num1 == 6 || num2 == 6  || (num1 + num2) % 6 == 0;
        System.out.println(V);

    }
}
