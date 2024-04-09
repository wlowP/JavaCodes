package wlow02_java_advance._4_MultiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 死锁: 不同的锁互相嵌套导致出现死锁, 程序卡死
public class _1_9_Deadlock {
    public static void main(String[] args) {
        Thread th1 = new ThreadWithDeadlock("线程1");
        Thread th2 = new ThreadWithDeadlock("线程2");
        th1.start();
        th2.start();
    }
}

class ThreadWithDeadlock extends Thread {
    public ThreadWithDeadlock(String name) {super(name);}

    static final Object obj1 = new Object();
    static final Object obj2 = new Object();

    @Override
    public void run() {
        // 上面两个线程执行下面代码的话会卡住
/*        while (true) {
            if ("线程1".equals(getName())) {
                synchronized (obj1) {
                    System.out.println("线程1拿到了1锁, 准备拿2锁");
                    synchronized (obj2) {
                        System.out.println("线程1拿到了2锁, 执行完一轮");
                    }
                }
            } else if ("线程2".equals(getName())) {
                synchronized (obj2) {
                    System.out.println("线程2拿到了2锁, 准备拿1锁");
                    synchronized (obj1) {
                        System.out.println("线程2拿到了1锁, 执行完一轮");
                    }
                }
            }
        }*/
        run1();
    }

    // 用ReentrantLock构造的死锁:
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();
    void run1() {
        while (true) {
            if ("线程1".equals(getName())) {
                lock1.lock();
                System.out.println(getName() + "拿到了1锁, 准备拿2锁");
                lock2.lock();
                System.out.println(getName() + "又拿到了2锁, 准备释放锁");
                lock2.unlock();lock1.unlock();
            } else if ("线程2".equals(getName())) {
                lock2.lock();
                System.out.println(getName() + "拿到了2锁, 准备拿1锁");
                lock1.lock();
                System.out.println(getName() + "又拿到了1锁, 准备释放锁");
                lock1.unlock();lock2.unlock();
            }
        }
    }
}