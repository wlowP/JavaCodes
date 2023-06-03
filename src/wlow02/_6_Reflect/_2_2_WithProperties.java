package wlow02._6_Reflect;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

// 根据配置文件来动态地创建对象并调用方法
public class _2_2_WithProperties {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException, NoSuchMethodException,
                   InvocationTargetException, InstantiationException, IllegalAccessException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("IOPractice/configFiles/instantiation.properties"));
        Properties prop = new Properties();
        prop.load(bis);
        System.out.println(prop);
        bis.close();

        Class clazz = Class.forName((String) prop.get("className"));

        Constructor con = clazz.getDeclaredConstructor();
        Object o = con.newInstance();

        Method m = clazz.getDeclaredMethod((String) prop.get("method"));
        m.setAccessible(true);
        m.invoke(o);
    }
}
