package wlow02_java_advance._4_MultiThread;

// 守护线程
public class _1_5_Daemon {
    public static void main(String[] args) {
        // 📌📌当其他的非守护线程执行完毕后, 守护线程会陆续结束(不会立马结束)
        // 创建的线程对象默认是非守护的
        Thread nonDaemon = new Thread(new Task1());
        Thread daemon = new Thread(new Task1());
        nonDaemon.setName("非守护线程");
        daemon.setName("守护备胎线程");
        daemon.setDaemon(true);
        daemon.start();nonDaemon.start();
    }
}

class Task1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--在执行--" + (i + 1));
        }
    }
}

