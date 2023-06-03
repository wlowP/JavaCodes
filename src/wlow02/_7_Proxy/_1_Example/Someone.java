package wlow02._7_Proxy._1_Example;

// 📌📌代理了这个类的方法的接口都得要实现.
public class Someone implements MyProxy, Activities {
    private final String name;
    public Someone(String name){
        this.name = name;
    }
    @Override
    public String eat(String food){
        System.out.println(name + "在吃" + food);
        return "吃完了";
    }
    @Override
    public void play(String game){
        System.out.println(name + "在玩: " + game);
    }
    @Override
    public void activity(String act) {
        System.out.println(name + "进行了活动: " + act);
    }
    @Override
    public String toString() {
        return "Someone{" +
                "name='" + name + '\'' +
                '}';
    }
}