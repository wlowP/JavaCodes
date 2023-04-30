package wlow02._1_MethodReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 引用构造方法
public class _1_3_ReferenceConstructor {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "铃仙-18", "博丽灵梦-18", "芙兰朵露-495", "蕾米莉亚-500");

        // 引用构造方法时要注意构造方法的形参必须匹配流中的数据.
        // 📌📌自定义类最好再写一个能匹配的构造方法
        List<Person> newList = list.stream()
                .map(Person::new)
                .toList();
        System.out.println(newList);
        // [Person{name='铃仙', age=18}, Person{name='博丽灵梦', age=18}, Person{name='芙兰朵露', age=495}, Person{name='蕾米莉亚', age=500}]

        /*List<Person> list1 = list.stream()
                .map(str -> {
                    String[] arr = str.split("-");
                    return new Person(arr[0], Integer.parseInt(arr[1]));
                })
                .toList();
        System.out.println(list1);*/
    }
}

class Person {
    private String name;
    private int age;

    // 自定义类默认的全参构造方法的形参跟
    // map形参的Function接口的apply方法的形参不一样, 不符合方法引用的条件
    // 所以要再在自定义类里面写一个形参匹配的构造方法. (构造方法不用考虑返回值)
    // 📌📌给方法引用准备的构造方法:
    public Person(String str){
        String[] arr = str.split("-");
        this.name = arr[0];
        this.age = Integer.parseInt(arr[1]);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}