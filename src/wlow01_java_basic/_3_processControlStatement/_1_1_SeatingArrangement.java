package wlow01_java_basic._3_processControlStatement;

import java.util.Scanner;

public class _1_1_SeatingArrangement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("您的票号是?");
        int num = sc.nextInt();

        if (num >= 1 && num <=100) {
            if (num % 2 == 0){
                System.out.println("亲您的座位在右侧哟~");
            }else{
                System.out.println("亲您的座位在左侧哟~");
            }
        }else{
            System.out.println("亲是不是输错了?再看看呀");
        }

        //还有 else if, 记得else后面要带空格.


    }
}
