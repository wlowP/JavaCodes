package wlow01_java_basic._11_OOAdvance._1_0_static;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("aa");
        Student s2 = new Student("bb");
        Student s3 = new Student("cc");

        System.out.println(Student.teacherName); //null
        System.out.println(s1.teacherName); //null
        Student.teacherName = "abc";
        System.out.println(Student.teacherName); //abc
        System.out.println(s1.teacherName); //abc
    }
}
