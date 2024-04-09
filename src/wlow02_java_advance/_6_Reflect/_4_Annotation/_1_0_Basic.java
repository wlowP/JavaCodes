package wlow02_java_advance._6_Reflect._4_Annotation;

public class _1_0_Basic {
    public static void main(String[] args) {
        method();
    }

    // 将方法声明为以弃用
    @Deprecated
    static void method(){
        System.out.println("已经废弃的方法");
    }

    // 忽略任何编译器警告, 包括拼写错误等
    @SuppressWarnings(value = {"all"})
    static void m(){
        System.out.println("qjdhakjwdbnakhdkwjq");
    }
}
