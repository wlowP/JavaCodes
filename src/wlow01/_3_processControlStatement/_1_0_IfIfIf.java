package wlow01._3_processControlStatement;

import java.util.Scanner;

public class _1_0_IfIfIf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("你考了第几名呀~?");
        int rank = sc.nextInt();

        if (rank == 1){
            System.out.println("好好奖励你~❤");
        }
        else{
            System.out.println("shit.");
        }
    }
}
