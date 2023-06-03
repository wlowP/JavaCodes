package wlow02._7_Proxy._1_Example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 该类的作用: 主要就是容纳createProxy方法, 📌用来创建一个Someone的对象的代理对象
public class ProxyUtil {
    /**
     * 传入要被代理的对象, 给一个要被代理的对象创建一个代理对象
     * @param principal 要被代理的对象
     * @return 给要被代理的对象创建的代理对象
     */
    public static MyProxy createProxy(Someone principal){
        /* newProxyInstance有三个参数:
        *
        *     参数一: 指定用于加载生成的代理类的类加载器. 一般就用当前的类的加载器.
        *     参数二: 指定生成的代理类的模板, 或者说决定生成的代理类当中要有哪些成员, 📌或者说指定生成的代理对象能代理哪些方法📌
        *                传递对应接口的字节码对象数组.
        *     参数三: 指定生成的代理类的对象要干什么事情, 传递匿名内部类对象, 可用lambda表达式
        *                📌📌当外界通过代理对象调用方法时, 就会先调用这里面的invoke方法, 并且外界调用到的方法会变成Method对象传给invoke方法📌📌
        *  方法默认返回一个Object对象, 要强转成自己的代理对象的类型(MyProxy)
        * */
        MyProxy myProxy = (MyProxy) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{ MyProxy.class, Activities.class }, // 能代理多个接口里面的方法, 📌📌但被代理的类也都要实现这些接口
                new InvocationHandler() {
                    /*
                    *  invoke方法有三个参数:
                    *     参数一: 代理的对象, 一般不需要管
                    *     参数二: 📌📌📌当前运行到的(外界调用到的)方法的对象
                    *     参数三: 📌参数二对应的方法的实参
                    * */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                        // 先决定真正调用方法前干些什么事, 也就是要补充哪些新功能
                        if ("eat".equals(method.getName())){
                            System.out.println("吃东西前先准备盘子勺子筷子");
                        } else if ("play".equals(method.getName())) {
                            System.out.println("玩游戏前先准备好可乐炸鸡翅");
                        } else if ("activity".equals(method.getName())) {
                            System.out.println("进行了什么活动要告诉老师家长哦");
                        }
                        // 然后开始真正调用目标对象的方法, 用方法反射的invoke
                        // 因为方法可能有返回值, 所以直接return
                        return method.invoke(principal, args);
                    }
                }
        );
        return myProxy;
    }
}
