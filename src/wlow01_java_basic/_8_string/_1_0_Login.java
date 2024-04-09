package wlow01_java_basic._8_string;

import java.util.Scanner;

public class _1_0_Login {
            //模拟用户登录系统.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ac = "wlow455";
        String pwd = "lololo2333";


        for (int i = 0, j = 2; i < 3; i++, j--) {
            System.out.println("请输入用户名>");
            String ac1 = sc.next();
            System.out.println("请输入密码>");
            String pwd1 = sc.next();
            if (ac.equals(ac1) && pwd.equals(pwd1)) {
                System.out.println("登录成功!");
                break;
            } else if (i == 2){
                System.out.println("登陆失败!");
            } else {
                System.out.println("用户名或密码错误!登陆失败!请重新输入!您还有" + j + "次机会."); //j 换成2 - i 也行.
            }
        }
    }
}
