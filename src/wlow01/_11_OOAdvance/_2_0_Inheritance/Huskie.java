package wlow01._11_OOAdvance._2_0_Inheritance;

public class Huskie extends Dog{

    int b = 111;

    public Huskie() {
    }

    public void breakHouse(){
        System.out.println("拆家家");
    }

    @Override
    public void guard() {
        System.out.println("重写了的看家方法");
    }

}
