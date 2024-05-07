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
     * 然后逐个为无序范围内的元素寻找在有序范围内的正确插入位置, 然后进行插入操作. <br>
     * 虽然可以用二分查找来找到这个插入位置, <b>但是移动元素仍然需要O(n^2)的复杂度, 不会改变总的复杂度</b>
     * 递推关系:
     * <pre><code>
     *     j = 0;
     *     i(arr, j);
     *     递归:
     *     i(arr, j + 1)                            j < n - 1,
     *      - 将第j + 2个元素插入到有序区间的正确位置
     *     停止                                     j = n - 1;
     * </code></pre>
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
