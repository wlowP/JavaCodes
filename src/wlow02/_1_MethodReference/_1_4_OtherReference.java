package wlow02._1_MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class _1_4_OtherReference {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("aaa", "bbb", "ccc"));

        // 至少在map方法中, 非static的成员方法如果是空参的就可以这样用类名引用:
        // 相当于让流里面的元素充当该方法的调用者.
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        // AAA \n BBB \n CCC

        // 目标: 将集合流中的数据收集到数组中.
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        // 传统做法:
        /*Integer[] ints = list1.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        System.out.println(Arrays.toString(ints)); // [1, 2, 3, 4, 5]*/

        // 📌引用数组构造方法:
        // stream流的toArray和Collection的toArray都可以引用数组的构造方法
        // 数组的数据类型要和流中的/集合中的数据一致.
        // 省去了写value值和数组长度
        Integer[] ints1 = list1.stream().toArray(Integer[]::new);
        Integer[] ints2 = list1.toArray(Integer[]::new);
        System.out.println(Arrays.toString(ints1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(ints2)); // [1, 2, 3, 4, 5]

    }
}
