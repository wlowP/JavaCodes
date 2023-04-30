package wlow02._4_MultiThread._3_practice;


import java.util.ArrayList;

// 五个线程抢红包:
public class _2_LuckyMoney {
    public static void main(String[] args) {
        Person p1 = new Person("张三"),
               p2 = new Person("李四"),
               p3 = new Person("王五"),
               p4 = new Person("赵六"),
               p5 = new Person("孙七");
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}

class Person extends Thread{
    static final int AVAILABLE_COUNT = 3; // 有几个人能抢到红包
    static double moneyPool = 500.0; // 红包总金额
    static int count = 0; // 已经抢了红包的人(线程)的个数

    // 用权重表来随机将moneyPool划分
    static ArrayList<Integer> weights = new ArrayList<>(); // 抽奖的权重表
    static int totalWeight = 0;
    static {
        int w;
        for (int i = 0; i < AVAILABLE_COUNT; i++) {
            w = (int)(Math.random() * 100 + 1);
            weights.add(w);
            totalWeight += w;
        }
    }

    public Person(String name){
        super(name);
    }
    @Override
    public void run() {
        synchronized (Person.class){
            if (count < AVAILABLE_COUNT){
                double bonus = (weights.remove(0) * 1.0 / totalWeight) * moneyPool;
                System.out.printf("%s抢到了: %.2f元!\n", getName(), bonus);
                count ++;
            }else{
                System.out.println("很遗憾, " + getName() + "没抢到");
            }
        }
    }
}
