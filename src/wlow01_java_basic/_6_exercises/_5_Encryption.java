package wlow01_java_basic._6_exercises;

import java.util.Scanner;

public class _5_Encryption {
            //把输入的一串数字进行加密:每一位数先加5后对10取余, 得到的余数拼接起来并且反转排列
            //1983 -> 8346   6438
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要加密的原始密码>");
        int pwd1 = sc.nextInt();

        int pwd2 = 0;
        while (pwd1 != 0) {
            int ge = pwd1 % 10;
            pwd1 /= 10;
            ge = (ge + 5) % 10;
            pwd2 = pwd2 * 10 + ge;
        }
        System.out.println("加密后的密码:" + pwd2);

        System.out.println("解密:" + Decryption(pwd2));

    }

    //解密.
    public static int Decryption(int pwd2) {
        int pwd1 = 0;
        while (pwd2 != 0) {
            int ge = pwd2 % 10;
            pwd2 /= 10;
            ge = (ge + 5) % 10;
            pwd1 = pwd1 * 10 + ge;
        }
        return pwd1;
    }
}
