package wlow03_datastruct_algorithm.algorithm.w2_0_Recursion;

import java.util.Arrays;

/**
 * <h2>递归06 - 斐波那契数列</h2>
 * 递归求通项, 时间复杂度为 θ(1.618^n) 达到了指数级, 因此不太实用<br>
 * 而带备忘机制的方法复杂度降到了 O(n) <br>
 *
 * 有诸多问题其实都是斐波那契数列问题的不同实例 <br>
 *  - 比如兔子生兔子问题, 以及爬楼梯问题
 */
public class R06_Fibonacci {
    public static void main(String[] args) {
        // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...]
        long start = System.currentTimeMillis();
        System.out.println(fibonacci(40));
        System.out.println("recursive: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(fibonacciMemo(40));
        System.out.println("recursive-memo: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(fibonacci1(40));
        System.out.println("non-recursive-memo: " + (System.currentTimeMillis() - start));
    }

     /**
     * <h3>递归计算斐波那契数列的第n项 (索引从0开始, 第0项认为是0)</h3>
     * 递推关系:
     * <pre><code>
     *     f(n) = 0                     n = 0,
     *            1                     n = 1,
     *            f(n - 1) + f(n - 2)   n > 1;
     * </code></pre>
     * <h3>📌多路递归</h3>
     * 在此递归中, 每个递归函数例包含多次自身调用, 这属于<b>多路递归</b> <br>
     * <b>相当于将问题拆分成了多个子问题</b>, 而不是单路递归那样一次次减小问题的数据规模
     * 多路递归的具体执行过程可以画成树结构来直观体现: <br>
     * <b>n路递归 => n叉树</b>
     * <pre><code>
     *     // 以f(4)为例.
     *     f(4)
     *       -- f(3)
     *         -- f(2)
     *           -- f(1)
     *           -- f(0)
     *         -- f(1)
     *       -- f(2)
     *         -- f(1)
     *         -- f(0)
     * </code></pre>
     * 由此还能得出递归调用次数与斐波那契数列的规律: <br>
     *  - 函数调用次数等于树的节点个数, 也等于 <pre>2 * f(n + 1) - 1</pre>
     *  - 再由斐波那契数列的通项公式, 得出时间复杂度为 <pre><b>θ(1.618^n)</b></pre> 达到了指数级复杂度 <br>
     *  -- <b>因为时间复杂度的具体公式已知, 而不是假设最坏/最好情况</b>, 所以直接表示为θ(...)
     * @param n 要获取的项的索引(从0开始)
     * @return 第n项对应的值
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * <h3>带备忘机制(记忆, Memoization)的递归版</h3>
     * 从递归树可看出, 递归版的斐波那契数方法 {@link #fibonacci} 会进行多次重复运算 <br>
     *  - 比如上面f(4)的栗子中f(2)就计算了两遍 <br>
     * 此时可以设立变量来存储之前的运算结果, 然后直接使用. -- 备忘机制 <br>
     * 此技法也称为以空间换时间 <br><br>
     *
     * 此处设立一个长度为n的数组, 用来记录计算出的斐波那契数组中的每一项 <br>
     * 这样以后, 在递归时如果发现数组中已存在计算结果, 直接拿来用, 而不是再计算一次 <br>
     * 显著降低了算法时间复杂度:
     * <h4>θ(1.618^n) => O(n)</h4>
     * @param n 要获取的项的索引(从0开始)
     * @return 第n项对应的值
     */
    public static int fibonacciMemo(int n) {
        int[] fibonacci = new int[n + 1];
        // 还未计算出来的每一项都设置为-1以便递归时判断
        Arrays.fill(fibonacci, -1);
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        return fm(n, fibonacci);
    }

    private static int fm(int n, int[] fibonacci) {
        /*if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }*/
        // 每次递归之前都先看看备忘数组中是否已存在计算结果, 如果有直接反回之
        if (fibonacci[n] != -1) {
            return fibonacci[n];
        }
        /*
        * int a = fm(n - 1, fibonacci);
        * int b = fm(n - 2, fibonacci);
        * fibonacci[n] = a + b;
        * return fibonacci[n];
        * 简写为如下形式:
        * */
        return (fibonacci[n] = fm(n - 1, fibonacci) + fm(n - 2, fibonacci));
    }

    /**
     * <h3>带备忘机制(记忆, Memoization)的非递归版</h3><br>

     * 此处设立三个变量c, a, b, 分别代表斐波那契递推公式: f(n) = f(n - 1) + f(n - 2)中的三项 <br>
     * 每计算出新的一项, 即c = a + b, 就将数据整体往前移动, a中的数据f(n - 1)舍弃, 然后如此循环直到算出f(n)
     * @param n 要获取的项的索引(从0开始)
     * @return 第n项对应的值
     */
    public static int fibonacci1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0, b = 1, c;
            for (int i = 0; i < n - 1; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return b;
        }
    }
}
