package wlow01_java_basic._3_processControlStatement;

import java.util.Scanner;
            //***不用除号进行除法计算, 那就用多次减法, 减的次数就是商.
public class _4_2_XNoDivisionMark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入被除数>");
        double a = sc.nextInt();
        System.out.println("请输入除数>");
        double b = sc.nextInt();
        int quotient = 0;

        while((a - b) >=0){
            a -= b;
            quotient ++;
        }

        System.out.println("商:" + quotient);
        System.out.println("余数:" + a);

    }
}
