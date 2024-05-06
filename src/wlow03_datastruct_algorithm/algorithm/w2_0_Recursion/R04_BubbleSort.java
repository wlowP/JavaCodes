package wlow03_datastruct_algorithm.algorithm.w2_0_Recursion;

import java.util.Arrays;

/**
 * <h2>递归04 - 冒泡排序的递归版</h2>
 */
public class R04_BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 7, 5, 9, 8, 6, 13, 11};

        bubbleSortRecursive(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSortRecursive(int[] arr) {
        bubble(arr, arr.length - 1);
    }

    /**
     * <h3>递归的冒泡排序</h3>
     * 设n为数组长度. <br>
     * 将数组划分为已排序和未排序两个部分. 其中[0, j]是未排序部分, [j + 1, n - 1]是已排序部分 <br>
     * 递推关系:
     * <pre><code>
     *     j = n - 1;
     *     递归:
     *       b(arr, j - 1)    j > 0,
     *       停止             j = 0; (递归出口)
     * </code></pre>
     * 📌📌然而上述递推关系在遇到大部分已有序的数组<code>(2,1,3,4,5,6,7...)</code>时会进行多次不包含交换的不必要递归 <br>
     * 降低效率. 因此考虑设立一个临时变量x, 记录<b>无序右边界的最小值.</b> <br>
     * <b>每当发生交换, 说明至少当前i索引及之前的部分都是未排序的</b> <br>
     * 递推关系1:
     * <pre><code>
     *     j = n - 1;
     *     b(arr, j);
     *     递归:
     *       数组中每发生一次交换, 令x = i.
     *       b(arr, x)                  x > 0,
     *       停止                       x = 0; (递归出口)
     * </code></pre>
     * @param arr 待排序数组
     * @param j 未排序部分的右边界(闭区间)
     */
    private static void bubble(int[] arr, int j) {
        if (j == 0) {
            return;
        }
        int temp;
        int x = 0; // 用来记录当前检测到的未排序部分右边界
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                x = i; // 📌每当发生交换, 说明至少当前i索引及之前的部分都是未排序的
            }
        }
        bubble(arr, x); // 递归区间改为x, 而不是j - 1, 能减少不必要的递归
    }
}
