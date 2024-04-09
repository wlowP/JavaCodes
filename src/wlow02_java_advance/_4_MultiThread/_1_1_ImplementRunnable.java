package wlow02_java_advance._4_MultiThread;

public class _1_1_ImplementRunnable {
    public static void main(String[] args) {
        // Runnable实现类的对象传给Thread类的构造方法来创建线程对象.
        MyRun mr = new MyRun();
        // Runnable实现类对象表示线程要执行的任务, 可以理解为一个任务对象.
        // 把线程要执行的任务通过构造方法传给Thread类对象.
        Thread th1 = new Thread(mr),
               th2 = new Thread(mr);
        th1.setName("线程1");
        th2.setName("线程2");
        th1.start();th2.start();
    }
}

// 自定义线程类实现Runnable接口, 重写run抽象方法
class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            // 不能直接调用getName方法, 因为Runnable接口里面没有这个方法.
            // 📌📌Thread类的静态方法currentThread可以获取到当前正在执行的线程对象.
            // 哪条线程执行到这个方法, 返回的就是哪个线程对象
            Thread th = Thread.currentThread();
            System.out.println(th.getName() +  "在运行" + i);
        }
    }
}