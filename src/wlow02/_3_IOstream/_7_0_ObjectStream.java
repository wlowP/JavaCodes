package wlow02._3_IOstream;

import java.io.*;

// 对象操作流
public class _7_0_ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User u = new User("张三", "1234qwerty", 18, "火星");
        // 序列化流/对象操作输出流: 将对象以特殊格式存储到文件中:
        // 构造方法要传递字节流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IOPractice/objects/objs.txt"));
        oos.writeObject(u);
        oos.close();

        // 反序列化流/对象操作输入流: 将文件中序列化的对象数据读取为对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IOPractice/objects/objs.txt"));
        // 读取文件中的对象并返回Object类型的对象, 会抛出ClassNotFoundException编译时异常
        Object o = ois.readObject();
        // 被transient修饰了的成员变量不会序列化到文件中, 反序列化时得到的是变量默认值
        System.out.println(o.toString()); // User{uname='张三', password='1234qwerty', age=18, address='null', num=0}
        ois.close();
    }
}

// 要实现Serializable接口, 序列化输出到文件的时候才不会报错
// Serializable接口是标记型接口, 没有抽象方法
class User implements Serializable {
    // 📌📌序列化输出后修改本地类文件再读取会因为序列号不一致而报错InvalidClassException
    // 固定序列号的方法之一: 设置一个特殊的静态常量serialVersionUID
    // 这样在发生上述修改情况后就不会报错了
    @Serial
    private static final long serialVersionUID = 1332495142600914143L;

    private String uname;
    private String password;
    private int age;
    // transient: 瞬态关键字
    // 作用: 被其修饰的成员不会被序列化到本地文件中.
    private transient String address;
    private transient int num;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", num=" + num +
                '}';
    }

    public User() {}

    public User(String uname, String password, int age, String address) {
        this.uname = uname;
        this.password = password;
        this.age = age;
        this.address = address;
    }
}