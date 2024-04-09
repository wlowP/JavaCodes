package wlow01_java_basic._11_OOAdvance._4_1_InterfaceExercise;

public class CoachBasketball extends Coach{
    public CoachBasketball() {
    }

    public CoachBasketball(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach(){
        System.out.println("教打篮球");
    }
}
