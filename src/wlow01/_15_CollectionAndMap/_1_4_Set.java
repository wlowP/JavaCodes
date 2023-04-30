package wlow01._15_CollectionAndMap;

import java.util.*;

// Set集合
public class _1_4_Set {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // 继承自Collection顶级接口的方法
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");
        set.add("123");

        boolean res = set.add("aaa");

        System.out.println(set); // [aaa, ccc, 123, bbb, ddd]
        System.out.println(res); // false

        // 三种遍历方式
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + ", ");
        }
        System.out.println();

        for (String s : set) {
            System.out.print(s + ", ");
        }
        System.out.println();

        set.forEach(s -> System.out.print(s + ", "));
        System.out.println();

        // 利用Set实现数组去重:
        // Set构造方法可以传递Collection的所有子实现类
        String[] strings = {"aa", "bb", "cc", "cc", "123", "123"};
        // List.of(arr)或者Arrays.asList(arr)都将数组转为List类型的
        Set<String> set1 = new HashSet<>(Arrays.asList(strings));
        //Set<String> set1 = new HashSet<>(List.of(strings));
        System.out.println(set1);
    }
}
