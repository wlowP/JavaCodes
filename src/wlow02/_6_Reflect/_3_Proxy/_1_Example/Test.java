package wlow02._6_Reflect._3_Proxy._1_Example;

// 演示动态代理: 在无侵入式修改(不修改源代码)的情况下给方法补充新功能
public class Test {
    public static void main(String[] args) {
        // 通过代理来访问对象的步骤:
        Someone so = new Someone("Reisen");

        // 🔖1. 先获取到代理的对象
        MyProxy proxy = ProxyUtil.createProxy(so);

        // 🔖2. 然后通过代理对象来调用方法
        String res = proxy.eat("胡萝卜");
        System.out.println(res);
        proxy.play("東方紺珠伝　～ Legacy of Lunatic Kingdom.");

        // 📌📌注意这个代理是属于MyProxy类型的, 用到别的接口的代理方法时得先强转.
        ((Activities)proxy).activity("出门采药");
    }
}
