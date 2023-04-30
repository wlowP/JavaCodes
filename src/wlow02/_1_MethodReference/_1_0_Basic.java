package wlow02._1_MethodReference;

import java.util.Arrays;
import java.util.Comparator;

public class _1_0_Basic {
    public static void main(String[] args) {
        // Arrays.sort方法传递Comparator实现类对象的话, 原数组必须是引用数据类型
        // int[] -> Integer[]
        Integer[] arr = {3, 5, 1, 9, 7, 13, 11};

        // lambda:
        // Arrays.sort(arr, (a, b) -> b - a);

        // 方法引用:
        // 📌表示引用本类里面一个静态方法,
        // 📌把这个方法当做函数接口中抽象方法的方法体
        Arrays.sort(arr, _1_0_Basic::subtract);

        System.out.println(Arrays.toString(arr)); // [13, 11, 9, 7, 5, 3, 1]
    }

    // 📌📌方法引用的形参和返回值要与函数式接口中抽象方法一样.
    public static int subtract(Integer a, Integer b){
        return b - a;
    }
    //Arrays.sort(arr, new Comparator<Integer>() {
    //    @Override
    //    public int compare(Integer o1, Integer o2) {
    //        return o2 - o1;
    //    }
    //});
}
