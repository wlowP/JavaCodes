package wlow02._4_MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 线程池的应用
public class _4_0_ThreadPools {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程池(无上限线程池)
        ExecutorService limitlessPool = Executors.newCachedThreadPool();
        // 有限线程池, 线程数上限为2个
        ExecutorService limitedPool = Executors.newFixedThreadPool(2);

        // 给线程池提交任务
        // submit方法形参可以接受Runnable, Callable的实现类对象
        limitedPool.submit(new PoolTask());
        // Thread.sleep(100);
        limitedPool.submit(new PoolTask());
        limitedPool.submit(new PoolTask());
        limitedPool.submit(new PoolTask());

        // shutdown销毁线程池, 把池子关了, 但一般不需要关
        // 📌📌不关闭线程池的话, 程序也不会结束运行
        limitedPool.shutdown();
    }
}

class PoolTask implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i); // pool-n-thread-m---i
            // 📌📌此时线程的默认名字变成pool-n-thread-m, 带上了所属线程池的序号. n, m都从1开始
        }
    }
}
