package wlow02._6_Reflect;

import java.lang.reflect.Field;
import java.util.Arrays;


// 反射获取类里面的成员变量(字段)及其具体信息
public class _1_2_GetFields {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz = Class.forName("wlow02._6_Reflect.Person");

        // 获取所有📌public📌的成员变量: getFields(); getDeclaredFields()获取所有成员变量
        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(fields)); // [public java.lang.String wlow02._6_Reflect.Person.gender]
        System.out.println(Arrays.toString(declaredFields));
        // [
        //  private java.lang.String wlow02._6_Reflect.Person.name,
        //  private int wlow02._6_Reflect.Person.age,
        //  public java.lang.String wlow02._6_Reflect.Person.gender
        // ]

        // 获取指定的public成员变量: getField(String name), name传递变量名称; getDeclaredField 能获取非public的
        Field gender = clazz.getField("gender"),
              name = clazz.getDeclaredField("name");
        System.out.println(gender); // public java.lang.String wlow02._6_Reflect.Person.gender
        System.out.println(name); // private java.lang.String wlow02._6_Reflect.Person.name

        // 获取变量具体信息: 变量名, 修饰符, 类型
        String fieldName = name.getName();
        int modifiers = name.getModifiers();
        Class<?> nameType = name.getType();
        System.out.println(fieldName); // name
        System.out.println(modifiers); // 2
        System.out.println(nameType); // class java.lang.String


        // 📌📌获取变量的值: get(Object obj), obj传递要获取值的对象
        Person p = new Person("张三", 18, "男");
        // 📌📌name字段是私有的, 要先setAccessible(true)
        name.setAccessible(true);
        // 📌获取到的默认都是Object类型, 要看情况进行强转
        String nameValue = (String) name.get(p);
        System.out.println(nameValue); // 张三

        // 设置变量的值: set(Object obj, Object value), 传递要修改值的对象和新的值
        name.set(p, "李四");
        System.out.println(p.getName()); // 李四
    }
}
