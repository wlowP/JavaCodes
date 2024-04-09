package wlow01_java_basic._11_OOAdvance._4_1_InterfaceExercise;

public class Test {
    public static void main(String[] args) {
        CoachPingpong cp = new CoachPingpong();
        CoachBasketball cb = new CoachBasketball();
        PlayerPingpong pp = new PlayerPingpong();
        PlayerBasketball pb = new PlayerBasketball();

        cp.eng();
        pp.eng();
    }
}
