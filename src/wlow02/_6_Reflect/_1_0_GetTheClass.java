package wlow02._6_Reflect;

// 获取class对象的三种方式
public class _1_0_GetTheClass {
    public static void main(String[] args) throws ClassNotFoundException {

        // 1.Class.forName("全类名")静态方法, 注意要是全类名 wlow02._6_Reflect.Person
        // 最常用, 会抛出编译异常: ClassNotFoundException
        Class clazz = Class.forName("wlow02._6_Reflect.Person");
        System.out.println(clazz); // class wlow02._6_Reflect.Person

        // 2.类的class属性
        // 一般当做参数传递, 比如在同步代码块synchronized()中作为锁传递
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        // 3.通过对象.getClass获取. 该方法继承自Object
        // 得先创建对象
        Person p = new Person();
        Class clazz2 = p.getClass();
        System.out.println(clazz2);

        // 📌📌这三个方法获取到的都是同一个class对象
        System.out.println(clazz == clazz1); // true
        System.out.println(clazz1 == clazz2); // true
    }
}

class Person {
    private String name;
    private int age;
    public String gender;

    public Person() {}

    // 注意这个构造方法是protected的
    protected Person(String name){
        this.name = name;
        this.age = -1;
    }

    // 注意这个构造方法是私有的
    private Person(int age){
        this.name = "未设置";
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // 注意这个方法手动抛出了一些异常, 以便反射获取
    private void study(String subject) throws ArrayIndexOutOfBoundsException, NullPointerException {
        System.out.println("学习: " + subject);
    }

    public void sleep(){
        System.out.println("睡觉");
    }

    public String toString() {
        return "Person{name = " + name + ", age = " + age + "}";
    }
}