package wlow01_java_basic._2_calculation;

public class _4_SelfPlusAndMinus {
    public static void main(String[] args) {
        //参与运算.
        int a = 10;
        int b = a++;

        System.out.println(a);//11
        System.out.println(b);//10

        int c = 10;
        int d = ++c;

        System.out.println(c);//11
        System.out.println(d);//11

        //单独使用.
        a--;
        System.out.println(a);//10
        --a;
        System.out.println(a);//9

        //运算多次.
        int x = 10;
        int y = x++;
        int z = ++x;
        //结果:x=12, y=10, z=12.
    }


}
