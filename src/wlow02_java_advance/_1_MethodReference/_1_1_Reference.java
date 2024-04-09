package wlow02_java_advance._1_MethodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1_1_Reference {
    public static void main(String[] args) {
        // 引用静态方法(以Integer.parseInt方法为例)
        ArrayList<String> list = new ArrayList<>(List.of("11", "22", "33"));
        // 将字符串转换为整数
        List<Integer> integers = list.stream().map(Integer::parseInt).toList();
        System.out.println(integers); // [11, 22, 33], 但是是整数集合

        // 引用成员方法
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,
                "1234-a01",
                "666-aa",
                "11-b23",
                "996-abc"
        );
        // 规则: 保留所有第二部分开头为a且长度为3的字符串
        Assessor assessor = new Assessor(); // 📌📌一定先创建对象
        list1.stream().filter(assessor::decide).forEach(System.out::println);
        //1234-a01 \n 996-abc
    }
}

class Assessor {
    final int MAX_LENGTH = 3;
    public Assessor() {}
    public boolean decide(String str) {
        String s = str.split("-")[1];
        return s.startsWith("a") && s.length() == MAX_LENGTH;
    }
}
