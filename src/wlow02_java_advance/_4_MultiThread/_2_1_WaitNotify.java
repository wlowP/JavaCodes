package wlow02_java_advance._4_MultiThread;

// 生产者-消费者, 等待唤醒机制
public class _2_1_WaitNotify {
    public static void main(String[] args) {
        Consumer thc = new Consumer(); thc.setName("消费者");
        Producer thp = new Producer(); thp.setName("生产者");
        thc.start();
        thp.start();
    }
}

// 消费者, 负责使用, 消费数据
class Consumer extends Thread {
    @Override
    public void run() {
        /* 1. 循环
         * 2. 📌📌同步代码块(因为可能有多个消费者和生产者更改同一数据, 要确保其线程安全)
         * 3. 判断共享数据是否到了末尾(用完了), 分别执行不同逻辑
         * */
        while (true) {
            synchronized (Controller.lock) {
                // 如果共享数据到达尽头(用完了), 就跳出循环, 结束线程
                if (Controller.dataCount == 0) break;
                else {
                    // 先判断有没有共享数据, 没有的话, 当前线程进入等待.
                    if (Controller.dataStatus == 0) {
                        try {
                            // 📌📌要让锁对象来wait, 这样做会将当前线程与锁对象绑定
                            // 📌📌这样的话以后再通过锁对象调用notifyAll方法时就能唤醒这把锁绑定的所有线程.
                            Controller.lock.wait();
                            // 📌📌📌等待中的线程被唤醒后, 会从上次阻塞的地方继续执行, 也就是紧跟着wait()后面执行
                        } catch (InterruptedException ignored) {}
                    } else {
                        // 有共享数据的话就可以消费数据, 同时通知生产者线程重新生产数据
                        Controller.dataCount--;
                        System.out.println(getName() + "消费了数据, 还剩" + Controller.dataCount + "个数据");
                        Controller.dataStatus = 0; // 📌修改数据状态为不可用
                        Controller.lock.notifyAll(); // 📌唤醒生产者线程生产数据
                    }
                }
            }
        }
    }
}

// 生产者, 负责生产数据
class Producer extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Controller.lock) {
                if (Controller.dataCount == 0) break;
                else {
                    // 如果已经有可用共享数据了, 就等待, 等消费者去消费数据
                    if (Controller.dataStatus == 1) {
                        try {
                            Controller.lock.wait();
                        } catch (InterruptedException ignored) {}
                    } else {
                        Controller.dataStatus = 1;
                        System.out.println(getName() + "生产了数据");
                        // 📌唤醒等待中的消费者开始消费数据
                        Controller.lock.notifyAll();
                    }
                }
            }
        }
    }
}

// 控制生产者和消费者的执行
class Controller {
    // 表示是否有可用数据, 0->没有, 1->有
    // 用布尔值的话只有两种状态, 只能对应两个线程
    static int dataStatus = 0;
    // 表示数据的总量
    static int dataCount = 10;
    // 锁对象
    static final Object lock = new Object();
}