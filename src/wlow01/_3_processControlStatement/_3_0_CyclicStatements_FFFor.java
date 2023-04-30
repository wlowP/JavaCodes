package wlow01._3_processControlStatement;

import java.util.Scanner;

public class _3_0_CyclicStatements_FFFor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("等差数列求和. 请输入起始数>");
        int a = sc.nextInt();
        System.out.print("请输入末尾数>");
        int b = sc.nextInt();

        //若直接用下面for语句对a进行累加再输出a(详见Demo1)
        //则第一步+=时, a,i 都是输入的初始值, 相当于初始值被累加了两次
        //本来想要1+2+3=6, 结果变成1+1+2+3=7
        //此处新建变量sum=0然后对其累加,输出sum可以解决
        int sum = 0;

        for (int i = a; i <= b; i++ ) {
            sum += i;
        }

        System.out.println("求和结果:" + sum);


    }
}