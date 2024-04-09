package wlow01_java_basic._6_exercises;

import java.util.Random;
import java.util.Scanner;

public class _3_VerificationCode {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入验证码长度>");
        int e = sc.nextInt();
        for (int i = 0; i <= e; i++) {

            if (i == e - 1) {
                System.out.print(r.nextInt(0, 10));
                break;
            }

            int p = r.nextInt(1, 3);
            char a;
            if (p == 1) {
                a = (char) (r.nextInt(65, 91));

            } else {
                a = (char) (r.nextInt(97, 123));

            }
            System.out.print(a);


        }


    }
}
