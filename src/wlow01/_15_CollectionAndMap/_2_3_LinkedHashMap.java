package wlow01._15_CollectionAndMap;

import java.util.HashMap;
import java.util.LinkedHashMap;

// LinkedHashMap保证存取顺序一致.
public class _2_3_LinkedHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("zhangsan", 18);
        hm.put("lisi", 19);
        hm.put("wangwu", 20);
        hm.put("zhaoliu", 21);
        System.out.println(hm); // {lisi=19, zhaoliu=21, zhangsan=18, wangwu=20}

        // 📌📌存入和取出元素的顺序一致.
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("zhangsan", 18);
        lhm.put("lisi", 19);
        lhm.put("wangwu", 20);
        lhm.put("zhaoliu", 21);
        System.out.println(lhm); // {zhangsan=18, lisi=19, wangwu=20, zhaoliu=21}
    }
}
