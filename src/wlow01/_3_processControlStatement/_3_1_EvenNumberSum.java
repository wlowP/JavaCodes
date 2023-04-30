package wlow01._3_processControlStatement;

import java.util.Scanner;
        //数列中寻求偶数求和
public class _3_1_EvenNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("数列中寻求偶数求和, 请输入起始数>");
        int a = sc.nextInt();
        System.out.print("请输入末尾数>");
        int b = sc.nextInt();

        int sum = 0;

        //运用三元运算符.
/*        for(int i = a ; i <= b ; i++ ){
            sum += (i % 2 == 0 ? i : 0);
        }*/

        //也可以用if判断.
        for(int i = a; i <=b ; i++){

            if(i % 2 == 0){
                sum += i;
            }

        }

        System.out.println("求和结果:" + sum);

    //for快捷输入:  [循环次数].fori  比如:100.fori  :
/*        for (int i = 0; i < 100; i++) {

        }    */
    }


}

