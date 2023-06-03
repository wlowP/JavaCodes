package wlow02._7_Proxy._1_Example;

public class Someone implements MyProxy, Activities {
    private String name;
    public Someone(){}
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
        System.out.println(name + "在玩" + game);
    }
    @Override
    public void activity(String act) {
        System.out.println(name + "进行了活动: " + act);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Someone{" +
                "name='" + name + '\'' +
                '}';
    }
}