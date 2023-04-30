package wlow01._11_OOAdvance._4_1_Interface;

public class Fish extends Animals implements swim{
    public Fish() {
    }

    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("鱼吃饲料");
    }

    @Override
    public void swim(){
        System.out.println("鱼当然会游泳");
    }

}
