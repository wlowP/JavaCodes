package wlow03_datastruct_algorithm.algorithm.w2_0_Recursion;

/**
 * <h2>递归01 - 阶乘</h2>
 * 往深层调用叫「递」, 从深层调用返回叫「归」 <br>
 * <b>问题跟其子问题的结构一致, 只有参数不同时</b>, 可以用递归解决. <br>
 * 实现递归的核心就是找出递推关系, 其中包含进一步「递」的条件以及「归」的条件(递归出口)
 */
public class R01_Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(6));
    }

    /**
     * <h3>计算阶乘数. factorial(n) = n! </h3>
     * 递推关系:
     * <pre><code>
     *     f(n) = 1             n = 1, (递归出口)
     *            n * f(n - 1)  n > 1;
     * </code></pre>
     * 执行顺序的伪代码: (以f(3)为例) <br>
     * *仅列出实际运行的部分
     * <pre><code>
     *     f(3) {
     *         return 3 * f(2) {
     *             return 2 * f(1) {
     *                 if (1 == 1) {
     *                     return 1;
     *                 }
     *             }
     *         }
     *     }
     * </code></pre>
     * @param n 阶乘的数目, 是自然数
     * @return 阶乘的结果n!
     */
    public static int factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
