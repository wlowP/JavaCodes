package wlow01._15_CollectionAndMap._10_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _6_ArrayToMap {
    public static void main(String[] args){
        ArrayList<Integer> keys = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<String> values = new ArrayList<>(List.of("张三", "李四", "王五"));

        Map<Integer, String> map = Map.ofEntries(toEntries(keys, values));

        System.out.println(map);
    }

    public static<K, V> Map.Entry<K, V>[] toEntries(ArrayList<K> keys, ArrayList<V> values){
        if (values.size() > keys.size()) {
            System.out.println("键值多于键名!");
            return new Map.Entry[0];
        }
        ArrayList<Map.Entry<K, V>> entries = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            entries.add(Map.entry(keys.get(i), values.get(i)));
        }
        return entries.toArray(new Map.Entry[0]);
    }
}
