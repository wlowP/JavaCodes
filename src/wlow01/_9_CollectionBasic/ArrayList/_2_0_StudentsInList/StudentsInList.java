package wlow01._9_CollectionBasic.ArrayList._2_0_StudentsInList;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentsInList {
            //集合当中添加学生对象并遍历其信息.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();


        for (int i = 0 ; i < 3 ; i++) {
            Student s = new Student();
            System.out.println("输入学生名字:");
            s.setName(sc.next());
            System.out.println("输入学生年龄:");
            s.setAge(sc.nextInt());
            list.add(s);
        }

        for (int i = 0; i < list.size(); i++) {
            Student p = list.get(i);
            System.out.println(p.getName() + ", " + p.getAge());
        }
    }
}
