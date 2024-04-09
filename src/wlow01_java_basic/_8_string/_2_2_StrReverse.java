package wlow01_java_basic._8_string;

import java.util.Scanner;

public class _2_2_StrReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串>");
        String str = sc.next();
        //*****直接反着遍历字符串不好吗为什么要转为数组哇...
        char[] arr = string2Arr(str);

        arrReverse(arr);

        System.out.println("乾坤大挪移:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        //*****直接用forr反着遍历字符串::
        System.out.println("");
        System.out.println(reverse(str));
    }



    //将字符串转换为数组.
    public static char[] string2Arr(String str){
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    //数组反转.
    public static void arrReverse(char[] arr){
        if (arr == null){
            System.out.println("不能为空!");
        }else{
            for (int i = 0; i < arr.length - i - 1; i++) {
                char temp = arr[i];
                arr[i] = arr[arr.length - i -1];
                arr[arr.length - i -1] = temp;
            }
        }
    }

    //*****也可以用forr 直接反着遍历:
    public static String reverse(String str){
        //***空白字符串用于接收结果.
        String a = "";
        for (int i = str.length() -1; i >= 0; i--) {
            a += str.charAt(i);
        }
        return a;
    }

}
