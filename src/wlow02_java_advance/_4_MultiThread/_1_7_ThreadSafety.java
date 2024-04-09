package wlow02_java_advance._4_MultiThread;

// 线程安全
public class _1_7_ThreadSafety {
    public static void main(String[] args) {
        TicketHall th1 = new TicketHall("售票厅1");
        TicketHall th2 = new TicketHall("售票厅2");
        TicketHall th3 = new TicketHall("售票厅3");
        th1.start();th2.start();th3.start();

        // TicketTask tt = new TicketTask();
        // Thread ticketHall1 = new Thread(tt);
        // Thread ticketHall2 = new Thread(tt);
        // Thread ticketHall3 = new Thread(tt);
        // ticketHall1.setName("售票厅1");
        // ticketHall2.setName("售票厅2");
        // ticketHall3.setName("售票厅3");
        // ticketHall1.start();ticketHall2.start();ticketHall3.start();


/*        new A().start();
        new A().start();
        new A().start();
        new A().start();*/
    }
}

class A extends Thread{
    static int count = 10;
    @Override
    /*
    * run方法可以加上synchronized修饰符. 然而对于非静态方法, synchronized
    * 对应的锁对象是该类的对象(new出来的), 📌📌会导致每个线程的锁都独立, 各执行各的, 没有多线程效果.
    * 如果是实现Runnable接口的类的run方法加上synchronized, 就不会有上面问题.
    * */
    public synchronized void run() {
        while (count > 0){
            try {
                sleep(10);
            } catch (InterruptedException ignored) {}
            count--;
            System.out.println(getName() + " at: " + count);
        }
    }
}

// 售票厅
class TicketHall extends Thread{
    static int totalTicket = 100;
    // 同步代码块的锁. 可以是任意的对象. 但要唯一. (static)
    //static final Object obj = new Object();
    public TicketHall(String name){super(name);}
    @Override
    public void run() {
        while (true) {
            // 利用同步代码块解决线程安全的问题.
            // 同步代码块的锁对象可以是任意对象, 但一定要是唯一的.(static)
            // 推荐引用当前类的字节码文件的对象作为锁, 因为是唯一的.
            // 格式: 类名.class, 表示字节码文件对应的对象, 是唯一的.
            synchronized (TicketHall.class){
                if (totalTicket > 0) {
                    totalTicket--;
                    System.out.println(getName() + "售出一张票, 剩下" + totalTicket + "张票");
                }else break;
            }
            // 📌📌📌在锁的外面让线程sleep一下能让多个线程执行地更平均一点, 防止一个线程瞬间执行完所有任务
            try {
                sleep(10);
            } catch (InterruptedException ignored) {}
        }
    }
}

class TicketTask implements Runnable{
    // 因为创建多个Thread线程都是用的同一个TicketTask对象
    // 所以票数可以不必设置成static的了
    int totalTicket = 100;
    @Override
    public void run() {
        while (true) {
            if (sellTicket()) break;
        }
    }
    // 同步代码块里的代码很多时, 可以抽取成同步方法.
    // 格式: 方法修饰符后跟一个synchronized
    private synchronized boolean sellTicket() {
        if (totalTicket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {}
            totalTicket--;
            System.out.println(Thread.currentThread().getName() + "售出一张票, 剩下" + totalTicket + "张票");
        }else return true;
        return false;
    }
}