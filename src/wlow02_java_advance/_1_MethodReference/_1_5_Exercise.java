package wlow02_java_advance._1_MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _1_5_Exercise {
    public static void main(String[] args) {
        ArrayList<String> info = new ArrayList<>();
        Collections.addAll(info,
                "zhangsan-18",
                "lisi-19",
                "wangwu-20",
                "zhaoliu-21"
        );
        Someone[] people = info.stream().map(Someone::new).toArray(Someone[]::new);
        System.out.println(Arrays.toString(people));

        String[] names = Arrays.stream(people).map(Someone::getName).toArray(String[]::new);
        System.out.println(Arrays.toString(names));
    }
}

class Someone {
    private String name;
    private int age;

    // 用于方法引用的构造方法
    public Someone(String str) {
        String[] s = str.split("-");
        this.name = s[0];
        this.age = Integer.parseInt(s[1]);
    }

    @Override
    public String toString() {
        return "Someone{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}