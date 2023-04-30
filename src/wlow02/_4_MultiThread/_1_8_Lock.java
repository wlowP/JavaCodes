package wlow02._4_MultiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 锁对象
public class _1_8_Lock {
    public static void main(String[] args) {
        TicketHallWithLock th1 = new TicketHallWithLock("售票厅1");
        TicketHallWithLock th2 = new TicketHallWithLock("售票厅2");
        TicketHallWithLock th3 = new TicketHallWithLock("售票厅3");
        th1.start();th2.start();th3.start();
    }
}

class TicketHallWithLock extends Thread{
    static int totalTicket = 100;
    // 利用锁对象实现synchronized的上锁/解锁功能
    // 要共享一个锁(不然每个线程自己有自己的锁, 没有意义), 所以要static.
    static Lock lock = new ReentrantLock();
    public TicketHallWithLock(String name){super(name);}
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (totalTicket > 0) {
                    sleep(10);
                    totalTicket--;
                    System.out.println(getName() + "售出一张票, 剩下" + totalTicket + "张票");
                }else {
                    // 📌把unlock写在finally中, 就不用在break之前和while最后都写一句unlock了.
                    // lock.unlock();
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // 📌📌最后如果线程没有及时调用unlock的话, 程序就不会结束, 一直开着.
            }
            //lock.unlock();
        }
    }
}