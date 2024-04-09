package wlow01_java_basic._11_OOAdvance._3_0_Exercise;

public class Cat extends Animal{
    private String type = "猫咪";
    public Cat() {
    }

    public Cat(int age, String color) {
        super(age, color);
        //this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    //method: mouse
    public void catchMouse(){
        System.out.println("猫咪在抓老鼠");
    }

    @Override
    public void eat(String sth) {
        System.out.println(getAge() + "岁的" + getColor() + "的猫咪眯着眼睛侧着头吃" + sth);
    }
}
