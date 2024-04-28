package wlow03_datastruct_algorithm.algorithm;

/*
* 二分查找及其各种优化
* - 时间复杂度: O(log(n))
* - 空间复杂度: O(1)
* */
public class _0_0_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 9, 11, 17, 23, 50, 68, 89, 102};
        int[] arrDuplicated = {1, 2, 4, 7, 9, 9, 9, 11, 17, 23, 50, 68, 68, 68, 89, 102};

        System.out.println("binarySearchBasic: " + binarySearchBasic(arr, 51));

        System.out.println("binarySearchLeftMost1: " + binarySearchLeftMost1(arrDuplicated, 5));
        System.out.println("binarySearchRightMost1: " + binarySearchRightMost1(arrDuplicated, 5));

        /*
        * 一些应用场景:
        *      n存在于数组中时, 用一般的边界查找(找不到时返回-1)即可; n不存在时, 使用带后缀1的方法
        *   - 求一个数n在有序数组中的排名(从小到大, 📌索引从1开始) ==> leftmost(n) + 1
        *   -- 以下应用都是默认数组的索引从0开始:
        *   - 求n的左邻居(前任) ==> leftmost(n) - 1
        *   - 求n的右邻居(后任) ==> rightmost(n) + 1
        *   - 求n的近邻 ==> 左邻居和右邻居中与n绝对值之差较小者
        *   - 求数组中大于x小于y的索引范围 ==> [rightmost(x) + 1, leftmost(y) - 1]
        * */
    }

    /**
     * 二分查找基本版 <p>
     *   1. 设置两个指针i = 0, j = n - 1 <p>
     *   2. 如果i > j, 说明没找到, 结束查找, 返回-1 <p>
     *   3. 令m = floor((i + j) / 2) <p>
     *   4. 如果arr[m] > n, 令j = m - 1, 并跳到第2步 <p>
     *   5. 如果arr[m] < n, 令i = m + 1, 并跳到第2步 <p>
     *   6. 如果arr[m] = n, 说明找到了, 结束查找, 返回m <p>
     *
     * Java.utils.Arrays中的二分查找也是使用的基本版, 只不过查找失败时返回-(i + 1): {@link java.util.Arrays#binarySearch(int[], int)} <p>
     * - 📌查找失败时, i的值比较特殊. 如果要将n插入arr中并保持有序, 则要插入的索引位置就是查找失败时i的值. <p>
     * - 所以查找失败时可以返回 -i, 但是要跟 -0 区分开来, 于是返回 -(i + 1)
     * - 如果不关心是否找到, 只需要插入元素的话, 直接返回i即可
     * @param arr 数组 arr(0 : n-1), 📌已有序
     * @param n 要查找的数n
     * @return n对应的索引. 不存在时返回-1
     */
    public static int binarySearchBasic(int[] arr, int n) {
        int i = 0, j = arr.length - 1, m;
        // i = j时, m = i = j也还要再跟n比较一下 => i, j所指向的元素也会参与比较
        while(i <= j) {
            // 📌这里用无符号右移一位而不是 / 2, 防止i, j过大(> 2^31-1)导致运算溢出
            // >> 是算术(有符号)移位, >>> 是逻辑(无符号)移位
            // 📌当i + j超出了2^31-1(int正数上限), 在底层32位二进制代码中首位符号位就会溢出变成1, Java将其当做一个负数. 但此时若将其看做无符号整数, 就是正确的结果, 所以采取无符号右移的方式来除以2
            m = (i + j) >>> 1;
            if (n < arr[m]) {
                j = m - 1;
            } else if (arr[m] < n) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * binarySearchBasic的左闭右开区间版本 <p>
     *  - 上面的binarySearchBasic中的指针i, j指向的都是需要参与比较的元素, 故为'左右闭区间' <p>
     *  - 而在此处, i仍然指向需要比较的元素, 但j指向的是不需要参与比较的元素, 是'左闭右开区间' <p>
     *  - 所以要明确指针i, j的含义, 才能更好地逻辑证明
     *  - 📌于是循环条件变成了i < j, 因为当i = j的时候显然↑上述条件↑不成立, 应当结束查找了 <p>
     *  - 并且m的值直接赋给j, 因为比较过的元素在下一轮不需要比较了 <p>
     */
    public static int binarySearchBasic1(int[] arr, int n) {
        int i = 0, j = arr.length, m;
        while(i < j) {
            m = (i + j) >>> 1;
            if (n < arr[m]) {
                j = m;
            } else if (arr[m] < n) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 二分查找的平衡版. <p>
     *  - 上面的二分查找在查找数组最左侧元素和最右侧元素时比较次数不平衡: <p>
     *  -- 📌查找最左侧元素时只需比较n < arr[m], 而查找最右侧元素时还需再比较arr[m] < n, 比较次数翻倍了 <p>
     *  - 通过将相等的比较移到循环外侧来平衡查找次数. <p>
     *  - 但是此时算法最好情况下的复杂度会增为O(log(n)), 于是算法的复杂度可记为Θ(log(n)) <p>
     */
    public static int binarySearchBalanced(int[] arr, int n) {
        // 左闭右开区间: i指向查找目标, j指向的不是查找目标
        int i = 0, j = arr.length, m;
        while (j - i > 1) {
            m = (i + j) >>> 1;
            if (n < arr[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        // 将相等的比较移到循环外侧以平衡查找次数
        return arr[i] == n ? i : -1;
    }

    /**
     *  二分查找: 查找重复元素时, 返回其第一次出现的索引
     *   - 未找到时返回-1
     */
    public static int binarySearchLeftMost(int[] arr, int n) {
        int i = 0, j = arr.length - 1, m;
        int firstIndex = -1; // 重复值第一次出现的可能索引位置
        while (i <= j) {
            m = (i + j) >>> 1;
            if (n < arr[m]) {
                j = m - 1;
            } else if (n > arr[m]) {
                i = m + 1;
            } else {
                firstIndex = m;
                // 这一步处理跟n < arr[m]分支一样, 也就是将arr[m]视作大于n, 据此才能找到n出现的第一个位置
                j = m - 1; // 这里要求数组必须升序排列
            }
        }
        return firstIndex;
    }

    /**
     *  二分查找: 查找重复元素时, 返回其最后一次出现的索引 <p>
     *   - 未找到时返回-1
     *  代码跟 {{@link #binarySearchLeftMost(int[], int)}} 对称
     */
    public static int binarySearchRightMost(int[] arr, int n) {
        int i = 0, j = arr.length - 1, m;
        int lastIndex = -1;
        while (i <= j) {
            m = (i + j) >>> 1;
            if (n > arr[m]) {
                i = m + 1;
            } else if (n < arr[m]) {
                j = m - 1;
            } else {
                lastIndex = m;
                i = m + 1;
            }
        }
        return lastIndex;
    }


    /**
     *  二分查找 {{@link #binarySearchLeftMost(int[], int)}} 的改版: <br>
     *   - 其实就是在其基础上删去firstIndex变量, 合并if分支得来 <br>
     *   - 查找重复元素时, 返回其第一次出现的索引值. 没找到时返回的是>=n的最小(最靠左)数字索引 (插入位置) <br>
     *   - 📌无法判断查找是否成功, 适合仅需往数组中有序插入元素时使用 (在返回值对应的索引之前插入)
     */
    public static int binarySearchLeftMost1(int[] arr, int n) {
        int i = 0, j = arr.length - 1, m;
        while (i <= j) {
            m = (i + j) >>> 1;
            if (n <= arr[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        // 直接return i, 所以无法判断是否查找到对应元素
        return i;
    }

    /**
     * 同理, 二分查找 {{@link #binarySearchRightMost(int[], int)}} 的改版. <br>
     *   - 查找重复元素时, 返回其第一次出现的索引值. 没找到时返回的是<=n的最大(最靠右)数字的索引 (插入位置) <br>
     *   - 📌无法判断查找是否成功, 适合仅需往数组中有序插入元素时使用 (在返回值对应的索引之后插入)
     */
    public static int binarySearchRightMost1(int[] arr, int n) {
        int i = 0, j = arr.length - 1, m;
        while (i <= j) {
            m = (i + j) >>> 1;
            if (n < arr[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return j;
    }


    /**
     * leftmost和rightmost的结合版本. 传入参数lower决定使用哪种
     *  - lower = true -> leftmost; false -> rightmost
     *  -- lower为true时跟 {@link #binarySearchLeftMost(int[], int)} 基本一样, 只是index = m这一步会多执行几次
     *  -- lower为false时与 {@link #binarySearchRightMost(int[], int)} 有区别, 区别就是index是从右往左逼近目标的.
     */
    public int binarySearchLR(int[] arr, int n, boolean lower) {
        int i = 0, j = arr.length - 1, m;
        int index = arr.length;
        while (i <= j) {
            m = (i + j) / 2;
            if (arr[m] > n || (lower && arr[m] >= n)) {
                j = m - 1;
                index = m;
            } else {
                i = m + 1;
            }
        }
        return index;
    }
}
