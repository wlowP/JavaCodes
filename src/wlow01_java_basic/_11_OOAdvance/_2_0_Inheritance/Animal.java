package wlow01_java_basic._11_OOAdvance._2_0_Inheritance;

public class Animal {
    private int a = 666;
    int b = 12345;

    public int getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

    //爷类()
    public void eat(){
        System.out.println("吃饭饭");
    }
    public void drink(){
        System.out.println("喝水水");
    }
    public static void ss(){
        System.out.println("lol");
    }

}
