package wlow01._5_methods;

import java.util.Random;
import java.util.Scanner;

public class _2_0_MultiFunctions {
    //多个包含不同功能的方法.
    //***在方法当中引用数组, 数据类型是 : 数组类型[]
    public static void main(String[] args) {
        //先创建数组:
        Random r = new Random();
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1, 21);
        }
        Scanner sc = new Scanner(System.in);

        //1.数组遍历
        traversal(arr);

        //2.找数组中最大值
        //System.out.println("最大值是:" + max(arr));

        //3,判断数组中某个数是否存在
        System.out.println("请输入你认为正确的数>");
        int a = sc.nextInt();
        System.out.println(isExistent(arr, a));

        //4.**数组定点复制
/*        System.out.println("输入复制起点:");
        int from = sc.nextInt() - 1;
        System.out.println("复制终点:");
        int to = sc.nextInt() - 1;
        int[] arr0 = copy(arr , from , to);
        System.out.println("复制的部分:");
        traversal(arr0);*/
    }

    //数组遍历: ***注意如何引用上面创建的数组***
    public static void traversal(int[] arr1) {
        //遍历数组.
        System.out.print("[");
        for (int i = 0; i < arr1.length; i++) {

            if (i < arr1.length - 1) {
                System.out.print(arr1[i] + ", ");
            } else {
                System.out.println(arr1[i] + "]");
            }
        }
    }

    //找数组最大值:
    public static int max(int[] arr2) {
        //找出数组中的最大值.
        int max = arr2[0];
        for (int i = 1; i < arr2.length; i++) {
            max = arr2[i] > max ? arr2[i] : max;
        }
        return max;
    }

    //判断某个数在数组中是否存在(整个数组中):
    public static boolean isExistent(int[] arr, int a) {
        //整个数组中判断某个数在数组中是否存在.
        for (int i = 0; i < arr.length; i++) {
            if (a == arr[i]) {
                return true;
            }
        }
        return false;
    }

    //判断某个数在数组中是否存在(向前检测):
    //(动态初始化数组时检测前面赋予的数据是否重复)
    //b为动态初始化时循环到的i(详见Shuangseqiu)
    public static boolean isExistent(int[] arr , int a , int b){
        //向前判断某个数在数组中是否存在.
        for (int i = 0; i < b; i++) {
            if (a == arr[i]){
                return true;
            }
        }
        return false;
    }

    //数组定点复制:
    public static int[] copy(int[] arr, int from, int to) {
        int[] arr2 = new int[to - from];
        for (int i = from, j = 0; i < to; i++, j++) {
            arr2[j] = arr[i]; // 也可以用 i - from 替换j
        }
        return arr2;
    }

}