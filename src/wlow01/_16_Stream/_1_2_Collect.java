package wlow01._16_Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Stream流的collect方法
public class _1_2_Collect {
    public static void main(String[] args) {
        // collect方法将流中的数据收集到集合中
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "abc-true-123", "qwer-true-666",
                "lol-false-567", "false-true-996", "true-false-777");

        // 收集到List集合中
        // 规则: 收集所有第二部分为true的字符串.
        List<String> list1 = list.stream()
                .filter(str-> "true".equals(str.split("-")[1]))
                .collect(Collectors.toList());
        System.out.println(list1); // [abc-true-123, qwer-true-666, false-true-996]

        // 收集到Set集合中
        // 规则: 收集所有第二部分为false的字符串.
        Set<String> set = list.stream()
                .filter(str -> "false".equals(str.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(set); // [lol-false-567, true-false-777]

        /* 收集到map集合中.
        * 规则: list中字符串的第一部分为键名, 第三部分为键值.
        * 📌📌用toMap方法时要指定键名的规则和键值的规则:
        * 📌📌收集时键名不能重复, 否则报错.
        *
        * toMap的参数一: 键名的生成规则; 参数二: 键值的生成规则
        * 参数里的Function实现类对象:
        *   两个泛型:
        *       泛型一: 从流中取出来的每一个数据的类型
        *       泛型二: 生成的键名/键值的数据类型
        *       (两个泛型可以不考虑, 写成<>)
        *   重写的apply方法:
        *       形参: 从流中取出来的每一个数据. 类型要与泛型一对应
        *       方法体: 生成键名/键值的处理逻辑
        *       返回值: 生成的键名/键值. 类型要与泛型二对应
        * */
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }));
        System.out.println(map); // {abc=123, qwer=666, lol=567, false=996, true=777}

        // 使用lambda:
        Map<String, Integer> map1 = list.stream().collect(Collectors.toMap(
                s -> s.split("-")[0],
                s -> Integer.parseInt(s.split("-")[2])
        ));
        System.out.println(map1); // {abc=123, qwer=666, lol=567, false=996, true=777}
    }
}
