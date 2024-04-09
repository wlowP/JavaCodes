package wlow01_java_basic._15_CollectionAndMap;

import java.util.Map;
import java.util.TreeMap;

// TreeMap可根据键名对Entry进行排序
public class _2_4_TreeMap {
    public static void main(String[] args) {
        // 传入Comparator实现类对象比较, 可用Lambda
        TreeMap<Integer, String> goods = new TreeMap<>((a, b)->a - b);
        goods.put(1, "aa");
        goods.put(7, "bb");
        goods.put(3, "cc");
        goods.put(5, "dd");
        goods.put(2, "ee");
        System.out.println(goods);

        // 键名存储自定义对象.
        // 自定义类必须实现Comparable接口
        TreeMap<Someone, String> tm = new TreeMap<>();
        tm.put(new Someone("zhangsan", 21), "广东");
        tm.put(new Someone("lisi", 18), "广西");
        tm.put(new Someone("wangwu", 19), "山东");
        tm.put(new Someone("zhaoliu", 18), "山西");
        tm.put(new Someone("reisen", 22), "月之都");

        for (Map.Entry<Someone, String> sb : tm.entrySet()) {
            System.out.println(sb);
        }

        // 统计字符串中各字符出现的次数
        String str = "lifuhaaacdbbcadbcadbsilh,'.;]'[';/p[];l.//',filnlkjwdliuansjdasnadknj";
        TreeMap<Character, Integer> tmp = new TreeMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (tmp.containsKey(c)){
                tmp.put(c, tmp.get(c) + 1);
            }else{
                tmp.put(c, 1);
            }
        }
        System.out.println(tmp);
    }
}

class Someone implements Comparable<Someone>{
    private String name;
    private int age;

    public Someone() {
    }
    public Someone(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "Somebody{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(Someone o) {
        int d = age - o.age;
        if (d != 0) {
            return d;
        } else{
            return name.compareTo(o.name);
        }
    }
}