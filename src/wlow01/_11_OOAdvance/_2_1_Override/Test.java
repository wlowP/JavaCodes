package wlow01._11_OOAdvance._2_1_Override;

public class Test {
    public static void main(String[] args) {
        Huskie h = new Huskie();
        Sharpei s = new Sharpei();
        ChineseDog c = new ChineseDog();

        h.eat();
        s.eat();
        c.eat();
        c.guard();

        System.out.println("----------------------");
    }
}
