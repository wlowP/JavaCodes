package wlow01._8_string;

import java.util.Scanner;

public class _3_1_NumBlocking {
    //屏蔽电话号码.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入电话号码>"); //11位数.
        String phoneNum = sc.next();

        System.out.println("屏蔽:" + block(phoneNum));

    }


    //部分屏蔽电话号码的方法.
    public static String block(String str){
        String blocked ;

        blocked = str.substring(0 , 3) + "****" + str.substring(7);

        return blocked;
    }
}
