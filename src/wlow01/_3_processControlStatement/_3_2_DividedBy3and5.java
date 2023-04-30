package wlow01._3_processControlStatement;

import java.util.Scanner;
        //统计一个范围中能同时被3和5整除的数.
public class _3_2_DividedBy3and5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入起始数字>");
        int a = sc.nextInt();
        System.out.print("请输入末尾数字>");
        int b = sc.nextInt();
        int count = 0;

        //运用if判断.
/*        for (int i = a ; i <= b ; i++ ){

            if(i % 3 == 0 && i % 5 == 0){
                count ++;
            }

        }*/

        //也可以运用三元运算符
        for (int i = a ; i <= b ; i++ ){

        count += (i % 3 == 0 && i % 5 == 0 ? 1 : 0 );

        }

        System.out.println(count);

    }
}
