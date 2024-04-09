package wlow01_java_basic._4_array;

import java.util.Scanner;

public class _2_4_Series {
            //自定义等比数列.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数列首项>");
        int start = sc.nextInt();
        while(start == 0){
            System.out.println("不能为0! 请重新输入!");
            start = sc.nextInt();
        }
        System.out.println("请输入数列公比>");
        int r = sc.nextInt();
        System.out.println("请输入数列项数>");
        int length = sc.nextInt();

        int[] ser = new int[length];
        ser[0] = start;

        for (int i = 1; i < length; i++) {
            ser[i] = ser[i - 1]*2;
        }

        System.out.println("数列结果:");
        System.out.print("[");
        for (int i = 0; i < ser.length; i++) {

            if (i == ser.length - 1){
                System.out.println(ser[length - 1] + "]");
            }else{
                System.out.print(ser[i] + " ");
            }

        }

    }
}
