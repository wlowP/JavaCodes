package wlow01._10_StudentManager;

public class Student {
    private String id;
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //id.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //name.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //age.
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //address.
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //showInfo.
    public void showInfo(){
        System.out.println("id:" + this.id + ", 姓名:" + this.name + ", 年龄:" + this.age + ", 家庭住址:" + this.address);
    }
}
