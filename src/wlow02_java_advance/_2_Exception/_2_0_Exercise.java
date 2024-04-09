package wlow02_java_advance._2_Exception;

import java.util.Scanner;

// 输入姓名和年龄, 要求: 姓名长度[3, 10], 年龄[18, 40]
public class _2_0_Exercise {
    public static void main(String[] args) {
        // 输入格式: 姓名-年龄
        Scanner sc = new Scanner(System.in);
        girlfriend gf = new girlfriend();

        while (true) {
            try {
                System.out.println("输入女朋友的姓名>");
                gf.setName(sc.nextLine());
                System.out.println("输入女朋友的年龄>");
                gf.setAge(Integer.parseInt(sc.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.err.println("年龄格式有误!");
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(gf);
    }
}

class girlfriend {
    private String name;
    private int age;

    public girlfriend() {
    }

    public girlfriend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int l;
        if ((l = name.length()) < 3 || l > 10)
            throw new RuntimeException("姓名长度不符合范围!");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 40)
            throw new RuntimeException("年龄不符合范围!");
        this.age = age;
    }

    public String toString() {
        return "girlfriend{name = " + name + ", age = " + age + "}";
    }
}