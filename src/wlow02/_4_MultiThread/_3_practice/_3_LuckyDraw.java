package wlow02._4_MultiThread._3_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 多个抽奖箱各自不重复抽奖. 并统计抽奖结果
public class _3_LuckyDraw {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 20, 500, 70, 120, 666, 9090, 15, 5, 80, 700, 2);

        FutureTask<Integer> res1 = new FutureTask<>(new DrawBox(list)),
                            res2 = new FutureTask<>(new DrawBox(list));
        Thread th1 = new Thread(res1),
                th2 = new Thread(res2);
        th1.setName("抽奖箱1");
        th2.setName("抽奖箱2");
        th1.start();th2.start();
        int max1 = res1.get(),
            max2 = res2.get();
        System.out.println(max1 + " " + max2);
    }
}

class DrawBox implements Callable<Integer> {
    private ArrayList<Integer> bonusPool, results;
    public DrawBox(ArrayList<Integer> bonusPool){
        this.bonusPool = bonusPool;
        this.results = new ArrayList<>();
    }
    @Override
    public Integer call() {
        int size, res, max = 0, sum = 0;
        while (true) {
            synchronized (DrawBox.class) {
                size = bonusPool.size();
                if (size > 0) {
                    res = bonusPool.remove((int) (Math.random() * size));
                    max = Math.max(max, res);
                    sum += res;
                    results.add(res);
                    System.out.println(Thread.currentThread().getName() + " 产生了一个 " + res + " 元大奖");
                } else {
                    System.out.println(Thread.currentThread().getName() + "共产生了" + results.size() + "个奖项, 分别为: " + results + "\n   最高奖项为: " + max + "元, 总金额为: " + sum + "元");
                    break;
                }
            }
            // 📌📌📌在锁的外面让线程sleep一下能让多个线程执行地更平均一点, 防止一个线程瞬间执行完所有任务
            try {
                Thread.sleep(30);
            }catch (InterruptedException ignored) {}
        }
        return max;
    }
}