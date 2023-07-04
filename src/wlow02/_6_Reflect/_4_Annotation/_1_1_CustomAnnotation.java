package wlow02._6_Reflect._4_Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 使用自定义注解
public class _1_1_CustomAnnotation {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 反射获取注解中的信息
        Class<SomeClass> clazz = SomeClass.class;
        Method m = clazz.getDeclaredMethod("method");
        MyAnnotation myAnno = m.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(myAnno.message());
        System.out.println(myAnno.number());

        System.out.println("============");

        // 模拟@Test, 只运行有@MyTest注解的方法
        SomeClass sc = new SomeClass();
        for (Method mth : clazz.getDeclaredMethods()) {
            // 📌📌访问注解也别忘了先setAccessible(true)
            mth.setAccessible(true);
            if (mth.isAnnotationPresent(MyTest.class)){
                mth.invoke(sc);
            }
        }
    }
}

class SomeClass{
    int a = 9;
    @MyAnnotation(message = "自定义注解中的信息", number = 123)
    public void method(){
        System.out.println("使用了自定义注解的方法");
    }

    @MyTest
    private void method1(){
        System.out.println("SomeClass.method1");
    }

    public void method2(){
        System.out.println("SomeClass.method2");
    }

    @MyTest
    public void method3(){
        System.out.println("SomeClass.method3");
    }
}


