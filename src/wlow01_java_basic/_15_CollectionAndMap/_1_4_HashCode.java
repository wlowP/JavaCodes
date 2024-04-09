package wlow01_java_basic._15_CollectionAndMap;

import java.util.Objects;

// 哈希值
public class _1_4_HashCode {
    public static void main(String[] args) {
        somebody s1 = new somebody("zhangsan", 18);
        somebody s2 = new somebody("zhangsan", 18);

/*        // 不重写hashCode方法的话哈希值默认用地址值计算. 一般不会发生哈希碰撞.
        System.out.println(s1.hashCode() + "\n" + s2.hashCode());
        // (没有重写hashCode方法的情况下):
        // 1096979270
        // 1078694789*/

        System.out.println(s1.hashCode() + "\n" + s2.hashCode()); // 都是 -1461067297

        // 字符串本身重写了hashCode方法.
        // 哈希碰撞:
        System.out.println("abc".hashCode() + "\n" + "acD".hashCode()); // 96354
    }
}

class somebody{
    private String name;
    private int age;
    public somebody(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        somebody somebody = (somebody) o;
        return age == somebody.age && Objects.equals(name, somebody.name);
    }

    // 重写hashCode方法
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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
}