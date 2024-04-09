package wlow02_java_advance._6_Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class _1_3_GetMethods {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        // getMethods()会获取到所有public方法, 📌📌包括从父类继承下来的
        // 但getDeclaredMethods()只会获取到子类所有方法.
        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println(Arrays.toString(methods));
        // [
        //  public java.lang.String wlow02._6_Reflect.Person.toString(),
        //  public void wlow02._6_Reflect.Person.sleep(),
        //  public ...getters and setters...
        //   📌📌会获取到从父类(比如Object)继承下来的public方法
        //  public ...从Object类继承下来的public方法, 包括wait, equals, notify, hashCode等...
        // ]
        System.out.println(Arrays.toString(declaredMethods));
        // [
        //  public java.lang.String wlow02._6_Reflect.Person.toString(),
        //  public void wlow02._6_Reflect.Person.sleep(),
        //  private void wlow02._6_Reflect.Person.study(java.lang.String) \n
        //          throws java.lang.ArrayIndexOutOfBoundsException,java.lang.NullPointerException,
        //  public ...getters and setters...
        // ]

        // 获取指定方法: getDeclaredMethod(String name, Class<?>... parameterTypes), 传递方法名和形参列表
        Method m = clazz.getDeclaredMethod("study", String.class);
        System.out.println(m); // 同declaredMethods数组中的第三项

        // 获取方法的具体信息: 名字, 形参列表/个数/种类, 修饰符, 📌📌返回值类型, 抛出的异常类型📌📌
        String name = m.getName();
        Parameter[] parameters = m.getParameters();
        int parameterCount = m.getParameterCount(),
            modifiers = m.getModifiers();
        Class<?>[] parameterTypes = m.getParameterTypes(),
                   exceptionTypes = m.getExceptionTypes();
        Class<?> returnType = m.getReturnType();
        System.out.println(name); // study
        System.out.println(Arrays.toString(parameters)); // [java.lang.String arg0]
        System.out.println(parameterCount); // 1
        System.out.println(Arrays.toString(parameterTypes)); // [class java.lang.String]
        System.out.println(modifiers); // 2
        System.out.println(Arrays.toString(exceptionTypes)); // [class java.lang.ArrayIndexOutOfBoundsException, class java.lang.NullPointerException]
        System.out.println(returnType); // void


        // 📌📌用方法对象运行方法 invoke(Object obj, Object... args), 传递方法的调用者对象和方法实参
        Person p = clazz.getDeclaredConstructor(String.class, int.class, String.class).newInstance("小明", 18, "男");
        // 📌📌调用私有方法时记得先setAccessible(true)
        m.setAccessible(true);
        //  📌📌m代表的方法的返回值就是invoke方法的返回值(默认返回Object类型的). void的话invoke返回null
        m.invoke(p, "Java-反射"); // 学习: Java-反射
        Method getName = clazz.getDeclaredMethod("getName");
        Object result = getName.invoke(p);
        System.out.println(result); // 小明
    }
}
