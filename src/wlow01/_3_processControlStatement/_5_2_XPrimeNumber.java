package wlow01._3_processControlStatement;

import java.util.Scanner;

public class _5_2_XPrimeNumber {
            //***判断输入的数是不是质数.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要判断的数>");
        int a = sc.nextInt();
        int v = 0;

        //从2开始找, 看什么时候能把目标整除.
        for(int i = 2 ; i < a ; i++ ){
            if( a % i == 0 ){
                System.out.println("no.");
                v ++;
                break;
                //找到了就一定break, 因为后面的数都没必要再判断了.
            }
        }
        if (v == 0){
            System.out.println("yes.");
        }
    }
}
