package wlow02_java_advance._4_MultiThread;

import java.util.concurrent.ArrayBlockingQueue;

// 阻塞队列实现等待唤醒机制
public class _2_2_BlockingQueue {
    public static void main(String[] args) {
        // 生产者和消费者应当共享一个阻塞队列, 于是队列可以直接定义在主方法里面
        // 数组阻塞队列, 创建时要指定队列长度.
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        Thread thc = new Customer(queue);
        Thread ths = new Seller(queue);
        thc.start();ths.start();
    }
}

// 消费者
class Customer extends Thread{
    ArrayBlockingQueue<String> queue;
    public Customer(ArrayBlockingQueue<String> queue) {this.queue = queue;}
    @Override
    public void run() {
        while (true){
            try {
                // take方法底层有锁对象, 这里不用同步代码块了
                String bought = queue.take();
                System.out.println("顾客买了" + bought);
            }catch (InterruptedException ignored){}
        }
    }
}

// 生产者
class Seller extends Thread{
    ArrayBlockingQueue<String> queue;
    public Seller(ArrayBlockingQueue<String> queue) {this.queue = queue;}
    @Override
    public void run() {
        while (true){
            // 不断地向队列中放入生产出的数据
            try {
                // 📌📌put方法底层运用了锁对象, 这里就不需同步代码块了
                // 📌不然锁套锁的话容易导致死锁
                queue.put("商品" + queue.size());
                // 📌📌打印语句写在了锁的外面(因为锁对象实际在阻塞队列对象中, take, put方法中使用了锁对象)
                // 📌📌所以打印信息时看上去可能并不是等待-唤醒的轮流顺序, 但数据还是安全的.
                System.out.println("售货员放入了一件商品");
            } catch (InterruptedException ignored) {}
        }
    }
}