package wlow01_java_basic._7_object_oriented._2_Private;

            //Javabean类.运用private关键字对输入给对象的数据进行过滤.
public class _2_0_UsePrivate {
    private int health;

    //set赋值通道.辨识不合法数据后给health进行赋值.
    public void setHealth(int health){
        if (health >= 1 && health <= 100){
            //使用this关键字在变量重名时特指向成员变量health.
            this.health = health;
        }else{
            System.out.println("设置超出范围!");
        }
    }

    //get获取通道.对外(其他类)提供成员变量health的值.
    public int getHealth(){
        return health;
    }

}
