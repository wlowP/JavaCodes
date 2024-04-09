package wlow01_java_basic._2_calculation;

public class _5_AssignmentOperators {
    public static void main(String[] args) {
        //不同的赋值运算符.
        //+=
        int a = 10;
        int b = 20;
        a += b;  //省得去记 a = a + b 了.
        System.out.println(a); //30
        System.out.println(b); //20

        short c = 64;
        //***c是short类型数据,参与运算时已转化为int,
        //所以下面一行等效于 c = (short)(c - 10);
        c -= 10;
        //相当于是隐含了一个强制转换.
        System.out.println(c);
    }
}
