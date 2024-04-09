package wlow01_java_basic._3_processControlStatement;

import java.util.Random;
import java.util.Scanner;

public class _5_3_RandomNumGuess {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int n = r.nextInt(1,10);

        for(int i = 0; i < 3 ;i ++){
            System.out.println("请输入你认为正确的数字>");
            int m = sc.nextInt();
            if (m > n){
                System.out.println("大了!");
            }else if (m < n){
                System.out.println("小了!");
            }else {
                System.out.println("恭喜你猜对了!");
                break;
            }

        }
        //三次保底机制...
        System.out.println("看不下去...就当你猜对了把~");
    }
}
