package wlow03_datastruct_algorithm.algorithm.w2_0_Recursion;

/**
 * <h2>递归03 - 二分查找的递归版</h2>
 */
public class R03_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 9, 12, 15, 17, 21, 23};

        System.out.println(binarySearchRecursive(arr, 9));
    }

    public static int binarySearchRecursive(int[] arr, int n) {
        return bsr(arr, 0, arr.length - 1, n);
    }

    /**
     * <h3>二分查找递归版.</h3>
     * 递推关系:
     * <pre><code>
     *     m = floor((i + j) / 2);
     *     f(arr, i, j, n) = -1                     i < j,
     *                       m                      arr[m] = n,
     *                       f(arr, m + 1, j, n)    arr[m] < n,
     *                       f(arr, i, m - 1, n)    arr[m] > n;
     * </code></pre>
     * @param arr 待查找的数组
     * @param i 查找左边界(闭区间)
     * @param j 查找右边界(闭区间)
     * @param n 查找的目标值
     * @return 目标值对应的索引或者-1(找不到时)
     */
    private static int bsr(int[] arr, int i, int j, int n) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if (arr[m] > n) {
            return bsr(arr, i, m - 1, n);
        } else if (arr[m] < n) {
            return bsr(arr, m + 1, j, n);
        } else {
            return m;
        }
    }
}
