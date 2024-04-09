package wlow02_java_advance._2_Exception;

import java.util.Arrays;
import java.util.Objects;

public class _1_4_Throw {
    public static void main(String[] args) {
        int[] arr = {3, 5, 12, 2, 8, 19, 31, 24, 17};
        try {
            System.out.println(maxValueOf(arr));
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // 处理异常的流程....
        } finally {
            // finally: 后面的逻辑无论try中有没有异常, 无论异常有没有被catch到都会执行.
            // 异常没捕获到的话, finally能执行, 但是try-catch体系外的语句不能执行了
            System.out.println("无论怎样都会执行这一段");
        }
        System.out.println("try-catch体系以外");

        // 📌📌就算在包含finally的循环中break, finally也还是会执行.
        for (int i = 0; i < 5; i++) {
            try {
                if (i == 3) return;
                System.out.println("循环到: " + i);
            } catch (Exception ignored) {
            } finally {
                System.out.println("就算return了也还是会执行finally, i = " + i);
            }
        }
    }

    // 运行时异常都可以省略, 不需要手动throws声明
    public static int maxValueOf(int[] arr) /*throws NullPointerException, ArrayIndexOutOfBoundsException*/ {
        /*📌如果发现传进来的数据是null, 返回具体数据可能造成歧义
         * 比如求最大值时, 遇到null返回-1, 也许表示最大值就是-1
         * 📌这时候就可以抛出异常, 表示真的遇到异常了
         * 抛出的异常会交给方法的调用处处理, 此时throw下面的语句不执行了
         * */
        if (Objects.isNull(arr)) throw new NullPointerException();
        else if (arr.length == 0) throw new ArrayIndexOutOfBoundsException();

        return Arrays.stream(arr).skip(1).reduce(arr[0], Math::max);
    }
}
