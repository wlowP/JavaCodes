package wlow01_java_basic._15_CollectionAndMap;

import java.util.TreeSet;

// TreeSet集合, 其中元素有序排列.
public class _1_6_TreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(3);ts.add(8);ts.add(1);ts.add(32);ts.add(0);

        System.out.println(ts);
/*        // 遍历方式
        ts.forEach((item)-> System.out.println(item));
        for (Integer num : ts) {
            System.out.println(num);
        }*/

        // TreeSet排序:
        // 1.利用默认自然排序(排序的类须要实现Comparable接口)
        TreeSet<Student> stu = new TreeSet<>();
        // 对自定义类型数据进行排序. 📌注意自定义类要实现Comparable接口.
        stu.add(new Student("zhangsan", 18));
        stu.add(new Student("lisi", 22));
        stu.add(new Student("wangwu", 21));
        System.out.println(stu);
        // [Student{name='zhangsan', age=18}, Student{name='wangwu', age=21}, Student{name='lisi', age=22}]

        // 2.TreeSet构造方法传递Comparator实现类对象, 可用Lambda表达式:
        // 字符串排序为例: 按照长度从小到大排序, 如果一样长则按照字母排序
/*        TreeSet<String> ts1 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 按照长度排序
                int i = o1.length() - o2.length();
                // 如果长度一样则按照字母排序. String本身实现了Comparable接口.
                i = i == 0 ? o1.compareTo(o2) : i;
                return i;
            }
        });*/
        TreeSet<String> ts1 = new TreeSet<>(((o1, o2) -> {
            int i = o1.length() - o2.length();
            i = i == 0 ? o1.compareTo(o2) : i;
            return i;
        }));
        ts1.add("qwer");ts1.add("ab");ts1.add("dfa");ts1.add("daf");ts1.add("p");
        System.out.println(ts1); // [p, ab, daf, dfa, qwer]
    }
}

// 自定义类要想在TreeSet里面自然排序, 一定要实现Comparable接口.
class Student implements Comparable<Student> {
    private String name;
    private int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Student o) {
        // 根据年龄, 从小到大排列
        return this.age - o.age;
    }
    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}