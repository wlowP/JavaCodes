package wlow01._15_CollectionAndMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Map集合的遍历方式.
public class _2_1_Map_Traverse {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();

        m.put("aa", "0011");
        m.put("bb", "0022");
        m.put("cc", "0033");
        m.put("dd", "0044");
        m.put("ee", "0055");

        // 1.键找值: 先获取所有键名, 然后通过get方法获得键值
        Set<String> keys = m.keySet();
        System.out.println(keys); // [aa, bb, cc, dd, ee]
        keys.forEach(key -> System.out.println(key + "=" + m.get(key)));

        // 2.直接获得每一个键值对对象(Entry对象), 再获得键名和键值.
        // 📌📌Entry是Map类里的内部接口, 所以要用"."调用
        // 不想写"Map."的话就导包: import java.util.Map.Entry;
        Set<Map.Entry<String, String>> entries = m.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
        }

        // 3.Lambda表达式遍历:
/*        m.forEach(new BiConsumer<String, String>() {
            @Override // accept第一个参数是键名, 第二个是键值.
            public void accept(String s, String s2) {
                System.out.println(s + "=" + s2);
            }
        });*/
        m.forEach((a, b)-> System.out.println(a + "=" + b));
    }
}