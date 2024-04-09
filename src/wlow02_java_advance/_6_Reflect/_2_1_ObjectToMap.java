package wlow02_java_advance._6_Reflect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// 将一个对象转为Map或IO流输出
public class _2_1_ObjectToMap {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        Collections.addAll(list,
                new Person("王德发", 19, "男"),
                new Person("韩大狗", 18, "男"),
                new Person("翠花", 19, "女"),
                new Student("小明", "202300001", 18, "xiaoming@123.com"),
                new Student("小红", "202300002", 19, "xh@123456.com")
        );
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("IOPractice/reflectObjects.txt", true));
            for (Object o : list) {
                System.out.println(objToMap(o));
                writeObj(bw, o);
            }
            bw.close();
        } catch (IllegalAccessException | IOException e) {
            System.err.println("转化出错");
        }
    }

    // 用字段反射获取字段名和值, 再放到Map里面
    public static Map objToMap(Object o) throws IllegalAccessException {
        Map<String, Object> m = new HashMap<>();
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            m.put(f.getName(), f.get(o));
        }
        return m;
    }

    // 用反射获取信息并写到文本文件里面
    public static void writeObj(BufferedWriter bw, Object o) throws IllegalAccessException, IOException {
        bw.write("{");
        bw.newLine();
        Field f;
        Field[] fields = o.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            f = fields[i];
            f.setAccessible(true);
            bw.write(String.format("\t%s=%s", f.getName(), f.get(o)));
            if (i != fields.length - 1)
                bw.newLine();
        }
        bw.newLine();
        bw.write("}");
        bw.newLine();
        bw.flush();
    }
}

class Student{
    private String name;
    private String num;
    private int age;
    private String email;

    public Student(){}

    public Student(String name, String num, int age, String email) {
        this.name = name;
        this.num = num;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void lazy(){
        System.out.println("摸鱼");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}