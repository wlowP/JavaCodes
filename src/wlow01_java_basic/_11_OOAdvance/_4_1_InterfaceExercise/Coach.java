package wlow01_java_basic._11_OOAdvance._4_1_InterfaceExercise;

public abstract class Coach extends Person{
    public Coach() {
    }

    public Coach(String name, int age) {
        super(name, age);
    }

    public abstract void teach();
}
