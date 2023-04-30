package wlow01._11_OOAdvance._1_2_UtilAndArrayList;

import java.util.ArrayList;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student s1 = new Student("铃仙·优昙华院·因幡" , 18 , '女');
        Student s2 = new Student("蕾米莉亚·斯卡雷特" , 500 , '女');
        Student s3 = new Student("芙兰朵露·斯卡雷特" , 495 , '女');

        list.add(s1);
        list.add(s2);
        list.add(s3);
        System.out.println("几个学生中最大的年龄是:" + StudentUtil.getEldest(list));
    }
}
