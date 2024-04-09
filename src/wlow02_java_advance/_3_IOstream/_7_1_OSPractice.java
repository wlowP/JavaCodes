package wlow02_java_advance._3_IOstream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class _7_1_OSPractice {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化流写入多个对象
        ArrayList<User> userList = new ArrayList<>();
        Collections.addAll(userList,
                new User("reisen", "123456", 18, "lunatic kingdom"),
                new User("tenshi", "sky666", 19, "天界"),
                new User("reimu", "kanekane996", 18, "hakureijinja")
        );
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IOPractice/objects/objects"));
        // 直接序列化整个集合, 方便反序列化读取
        oos.writeObject(userList);
        oos.close();

        /*
        *  反序列化流读取多个对象, 如果读取到文件末尾了再读取不会返回null
        *  📌📌而是返回异常EOFException(End Of File)
        *  📌解决方案一: 多个对象装进集合/数组里后再序列化集合/数组, 反序列化时读取遍历集合/数组即可
        *  解决方案二: try catch
        * */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IOPractice/objects/objects"));
        ArrayList<User> list = (ArrayList<User>)ois.readObject();
        for (User user : list) {
            System.out.println(user);
        }
        ois.close();
    }
}