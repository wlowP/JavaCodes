package wlow02_java_advance._4_MultiThread;

public class _1_0_ExtendThread {
    public static void main(String[] args) {
        // 调用start方法开启线程
        //new MyThread().start();

        MyThread th1 = new MyThread(),
                 th2 = new MyThread();
        // 📌📌线程可以起名字, 以区分不同的线程.
        th1.setName("线程1");
        th2.setName("线程2");
        th1.start();th2.start();
        // 虚拟机一会执行线程1, 一会执行线程2, 交替执行.
    }
}

// 自定义线程继承Thread类
class MyThread extends Thread{
    // 重写run方法, 定义线程要完成的任务
    // 📌📌但是创建对象后应该调用start方法来启动线程.
    // 📌📌调用对象的run方法没有多线程效果.
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "在运行" + i);
            System.out.println(getName() + "-----" + i);
        }
    }
}

