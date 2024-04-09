package wlow01_java_basic._13_SomeAPI._11_Exercises;

import java.util.Scanner;

        //数列首项为1, 通项公式为f(n) = 2(f(n - 1) + 1).
        //用递归求其第n项.
public class _3_Series {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(series(n));
    }

    //f(1) = 1, f(n) = 2(f(n - 1) + 1).
    public static int series(int n){
        if(n == 1){
            return 1;
        }
        return 2 * (series(n - 1) + 1);
    }
}
