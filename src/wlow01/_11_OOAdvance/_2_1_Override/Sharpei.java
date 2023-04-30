package wlow01._11_OOAdvance._2_1_Override;

public class Sharpei extends Dog {
    //方法重写.以及运用super关键字调用父类方法.能不重复就不重复.
    @Override
    public void eat(){
        super.eat();
        System.out.println("啃骨头");
    }
}
