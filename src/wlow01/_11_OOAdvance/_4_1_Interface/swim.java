package wlow01._11_OOAdvance._4_1_Interface;

            //为部分子类创建的接口.
public interface swim {
    final int A = 9;
    public abstract void swim();
    default void m(){
        System.out.println("JDK8及以后接口中可以定义默认方法(default修饰)");
        m1();
    }
    private void m1(){
        System.out.println("JDK9及以后接口中可定义私有方法");
    }
    static void m2(){
        System.out.println("还能定义静态方法");
    }
}
