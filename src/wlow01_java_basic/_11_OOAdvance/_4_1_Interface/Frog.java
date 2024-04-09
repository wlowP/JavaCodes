package wlow01_java_basic._11_OOAdvance._4_1_Interface;

public class Frog extends Animals implements swim{
    public Frog() {
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃虫子");
    }

    @Override
    public void swim() {
        System.out.println("青蛙会蛙泳");
    }

    void ala(){
        System.out.println("nanana");
    }
}
