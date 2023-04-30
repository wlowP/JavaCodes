package wlow01._4_array;

import java.util.Scanner;

public class _2_5_IntToArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数:");
        int num = sc.nextInt();
        int length = 0;
        int tempnum = num;

        while(num != 0){
            num /= 10;
            length ++ ;
        }
        num = tempnum;

        int[] arr1 = new int[length];
        for (int i = arr1.length - 1; i >= 0; i--) {
            int ge = num % 10;
            num /= 10;
            arr1[i] = ge;
        }

        System.out.print("[");
        for (int i = 0; i < arr1.length; i++) {

            if(i < arr1.length - 1) {
                System.out.print(arr1[i] + ", ");
            }else{
                System.out.println(arr1[i] + "]");
            }
        }
    }
}
