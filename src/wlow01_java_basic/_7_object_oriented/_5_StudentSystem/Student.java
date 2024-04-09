package wlow01_java_basic._7_object_oriented._5_StudentSystem;

public class Student {
    private String id;
    private int StuID;
    private String name;
    private int age;

    public Student() {}

    public Student(String id, int stuID, String name, int age) {
        this.id = id;
        this.StuID = stuID;
        this.name = name;
        this.age = age;
    }

    //id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //学号
    public int getStuID() {
        return StuID;
    }

    public void setStuID(int stuID) {
        StuID = stuID;
    }

    //名字
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //年龄
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
