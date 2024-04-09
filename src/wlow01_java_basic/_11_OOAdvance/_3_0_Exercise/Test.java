package wlow01_java_basic._11_OOAdvance._3_0_Exercise;

public class Test {
    public static void main(String[] args) {
        Animal d = new Dog(2 , "黑颜色");
        Animal c = new Cat(3 , "灰颜色");
        Cat ca = (Cat) new Animal();
        Feeder f1 = new Feeder("老王" , 30);
        Feeder f2 = new Feeder("老李" , 25);

        f1.keepPet(d , "骨头");
        f2.keepPet(c , "鱼");

    }
}
