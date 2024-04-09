package wlow01_java_basic._11_OOAdvance._2_0_Inheritance;


public class Test {
    public static void main(String[] args) {
        Huskie h = new Huskie();
        System.out.println(h.getA());
        h.breakHouse();
        h.eat();
        System.out.println(h.b);

        System.out.println("===========");

        Dog dog = new Huskie();
        System.out.println(dog.b);
        System.out.println(((Huskie)dog).b);
        dog.guard();

    }
}
