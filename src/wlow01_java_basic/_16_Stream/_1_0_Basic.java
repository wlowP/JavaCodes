package wlow01_java_basic._16_Stream;

import java.util.*;
import java.util.stream.Stream;

// Stream流的基本获取
public class _1_0_Basic {
    public static void main(String[] args) {
        // 单列集合
        ArrayList<String> list = new ArrayList<>(List.of("aaa", "amp", "sic", "quio", "qwer", "xwa", "http"));
        // 获取到一条流水线. 集合中的数据会放到流水线上.
/*        Stream<String> stream = list.stream();
        stream.forEach(item-> System.out.println(item));*/
        list.stream().forEach(item-> System.out.print(item + " ")); // aaa amp sic quio qwer xwa http

        System.out.println("\n=========");

        // 双列集合
        HashMap<Integer, String> map = new HashMap<>(Map.of(1, "a", 2, "b", 3, "c"));
        map.keySet().stream().forEach(key-> System.out.print(map.get(key) + " ")); // a b c

        System.out.println("\n=========");

        // 数组, 要传递给Arrays工具类的stream方法:
        int[] arr = {1, 3, 5, 7, 9};
        Arrays.stream(arr).forEach(num-> System.out.print(num + " ")); // 1 3 5 7 9

        System.out.println("\n=========");

        // 零散数据: 用Stream的静态方法of
        Stream.of("aa", "bb", "cc").forEach(str-> System.out.print(str + " ")); // aa bb cc
        // 📌📌可变参数也可以用于数组, 但必须是引用数据类型的数组
        // 如果是基本数据的数组, 是不会自动装箱的, 直接把整个数组当做一个数据, 打印的话得到地址值
        Stream.of(arr).forEach(num-> System.out.println(num)); // #%$^#%#$地址值
    }
}
