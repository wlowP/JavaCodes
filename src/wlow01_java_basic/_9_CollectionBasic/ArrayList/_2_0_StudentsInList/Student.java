package wlow01_java_basic._9_CollectionBasic.ArrayList._2_0_StudentsInList;

public class Student {
    private String name;
    private int age;

    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
