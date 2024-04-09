package wlow01_java_basic._5_methods;

import java.util.Scanner;

public class _1_1_ParameterIncluded {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("输入长方形的长和宽>");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        //调用方法calc2:
        calc2(a , b);
    }

    //定义方法calc.
    public static void calc1(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    //可以用含参方法, 也可以用不含参的
    public static void calc2(double m , double n) {
        System.out.println("周长为:" + (m + n)*2);
    }

}
