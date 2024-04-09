package wlow01_java_basic._11_OOAdvance._1_0_static;

public class Student {
    private String name;
    //静态变量被所有创建的对象共享.
    static String teacherName;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public String getName(Student this) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
