package wlow01._11_OOAdvance._4_1_InterfaceExercise;

public class CoachPingpong extends Coach implements SpeakEnglish{
    public CoachPingpong() {
    }

    public CoachPingpong(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("教打乒乓球");
    }

    @Override
    public void eng(){
        System.out.println("乒乓球教练当然会说英语");
    }
}
