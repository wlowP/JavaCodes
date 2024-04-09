package wlow01_java_basic._15_CollectionAndMap;

import java.util.*;

// 不可变集合.
public class _3_1_Immutable {
    public static void main(String[] args) {
        // List, Set, Map中都有静态的of方法获取不可变的集合
        String[] strs = {"张三", "李四", "王五", "赵六"};

        List<String> list = List.of(strs);
        System.out.println(list); // [张三, 李四, 王五, 赵六]
        //list.add("aa"); // 修改的话会报错: UnsupportedOperationException
                          // remove, set等修改方法也一样报错

        Set<String> set = Set.of(strs);
        System.out.println(set); // [赵六, 张三, 王五, 李四]


        HashMap<Integer, String> map = new HashMap<>(Map.of(1, "张三", 2, "李四"));
        Map<Integer, String> map1 = Map.copyOf(map);
        //map1.put(1, "aa"); // UnsupportedOperationException
    }

}
