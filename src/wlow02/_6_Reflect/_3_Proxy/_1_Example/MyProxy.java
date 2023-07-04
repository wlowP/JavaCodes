package wlow02._6_Reflect._3_Proxy._1_Example;

// 把所有需要被代理的方法定义在接口中, 然后让目标类实现接口
public interface MyProxy {
    // 默认都是抽象方法
    String eat(String food);
    void play(String game);
}