package wlow01._13_SomeAPI._11_Exercises;

import java.util.Scanner;

        //求斐波那契数列的第n项.
public class _2_FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n:>");
        int n = sc.nextInt();
        //可以用循环:
        int a = 1, b = 1, c = 1;
        for (int i = 0; i < n - 2; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);

        //或者用递归: (比循环慢)
        System.out.println(fibonacciNum(n));
    }


    /*1. 找递归的规律.
    * 2. 找递归的出口:
    *
    * 斐波那契数列规律:
    * f(n) = f(n - 1) + f(n - 2)
    * f(n - 1) = f(n - 2) + f(n - 3)
    * ......
    * 其中f(1) = 1, f(2) = 1. (也就是递归的出口.base case)
    * */
    public static int fibonacciNum(int n){
        if (n == 2 || n == 1){
            return 1;
        }
        return fibonacciNum(n - 1) + fibonacciNum(n - 2);
    }
}
