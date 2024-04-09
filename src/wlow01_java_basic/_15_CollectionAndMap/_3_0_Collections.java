package wlow01_java_basic._15_CollectionAndMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

// 单列集合工具类Collections
public class _3_0_Collections {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("aaa");hs.add("bbb");hs.add("ccc");
        Collections.addAll(hs, "a", "b", "c");
        System.out.println(hs);

        // 自己指定max/min的规则:
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "bb", "ccc", "dddd", "ee");

        System.out.println(Collections.max(list, (a, b)->{
            return a.length() - b.length();
        }));
    }
}
