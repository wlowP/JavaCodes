package wlow01._11_OOAdvance._4_0_Abstract;

public class Test {
    public static void main(String[] args) {
        //用Animal多态创建对象也行.
        Frog f = new Frog("小宝" , 5);
        System.out.println(f.getName() + ", " + f.getAge());

        f.eat();
        f.drink();
    }
}
