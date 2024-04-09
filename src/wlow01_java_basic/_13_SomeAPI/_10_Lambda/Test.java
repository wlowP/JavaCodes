package wlow01_java_basic._13_SomeAPI._10_Lambda;

        //初见Lambda表达式作用.
public class Test {
    public static void main(String[] args) {
        //传递接口实现类对象, 可以先建一个成员内部类实现接口.
        class sub implements Action{
            @Override
            public void eat() {
                System.out.println("干饭");
            }
        }
        method(new sub());

        //或者用匿名内部类.
        method(new Action() {
            @Override
            public void eat() {
                System.out.println("干饭干饭");
            }
        });
        //但是都为了一个方法而new一个对象太麻烦了.
        //或者用Lambda简化书写.
        method(() -> System.out.println("干饭干饭干饭"));
    }

    public static void method(Action a){
        a.eat();
    }
}

    //注意Lambda表达式只能用于简化函数式接口的匿名内部实现类.
    //用@FunctionalInterface注解来校验是否是函数式接口.
@FunctionalInterface
interface Action {
    public abstract void eat();
}
