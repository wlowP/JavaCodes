package wlow02._4_MultiThread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 自定义线程池的参数
public class _4_1_CustomThreadPool {
    public static void main(String[] args) {
        /*
        * 使用ThreadPoolExecutor的七个参数的构造方法:
        * 参数一: 核心线程数量, 不小于0
        * 参数二: 最大线程数, 不小于0, 大于等于核心线程数
        *        于是最大临时线程数就是最大线程数 - 核心线程数
        * 参数三: 空闲线程最大存留时间, 不小于0
        * 参数四: 参数三的时间的单位, 用TimeUnit枚举类指定
        * 参数五: 任务队列, 不能为null
        * 参数六: 创建线程工厂, 不能为null
        * 参数七: 任务的拒绝策略, 不能为null
        * */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                6, // 于是最大临时线程数就是6 - 3 = 3
                60, // 时间数值是60
                TimeUnit.SECONDS, // 单位是秒 -> 60秒. 也可以是1 + TimeUnit.MINUTES
                new LinkedBlockingQueue<>(), // 任务队列, 采用了不限长度的队列
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy() // 注意创建静态内部类对象的格式
        );

        pool.submit(new PoolTask());
        // pool-1-thread-1---1
        // pool-1-thread-1---2
        // pool-1-thread-1---3

        // pool.shutdown();
    }
}
