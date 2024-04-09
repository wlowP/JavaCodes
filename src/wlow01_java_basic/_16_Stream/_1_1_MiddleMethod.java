package wlow01_java_basic._16_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// Stream流的一些中间方法
public class _1_1_MiddleMethod {
    public static void main(String[] args) {

        // filter:
        ArrayList<String> list = new ArrayList<>(List.of("月兔", "美少女", "白兔", "祝福", "变身", "兔子"));
        // filter方法传递Predicate函数式接口的实现类: 返回布尔值表示是否留下元素.
        list.stream().filter(item->item.contains("兔")).forEach(item-> System.out.print(item + " "));// 月兔 白兔 兔子

        System.out.println("\n===========");

        // limit, skip:
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 跳过前四个元素
        Arrays.stream(arr).skip(4).forEach(num-> System.out.print(num + " ")); // 5 6 7 8 9 10
        System.out.println();
        // 只处理前四个元素
        Arrays.stream(arr).limit(4).forEach(num-> System.out.print(num + " ")); //1 2 3 4
        System.out.println();
        // 组合拳: 在数组中间一部分找偶数
        Arrays.stream(arr).skip(3).limit(3).filter(num-> num % 2 == 0).forEach(num-> System.out.print(num + " ")); // 4 6

        System.out.println("\n===========");

        // distinct去重. 📌📌记得自定义对象一定重写equals和hashCode方法.
        String[] strs = {"a", "b", "c", "a", "a", "b"};
        Arrays.stream(strs).distinct().forEach(str-> System.out.print(str + " ")); // a b c

        System.out.println("\n===========");

        // Stream.concat: 流的拼接合并:
        ArrayList<String> list1 = new ArrayList<>(List.of("aa", "bb", "cc", "dd"));
        Stream<String> stream1 = list.stream().limit(3);
        Stream<String> stream2 = list1.stream().skip(2);
        Stream.concat(stream1, stream2).forEach(s-> System.out.print(s + " ")); // 月兔 美少女 白兔 cc dd

        System.out.println("\n===========");

        // Map方法: 用法大致同JavaScript的数组map方法, 只是函数式接口的方法只能传递一个参数.
        String str = "key1=value1&key2=value2&key3=value3";
        Arrays.stream(str.split("&")).map(s -> s.split("="))
                .forEach(a-> System.out.print(Arrays.toString(a) + " "));
        // [key1, value1] [key2, value2] [key3, value3]

        // flatMap方法: 用map处理完后将高维数组降一维, 但是映射结果一定要是一个流对象(ary-> Arrays.stream(ary)):
        Integer[][] arr2 = {{1, 2}, {3, 4}};
        Integer[] res2 = Arrays.stream(arr2)
                .flatMap(ary-> Arrays.stream(ary))
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(res2)); // [1, 2, 3, 4]

        // flatMap栗子2:
        String[] arr1 = {"Hello", "World"};
        List<String[]> res = Arrays.stream(arr1)
                .map(s -> s.split(""))
                .toList();
        for (String[] ary : res) {
            System.out.println(Arrays.toString(ary));
        } // [ [H, e, l, l, o], [W, o, r, l, d] ], 二维数组

        List<String> res1 = Arrays.stream(arr1)
                .map(s -> s.split(""))
                .flatMap(strs1 -> Arrays.stream(strs1).map(s -> s + "!"))
                .toList();
        System.out.println(res1);
        // [H!, e!, l!, l!, o!, W!, o!, r!, l!, d!] 一维数组


    }
}
