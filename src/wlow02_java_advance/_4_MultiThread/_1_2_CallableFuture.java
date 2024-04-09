package wlow02_java_advance._4_MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 使用Callable接口和Future接口的实现类FutureTask来实现多线程
// 能够获取到多线程任务的返回值. (call方法返回值由泛型决定)
public class _1_2_CallableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建Callable的实现类的对象mc
        MyCall mc = new MyCall();
        // 再将mc传给FutureTask的对象ft管理
        FutureTask<String> ft = new FutureTask<>(mc);
        // 📌再让Thread对象来运行ft
        Thread th = new Thread(ft);
        th.start();
        // 📌📌📌调用FutureTask对象的get方法获得线程执行结果, 会抛出异常
        String res = ft.get();
        System.out.println(res); // aaabbbccc
    }
}

// 定义Callable的实现类, 重写call抽象方法定义线程的任务📌📌和返回值类型
class MyCall implements Callable<String>{
    @Override
    public String call() throws InterruptedException {
        // 📌📌方法能有返回值, 返回值类型由泛型决定(实现类给出具体类型)
        return "aaa" + "bbb" + "ccc";
    }
}

