package others;

public class Polymorphism {
    public static void main(String[] args) {
        BaseClass obj1 = new SubClass(1);
        obj1.m1(2);
        ((SubClass)obj1).m1(4);
    }

}

class BaseClass{
    public BaseClass(){
        m1(1);
        System.out.println("BaseClass");
    }

    public void m1(double i){
        m2(i);
    }

    public void m2(int i){
        System.out.println("BaseClass Method2 Int");
    }

    public void m2(double i){
        System.out.println("BaseClass Method2 Double");
    }
}

class SubClass extends BaseClass{
    public SubClass(int i){
        System.out.println("SubClass");
        m1(i);
    }
    public void m1(int i){
        m2(i);
    }
    public void m2(double i){
        System.out.println("SubClass Method2 Double");
    }
}