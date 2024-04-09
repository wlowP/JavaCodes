package wlow02_java_advance._4_MultiThread._3_practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 多个线程一起输出0~100之间的所有奇数
public class _1_OddNumber {
    static int i = 0;

    public static void main(String[] args) {
        OddNumTask t = new OddNumTask();
        Thread th1 = new Thread(t);
        Thread th2 = new Thread(t);
        Thread th3 = new Thread(t);
        th1.start();
        th2.start();
        th3.start();
    }
}

class OddNumTask implements Runnable {
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            // 用lock锁:
            lock.lock();
            try {
                if (_1_OddNumber.i < 100){
                    Thread.sleep(10);
                    if (_1_OddNumber.i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " -oddNum: " + _1_OddNumber.i);
                    }
                    _1_OddNumber.i++;
                } else {
                    break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            // if (getOddNum()) break;
        }
    }

    // 用同步方法:
    private synchronized boolean getOddNum() {
        if (_1_OddNumber.i > 100) return true;

        if (_1_OddNumber.i % 2 != 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " -oddNum: " + _1_OddNumber.i);
        }
        _1_OddNumber.i++;
        return false;
    }
}