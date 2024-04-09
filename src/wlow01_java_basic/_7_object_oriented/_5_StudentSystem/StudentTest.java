package wlow01_java_basic._7_object_oriented._5_StudentSystem;

import java.util.Objects;
import java.util.Scanner;

public class StudentTest {
             //手动添加学生信息并进行操作.
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student("reisen001", 1, "铃仙·优昙华院·因幡", 19);
        Student s2 = new Student("tenshi002", 2, "比那名居天子", 18);
        //Student s3 = new Student("marisa003", 3, "雾雨魔理沙", 18);
        arr[0] = s1;
        arr[1] = s2;
        //arr[2] = s3;

        Student[] arr1 = null;
        if (isFull(arr)) {
            //创建新数组复制老数组来等效实现数组长度动态改变.
            arr1 = new Student[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                arr1[i] = arr[i];
            }
        }

        Student[] thearr = isFull(arr) ? arr1 : arr;

        //创建新的学生对象.
        Student s4 = new Student();
        thearr[isFull(arr) ? arr.length : arr.length - 1] = s4;

        //添加学生信息.
        System.out.println("请输入学生ID>");
        s4.setId(sc.next());
        System.out.println("请输入学生学号>");

        //检测学号是否与已有的重复.
        int tempid = sc.nextInt();
        //*****如果发现一段代码(判断是否与数组中数据重复的)要用到很多次, 就创建方法.
        //*****详见StudentTest2, L36~L41
        while (isExistent(thearr, tempid)) {
            System.out.println("此学号已存在!请重新输入>");
            tempid = sc.nextInt();
            isExistent(arr, tempid);
        }
        s4.setStuID(tempid);

        System.out.println("请输入学生名字>");
        s4.setName(sc.next());
        System.out.println("请输入学生年龄>");
        s4.setAge(sc.nextInt());

        traversal(thearr);

        //查找并删除学生信息.
        System.out.println("请输入您要删除的学生的ID>");
        String Delid = sc.next();
        if (isExistent(thearr, Delid)) {
            System.out.println("已成功删除!");
        } else {
            System.out.println("无法匹配!删除失败!");
        }
        traversal(thearr);

        //对指定学生的信息进行操作.
        System.out.println("请输入要增加年龄的学生的ID>");
        String ageplus = sc.next();
        if (ageplus(thearr, ageplus)) {
            System.out.println("操作成功!");
        } else {
            System.out.println("无法匹配, 操作失败!");
        }
    }


    //判断数组中某元素是否与输入的重复的方法.
    public static boolean isExistent(Student[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            if (id == arr[i].getStuID()) {
                return true;
            }
        }
        return false;
    }

    //方法重载.
    public static boolean isExistent(Student[] arr, String id) {
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(id, arr[i].getId())) {
                arr[i] = null;
                return true;
            }
        }
        return false;
    }

    //遍历对象数组的方法.
    public static void traversal(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            System.out.println("学生ID:" + arr[i].getId() + ", 学号:" + arr[i].getStuID() + ", 名字:" + arr[i].getName() + ", 年龄:" + arr[i].getAge());
        }
    }

    //操作数组内对象属性的方法.
    public static boolean ageplus(Student[] arr, String id) {
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(id, arr[i].getId())) {
                arr[i].setAge(arr[i].getAge() + 1);
                System.out.println("操作后年龄:" + arr[i].getAge());
                return true;
            }
        }
        return false;
    }

    //判断对象数组有没有存满的方法.
    public static boolean isFull(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return false;
            }
        }
        return true;
    }
}
