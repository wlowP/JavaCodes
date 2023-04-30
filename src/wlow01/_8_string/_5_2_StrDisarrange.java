package wlow01._8_string;

import java.util.Random;
import java.util.Scanner;

public class _5_2_StrDisarrange {
            //键盘录入一个字符串然后将其打乱并输出结果.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要打乱的字符串>");
        String say = sc.nextLine();
/*        while(say == null){
            System.out.println("不能为空!请重新输入>");
            say = sc.next();
        }*/
        System.out.println("使用混沌魔力:");
        System.out.println(StrDisarrange(say));

    }

    public static String StrDisarrange(String str){
        Random r = new Random();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int ranIndex = r.nextInt(arr.length);
            char temp = arr[i];
            arr[i] = arr[ranIndex];
            arr[ranIndex] = temp;
        }
        return new String(arr);
    }
}
