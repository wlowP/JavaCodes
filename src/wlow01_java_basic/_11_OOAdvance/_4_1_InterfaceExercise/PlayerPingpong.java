package wlow01_java_basic._11_OOAdvance._4_1_InterfaceExercise;

public class PlayerPingpong extends Player implements SpeakEnglish{
    public PlayerPingpong() {
    }

    public PlayerPingpong(String name, int age) {
        super(name, age);
    }

    @Override
    public void learn(){
        System.out.println("学打乒乓球");
    }

    @Override
    public void eng(){
        System.out.println("乒乓球运动员也要会说英语");
    }
}
