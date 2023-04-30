package wlow01._16_Stream;

import java.util.Arrays;

// reduce方法.
public class _1_2_EndMethod1 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        // 只传递一个累积器函数的reduce方法会返回OptionalInt对象, 用getAsInt方法获得int数据
        // 整数流中也有一个sum()方法直接返回对应的int类型结果. Arrays.stream(arr).sum();
        int res = Arrays.stream(arr).reduce((a, b) -> {
            // 原理: 回调函数的第一个形参a, 第二个形参b表示流里面轮流到的每个数据
            // 每次运算完后, 运算结果(返回值)合并为a, 然后a, b继续往后流, 直到流结束
            System.out.println("left: " + a + ", right: " + b);
            return a + b;
        }).getAsInt();
        System.out.println(res); // 15

        // reduce方法第一个参数还可以是累积的初始值.
        // 传两个参数的reduce返回的就是int类型的结果
        int res1 = Arrays.stream(arr).reduce(10, Integer::sum);
        System.out.println(res1); // 25

        // 寻找最大值:
        int[] arr1 = {2, 4, 7, 1, 8, 19, 10, 12, 31, 18, 22};
        int res2 = Arrays.stream(arr1).reduce(Math::max).getAsInt();
        System.out.println(res2); // 31



        String[] arr2 = {"aaa", "bbb", "ccc"};
        // 流中是字符串时, reduce有一个三个参数的重载, 跟多线程有关.
        // (字符串)只传递一个累积器的reduce会返回Optional<String>类型的对象, 用get方法获取String值
        String res3 = Arrays.stream(arr2).reduce((a, b)->a + b).get();
        System.out.println(res3); // aaabbbccc

        // 两个参数的reduce返回String类型的结果.
        String res4 = Arrays.stream(arr2).reduce("start", (a, b)->a + b);
        System.out.println(res4); // startaaabbbccc
    }
}
