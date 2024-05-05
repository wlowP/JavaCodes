package wlow03_datastruct_algorithm.algorithm.w2_0_Recursion;

/**
 * <h2>递归02 - 反向打印字符串</h2>
 */
public class R02_ReverseString {
    public static void main(String[] args) {
        reverseString("1234567890");
    }

    public static void reverseString(String str) {
        reverse(str, 0, str.length());
    }

    /**
     * <h3>反向打印字符串.</h3>
     * 递推关系:
     * <pre><code>
     *     f(n) = 停止       n = 字符串长度,
     *            f(n + 1)  0 <= n <= 字符串长度;
     * </code></pre>
     * 执行顺序的伪代码: (以r("abc")为例)
     * <pre><code>
     *     r("abc", 0, 3) {
     *         r("abc", 1, 3) {
     *             r("abc", 2, 3) {
     *                 r("abc", 3, 3) {
     *                     if (3 == 3) {
     *                         return;
     *                     }
     *                 }
     *                 打印第2个字符c
     *             }
     *             打印第1个字符b
     *         }
     *         打印第0个字符a
     *     }
     * </code></pre>
     * @param str 字符串
     * @param index 递归的开始索引 (倒序打印的终点)
     * @param length 字符串长度
     */
    private static void reverse(String str, int index, int length) {
        if (index == length) {
            return;
        }
        reverse(str, index + 1, length);
        System.out.print(str.charAt(index));
    }
}
