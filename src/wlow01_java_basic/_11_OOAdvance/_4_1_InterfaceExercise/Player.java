package wlow01_java_basic._11_OOAdvance._4_1_InterfaceExercise;

public abstract class Player extends Person{
    public Player() {
    }

    public Player(String name, int age) {
        super(name, age);
    }

    public abstract void learn();
}
