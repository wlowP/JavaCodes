package wlow01._2_calculation;

public class _1_IntVSIntGainInt {
    public static void main(String[] args) {
        //整数与整数运算只能得整数.
        System.out.println(10/3);//3
        System.out.println(10.0/3);//3.3333333333333335
        //也可以 double x = 10.0 再计算.
        System.out.println("好");

        int a = 1;
        a = a / 10; //0
        int b = 1;
        b = b % 10; //1
        System.out.println(a);
        System.out.println(b);
    }
}