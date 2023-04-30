package wlow02._4_MultiThread;

// Thread类的成员方法
public class _1_3_ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        // main线程:
        Thread thm = Thread.currentThread(); // 哪条线程执行到这个方法, 就获取到哪个线程的对象.
        /* 当JVM启动后, 自动启动多条线程
         *  📌📌当中有一条线程就是main线程
         *  📌📌其作用就是调用main方法, 执行里面的代码
         *  所有main方法里的内容都是运行在main线程中(创建的新线程除外)
         *  于是currentThread获取到main线程.
         * */
        System.out.println(thm.getName()); // main


        // 想给线程对象设置名字, 可以setName, 也可以用Thread的构造方法传递名字
        CustomThread th1 = new CustomThread("线程一");
        CustomThread th2 = new CustomThread("线程二");
        th1.start();th2.start();

        /* sleep方法:
        *  某条线程执行到这个📌静态📌方法, 它就会暂停相应时间, 然后再继续执行
        *  会抛出编译时异常: InterruptedException
        * */
        System.out.println("准备sleep");
        Thread.sleep(3000);
        System.out.println("sleep完了"); // 准备sleep\n -=[三秒后]=- sleep完了
    }
}

class CustomThread extends Thread{
    public CustomThread(String name){
        // Thread类构造方法可以传递字符串给线程命名, 子类通过super调用
        // 不给线程对象设置名字的话默认是"Thread-X", X从0开始.
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ignored) {}
            System.out.println(getName() + "在运行@" + (i + 1));
        }
    }
}