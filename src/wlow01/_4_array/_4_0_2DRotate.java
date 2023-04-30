package wlow01._4_array;

import java.util.Scanner;

public class _4_0_2DRotate {
    //二维数组旋转.
    //读入2个整数m和n（<=20），作为图片的长宽尺寸。输入1个整数r，作为旋转角度（只能输入90 180 -90中的一个，90表示图形向左旋转90度，-90表示图形向右旋转90度）。然后按照行列输入图片像素值
    //输入样例:
    //3 4
    //90
    //1 2 3 4
    //5 6 7 8
    //9 10 11 12
    //输出样例:
    //4 8 12
    //3 7 11
    //2 6 10
    //1 5 9
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = checkInt(sc.next()), n = checkInt(sc.next()), angle = checkInt(sc.next());
        if(angle != 90 && angle != 180 && angle != -90){
            System.out.println("angle data error");
            System.exit(0);
        }
        int[] arr = new int[m * n];
        int i = 0;
        while(sc.hasNext()){
            int num = checkInt(sc.next());
            if(num < 0 || num > 255){
                System.out.println("matrix data error");
                return;
            }
            arr[i] = num;
            i++;
        }
        switch(angle){
            case 90 : {
                show(ninety(arr, m, n, 90));
                break;
            }
            case -90 : {
                show(ninety(arr, m, n, -90));
                break;
            }
            case 180 : {
                show(reverse(arr, m, n));
                break;
            }
        }
    }

    public static int checkInt(String str){
        if(!str.matches("-?\\d+")){
            System.out.println("data type error");
            System.exit(0);
            return 0;
        }else{
            return Integer.parseInt(str);
        }
    }

    public static void show(int[][] arr){
        for(int i1 = 0; i1 < arr.length; i1++){
            for(int i2 = 0; i2 < arr[i1].length; i2++){
                if(i2 == 0){
                    System.out.print(arr[i1][i2]);
                    continue;
                }
                System.out.print(" " + arr[i1][i2]);
            }
            System.out.println();
        }
    }

    public static int[][] ninety(int[] arr0, int m, int n, int angle){
        int[][] arr = new int[n][m];
        if(angle == -90){
            for(int i = 0; i < arr0.length; i++){
                arr[i % n][m - 1 - (i / n)] = arr0[i];
            }
        }else if(angle == 90){
            for(int i = 0; i < arr0.length; i++){
                arr[n - 1 - (i % n)][i / n] = arr0[i];
            }
        }
        return arr;
    }

    public static int[][] reverse(int[] arr0, int m, int n){
        int[][] arr = new int[m][n];
        for(int i = 0; i < arr0.length; i++){
            arr[m - 1 - (i / n)][n - 1 - (i % n)] = arr0[i];
        }
        return arr;
    }
}
