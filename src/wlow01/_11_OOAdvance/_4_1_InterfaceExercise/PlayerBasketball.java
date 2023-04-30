package wlow01._11_OOAdvance._4_1_InterfaceExercise;

public class PlayerBasketball extends Player{

    public PlayerBasketball() {
    }

    public PlayerBasketball(String name, int age) {
        super(name, age);
    }

    @Override
    public void learn() {
        System.out.println("学两年半的篮球");
    }
}
