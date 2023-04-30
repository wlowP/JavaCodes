package wlow01._11_OOAdvance._3_0_Exercise;

public class Feeder {
    private String name;
    private int age;

    public Feeder(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Feeder() {
    }

    //name.
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

    public void keepPet(Animal a , String food){
        System.out.println("年龄为" + age + "岁的" + name + "养了一只" + a.getColor() + "的" + a.getAge() + "岁的" + a.getType());
        a.eat(food);
    }
}
