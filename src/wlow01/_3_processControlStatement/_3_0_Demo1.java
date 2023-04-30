package wlow01._3_processControlStatement;

import java.util.Scanner;

public class _3_0_Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("等差数列求和, 请输入起始数>");
        int a = sc.nextInt();
        System.out.print("请输入末尾数>");
        int b = sc.nextInt();
        //int c = a;   //1.可以用新变量c把最初的a复制一份,最后输出结果的时候减去
        for(int i = a; i <= b ; i++ ){a += i;}
        //2.或者这样也可以解决问题:
        //for(int i = a; i < b ; i++ , a += i){}

        System.out.println("求和结果:" + a);
    }
}
