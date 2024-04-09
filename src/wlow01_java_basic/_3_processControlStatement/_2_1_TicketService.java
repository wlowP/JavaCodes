package wlow01_java_basic._3_processControlStatement;

import java.util.Scanner;
        //根据不同输入给出不同回答.
public class _2_1_TicketService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("您好, 欢迎使用航空服务系统, 请输入服务选项:");
        int option = sc.nextInt();

        switch (option) {
            case 1 -> System.out.println("机票查询. ");
            case 2 -> System.out.println("机票预订. ");
            case 3 -> System.out.println("机票改签. ");
            case 4 -> System.out.println("人工服务. 请稍等, 我们为您转接在线客服...");
            default -> System.out.println("退出服务. ");


        }
    }
}
