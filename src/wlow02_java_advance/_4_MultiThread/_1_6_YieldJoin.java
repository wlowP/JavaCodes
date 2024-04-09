package wlow02_java_advance._4_MultiThread;

// 出让线程/礼让线程 ; 插入线程/插队线程
public class _1_6_YieldJoin {
    public static void main(String[] args) throws InterruptedException {
        //ThreadDemo th1 = new ThreadDemo("线程one");
        //ThreadDemo th2 = new ThreadDemo("线程two");
        //th1.start();th2.start();

        ThreadDemo1 th3 = new ThreadDemo1("县城");
        th3.start();
        /* join方法效果: 将调用join方法的线程📌📌插队到当前线程(执行到这段代码的线程, 在这里就是main线程)之前执行
        *  此时"县城"执行完后才会轮到下面main线程中的代码
        *  如果不加th3.join, 就会是main线程可能先抢到执行机会
        * */
        th3.join();

        // 在main线程中执行:
        for (int i = 0; i < 10; i++) {
            System.out.println("main--在执行--" + (i + 1));
        }
    }
}

class ThreadDemo1 extends Thread{
    public ThreadDemo1(String name){super(name);}
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--在执行--" + (i + 1));
        }
    }
}

// 出让线程/礼让线程
class ThreadDemo extends Thread{
    public ThreadDemo(String name){super(name);}
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--在执行--" + (i + 1));
            /* 原本: 多个线程抢占CPU的执行机会, 📌📌某一个线程抢到并执行一次后可能仍然占着
            *       📌就导致该线程多次被执行, 每个线程的执行情况不均匀
            *  📌📌📌yield()方法可以让当前线程出让被CPU执行的机会, 下次每个线程重新抢占CPU
            *  会使得多线程的执行机会分配尽量均匀一点, 也不会绝对均匀
            * */
            Thread.yield();
        }
    }
}

