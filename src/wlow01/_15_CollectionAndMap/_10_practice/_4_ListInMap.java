package wlow01._15_CollectionAndMap._10_practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 简单的集合嵌套
public class _4_ListInMap {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        map.put("江苏省", new HashSet<>(Set.of("南京市", "扬州市", "苏州市", "无锡市", "常州市")));
        map.put("湖北省", new HashSet<>(Set.of("武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市")));
        map.put("河北省", new HashSet<>(Set.of("石家庄市", "唐山市", "邢台市", "保定市", "张家口市")));
        System.out.println(map);
    }
}
