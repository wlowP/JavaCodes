package wlow02_java_advance._4_MultiThread;

// 线程优先级的影响
public class _1_4_Priority {
    public static void main(String[] args) {
        Thread th1 = new Thread(new Task());
        Thread th2 = new Thread(new Task());
        th1.setName("线程");
        th2.setName("县城");
        // 线程优先级范围1~10, 默认优先级都是5
        System.out.println(th1.getPriority()); // 5
        th1.setPriority(1);
        th2.setPriority(10); // 执行"县城"的概率较大, 但"县城"也不一定总是先执行完.
        th1.start();th2.start();
    }
}

class Task implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--在执行--" + (i + 1));
        }
    }
}

