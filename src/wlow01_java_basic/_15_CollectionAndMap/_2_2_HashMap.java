package wlow01_java_basic._15_CollectionAndMap;

import java.util.HashMap;
import java.util.Objects;

// 键名里面存自定义对象
public class _2_2_HashMap {
    public static void main(String[] args) {
        HashMap<Student1, String> hm = new HashMap<>();
        hm.put(new Student1("张三", 18), "广东");
        hm.put(new Student1("张三", 18), "广西");
        hm.put(new Student1("李四", 19), "湖北");
        hm.put(new Student1("王五", 20), "山东");
        hm.forEach((k, v)->{
            System.out.println(k + "=" + v);
        });
    }
}

class Student1{
    private String name;
    private int age;
    public Student1(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Student1(){}

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student = (Student1) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}