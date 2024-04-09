package wlow01_java_basic._7_object_oriented._5_StudentSystem;

import java.util.Scanner;

public class StudentTest2 {
            //手动添加学生信息并进行操作.
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student("reisen2022001", 1, "铃仙·优昙华院·因幡", 19);
        Student s2 = new Student("tenshi2022002", 2, "比那名居天子", 18);
        Student s3 = new Student("marisa2022003" , 3 , "雾雨魔理沙" , 18);
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;

        Student s4 = new Student();
        arr[2] = s4;
        System.out.println("请输入学生ID>");
        s4.setId(sc.next());
        System.out.println("请输入学生学号>");
        int tempid = sc.nextInt();
        //*****如果发现一段代码(判断是否与数组中数据重复的)要用到很多次, 就创建方法.
        boolean v = false;
        for (int i = 0; i < arr.length; i++) {
            if (tempid == arr[i].getStuID()){
                v = true;
                break;
            }
        }
        while(v){
            System.out.println("重新输入>");
            tempid = sc.nextInt();
            for (int i = 0; i < arr.length; i++) {
                if (tempid == arr[i].getStuID()){
                    v = true; //*****判断是否重复的过程创建为方法才行.
                              //***如果for没检测到重复, 就在for循环完后把v更新为false.
                    break;    //*****如果for检测到重复, 就把v更新为true, for大括号后面的语句v = false就不用执行了
                }             //*****但是break不能把v = false也终止, 导致v不能有效更新
            }                 //*****方法中的return能终止整个方法范围内的语句, 就能有效解决这个问题, 还能顺便返回布尔值结果
            // v = false;     //*****所以发现某段代码多次使用时或遇到类似问题时就创建方法.

        }
        s4.setStuID(tempid);
        System.out.println(s4.getStuID());


    }

    public static boolean isExistent(Student[] arr , int id){
        for (int i = 0 ; i < arr.length ; i++){
            if (id == arr[i].getStuID()){
                return true;
            }
        }
        return false;
    }
}
