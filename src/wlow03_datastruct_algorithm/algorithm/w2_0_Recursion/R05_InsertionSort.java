package wlow03_datastruct_algorithm.algorithm.w2_0_Recursion;

import java.util.Arrays;

/**
 * <h2>递归05 - 插入排序递归版</h2>
 */
public class R05_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 7, 5, 9, 8, 6, 13, 11, 19, 12, 12};

        insertionSortRecursive(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSortRecursive(int[] arr) {
        insert(arr, 0);
    }

    /**
     * <h3>递归的插入排序</h3>
     * 设n为数组长度 <br>
     * 初始时认为数组第一个元素的范围是有序的. <br>
     * @param arr 待排序数组
     * @param j 已排序区域的右边界(闭区间)
     */
    private static void insert(int[] arr, int j) {
        if (j == arr.length - 1) {
            return;
        }
        // 不用一直交换, 而是采用寻找合适插入位置的方式. 用交换的话, 每次循环的赋值次数较多
        int temp = arr[j + 1]; // 未排序区域的第一个元素
        int i = j;
        // i去寻找temp的合适插入位置 (从后往前找到第一个比temp小的值)
        while (i >= 0 && arr[i] > temp) {
            // 因为已经有temp缓存了, 直接往前挪就行
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = temp;
        insert(arr, j + 1);
    }
}
