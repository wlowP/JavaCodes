package wlow01._14_Algorithms;


import java.util.Random;

//实现一些排序的算法.
public class _2_Sort {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        long s = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(System.currentTimeMillis() - s);
    }

    //冒泡排序. (从小到大)
    public static void bubbleSort(int[] arr){
        int a, b;
        for (int n = arr.length - 1; n > 0; n--){
            for (int i = 0; i < n; i++) {
                a = arr[i];
                b = arr[i + 1];
                if(a > b){
                    arr[i] = b;
                    arr[i + 1] = a;
                }
            }
        }
    }

    //选择排序. (从小到大)
    public static void selectionSort(int[] arr){
        int a, b;
        for(int n = 0; n < arr.length - 1; n++){
            for(int i = 0; i < arr.length - 1 - n; i++){
                a = arr[n];
                b = arr[n + i + 1];
                if(b < a){
                    arr[n] = b;
                    arr[n + i + 1] = a;
                }
            }
        }
    }

    //插入排序. (从小到大)
    public static void insertSort(int[] arr){
        int temp, j, startIndex = -1;
        //先找到无序部分的起始索引.
        for (int i = 0; i < arr.length; i++) {
            if(arr[i + 1] < arr[i]){
                startIndex = i + 1;
                break;
            }
        }
        for (int i = startIndex; i < arr.length; i++) {
            j = i;
            while (j > 0 && arr[j] < arr[j - 1]){
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    //快速排序.
    public static void quickSort(int[] arr, int i, int j){
        int start = i, end = j, temp;
        if (start > end){
            return;
        }
        //base 的初始化要写在递归出口之后, 否则索引会越界.
        int base = arr[i];
        while (start != end){
            while (start < end && arr[end] >= base){
                end--;
            }
            while (start < end && arr[start] <= base){
                start++;
            }
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;

        //*****分成两部分分别再次进行快速排序. 使用递归.
        quickSort(arr, i, start - 1);
        quickSort(arr, start + 1, j);
    }
}
