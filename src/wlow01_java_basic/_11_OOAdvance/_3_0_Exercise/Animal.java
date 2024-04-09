package wlow01_java_basic._11_OOAdvance._3_0_Exercise;

public class Animal {
    private int age;
    private String color;
    private String type;

    public Animal() {
        super();
    }

    public Animal(int age, String color) {
        this.age = age;
        this.color = color;
    }

    //age.
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //color.
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //type.
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //method:eat.
    public void eat(String sth){
        System.out.println("宠物在吃东西, 美汁汁.");
    }
}
