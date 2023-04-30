package wlow01._15_CollectionAndMap;

import java.util.HashSet;
import java.util.LinkedHashSet;

// LinkedHashSet中的元素保持存取顺序.
public class _1_5_LinkedHashSet {
    public static void main(String[] args) {
        String str1 = "aaa",
               str2 = "bbb",
               str3 = "ccc";

        HashSet<String> hs = new HashSet<>();
        hs.add(str1);hs.add(str2);hs.add(str3);
        System.out.println(hs); // [aaa, ccc, bbb]

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add(str1);lhs.add(str2);lhs.add(str3);
        // 保持了元素存放的顺序.
        System.out.println(lhs); // [aaa, bbb, ccc]
    }
}
