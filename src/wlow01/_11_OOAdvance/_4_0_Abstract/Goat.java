package wlow01._11_OOAdvance._4_0_Abstract;

public class Goat extends Animal{
    public Goat() {
    }

    public Goat(String name, int age) {
        super(name, age);
    }

    //抽象类的子类要么也是抽象类要么重写父类中所有抽象方法.
    @Override
    public void eat() {
        System.out.println("吃艹");
    }
}
