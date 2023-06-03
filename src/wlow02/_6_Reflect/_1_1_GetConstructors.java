package wlow02._6_Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Arrays;

// 反射获取类里面的构造方法以及方法的具体信息
public class _1_1_GetConstructors {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 先获取字节码文件对象
        Class<Person> personClass = Person.class;

        // 1. 获取所有的📌public📌的构造方法: getConstructors()
        Constructor<?>[] constructors = personClass.getConstructors();
        System.out.println(Arrays.toString(constructors));
        // [
        //  public wlow02._6_Reflect.Person(java.lang.String,int,java.lang.String),
        //  public wlow02._6_Reflect.Person(java.lang.String,int),
        //  public wlow02._6_Reflect.Person()
        // ]
        // 可见非public的构造方法都不能被获取到

        // 2. 获取所有的构造方法: getDeclaredConstructors()
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));
        // [
        //  public wlow02._6_Reflect.Person(java.lang.String,int,java.lang.String),
        //  public wlow02._6_Reflect.Person(java.lang.String,int),
        //  public wlow02._6_Reflect.Person(),
        //  protected wlow02._6_Reflect.Person(java.lang.String),
        //  private wlow02._6_Reflect.Person(int)
        // ]

        // 3. 获取指定的构造方法: getDeclaredConstructor(Class<?>... parameterTypes)
        // 📌📌形参是可变参数, 传递对应的类字节码文件表示形参类型, 以此匹配构造方法. 空参调用就会去匹配空参构造方法.
        // 形参顺序要跟构造方法形参种类顺序一样. 📌📌基本类型数据有对应的.class, 不用包装类
        //   比如构造方法中是int para, 📌📌获取时就传递int.class而不是Integer.class
        //
        Constructor<Person> decCon = personClass.getDeclaredConstructor();
        System.out.println(decCon); // public wlow02._6_Reflect.Person()
        Constructor<Person> decCon1 = personClass.getDeclaredConstructor(int.class);
        System.out.println(decCon1); // private wlow02._6_Reflect.Person(int)
        Constructor<Person> decCon2 = personClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(decCon2); // public wlow02._6_Reflect.Person(java.lang.String,int)


        // 获取构造方法的各种信息
        // 获取修饰符: getModifiers(), 📌但是得到的是整数. 1 -> public; 2 -> private ...
        int modifiers = decCon.getModifiers();
        System.out.println(modifiers); // 1

        // 获取形参列表: getParameters(), 注意返回的是个Parameter对象数组; 获取形参个数: getParameterCount()
        // 获取形参种类: getParameterTypes(), 注意返回的是个Class对象数组
        Parameter[] parameters = decCon2.getParameters();
        int parameterCount = decCon2.getParameterCount();
        Class<?>[] parameterTypes = decCon2.getParameterTypes();
        System.out.println(Arrays.toString(parameters)); // [java.lang.String arg0, int arg1]
        System.out.println(parameterCount); // 2
        System.out.println(Arrays.toString(parameterTypes)); // [class java.lang.String, int]

        // 获取方法名: getName()
        String name = decCon.getName();
        System.out.println(name); // wlow02._6_Reflect.Person


        // 📌用构造方法对象来创建对象: newInstance(构造方法对应的形参列表);
        // private的构造方法对应的对象默认不能创建对象
        // 📌📌此时可以用setAccessible(true)来临时取消权限的校验 -- 暴力反射
        decCon1.setAccessible(true);
        Person person = (Person) decCon1.newInstance(1);
        System.out.println(person); // Person{name = 未设置, age = 1}
    }
}
