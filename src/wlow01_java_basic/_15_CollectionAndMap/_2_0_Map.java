package wlow01_java_basic._15_CollectionAndMap;

import java.util.HashMap;
import java.util.Map;

// 双列集合顶层接口Map
public class _2_0_Map {
    public static void main(String[] args) {

        Map<String, String> m = new HashMap<>();

        // 📌📌add方法会返回键名对应的原来的键值. 第一次添加就返回null,
        // 第二次(同键名)添加会覆盖, 返回第一次添加的键值
        System.out.println(m.put("a", "0011")); // null
        System.out.println(m.put("a", "00aa")); // 0011
        m.put("b", "0022");
        m.put("c", "0033");
        System.out.println(m); // {a=00aa, b=0022, c=0033}

        // remove(key)方法返回被删除的键值
        System.out.println(m.remove("c")); // 0033

        System.out.println(m.containsKey("b")); // true
        System.out.println(m.containsValue("0033")); // false

        System.out.println(m.size()); // 2

    }
}
