package wlow01_java_basic._11_OOAdvance._2_2_Staff;

public class Staff {
    private String id;
    private String name;
    private int salary;

    public Staff() {
    }

    public Staff(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void eat(){
        System.out.println("干饭力");
    }
    public void work(){
        System.out.println("当个打工人");
    }

}
