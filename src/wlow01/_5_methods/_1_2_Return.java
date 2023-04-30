package wlow01._5_methods;

import java.util.Scanner;

public class _1_2_Return {
    //用return返回方法的运行结果
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个长方形的长和宽>");
        double a1 = sc.nextDouble();
        double b1 = sc.nextDouble();
        System.out.println("请输入第二个长方形的长和宽>");
        double a2 = sc.nextDouble();
        double b2 = sc.nextDouble();

        if (area(a1 , b1) > area(a2 , b2)){
            System.out.println("第一个>第二个");
        }else if(area(a1 , b1) < area(a2 , b2)){
            System.out.println("第一个<第二个");
        }else{
            System.out.println("相等!");
        }
    }


    public static double area(double a , double b){
        double area = a * b;
        return area;
    }
}
